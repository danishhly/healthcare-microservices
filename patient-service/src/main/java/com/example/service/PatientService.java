package com.example.service;

import com.example.exception.ResourceNotFoundException;
import com.example.model.Patient;
import com.example.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PatientService {

    private final PatientRepository patientRepository;

    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    public Patient findByIdOrThrow(Long id) {
        return patientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Patient", id));
    }

    @Transactional
    public Patient save(Patient patient) {
        return patientRepository.save(patient);
    }

    @Transactional
    public Patient update(Long id, Patient patientDetails) {
        Patient patient = findByIdOrThrow(id);
        patient.setFirstName(patientDetails.getFirstName());
        patient.setLastName(patientDetails.getLastName());
        patient.setEmail(patientDetails.getEmail());
        patient.setPhone(patientDetails.getPhone());
        return patientRepository.save(patient);
    }

    @Transactional
    public Patient partialUpdate(Long id, Patient patientDetails) {
        Patient patient = findByIdOrThrow(id);

        if (StringUtils.hasText(patientDetails.getFirstName())) {
            patient.setFirstName(patientDetails.getFirstName());
        }
        if (StringUtils.hasText(patientDetails.getLastName())) {
            patient.setLastName(patientDetails.getLastName());
        }
        if (StringUtils.hasText(patientDetails.getEmail())) {
            patient.setEmail(patientDetails.getEmail());
        }
        if (StringUtils.hasText(patientDetails.getPhone())) {
            patient.setPhone(patientDetails.getPhone());
        }

        return patientRepository.save(patient);
    }

    @Transactional
    public void deleteById(Long id) {
        if (!patientRepository.existsById(id)) {
            throw new ResourceNotFoundException("Patient", id);
        }
        patientRepository.deleteById(id);
    }
}
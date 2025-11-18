package com.example.service;

import com.example.model.Patient;
import com.example.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepository patientRepository;

    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    public Optional<Patient> findById(Long id) {
        return patientRepository.findById(id);
    }

    public Patient save(Patient patient) {
        return patientRepository.save(patient);
    }

    public Optional<Patient> updatePatient(Long id, Patient patientDetails) {
        return patientRepository.findById(id).map(patient -> {
            if (patientDetails.getFirstName() != null) {
                patient.setFirstName(patientDetails.getFirstName());
            }
            if (patientDetails.getLastName() != null) {
                patient.setLastName(patientDetails.getLastName());
            }
            if (patientDetails.getEmail() != null) {
                patient.setEmail(patientDetails.getEmail());
            }
            if (patientDetails.getPhone() != null) {
                patient.setPhone(patientDetails.getPhone());
            }
            return patientRepository.save(patient);
        });
    }

    public Optional<Patient> partialUpdatePatient(Long id, Patient patientDetails) {
        return patientRepository.findById(id).map(patient -> {
            if (patientDetails.getFirstName() != null && !patientDetails.getFirstName().isBlank()) {
                patient.setFirstName(patientDetails.getFirstName());
            }
            if (patientDetails.getLastName() != null && !patientDetails.getLastName().isBlank()) {
                patient.setLastName(patientDetails.getLastName());
            }
            if (patientDetails.getEmail() != null && !patientDetails.getEmail().isBlank()) {
                patient.setEmail(patientDetails.getEmail());
            }
            if (patientDetails.getPhone() != null && !patientDetails.getPhone().isBlank()) {
                patient.setPhone(patientDetails.getPhone());
            }
            return patientRepository.save(patient);
        });
    }

    public void deleteById(Long id) {
        patientRepository.deleteById(id);
    }
}

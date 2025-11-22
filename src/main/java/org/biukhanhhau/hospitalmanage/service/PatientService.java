package org.biukhanhhau.hospitalmanage.service;

import org.biukhanhhau.hospitalmanage.model.Patient;
import org.biukhanhhau.hospitalmanage.repo.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    PatientRepo patientRepo;

    public List<Patient> findPatients(){
        return patientRepo.findAll();
    }

    public Patient findById(int id) {
        return patientRepo.findById(id);
    }

    public void putPatient(Patient patient) {
        Patient patientTemp = findById(patient.getId());
        if (patient.getName() != null){
            patientTemp.setName(patient.getName());
        }

        if (patient.getAge() != null){
            patientTemp.setAge(patient.getAge());
        }

        if (patient.getNurses() != null){
            patientTemp.setNurses(patient.getNurses());
        }

        if (patient.getProblem() != null){
            patientTemp.setProblem(patient.getProblem());
        }
        patientRepo.save(patientTemp);
    }

    public void addPatient(Patient patient) {
        patientRepo.save(patient);
    }

    public void delPatient(int id) {
        patientRepo.deleteById(id);
    }
}

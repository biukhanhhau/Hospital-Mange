package org.biukhanhhau.hospitalmanage.service;

import org.biukhanhhau.hospitalmanage.dto.PatientDTO;
import org.biukhanhhau.hospitalmanage.model.Nurse;
import org.biukhanhhau.hospitalmanage.model.Patient;
import org.biukhanhhau.hospitalmanage.repo.NurseRepo;
import org.biukhanhhau.hospitalmanage.repo.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    PatientRepo patientRepo;

    @Autowired
    NurseRepo nurseRepo;

    public List<Patient> findPatients(){
        return patientRepo.findAll();
    }

    public Patient findById(int id) {
        return patientRepo.findById(id);
    }

    public Patient putPatient(int id, PatientDTO dto) {
        Patient existingPatient = patientRepo.findById(id);
        if (existingPatient == null){
            return null;
        }
        existingPatient.setName(dto.getName());
        existingPatient.setAge(dto.getAge());
        existingPatient.setProblem(dto.getProblem());

        List<Nurse> newNurse = nurseRepo.findAllById(dto.getNurses());
        existingPatient.setNurses(newNurse);
        return patientRepo.save(existingPatient);
    }

    public Patient addPatient(PatientDTO dto) {
        Patient patient = new Patient();
        patient.setName(dto.getName());
        patient.setAge(dto.getAge());
        patient.setProblem(dto.getProblem());
        if (dto.getNurses()==null &&dto.getNurses().isEmpty()){
            patient.setNurses(nurseRepo.findAllById(dto.getNurses()));
        }
        return patientRepo.save(patient);
    }

    public void delPatient(int id) {
        patientRepo.deleteById(id);
    }
}

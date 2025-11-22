package org.biukhanhhau.hospitalmanage.service;

import org.biukhanhhau.hospitalmanage.model.Nurse;
import org.biukhanhhau.hospitalmanage.model.Patient;
import org.biukhanhhau.hospitalmanage.repo.NurseRepo;
import org.biukhanhhau.hospitalmanage.repo.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NurseService {

    @Autowired
    NurseRepo nurseRepo;
    @Autowired
    private PatientRepo patientRepo;

    public Nurse addNurse(Nurse nurse) {
        return nurseRepo.save(nurse);
    }

    public Nurse findNurse(int id){
        return nurseRepo.findNurseById(id);
    }

    public void putNurse(Nurse nurse){
        Nurse nurseTemp = findNurse(nurse.getId());
        if (nurse.getName() != null){
            nurseTemp.setName(nurse.getName());
        }

        if (nurse.getPatients() != null){
            nurseTemp.setPatients(nurse.getPatients());
        }

        if (nurse.getSpecialized() != null){
            nurseTemp.setSpecialized(nurse.getSpecialized());
        }

        nurseRepo.save(nurseTemp);
    }

    public void delNurse(int id) {
        Nurse nurse = nurseRepo.findById(id).orElseThrow(() -> new RuntimeException("Not found"));

        List<Patient> patients = nurse.getPatients();
        for(Patient p : patients){
            p.getNurses().remove(nurse);
            patientRepo.save(p);
        }
        nurseRepo.delete(nurse);
    }

    public List<Nurse> findNurses() {
        return nurseRepo.findAll();
    }
}

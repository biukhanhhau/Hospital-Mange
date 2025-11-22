package org.biukhanhhau.hospitalmanage.controller;

import org.apache.coyote.Response;
import org.biukhanhhau.hospitalmanage.dto.PatientDTO;
import org.biukhanhhau.hospitalmanage.model.Patient;
import org.biukhanhhau.hospitalmanage.service.PatientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService){
        this.patientService = patientService;
    }

    @GetMapping("patients")
    public ResponseEntity<List<Patient>> getPatients(){
        List<Patient> patients = patientService.findPatients();
        return ResponseEntity.ok(patients);
    }

    @GetMapping("patients/{id}")
    public ResponseEntity<Patient> getPatient(@PathVariable int id){
        Patient patient = patientService.findById(id);
        return ResponseEntity.ok(patient);
    }

    @PostMapping("patients")
    public ResponseEntity<Patient> postPatient(@RequestBody PatientDTO dto){
        Patient newP = patientService.addPatient(dto);
        return ResponseEntity.ok(newP);
    }

    @PutMapping("patients/{id}")
    public ResponseEntity<Patient> putPatient(@PathVariable int id, @RequestBody PatientDTO dto) {
        Patient tempP = patientService.putPatient(id, dto);
        if (tempP == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(tempP);
    }

    @DeleteMapping("patients/{id}")
    public ResponseEntity<Void> delPatient(@PathVariable int id){
        if (patientService.findById(id) == null){
            return ResponseEntity.notFound().build();
        }
        patientService.delPatient(id);
        return ResponseEntity.noContent().build();
    }
}

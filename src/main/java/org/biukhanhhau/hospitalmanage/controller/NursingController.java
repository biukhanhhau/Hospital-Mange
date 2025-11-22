package org.biukhanhhau.hospitalmanage.controller;

import org.biukhanhhau.hospitalmanage.model.Nurse;
import org.biukhanhhau.hospitalmanage.service.NurseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class NursingController {

    private final NurseService nurseService;

    public NursingController(NurseService nurseService){
        this.nurseService = nurseService;
    }

    @GetMapping("nurses")
    public ResponseEntity<List<Nurse>> getNurses(){
        List<Nurse> nurses = nurseService.findNurses();
        return ResponseEntity.ok(nurses);
    }

    @GetMapping("nurses/{id}")
    public ResponseEntity<Nurse> getNurse(@PathVariable int id){
        Nurse nurse = nurseService.findNurse(id);
        if (nurse == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(nurse);
    }

    @PostMapping("nurses")
    public Nurse postNurse(@RequestBody Nurse nurse){
        return nurseService.addNurse(nurse);
    }

    @PutMapping("nurses/{id}")
    public ResponseEntity<Nurse> putNurse(@PathVariable int id, @RequestBody Nurse nurse){
        if (nurseService.findNurse(id) == null){
            return ResponseEntity.notFound().build();
        }
        nurseService.putNurse(nurse);
        return ResponseEntity.ok(nurse);
    }

    @DeleteMapping("nurses/{id}")
    public ResponseEntity<Void> delNurse(@PathVariable int id){
        if (nurseService.findNurse(id) == null){
            return ResponseEntity.notFound().build();
        }

        nurseService.delNurse(id);
        return ResponseEntity.noContent().build();
    }
}



















































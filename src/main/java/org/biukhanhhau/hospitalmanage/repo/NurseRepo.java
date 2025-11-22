package org.biukhanhhau.hospitalmanage.repo;

import org.biukhanhhau.hospitalmanage.model.Nurse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NurseRepo extends JpaRepository<Nurse, Integer> {
    Nurse findNurseById(int id);
}

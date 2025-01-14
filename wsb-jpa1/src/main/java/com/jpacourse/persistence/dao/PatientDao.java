package com.jpacourse.persistence.dao;

import com.jpacourse.persistence.entity.PatientEntity;
import com.jpacourse.persistence.enums.Gender;

import java.time.LocalDateTime;
import java.util.List;

public interface PatientDao extends Dao<PatientEntity, Long> {
    public PatientEntity addVisitToPatient(Long patientId, Long doctorId, LocalDateTime time, String description);

    List<PatientEntity> findByLastName(String lastName);

    List<PatientEntity> findPatientsWithMoreVisitsThan(long minVisit);
    List<PatientEntity> findPatientsByGender(List<Gender> genderList);
}

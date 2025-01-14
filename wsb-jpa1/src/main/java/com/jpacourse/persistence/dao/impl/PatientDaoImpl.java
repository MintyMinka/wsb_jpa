package com.jpacourse.persistence.dao.impl;

import com.jpacourse.persistence.dao.PatientDao;
import com.jpacourse.persistence.entity.DoctorEntity;
import com.jpacourse.persistence.entity.PatientEntity;
import com.jpacourse.persistence.entity.VisitEntity;
import com.jpacourse.persistence.enums.Gender;
import com.jpacourse.rest.exception.EntityNotFoundException;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PatientDaoImpl extends AbstractDao<PatientEntity, Long> implements PatientDao {
    @Override
    @Transactional
    public PatientEntity addVisitToPatient(Long patientId, Long doctorId, LocalDateTime time, String description) {
        PatientEntity patient = entityManager.find(PatientEntity.class, patientId);

        if (patient == null) {
            throw new EntityNotFoundException(patientId);
        }

        DoctorEntity doctor = entityManager.find(DoctorEntity.class, doctorId);

        if (doctor == null) {
            throw new EntityNotFoundException(doctorId);
        }

        VisitEntity visit = new VisitEntity();
        visit.setTime(time);
        visit.setPatient(patient);
        visit.setDescription(description);
        visit.setDoctor(doctor);
        visit.setTreatments(new ArrayList<>());

        patient.getVisits().add(visit);

        entityManager.merge(patient);

        return patient;
    }

    @Override
    public List<PatientEntity> findByLastName(String lastName) {
        String query = "SELECT p FROM PatientEntity p WHERE p.lastName =: lastName";
        return entityManager.createQuery(query, PatientEntity.class)
                .setParameter("lastName", lastName)
                .getResultList();
    }

    @Override
    public List<PatientEntity> findPatientsWithMoreVisitsThan(long minVisit) {
        String query = "SELECT p FROM PatientEntity p JOIN VisitEntity v ON p.id = v.patient.id GROUP BY p.id HAVING COUNT(v.id) > :minVisit";
        return entityManager.createQuery(query, PatientEntity.class)
                .setParameter("minVisit", minVisit)
                .getResultList();
    }

    @Override
    public List<PatientEntity> findPatientsByGender(List<Gender> genderList) {
        return entityManager.createQuery(
                "SELECT patient FROM PatientEntity patient WHERE gender IN (:genderList)",
                        PatientEntity.class
                )
                .setParameter("genderList", genderList)
                .getResultList();
    }
}

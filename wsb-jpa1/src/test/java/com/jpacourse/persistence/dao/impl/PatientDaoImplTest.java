package com.jpacourse.persistence.dao.impl;

import com.jpacourse.persistence.dao.PatientDao;
import com.jpacourse.persistence.entity.PatientEntity;
import com.jpacourse.persistence.entity.VisitEntity;
import com.jpacourse.persistence.enums.Gender;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class PatientDaoImplTest {

    @Autowired
    private PatientDao patientDao;

    @Transactional
    @Test
    void testShouldAddNewVisitToPatient() {
        //given
        final Long patientId = 1L;
        final Long doctorId = 1L;
        final LocalDateTime time = LocalDateTime.now();
        final String description = "Description";

        //when
        final PatientEntity patient = patientDao.addVisitToPatient(patientId, doctorId, time, description);
        final VisitEntity lastVisit = patient.getVisits().get(patient.getVisits().size() - 1);

        //then
        assertThat(patient.getId()).isEqualTo(patientId);
        assertThat(lastVisit.getDescription()).isEqualTo(description);
        assertThat(lastVisit.getTime()).isEqualTo(time);
        assertThat(lastVisit.getDoctor().getId()).isEqualTo(doctorId);
    }

    @Transactional
    @Test
    void testShouldFindPatientsByGender() {
        //given
        List<Gender> genderList =  Arrays.asList(Gender.MALE, Gender.OTHER);
        List<Gender> genderSecondList = List.of(Gender.FEMALE);

        //when
        List<PatientEntity> patientsList = patientDao.findPatientsByGender(genderList);
        List<PatientEntity> patientsSecondList = patientDao.findPatientsByGender(genderSecondList);

        //then
        assertThat(patientsList).hasSize(4);
        assertThat(patientsSecondList).hasSize(2);
    }

    @Test
    void testFindByLastName() {
        // when
        List<PatientEntity> result = patientDao.findByLastName("Krzyk");

        // then
        assertThat(result).hasSize(2);
        assertThat(result.get(0).getFirstName()).isEqualTo("Malina");
        assertThat(result.get(1).getFirstName()).isEqualTo("Adam");
    }

    @Test
    void testFindPatientsWithMoreVisitsThan() {
        // when
        List<PatientEntity> result = patientDao.findPatientsWithMoreVisitsThan(1);

        // then
        assertThat(result).hasSize(1);
        assertThat(result.get(0).getLastName()).isEqualTo("Janowski");
    }
}
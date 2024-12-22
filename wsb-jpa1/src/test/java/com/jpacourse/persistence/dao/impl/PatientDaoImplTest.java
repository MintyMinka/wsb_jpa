package com.jpacourse.persistence.dao.impl;

import com.jpacourse.persistence.dao.PatientDao;
import com.jpacourse.persistence.entity.PatientEntity;
import com.jpacourse.persistence.entity.VisitEntity;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;

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
}
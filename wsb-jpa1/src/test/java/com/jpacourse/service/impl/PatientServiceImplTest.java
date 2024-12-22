package com.jpacourse.service.impl;

import com.jpacourse.dto.PatientTO;
import com.jpacourse.persistence.dao.Dao;
import com.jpacourse.persistence.dao.DoctorDao;
import com.jpacourse.persistence.dao.PatientDao;
import com.jpacourse.persistence.dao.VisitDao;
import com.jpacourse.persistence.entity.DoctorEntity;
import com.jpacourse.persistence.entity.PatientEntity;
import com.jpacourse.persistence.entity.VisitEntity;
import com.jpacourse.persistence.enums.Gender;
import com.jpacourse.service.PatientService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
class PatientServiceImplTest {
    @Autowired
    private PatientService patientService;

    @Autowired
    private PatientDao patientDao;
    @Autowired
    private VisitDao visitDao;
    @Autowired
    private DoctorDao doctorDao;

    @Transactional
    @Test
    void testShouldDeletePatientAndVisits() {
        //given
        final Long patienToDeleteId = 2L;
        final PatientEntity patientToDelete = patientDao.findOne(patienToDeleteId);
        final List<VisitEntity> visitListToDelete = patientToDelete.getVisits();

        //when
        patientService.delete(patientToDelete.getId());

        //then
        final PatientEntity deletedPatient = patientDao.findOne(patienToDeleteId);
        assertThat(deletedPatient).isEqualTo(null);

        for (VisitEntity visit : visitListToDelete) {
            assertThat(
                    visitDao.findOne(visit.getId())
            ).isEqualTo(null);

            assertThat(
                    doctorDao.findOne(visit.getDoctor().getId())
            ).isExactlyInstanceOf(DoctorEntity.class);
        }
    }

    @Test
    void testShouldReturnCorrectField() {
        //given
        final Long patientId = 1L;

        //when
        final PatientTO patient = patientService.findById(patientId);

        //then
        assertThat(patient.getGender()).isEqualTo(Gender.FEMALE);
    }
}
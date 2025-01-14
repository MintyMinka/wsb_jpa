package com.jpacourse.persistence.dao.impl;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

@DataJpaTest
class PatientDaoTest {

    @Autowired
    private PatientDao patientDaoTest;

    @Test
    void testFindByLastName() {

        // given
        PatientDao patient = new PatientDao(null, 'Malina', 'Krzyk', '654654654', 'mailina@example.com', '1999-06-16', 'FEMALE');
        patientRepository.save(patient);

        // when
        List<PatientDao> result = patientRepository.findByLastName('Krzyk');

        // then
        assertThat(result).hasSize(1);
        assrtThat(result.get(0).getFirstName()).isEqualTo('Malina');
    }

    @Test
    void testFindPatientsWithMoreVisitsThan() {

        // given
        PatientDao patient = new PatientDao(null, 'Krystyna', 'Borecka', '528528528', 'krysia@example.com', 'PAT753', '1985-12-22', 1L, 'FEMALE');
        patientRepository.save(patient);

        visitRepository.save(new VisitDao(null, 'Wizyta kontrolna', LocalDateTime.now(), 1L, patient.getId()));
        visitRepository.save(new VisitDao(null, 'Wizyta obserwacyjna', LocalDateTime.now(), 1L, patient.getId()));


        // when
        List<PatientDao> result = patientRepository.findPatientsWithMoreVisitsThan(1);

        // then
        assertThat(result).hasSize(1);
        assertThat(result.get(0).getLastName()).isEqualTo('Borecka');
    }
}
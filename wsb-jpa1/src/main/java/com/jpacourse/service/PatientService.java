package com.jpacourse.service;

import com.jpacourse.dto.NewVisitTO;
import com.jpacourse.dto.PatientTO;
import com.jpacourse.dto.VisitTO;

import java.util.List;

public interface PatientService
{
    public PatientTO findById(final Long id);
    public PatientTO createNewVisit(final NewVisitTO newVisitTO);
    public void delete(final Long id);
    public List<VisitTO> findVisitsByPatientId(final Long patientId);
}

package com.jpacourse.service;

import com.jpacourse.dto.NewVisitTO;
import com.jpacourse.dto.PatientTO;

public interface PatientService
{
    public PatientTO findById(final Long id);
    public PatientTO createNewVisit(final NewVisitTO newVisitTO);
}

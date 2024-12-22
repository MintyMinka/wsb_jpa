package com.jpacourse.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

public class VisitTO implements Serializable
{
    private String description;
    private LocalDateTime time;
    private DoctorTO doctor;
    private List<MedicalTreatmentTO> treatments;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public DoctorTO getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorTO doctor) {
        this.doctor = doctor;
    }

    public List<MedicalTreatmentTO> getTreatments() {
        return treatments;
    }

    public void setTreatments(List<MedicalTreatmentTO> treatments) {
        this.treatments = treatments;
    }
}

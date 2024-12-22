package com.jpacourse.dto;

import com.jpacourse.persistence.enums.TreatmentType;

import java.io.Serializable;

public class MedicalTreatmentTO implements Serializable
{
    private TreatmentType type;

    public TreatmentType getType() {
        return type;
    }

    public void setType(TreatmentType type) {
        this.type = type;
    }
}

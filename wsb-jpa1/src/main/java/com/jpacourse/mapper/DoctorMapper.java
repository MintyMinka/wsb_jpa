package com.jpacourse.mapper;

import com.jpacourse.dto.DoctorTO;
import com.jpacourse.persistence.entity.DoctorEntity;

public final class DoctorMapper {

    public static DoctorTO mapToTO(final DoctorEntity doctorEntity) {
        if (doctorEntity == null) {
            return null;
        }

        final DoctorTO doctorTO = new DoctorTO();
        doctorTO.setFirstName(doctorEntity.getFirstName());
        doctorTO.setLastName(doctorEntity.getLastName());

        return doctorTO;
    }

    public static DoctorEntity mapToEntity(final DoctorTO doctorTO) {
        if (doctorTO == null) {
            return null;
        }
        DoctorEntity doctorEntity = new DoctorEntity();
        doctorEntity.setFirstName(doctorTO.getFirstName());
        doctorEntity.setLastName(doctorTO.getLastName());

        return doctorEntity;
    }
}

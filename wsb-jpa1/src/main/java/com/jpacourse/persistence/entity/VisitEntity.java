package com.jpacourse.persistence.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "VISIT")
public class VisitEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String description;

	@Column(nullable = false)
	private LocalDateTime time;

	@ManyToOne(optional = false)
	@JoinColumn(name = "DOCTOR_ID")
	// Jednostronna relacja od strony Visit do Doctor
	private DoctorEntity doctor;

	@ManyToOne(optional = false)
	@JoinColumn(name = "PATIENT_ID")
	// Jednostronna relacja od strony Visit do Patient
	private PatientEntity patient;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "VISIT_ID")
	// Dwustronna relacja między Visit a MedicalTreatment (Visit jest właścicielem)
	private List<MedicalTreatmentEntity> treatments;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public DoctorEntity getDoctor() {
		return doctor;
	}

	public void setDoctor(DoctorEntity doctor) {
		this.doctor = doctor;
	}

	public PatientEntity getPatient() {
		return patient;
	}

	public void setPatient(PatientEntity patient) {
		this.patient = patient;
	}

	public List<MedicalTreatmentEntity> getTreatments() {
		return treatments;
	}

	public void setTreatments(List<MedicalTreatmentEntity> treatments) {
		this.treatments = treatments;
	}
}

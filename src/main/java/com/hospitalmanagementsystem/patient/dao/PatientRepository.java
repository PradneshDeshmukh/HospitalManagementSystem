package com.hospitalmanagementsystem.patient.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospitalmanagementsystem.patient.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer> {

}

package com.hospitalmanagementsystem.patient.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hospitalmanagementsystem.patient.dao.PatientRepository;
import com.hospitalmanagementsystem.patient.model.Patient;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class PatientController {

	@Autowired
	PatientRepository pRepo;
	
	
	@GetMapping("/patient")
	public List<Patient> getAllPatients(){
		
		return pRepo.findAll();
	}
	
	
	@PostMapping("/patient")
	public Patient createPatient(@RequestBody Patient patient) {
		
		return pRepo.save(patient);
	}
	
	@PutMapping(path="/patient")
	public Patient saveOrUpdatePatient(@RequestBody Patient patient)
	{
		pRepo.save(patient);
		return patient;
	}
	

	
	@GetMapping("/patient/{id}")
	public Optional<Patient> getPatient(@PathVariable("id")int id)
	{
		return pRepo.findById(id);


	} 
	
	@DeleteMapping("/patient/{id}")
	public String deleteAlien(@PathVariable int id)
	{
		Patient a = pRepo.getOne(id);
		pRepo.delete(a);
		return "deleted";
	}
	
}

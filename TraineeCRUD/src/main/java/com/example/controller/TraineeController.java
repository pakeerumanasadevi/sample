package com.example.controller;

import java.util.List;

import com.example.exceptions.IdNotFoundException;
import com.example.service.TraineeService;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.entity.Trainee;

@RestController
@RequestMapping("/Trainees")
@CrossOrigin("http://localhost:4200")
public class TraineeController {
	@Autowired
	TraineeService serviceobj;

	// Create Employee
	@PostMapping("/TraineeCreation")
	public ResponseEntity<String> traineeCreation(@RequestBody Trainee emp) {
		Trainee e = serviceobj.traineeCreation(emp);
		if (e == null) {
			throw new IdNotFoundException("Enter Valid Id");
		} else {
			return new ResponseEntity<String>("Trainee created successfully", new HttpHeaders(), HttpStatus.OK);
		}
	}

	// Get Particular Employee Data
	@GetMapping("/GetTrainee/{id}")
	private ResponseEntity<Trainee> getTrainee(@PathVariable("id") int id) {
		Trainee e = serviceobj.getTraineeById(id);
		if (e == null) {
			throw new IdNotFoundException("Id does not exist,so we couldn't fetch details");
		} else {
			return new ResponseEntity<Trainee>(e, new HttpHeaders(), HttpStatus.OK);
		}
	}

	// Get All Employees Data
	@GetMapping("/GetAllTrainees")
	private ResponseEntity<List<Trainee>> getAllTrainee() {
		List<Trainee> emplist = serviceobj.getAllTrainee();
		return new ResponseEntity<List<Trainee>>(emplist, new HttpHeaders(), HttpStatus.OK);

	}

	// Updating Employee data
	@PutMapping("/UpdateTrainee")
	public ResponseEntity<String> updateTrainee(@RequestBody Trainee emp) {
		Trainee e = serviceobj.updateTrainee(emp);
		if (e == null) {
			throw new IdNotFoundException("Update Operation Unsuccessful,Provided Id does not exist");
		} else {
			return new ResponseEntity<String>("Trainee updated successfully", new HttpHeaders(), HttpStatus.OK);
		}
	}

	// Deleting Employee
	@DeleteMapping("/DeleteTrainee/{id}")
	private ResponseEntity<String> deltra(@PathVariable("id") int id) {
		Trainee e = serviceobj.delete(id);
		if (e == null) {
			throw new IdNotFoundException("Delete Operation Unsuccessful,Provided Id does not exist");
		} else {
			return new ResponseEntity<String>("Trainee deleted successfully", new HttpHeaders(), HttpStatus.OK);
		}
	}

	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<String> userNotFound(IdNotFoundException e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
}

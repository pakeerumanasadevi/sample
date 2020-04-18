package com.example.service;

import java.util.List;

import com.example.entity.Trainee;

public interface TraineeService {

	Trainee traineeCreation(Trainee emp);

	Trainee getTraineeById(int id);

	List<Trainee> getAllTrainee();

	Trainee delete(int id);

	Trainee updateTrainee(Trainee tra);


}
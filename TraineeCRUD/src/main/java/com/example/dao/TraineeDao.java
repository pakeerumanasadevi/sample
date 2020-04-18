package com.example.dao;

import java.util.List;

import com.example.entity.Trainee;

public interface TraineeDao {

	Trainee deleteById(int id);

	List<Trainee> getAllTrainee();

	Trainee getTraineeById(int id);

	Trainee TraineeCreation(Trainee emp);

	Trainee updateTrainee(Trainee emp);
}

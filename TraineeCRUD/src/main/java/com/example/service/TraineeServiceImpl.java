package com.example.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.entity.Trainee;
import com.example.dao.TraineeDaoImpl;

@Service
@Transactional
public class TraineeServiceImpl implements TraineeService 
{
@Autowired
TraineeDaoImpl dao;

/* (non-Javadoc)
 * @see com.example.service.EmployeeService#EmployeeCreation(com.example.entity.Employee)
 */
public Trainee traineeCreation(Trainee emp) {
	return dao.TraineeCreation(emp);
}

/* (non-Javadoc)
 * @see com.example.service.EmployeeService#getEmployeeById(int)
 */
@Override
public Trainee getTraineeById(int id) 
{
return dao.getTraineeById(id);
}

/* (non-Javadoc)
 * @see com.example.service.EmployeeService#getAllEmployee()
 */
@Override
public List<Trainee> getAllTrainee() 
{
return dao.getAllTrainee();
}

/* (non-Javadoc)
 * @see com.example.service.EmployeeService#delete(int)
 */
@Override
public Trainee delete(int id) 
{
	return dao.deleteById(id);
}

/* (non-Javadoc)
 * @see com.example.service.EmployeeService#UpdateEmployee(com.example.entity.Employee)
 */
@Override
public Trainee updateTrainee(Trainee emp) {
	return dao.updateTrainee(emp);	
}



}
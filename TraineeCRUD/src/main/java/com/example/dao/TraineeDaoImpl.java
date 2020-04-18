package com.example.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

import com.example.entity.Trainee;
@Repository
public class TraineeDaoImpl implements TraineeDao {

	@PersistenceContext	
	 EntityManager em;
	
	@Override
	public Trainee TraineeCreation(Trainee emp) {
		// TODO Auto-generated method stub
		Trainee e=em.merge(emp);
		return e;
	}
	
	@Override
	public Trainee getTraineeById(int id) {
		
		return em.find(Trainee.class,id);
	}
	
	@Override
	public List<Trainee> getAllTrainee() {
		Query q=em.createQuery("select m from Trainee m");
		List<Trainee> emplist=q.getResultList();
		return emplist;
	}
	
	@Override
	public Trainee updateTrainee(Trainee emp) {
		Trainee e=em.find(Trainee.class,emp.getId());
		if(e!=null)
		{
			e.setName(emp.getName());
			e.setSalary(emp.getSalary());
			e.setPhonenumber(emp.getPhonenumber());
			e.setCompany(emp.getCompany());
		}
		return e;
			
	}
	@Override	
	public Trainee deleteById(int id) {
		Trainee e=em.find(Trainee.class,id);
		if(e!=null)
			{em.remove(e);
			}
        return e;
	}
}

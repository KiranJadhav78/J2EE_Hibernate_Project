package com.user.dao;


import java.util.List;

import javax.transaction.SystemException;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.user.domain.User;
import com.user.util.HibernateUtil;

public class UserDao {
	
	//Save User
	//Get All User
	//Get User By ID
	//Update User
	//Delete User

	public void saveUser(User user) throws IllegalStateException, SystemException {
		
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			
			transaction = session.beginTransaction();
			
			//save users
			session.save(user);
			
			transaction.commit();
		}catch(Exception e) {
			if(transaction != null){
			     transaction.rollback();
			}
		}
	}
	public void UpdateUser(User user) throws IllegalStateException, SystemException {
		
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			
			transaction = (Transaction) session.beginTransaction();
			
			//save users
			session.saveOrUpdate(user);
			
			transaction.commit();
		}catch(Exception e) {
			if(transaction != null){
			     transaction.rollback();
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<User> getAllUsers() throws IllegalStateException, SystemException {
		
		Transaction transaction = null;
		List <User> users=null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			
			transaction = (Transaction) session.beginTransaction();
			
			//save users
			users = session.createQuery("from User").list();
			
			transaction.commit();
		}catch(Exception e) {
			if(transaction != null){
			     transaction.rollback();
			}
		}
		return users;
	}
	
	public void deleteuser(long id) throws IllegalStateException, SystemException{		
		Transaction transaction = null;
		User user=null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			
			transaction = (Transaction) session.beginTransaction();
			
			user = session.get(User.class,id);
			//save users
			session.delete(user);
			
			transaction.commit();
		}catch(Exception e) {
			if(transaction != null){
			     transaction.rollback();
			}
		}
		
	}
}

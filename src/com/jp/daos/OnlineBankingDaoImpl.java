package com.jp.daos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jp.entity.CustomerDetails;
import com.jp.entity.CustomerMaster;

@Transactional
@Repository("dao")
public class OnlineBankingDaoImpl implements IOnlineBankingDao{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	
	
	//@Autowired
	/*public OnlineBankingDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
	}*/




	
	@Override
	public void addNewCustoer(CustomerMaster cm) {
		//boolean custAdd=false;
		System.out.println("reached");
		System.out.println(cm);
		System.out.println(cm.getCustomerdetails().getCustomerDetailsId());
		entityManager.persist(cm);
		
	}



	@Override
	public void addNewCustoer(CustomerDetails cd) {
		// TODO Auto-generated method stub
		System.out.println("reached");
		System.out.println(cd);
		entityManager.persist(cd);
	}
	
	

}

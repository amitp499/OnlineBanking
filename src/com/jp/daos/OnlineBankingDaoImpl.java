package com.jp.daos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.jp.entity.CustomerMaster;
import com.jp.entity.CustomerDetail;
import com.jp.exceptions.OnlineBankingException;


@Repository("dao")
@Transactional(propagation=Propagation.REQUIRED)
public class OnlineBankingDaoImpl implements IOnlineBankingDao{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public boolean addNewCustoer(CustomerMaster cm) throws OnlineBankingException {		
		boolean addCustomerFlag=false;
		
		System.out.println("reached");
		
		System.out.println(cm);
		entityManager.persist(cm);		
		if (entityManager.find(CustomerMaster.class, cm.getUserId())!=null){
			
			addCustomerFlag=true;
			
		}
		return addCustomerFlag;
	}
		
	
	

}

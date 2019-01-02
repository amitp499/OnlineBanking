package com.jp.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name="Beneficiary")
@Table(name="BENEFICIARY_DETAILS_TBL")
public class BeneficiaryDetails implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1002160690606641618L;
	private Integer beneficiaryId;
	private String beneficiaryIfscCode;
	private String beneficiartName;
	private Integer beneficiaryAccountNo;
	private CustomerDetail customerDetail;
	
	
	
	public BeneficiaryDetails() {
		super();
		
	}
	
	@SequenceGenerator(name="beneficiary_id_seq",sequenceName="beneficiary_id_seq", allocationSize=60)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="beneficiary_id_seq")
	@Id
	@Column(name="BENEFICIARY_ID")
	public Integer getBeneficiaryId() {
		return beneficiaryId;
	}
	public void setBeneficiaryId(Integer beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
	}
	
	@Column(name="BENEFICIARY_IFSC_CODE")
	public String getBeneficiaryIfscCode() {
		return beneficiaryIfscCode;
	}
	public void setBeneficiaryIfscCode(String beneficiaryIfscCode) {
		this.beneficiaryIfscCode = beneficiaryIfscCode;
	}
	
	@Column(name="BENEFICIARY_NAME")
	public String getBeneficiartName() {
		return beneficiartName;
	}
	public void setBeneficiartName(String beneficiartName) {
		this.beneficiartName = beneficiartName;
	}
	
	@Column(name="BENEFICIARY_ACCOUNTNO")
	public Integer getBeneficiaryAccountNo() {
		return beneficiaryAccountNo;
	}
	public void setBeneficiaryAccountNo(Integer beneficiaryAccountNo) {
		this.beneficiaryAccountNo = beneficiaryAccountNo;
	}

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="CUSTOMER_ID")
	public CustomerDetail getCustomerDetail() {
		return customerDetail;
	}

	public void setCustomerDetail(CustomerDetail customerDetail) {
		this.customerDetail = customerDetail;
	}

	@Override
	public String toString() {
		return "BeneficiaryDetails [beneficiaryId=" + beneficiaryId + ", beneficiaryIfscCode=" + beneficiaryIfscCode
				+ ", beneficiartName=" + beneficiartName + ", beneficiaryAccountNo=" + beneficiaryAccountNo
				+ ", customerDetail=" + customerDetail + "]";
	}
	
	
	
	
	
	
	
	
	

}

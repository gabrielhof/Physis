package br.feevale.physis.business.model.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.feevale.physis.model.Bean;

@Entity @Table(name="payments")
public class Payment extends Bean {

	private static final long serialVersionUID = -4240062157307294484L;
	
	private Integer id;
	
	private Date issueDate;
	private Date paymentDate;
	private Double value;
	private Person person;
	
	@Id @GeneratedValue @Override
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
//	@Temporal(TemporalType.DATE)
	@Column(name="issue_date")
	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

//	@Temporal(TemporalType.DATE)
	@Column(name="payment_date", nullable=true)
	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	@Column(name="value", length=12, precision=10, scale=2)
	public Double getValue() {
		return value;
	}
	
	public void setValue(Double value) {
		this.value = value;
	}
	
	@Override
	public String toUserString() {
		//Gabriel
		return null;
	}

	@ManyToOne @JoinColumn(name="person_id", updatable=true)
	public Person getPerson() {
		return person;
	}
	
	public void setEquipment(Person person) {
		this.person = person;
	}	
	
}

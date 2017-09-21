package com.example.crudexample.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "receipt")
public class Receipt {	
	
		@Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name = "id", updatable = false)
	    private long id;
		
		@NotNull
		@Min(value = 1)
		@Column(name = "empid", updatable = true)
	    private long empid;	
		
		@NotNull
		@Size(max = 255)
		@Column(name = "receipt_type", updatable = true)
		private String receipt_type;
		
		
		@NotNull
		@Column(name = "receipt_amount", updatable = true)
	    private double receipt_amount;
		
		@NotNull
		@Size(max = 255)
		@Column(name = "receipt_date", updatable = true)
		private String receipt_date;
		

		public Receipt() {
			super();
		}

		public Receipt( long empid, String receipt_type, double receipt_amount, String receipt_date) {
			super();
			
			this.empid = empid;
			this.receipt_type = receipt_type;
			this.receipt_amount = receipt_amount;
			this.receipt_date = receipt_date;
		}

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public long getEmpid() {
			return empid;
		}

		public void setEmpid(long empid) {
			this.empid = empid;
		}

		public String getReceipt_type() {
			return receipt_type;
		}

		public void setReceipt_type(String receipt_type) {
			this.receipt_type = receipt_type;
		}

		public double getReceipt_amount() {
			return receipt_amount;
		}

		public void setReceipt_amount(double receipt_amount) {
			this.receipt_amount = receipt_amount;
		}

		public String getReceipt_date() {
			return receipt_date;
		}

		public void setReceipt_date(String receipt_date) {
			this.receipt_date = receipt_date;
		}
	    

}

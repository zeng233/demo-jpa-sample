package com.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;


@Entity
@Table(name="t_flow")
public class Flow {
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	

	private int flowid;
	private String flowname;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="i_flowid")
	public int getFlowid() {
		return flowid;
	}
	public void setFlowid(int flowid) {
		this.flowid = flowid;
	}
	
	@Column(name="v_flowname")
	public String getFlowname() {
		return flowname;
	}
	public void setFlowname(String flowname) {
		this.flowname = flowname;
	}
	
}

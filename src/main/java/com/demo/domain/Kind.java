package com.demo.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="t_kind")
public class Kind implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer kindid;
	private String kname;
	private String kcode;
	private String status;
	
	@Id
	@GeneratedValue
	public Integer getKindid() {
		return kindid;
	}
	public void setKindid(Integer kindid) {
		this.kindid = kindid;
	}
	public String getKname() {
		return kname;
	}
	public void setKname(String kname) {
		this.kname = kname;
	}
	public String getKcode() {
		return kcode;
	}
	public void setKcode(String kcode) {
		this.kcode = kcode;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	

}

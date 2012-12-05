package com.demo.domain;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="t_ware")
public class Ware implements Serializable {

	private static final long serialVersionUID = -4754461416489868253L;

	private Integer wid;
	private String wname;
	private String wcode;
	private Integer price;
	private String img;
	private String description;
	private String remark;
	private Date releaseDate;
	private Integer status;
	//private Kind kind;
	
	public Ware() {
		//kind = new Kind();// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Entity Ware={wid:"+wid+",wname:"+wname+",price:"+price+"}";
	}
	
	@Id
	@GeneratedValue
	public Integer getWid() {
		return wid;
	}
	public void setWid(Integer wid) {
		this.wid = wid;
	}
	public String getWname() {
		return wname;
	}
	public void setWname(String wname) {
		this.wname = wname;
	}
	public String getWcode() {
		return wcode;
	}
	public void setWcode(String wcode) {
		this.wcode = wcode;
	}

	@Column(name="points")
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	//这里不写fetchtype会是什么呢
//	@ManyToOne
//	@Column(name="kindid")
//	public Kind getKind() {
//		return kind;
//	}
//	public void setKind(Kind kind) {
//		this.kind = kind;
//	}	
	
	
	
}

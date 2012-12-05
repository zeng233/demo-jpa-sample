package com.demo.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;


/**
 * 技巧:输出完整的对象
 * ToStringBuilder.reflectionToString(this);
 */

@Entity
@NamedQuery(name="User.byNamedQuery",query="from User u where u.name = '9527'")
@NamedNativeQuery(name="User.byNamedNativeQuery",query="select * from xchen7129752.t_user where name = '9527'",resultClass=User.class)
@Table(name="t_user")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer userid;
	private String username;
	private String password;
	private String serial;
	private String name;
	private Integer gender;
	private String mail;
	private Integer status;
	private Dept dept;
	private Set<Role> roles;
	
	@Override
	public String toString() {
		return "Entity User={userid:"+userid+",username:"+username+",name:"+name+"}";
		//return ToStringBuilder.reflectionToString(this);
	}
	
	public User() {
		dept = new Dept();
		roles = new HashSet<Role>();
	}
	
	
	/** ------------ getter/setter ------------ */

	@Id
	@GeneratedValue
	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="deptid")
	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="t_user_role"
		,joinColumns={@JoinColumn(name="userid")}
		,inverseJoinColumns={@JoinColumn(name="rid")
	})
	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

}
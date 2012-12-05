package com.demo.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;


@Entity
@Table(name="t_dept")
public class Dept implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer deptid;
	private Integer parentId;
	private String deptname;
	private String deptcode;
	private Integer status;
	private Set<User> users;
	
	
	public Dept() {
		users = new HashSet<User>();
	}
	
	@Override
	public String toString() {
		//return ToStringBuilder.reflectionToString(this);
		return "Entity Dept={deptid:"+deptid+",deptname:"+deptname+"}";
	}

	
	

	/** ------------ getter/setter ------------ */

	@Id
	@GeneratedValue
	public Integer getDeptid() {
		return deptid;
	}

	public void setDeptid(Integer deptid) {
		this.deptid = deptid;
	}

	public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	public String getDeptcode() {
		return deptcode;
	}

	public void setDeptcode(String deptcode) {
		this.deptcode = deptcode;
	}

	@Column(name="parent_id")
	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@OneToMany(fetch=FetchType.LAZY,mappedBy="dept")
	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	

	/** ------------ getter/setter ------------ */
	

}
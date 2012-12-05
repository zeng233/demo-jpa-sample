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
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;

@Entity
@Table(name="t_role")
public class Role implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer rid;
	private String rname;
	private Integer status;
	private Set<User> users;

	public Role() {
		users = new HashSet<User>();
	}
	
	@Override
	public String toString() {
		return "Entity Role={rid:"+rid+",rname:"+rname+"}";
		//return ToStringBuilder.reflectionToString(this);
	}
	
	
	/** ------------ getter/setter ------------ */
//	private List<Right> rights;
//	public List<Right> getRights() {
//		return rights;
//	}
//
//	public void setRights(List<Right> rights) {
//		this.rights = rights;
//	}
	
	



	@Id
	@GeneratedValue
	public Integer getRid() {
		return rid;
	}
	
	public void setRid(Integer rid) {
		this.rid = rid;
	}
	
	public String getRname() {
		return rname;
	}
	
	public void setRname(String rname) {
		this.rname = rname;
	}

	public Integer getStatus() {
		return status;
	}
	
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="t_user_role",
			joinColumns={@JoinColumn(name="rid")},
			inverseJoinColumns={@JoinColumn(name="userid")}
	)
	public Set<User> getUsers() {
		return users;
	}
	
	public void setUsers(Set<User> users) {
		this.users = users;
	}

}
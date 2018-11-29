package com.nareshit.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Role implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="roleId")
	private Integer id;
	
	
	/*@OneToMany(cascade=CascadeType.ALL)
	private List<Permission> permList;
	
	public List<Permission> getPermList() {
		return permList;
	}
	public void setPermList(List<Permission> permList) {
		this.permList = permList;
	}*/
	@OneToMany(cascade=CascadeType.ALL,mappedBy="role")
	private List<RoleToPermission> permList;
	
	
	public List<RoleToPermission> getPermList() {
		return permList;
	}
	public void setPermList(List<RoleToPermission> permList) {
		this.permList = permList;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	private String role;
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

}

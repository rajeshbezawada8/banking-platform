package com.bank.auth.model.entity;

import java.util.List;

import com.bank.auth.model.enums.Status;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "permissions")
public class Permissions {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "permission_id")
	private Long id;

	@Column(name = "permission_code", nullable = false, unique = true, length = 100)
	private String permissionCode;

	@Column(name = "permission_name", nullable = false, length = 150)
	private String permissionName;

	@Column(name = "resource", nullable = false, length = 100)
	private String resource;

	@Column(name = "action", nullable = false, length = 50)
	private String action;

	@Column(name = "description", length = 255)
	private String description;

	@Enumerated(EnumType.STRING)
	@Column(name = "status", nullable = false)
	private Status status;
	
	@OneToMany(mappedBy = "permission")
    private List<RolePermissions> rolePermissions;
	
	public Permissions() {
		
	}

	public Long getId() {
		return id;
	}

	public String getPermissionCode() {
		return permissionCode;
	}

	public void setPermissionCode(String permissionCode) {
		this.permissionCode = permissionCode;
	}

	public String getPermissionName() {
		return permissionName;
	}

	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}

	public String getResource() {
		return resource;
	}

	public void setResource(String resource) {
		this.resource = resource;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public List<RolePermissions> getRolePermissions() {
		return rolePermissions;
	}

	public void setRolePermissions(List<RolePermissions> rolePermissions) {
		this.rolePermissions = rolePermissions;
	}
}

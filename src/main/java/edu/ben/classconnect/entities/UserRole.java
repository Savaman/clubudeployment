package edu.ben.classconnect.entities;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "userRole")
@AttributeOverride(name = "id", column = @Column(name = "idUserRole", nullable = false, columnDefinition = "BIGINT UNSIGNED"))
public class UserRole extends BaseEntity {

	@Column(name = "role")
	private String role;

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "UserRole [ role=" + role + "]";
	}

}

package com.app.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity(name = "role")
@Table(name = "role2")
public class RoleEntity {
	
	@Id
    @Column(name="role_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roleNo;

    @Column(name="role_nm", length = 20)
    private String roleNm;
    
}

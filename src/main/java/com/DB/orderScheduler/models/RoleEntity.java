package com.DB.orderScheduler.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "role")
@Getter
@Setter
public class RoleEntity extends BaseModel{

    @Enumerated(EnumType.STRING)
    @Column(unique = true, nullable = false)
    private RoleType type;
}

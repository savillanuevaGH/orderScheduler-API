package com.DB.orderScheduler.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class UserModel extends BaseModel {

    @Column(unique = true, nullable = false)
    private String email;

    @Column(name = "nombre")
    private String name;
    @Column(name = "apellido")
    private String lastName;
    @Column(name = "fechaBaja")
    private LocalDate dischargeDate;
    @Column(name = "dni",unique = true, nullable = false)
    private int dni;
    @Column(name = "contrasena", nullable = false)
    private String password;

    // Tabla para asignar roles (dudoso)
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<RoleEntity> roles;

    //Tabla de Usarios a Tabla de Pedidos
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(
            name = "user_order",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "order_id")
    )
    private List<OrderModel> orderModelList;

    // Tabla de 'Admin' a Tabla de Menúses
    @OneToMany
    @JoinTable(
            name = "user_menu",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "menu_id")
    )
    private List<MenuModel> menuModelList;
}

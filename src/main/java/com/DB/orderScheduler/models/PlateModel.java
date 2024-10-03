package com.DB.orderScheduler.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "plate")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class PlateModel extends BaseModel {

    @Column(name = "nombre")
    private String name;
    @Column(name = "descripcion")
    private String description;
    @Column(name = "categoria")
    private Enum<?> category;
    @Column(name = "dia")
    private LocalDate day;
    @Column(name = "stock")
    private Integer stock;
    @Column(name = "comentario")
    private String comment;

    @OneToMany(mappedBy = "plate", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<OrderPlate> orderPlates;

    @ManyToOne()
    @JoinTable(
            name = "plate_menu",
            joinColumns = @JoinColumn(name = "plate_id"),
            inverseJoinColumns = @JoinColumn(name = "menu_id")
    )
    private Set<UserModel> user;
}

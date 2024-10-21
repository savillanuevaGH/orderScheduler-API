package com.DB.orderScheduler.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "menu")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class MenuModel extends BaseModel {

    @Column(name = "semana")
    private Integer week;
    @Column(name = "fecha_baja")
    private LocalDate dischargeDate;

    @OneToOne
    @JoinTable(
            name = "menu_plate",
            joinColumns = @JoinColumn(name = "menu_id"),
            inverseJoinColumns = @JoinColumn(name = "menu_plate_id")
    )
    private MenuPlate menuPlate;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinTable(
            name = "menu_user",
            joinColumns = @JoinColumn(name = "menu_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private UserModel user;
}

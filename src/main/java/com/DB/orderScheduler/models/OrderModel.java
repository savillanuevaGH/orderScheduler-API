package com.DB.orderScheduler.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "order")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class OrderModel extends BaseModel{

    @Column(name = "semana")
    private Integer week;
    @Column(name = "fecha_pedido")
    private LocalDate orderDate;
    @Column(name = "fecha_baja")
    private LocalDate dischargeDate;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private UserModel userModel;
}

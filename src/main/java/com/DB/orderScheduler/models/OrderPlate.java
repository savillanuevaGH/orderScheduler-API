package com.DB.orderScheduler.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "order_plate")
@Getter
@Setter
public class OrderPlate extends BaseModel {

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private OrderModel order;

    @ManyToOne
    @JoinColumn(name = "plate_id", nullable = false)
    private PlateModel plate;

    @Column(name = "dia", nullable = false)
    private String day;

    @Column(name = "cantidad", nullable = false)
    private Integer amount;
}

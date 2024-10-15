package com.DB.orderScheduler.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "menu_plate")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MenuPlate extends BaseModel{

    @ManyToOne
    @JoinColumn(name = "id_menu", nullable = false)
    private MenuModel menuModel;

    @ManyToOne
    @JoinColumn(name = "id_plate", nullable = false)
    private PlateModel plateModel;
}

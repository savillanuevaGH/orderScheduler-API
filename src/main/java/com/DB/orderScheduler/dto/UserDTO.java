package com.DB.orderScheduler.dto;

import com.DB.orderScheduler.models.MenuModel;
import com.DB.orderScheduler.models.OrderModel;
import com.DB.orderScheduler.models.RoleEntity;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDTO {

    @NotNull
    private String email;
    @NotNull
    private String name;
    private String lastName;
    private LocalDate dischargeDate;
    private int dni;
    private String password;
    private Set<RoleEntity> roles;
    private List<OrderModel> orderModelList;
    private List<MenuModel> menuModelList;
}

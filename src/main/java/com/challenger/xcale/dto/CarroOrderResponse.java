package com.challenger.xcale.dto;

import com.challenger.xcale.model.Producto;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class CarroOrderResponse {

    String idCarrito;
    List<Producto> listaProductos;
    String accountId;
    double totalAmount;
    double totalTax;
    double totalAmountTax;
    Date fechaCreacion;
}

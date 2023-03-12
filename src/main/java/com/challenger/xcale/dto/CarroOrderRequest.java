package com.challenger.xcale.dto;

import com.challenger.xcale.model.Producto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarroOrderRequest {

    List<Producto> listaProductos;
}

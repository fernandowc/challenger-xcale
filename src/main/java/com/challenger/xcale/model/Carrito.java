package com.challenger.xcale.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Carrito {
    String idCarrito;
    List<Producto> listaProductos;
    String fechaCreacion;
}

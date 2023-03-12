package com.challenger.xcale.service;

import com.challenger.xcale.dto.CarroOrderRequest;
import com.challenger.xcale.model.Carrito;
import java.util.Optional;


public interface CarritoService {

    Carrito buscarCarritoPorId(String idCarrito);
    Carrito nuevoCarrito(CarroOrderRequest carrito);
    Optional<Carrito> eliminarCarrito(String idCarrito);
}

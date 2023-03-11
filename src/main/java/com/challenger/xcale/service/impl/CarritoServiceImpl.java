package com.challenger.xcale.service.impl;

import com.challenger.xcale.model.Carrito;
import com.challenger.xcale.model.Producto;
import com.challenger.xcale.service.CarritoService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CarritoServiceImpl implements CarritoService {

    @Override
    public Carrito nuevoCarrito(Carrito carritos) {

        return iniCarrito(carritos);
    }


    private Carrito iniCarrito(Carrito productoRequest) {

        Carrito carritoObj = new Carrito();
        carritoObj.setIdCarrito(UUID.randomUUID().toString());

        List<Producto> productos = productoRequest.getListaProductos().stream()
                .map(item -> Producto.builder()
                        .indentificacion(UUID.randomUUID().toString())
                        .descripcion(item.getDescripcion())
                        .importe(item.getImporte()).build())
                .collect(Collectors.toList());

        carritoObj.setListaProductos(productos);
        carritoObj.setFechaCreacion(String.valueOf(new Date()));

    return carritoObj;
    }
}

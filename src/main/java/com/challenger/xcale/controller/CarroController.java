package com.challenger.xcale.controller;

import com.challenger.xcale.model.Carrito;
import com.challenger.xcale.service.CarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/carrito")
public class CarroController {

    @Autowired
    CarritoService carritoService;

    @PostMapping()
    public ResponseEntity<Carrito> crearCarrito(@RequestBody Carrito carrito) {

        Carrito carrito1 = carritoService.nuevoCarrito(carrito);
        return new ResponseEntity<>(carrito1, HttpStatus.CREATED);
    }



}

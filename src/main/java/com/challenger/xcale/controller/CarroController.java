package com.challenger.xcale.controller;

import com.challenger.xcale.dto.CarroOrderRequest;
import com.challenger.xcale.dto.CarroOrderResponse;
import com.challenger.xcale.model.Carrito;
import com.challenger.xcale.service.CarritoService;
import com.challenger.xcale.util.mapper.EntityDtoConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/carrito")
public class CarroController {

    @Autowired
    CarritoService carritoService;

    @Autowired
    private EntityDtoConverter converter;

    @GetMapping("/{carritoId}")
    public ResponseEntity<CarroOrderResponse> findById(@PathVariable String carritoId) {

        Carrito carrito = carritoService.buscarCarritoPorId(carritoId);

        return new ResponseEntity<>(converter.convertEntitytoDto(carrito), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<CarroOrderResponse> crearCarrito(@RequestBody CarroOrderRequest carrito) {

        Carrito nuevoCarro = carritoService.nuevoCarrito(carrito);
        return new ResponseEntity<>(converter.convertEntitytoDto(nuevoCarro), HttpStatus.CREATED);
    }

    @DeleteMapping("/{carritoId}")
    public ResponseEntity<CarroOrderResponse> deleteById(@PathVariable String carritoId) {

        Optional<Carrito> carrito = carritoService.eliminarCarrito(carritoId);

        return new ResponseEntity<>(converter.convertEntitytoOptional(carrito), HttpStatus.OK);
    }



}

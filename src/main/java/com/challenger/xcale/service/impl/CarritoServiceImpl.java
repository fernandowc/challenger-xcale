package com.challenger.xcale.service.impl;

import com.challenger.xcale.dto.CarroOrderRequest;
import com.challenger.xcale.model.Carrito;
import com.challenger.xcale.model.Producto;
import com.challenger.xcale.service.CarritoService;
import com.challenger.xcale.util.Constant;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;

import static com.challenger.xcale.util.Util.formatNumber;

@Service
public class CarritoServiceImpl implements CarritoService, InitializingBean {

    private List<Carrito> BDCarros;

    @Override
    public Carrito buscarCarritoPorId(String idCarrito) {

        Optional<Carrito> temp = BDCarros.stream()
                .filter(c -> c.getIdCarrito().equalsIgnoreCase(idCarrito))
                .findFirst();

        return temp.orElseThrow(RuntimeException::new);
    }

    @Cacheable(cacheNames = "carritos")
    @Override
    public Carrito nuevoCarrito(CarroOrderRequest carritos) {
        return iniCarrito(carritos);
    }

    @Override
    public Optional<Carrito> eliminarCarrito(String idCarrito) {

        Optional<Carrito> existeCarro = Optional.ofNullable(buscarCarritoPorId(idCarrito));

        if (existeCarro.isPresent()) {
            BDCarros.removeIf(a -> a.getIdCarrito().equals(idCarrito));
        }

        return existeCarro;
    }


    private Carrito iniCarrito(CarroOrderRequest carroRequest) {

        Carrito carritoObj = new Carrito();
        carritoObj.setIdCarrito(UUID.randomUUID().toString());

        List<Producto> productos = carroRequest.getListaProductos().stream()
                .map(item -> Producto.builder()
                        .indentificacion(UUID.randomUUID().toString())
                        .descripcion(item.getDescripcion())
                        .importe(item.getImporte()).build())
                .collect(Collectors.toList());

        carritoObj.setListaProductos(productos);
        carritoObj.setAccountId(UUID.randomUUID().toString());
        carritoObj.setTotalAmount(formatNumber(productos.stream().mapToDouble(Producto::getImporte).sum()));
        carritoObj.setTotalTax(formatNumber(carritoObj.getTotalAmount() * Constant.TAX_IMPORT));
        carritoObj.setTotalAmountTax(formatNumber(carritoObj.getTotalAmount() + carritoObj.getTotalTax()));
        carritoObj.setFechaCreacion(new Date());

        //guardando BD LOCAL
        this.BDCarros.add(carritoObj);

    return carritoObj;
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        this.BDCarros = new ArrayList<>();
    }
}

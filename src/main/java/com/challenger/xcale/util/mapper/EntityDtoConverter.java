package com.challenger.xcale.util.mapper;

import com.challenger.xcale.dto.CarroOrderResponse;
import com.challenger.xcale.model.Carrito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class EntityDtoConverter {

    @Autowired
    private ModelMapper modelMapper;

    public CarroOrderResponse convertEntitytoDto(Carrito order) {
        return modelMapper.map(order, CarroOrderResponse.class);
    }

    public CarroOrderResponse convertEntitytoOptional(Optional<Carrito> order) {
        return modelMapper.map(order, CarroOrderResponse.class);
    }


    public List<CarroOrderResponse> convertEntitytoDtoList(List<Carrito> carritos) {
        return carritos.stream()
                .map(this::convertEntitytoDto)
                .collect(Collectors.toList());
    }
}

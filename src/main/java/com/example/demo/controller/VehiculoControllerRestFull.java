package com.example.demo.controller;

import com.example.demo.repo.Vehiculo;
import com.example.demo.service.IVehiculoService;
import com.example.demo.service.VehiculoTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/vehiculos")
public class VehiculoControllerRestFull {
    @Autowired
    private IVehiculoService vehiculoService;
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<VehiculoTO> obtenerTodos(){
        var vehiculos=this.vehiculoService.getAll();
        for( var v :vehiculos){
            Link myLink=linkTo(methodOn(VehiculoControllerRestFull.class).obtenerPorPlaca(v.getPlaca())).withRel("vehiculo");
            v.add(myLink);
        }
        return vehiculos;
    }
    @GetMapping(value = "/{placa}",produces = MediaType.APPLICATION_JSON_VALUE)
    public Vehiculo obtenerPorPlaca(@PathVariable String placa){
        return this.vehiculoService.getByPlaca(placa);
    }

}

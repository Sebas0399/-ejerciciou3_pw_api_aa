package com.example.demo.service;

import com.example.demo.repo.IVehiculoRepo;
import com.example.demo.repo.Vehiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiculoServiceImpl implements  IVehiculoService {
    @Autowired
    private IVehiculoRepo vehiculoRepo;
    @Override
    public List<VehiculoTO> getAll() {
        return this.vehiculoRepo.getAll().stream().map(x->convertir(x)).toList();
    }

    @Override
    public Vehiculo get(Integer id) {
        return this.vehiculoRepo.get(id);
    }

    @Override
    public Vehiculo getByPlaca(String placa) {
        return this.vehiculoRepo.getByPlaca(placa);
    }

    public VehiculoTO convertir(Vehiculo vehiculo){
        VehiculoTO vehiculoTO=new VehiculoTO();
        vehiculoTO.setCilindraje(vehiculo.getCilindraje());
        vehiculoTO.setId(vehiculo.getId());
        vehiculoTO.setMarca(vehiculo.getMarca());
        vehiculoTO.setModelo(vehiculo.getModelo());
        vehiculoTO.setPlaca(vehiculo.getPlaca());
        return vehiculoTO;
    }
}

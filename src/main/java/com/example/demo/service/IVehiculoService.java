package com.example.demo.service;

import com.example.demo.repo.Vehiculo;

import java.util.List;

public interface IVehiculoService {
    public List<VehiculoTO> getAll();
    public Vehiculo get(Integer id);
    public Vehiculo getByPlaca(String placa);


}


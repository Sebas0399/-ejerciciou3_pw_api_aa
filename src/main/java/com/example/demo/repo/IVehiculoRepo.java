package com.example.demo.repo;

import java.util.List;

public interface IVehiculoRepo {
    public List<Vehiculo> getAll();
    public Vehiculo get(Integer id);
    public Vehiculo getByPlaca(String placa);

}

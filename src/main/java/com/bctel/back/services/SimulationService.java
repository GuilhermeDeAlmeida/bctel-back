package com.bctel.back.services;


import com.bctel.back.models.Simulation;

public interface SimulationService {
    /*
    * receive a simulation by parameter,
    * and return the same object with the pair valuer of simulation calculated
    *
    * */
    Simulation obtainCallPrice(Simulation simulation);
}

package com.bctel.back.services;

import com.bctel.back.data.SimulationDataObject;
import com.bctel.back.models.Simulation;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class SimulationServiceImpl implements SimulationService {
    @Override
    public Simulation obtainCallPrice(Simulation simulation) {
        simulation.setWithPlan(this.calculateWithPlan(simulation, true));
        simulation.setWithoutPlan(this.calculateWithPlan(simulation, false));
        return simulation;
    }

    private Double calculateWithPlan(Simulation simulation, Boolean withPlan) {

        Integer plan = simulation.getPlan();
        Integer time = simulation.getTime();
        Integer timeCalculation = time - plan;
        Double price = 0.0;

        //Caso
        if (timeCalculation > 0) {
            Double tax = calculateTax(simulation);
            //multiplicar tempo por taxa
            price = time * tax;
            if (withPlan) price = price * 0.1;
        }
        return price;
    }

    private Double calculateTax(Simulation simulation) {

        Integer origin = simulation.getOrigin();
        Integer destionation = simulation.getDestination();
        //TODO colocar excessão para quando não houver a origem/destino cadastrada
        HashMap<Integer, HashMap<Integer, Double>> defaultTaxes = SimulationDataObject.simulationTaxes();
        HashMap<Integer, Double> originTaxes = defaultTaxes.get(origin);
        return originTaxes.get(destionation);

    }




}

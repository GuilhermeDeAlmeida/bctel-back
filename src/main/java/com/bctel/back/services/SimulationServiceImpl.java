package com.bctel.back.services;

import com.bctel.back.data.SimulationDataObject;
import com.bctel.back.models.Simulation;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class SimulationServiceImpl implements SimulationService {
    @Override
    public Simulation obtainCallPrice(Simulation simulation) {
        simulation.setWithPlan(this.calculateWithPlan(simulation));
        simulation.setWithoutPlan(this.calculateWithOutPlan(simulation));
        return simulation;
    }

    private Double calculateWithPlan(Simulation simulation) {

        Integer plan = simulation.getPlan();
        Integer time = simulation.getTime() != null? simulation.getTime(): 1;
        Integer timeCalculation = time - plan;
        Double price = 0.0;

        //verificar se o tempo de ligação é foi maior que o plano
        //se sim, calcular taxa e incluir 10%
        if (timeCalculation > 0) {
            Double tax = calculateTax(simulation);
            //valor somente do que ultrapassou
            price = timeCalculation * tax;
            price += price * 0.1;
        }
        return price;
    }

    private Double calculateWithOutPlan(Simulation simulation){
        Integer time = simulation.getTime() != null? simulation.getTime(): 1;

        Double tax = calculateTax(simulation);
        Double price = time * tax;
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

package com.bctel.back.data;

import java.util.HashMap;

public final class SimulationDataObject {

    //TODO colocar o map que vai vir do arquivo.
    public static HashMap<Integer, HashMap<Integer, Double>> simulationTaxes() {
        return defaultTaxes();
    }

    private static HashMap<Integer, HashMap<Integer, Double>> defaultTaxes() {

        HashMap map11 = new HashMap<Integer, Double>();
        map11.put(16, 1.90);
        map11.put(17, 1.70);
        map11.put(18, 0.90);

        HashMap map16 = new HashMap<Integer, Double>();
        map16.put(11, 2.90);
        map16.put(17, 0.0);
        map16.put(18, 0.0);

        HashMap map17 = new HashMap<Integer, Double>();
        map17.put(11, 2.70);
        map17.put(16, 0.0);
        map17.put(18, 0.0);

        HashMap map18 = new HashMap<Integer, Double>();
        map18.put(11, 1.90);
        map18.put(16, 0.0);
        map18.put(17, 0.0);

        HashMap<Integer, HashMap<Integer, Double>> taxes = new HashMap();

        taxes.put(11, map11);
        taxes.put(16, map16);
        taxes.put(17, map17);
        taxes.put(18, map18);

        return taxes;
    }
}

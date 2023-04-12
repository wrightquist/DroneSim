package org.example;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;

public class DroneSim {
    long seed = 1000;

    public static void main(String[] args){
        DroneSim sim = new DroneSim();
        int n = 81;
        int k = 550;
        for (int i = 0; i<k; i++){
            ArrayList<Double> list = new ArrayList<>();
            for(int j = 0; j<n; j++){
                list.add(sim.getDistance());
            }
            DoubleSummaryStatistics iss = list.stream().mapToDouble((a) -> a). summaryStatistics();
            System.out.println(iss.getAverage());
        }
    }
    public double getRandomNumber(){
        long multiplier = 24693;
        long increment = 3967;
        long modulus = (long)Math.pow(2, 18);
        seed = ((seed * multiplier) + increment)%modulus;
        return ((double) seed)/modulus;
    }

    public double getDistance(){
        double randomNumber = getRandomNumber();
        return Math.sqrt((-2*Math.pow(57,2))*Math.log(1-randomNumber));
    }
}

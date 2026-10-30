package com.mycompany.was;

public class Runner extends Athlete{
    private double vo2max;
    
    public Runner(String name, int age, double height, double weight, int maxHr, double vo2max){
        super (name, age, height, weight, maxHr);
        this.vo2max = vo2max;
    }
    
    public double getVo2max(){
        return vo2max;
    }
    
    public void setVo2max(double vo2max){
        if (vo2max >=10 && vo2max <=100){
            this.vo2max = vo2max;
        }
    }
    //missing: vo2max chart
}

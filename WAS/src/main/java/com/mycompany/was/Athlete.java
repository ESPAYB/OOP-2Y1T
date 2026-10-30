
package com.mycompany.was;


public class Athlete {
    private String name;
    private int age;
    private double height;
    private double weight;
    private int maxHr;
    
    public Athlete(String name, int age, double height, double weight, int maxHr){
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.maxHr = maxHr;
    }
    //setters and getters for name
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
     //setters and getters for age
    public int getAge(){
        return age;
    }
    
    public void setAge(int age){
        if (age >= 0){
             this.age = age;
        }       
    }
     //setters and getters for height
    public double getHeight(){
        return height;        
    }
    
    public void setHeight(double height){
        if (height >= 0){
             this.height = height;
        }       
    }
     //setters and getters for weight
    public double getWeight(){
        return weight;
    }
    
    public void setWeight(double weight){
        if (weight >= 0){
             this.weight = weight;
        }       
    }
    public int getMaxHr(){
        return maxHr;
    }
    public void setMaxHr(){
        if (maxHr > 100 && maxHr < 220){
            this.maxHr = maxHr;
        }
    }
    public double getBmi(double height, double weight){
        return weight/(height*height);
    }
    //missing: bmi chart, hr chart for zones
}

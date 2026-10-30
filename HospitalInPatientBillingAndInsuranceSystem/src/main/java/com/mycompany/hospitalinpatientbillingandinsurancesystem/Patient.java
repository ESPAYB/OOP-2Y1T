package com.mycompany.hospitalinpatientbillingandinsurancesystem;

public class Patient {
  private String patientId;
  private String name;
  private int age;
  
  public Patient(String patientId, String name, int age){
    this.patientId = patientId;
    this.name = name;
    this.age = age;
  }
  
  public String getPatientId(){
      return patientId;
  }    
  
  public String getName(){
      return name;  
  }
  
  public int getAge(){
      return age;        
  }
  
  public void setPatientId(String patientId){
      this.patientId = patientId;
  }
  
  public void setName(String name){
      this.name = name;
  }
  
  public void setAge(int age){
      if (age >= 0){
          this.age = age;
      }
  } 
  
}
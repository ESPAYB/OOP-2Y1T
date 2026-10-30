package com.mycompany.was;

public class Cyclist extends Athlete {
   private String bike;
   private double ftp;
   
   public Cyclist(String name, int age, double height, double weight, int maxHr, String bike, double ftp){
       super (name, age, height, weight, maxHr);
       this.bike = bike;
       this.ftp = ftp;
       
   }
   
   public String getBike(){
       return bike;
   }
   public void setBike(String bike){
       this.bike = bike;
   }
   
   public double getFtp(){
       return ftp;
   }
   public void setFtp(double ftp){
       if (ftp > 0){
          this.ftp = ftp;
       }      
   }  
   //missing ftp chart
}

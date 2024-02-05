package com.example.bmicalculator;

import java.text.DecimalFormat;

public class User {

    double weight;
    double height;
    double calculatedBmi;
    String weightStatus;

    public User(double weight, double height){
        this.weight = weight;
        this.height = height;
        calculateBmi();
    }

    public double getWeight(){
        return this.weight;
    }

    public double getHeight(){
        return this.height;
    }

    public double getCalculatedBmi(){
        return this.calculatedBmi;
    }

    public String getWeightStatus(){
        return this.weightStatus;
    }

    public void setWeight(double newWeight){
        this.weight=newWeight;
    }

    public void setHeight(double newHeight){
        this.height=newHeight;
    }

    public void setCalculatedBmi(double newCalculateBmi){
        this.calculatedBmi=newCalculateBmi;
    }

    public void setWeightStatus(String newWeightStatus){
        this.weightStatus=newWeightStatus;
    }

    public void calculateBmi() {
        DecimalFormat df = new DecimalFormat("#.##");
        double cmToM = this.height * 0.01;
        double finalBmi = this.weight / (cmToM * cmToM);
        this.calculatedBmi = Double.parseDouble(df.format(finalBmi));

        if (this.calculatedBmi < 18.5) {
            this.weightStatus = "Underweight";
        } else if (this.calculatedBmi >= 18.5 && this.calculatedBmi <= 24.9) {
            this.weightStatus = "Normal";
        } else if (this.calculatedBmi >= 25.0 && this.calculatedBmi <= 29.9) {
            this.weightStatus = "Overweight";
        } else if (this.calculatedBmi >= 30.0) {
            this.weightStatus = "Obese";
        }
    }

}

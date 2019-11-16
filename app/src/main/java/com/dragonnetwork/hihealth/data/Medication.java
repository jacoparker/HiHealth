package com.dragonnetwork.hihealth.data;


public class Medication {
    private String Prescription;
    private String Type;
    private int TotalNum;
    private String Strength;
    private int Doses;
    private String Frequency;

    public Medication(String prescription, String type, int totalNum, String strength, int doses, String frequency) {
        Prescription = prescription;
        Type = type;
        TotalNum = totalNum;
        Strength = strength;
        Doses = doses;
        Frequency = frequency;
    }

    public String getPrescription() {
        return Prescription;
    }

    public void setPrescription(String prescription) {
        Prescription = prescription;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public int getTotalNum() {
        return TotalNum;
    }

    public void setTotalNum(int totalNum) {
        TotalNum = totalNum;
    }

    public String getStrength() {
        return Strength;
    }

    public void setStrength(String strength) {
        Strength = strength;
    }

    public int getDoses() {
        return Doses;
    }

    public void setDoses(int doses) {
        Doses = doses;
    }

    public String getFrequency() {
        return Frequency;
    }

    public void setFrequency(String frequency) {
        Frequency = frequency;
    }
}

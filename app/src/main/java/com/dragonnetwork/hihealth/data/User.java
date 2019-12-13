package com.dragonnetwork.hihealth.data;

import android.app.Activity;

import com.dragonnetwork.hihealth.cloudio.CloudIO;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class User {
    private static boolean status; // True: User is signed in. False: User is not signed in. Set this to false during initialize.
    private static String UID;
    private static String Email;
    private static String Name;
    private static String DateOfBirth;
    private static List<Appointment> Appointments;
    private static List<String> AppointmentIDs;
    private static List<Medication> Medications;
    private static List<String> MedicationIDs;
    private static List<String> Reports;
    private static String Symptoms;
    private static List<Reminder> morning;
    private static List<Reminder> noon;

    public static List<Reminder> getMorning() {
        return morning;
    }

    public static void setMorning(List<Reminder> morning) {
        User.morning = morning;
    }

    public static List<Reminder> getNoon() {
        return noon;
    }

    public static void setNoon(List<Reminder> noon) {
        User.noon = noon;
    }

    public static List<Reminder> getNight() {
        return night;
    }

    public static void setNight(List<Reminder> night) {
        User.night = night;
    }

    private static List<Reminder> night;

    public static List<String> getAppointmentIDs() {
        return AppointmentIDs;
    }

    public static void setAppointmentIDs(List<String> appointmentIDs) {
        AppointmentIDs = appointmentIDs;
    }

    public static List<String> getMedicationIDs() {
        return MedicationIDs;
    }

    public static void setMedicationIDs(List<String> medicationIDs) {
        MedicationIDs = medicationIDs;
    }

    public static boolean isStatus() {
        return status;
    }

    public static void setStatus(boolean status) {
        User.status = status;
    }

    public static String getUID() {
        return UID;
    }

    public static void setUID(String UID) {
        User.UID = UID;
    }

    public static String getEmail() {
        return Email;
    }

    public static void setEmail(String email) {
        Email = email;
    }

    public static String getName() {
        return Name;
    }

    public static void setName(String name) {
        Name = name;
    }

    public static String getDateOfBirth() {
        return DateOfBirth;
    }

    public static void setDateOfBirth(String dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    public static List<Appointment> getAppointments() {
        return Appointments;
    }

    public static void setAppointments(List<Appointment> appointments) {
        Appointments = appointments;
    }

    public static List<Medication> getMedications() {
        return Medications;
    }

    public static void setMedications(List<Medication> medications) {
        Medications = medications;
    }

    public static List<String> getReports() {
        return Reports;
    }

    public static void setReports(List<String> reports) {
        Reports = reports;
    }

    public static String  getSymptoms() {
        return Symptoms;
    }

    public static void setSymptoms(String symptoms) {
        Symptoms = symptoms;
    }

    public static void updateSymptoms(String symptoms) {
        Symptoms = symptoms;
        CloudIO.UpdateSymptom(Symptoms);
    }

    public static void SignOut(){
        UID = "";
        Email = "";
        Name = "";
        DateOfBirth = "";
        Appointments = null;
        MedicationIDs = null;
        MedicationIDs = null;
        Reports = null;
        Symptoms = null;
        CloudIO.SignOut();
    }

    public static void removeMedication(String medID, Activity context) {
        for (Medication m: Medications) {
            if (m.getMedID().equals(medID)) {
                Medications.remove(m);
                break;
            }
        }
        CloudIO.removeMedication(medID, context);
    }

    public static void addMedication(String prescription, int totalnum, String strength, int doses, int frequency, int icontype){
        Medications.add(new Medication(null, prescription, totalnum, strength, doses, frequency, null, icontype));
        CloudIO.addMedication(prescription, totalnum, strength, doses, frequency,icontype);
    }

    public static void addMedication(Medication medication){
        Medications.remove(Medications.size()-1);
        Medications.add(medication);
        MedicationIDs.add(medication.getMedID());
    }

    public static Medication getMedicationByID(String MedID){
        //TODO: Write an efficient algorithm to return the medication in ArrayList Medications with the given Medication ID.
        return null;
    }
    public static void CreateNewReminders(Medication medication){

    }
    public static void getReminders(List<Medication> medications, Timestamp timestamp){
        // Medication.frequency: 1-7 = 1+2+4;
        if(morning!=null)
            morning.clear();
        else
            morning = new ArrayList<>();
        if(noon!=null)
            noon.clear();
        else
            noon = new ArrayList<>();
        if(night!=null)
            night.clear();
        else
            night = new ArrayList<>();
        int frequency = 0, duration = 0;
        if(!medications.isEmpty())
        for(Medication medication:medications){
            frequency=medication.getFrequency();
            duration=medication.getTotalNum()/medication.getDoses();
            if(frequency >= 4){
                night.add(new Reminder(medication.getPrescription(),medication.getStrength()+" "+medication.getDoses(),2,0));
                frequency-=4;
            }
            if(frequency >= 2){
                noon.add(new Reminder(medication.getPrescription(),medication.getStrength()+" "+medication.getDoses(),1,0));
                frequency-=2;
            }
            if(frequency >= 1){
                morning.add(new Reminder(medication.getPrescription(),medication.getStrength()+" "+medication.getDoses(),1,0));
                frequency-=1;
            }
        }
    }
}

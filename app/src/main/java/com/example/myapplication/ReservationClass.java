package com.example.myapplication;

public class ReservationClass {
    String Date;
    String GuestNumber;
    String SpecialRequest;
    String Time;
    String Order;
    String GuestName;
    String GuestPhoneNumber;

    public ReservationClass(String date, String guestNumber, String specialRequest, String time, String order, String guestName, String guestPhoneNumber) {
        Date = date;
        GuestNumber = guestNumber;
        SpecialRequest = specialRequest;
        Time = time;
        Order = order;
        GuestName = guestName;
        GuestPhoneNumber = guestPhoneNumber;
    }

    public String getGuestName() {
        return GuestName;
    }

    public void setGuestName(String guestName) {
        GuestName = guestName;
    }

    public String getGuestPhoneNumber() {
        return GuestPhoneNumber;
    }

    public void setGuestPhoneNumber(String guestPhoneNumber) {
        GuestPhoneNumber = guestPhoneNumber;
    }

    public String getOrder() {
        return Order;
    }

    public void setOrder(String order) {
        Order = order;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getGuestNumber() {
        return GuestNumber;
    }

    public void setGuestNumber(String guestNumber) {
        GuestNumber = guestNumber;
    }

    public String getSpecialRequest() {
        return SpecialRequest;
    }

    public void setSpecialRequest(String specialRequest) {
        SpecialRequest = specialRequest;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

}

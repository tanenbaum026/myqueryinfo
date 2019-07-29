package com.mytest.mytestdb;

public class contactinfo {

    private String ID;

    private String Unit;

    private String Contact;

    private String Phone;

    private String Mobile;

    public contactinfo(String id, String unit,String contact,String phone,String mobile) {
        this.ID = id;
        this.Unit = unit;
        this.Contact=contact;
        this.Phone=phone;
        this.Mobile =mobile;
    }

    public String getid() {
        return ID;
    }

    public String getunit() {
        return Unit;
    }

    public String getcontact() {
        return Contact;
    }

    public String getphone() {
        return Phone;
    }

    public String getmobile() {
        return Mobile;
    }

}


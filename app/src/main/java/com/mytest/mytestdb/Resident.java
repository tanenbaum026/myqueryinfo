package com.mytest.mytestdb;

public class Resident {
    private String ID;

    private String Name;

    private String Address;

    private String Properties;

    private String Belong;

    private String Person;

    private String Phone;

    private String Mobile;

    private String Wuye;

    private String Wuyeren;

    private String Wuyephone;

    public Resident(String id, String name,String address,String properties,String belong,String person,String phone,String mobile,String wuye,String wuyeren,String wuyephone) {
        this.ID = id;
        this.Name = name;
        this.Address=address;
        this.Properties=properties;
        this.Belong=belong;
        this.Person =person;
        this.Phone=phone;
        this.Mobile=mobile;
        this.Wuye =wuye;
        this.Wuyeren=wuyeren;
        this.Wuyephone=wuyephone;
    }

    public String getid() {
        return ID;
    }

    public String getname() {
        return Name;
    }

    public String getaddress() {
        return Address;
    }

    public String getproperties() {
        return Properties;
    }

    public String getbelong() {
        return Belong;
    }

    public String getperson() {
        return Person;
    }

    public String getphone() {
        return Phone;
    }

    public String getmobile() {
        return Mobile;
    }

    public String getwuye() {
        return Wuye;
    }

    public String getwuyeren() {
        return Wuyeren;
    }

    public String getwuyephone() {
        return Wuyephone;
    }

}

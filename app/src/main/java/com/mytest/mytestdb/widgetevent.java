package com.mytest.mytestdb;

public class widgetevent {
    private String ID;
    private String Name;
    private String Range;
    private String Dealunit;
    private String Dealtime;

    public widgetevent(String id,String name,String range,String dealunit,String dealtime){
        this.ID=id;
        this.Name=name;
        this.Range=range;
        this.Dealunit=dealunit;
        this.Dealtime=dealtime;
    }

    public String getID(){
        return ID;
    }

    public String getName(){
        return Name;
    }

    public String getRange() {
        return Range;
    }

    public String getDealunit() {
        return Dealunit;
    }

    public String getDealtime() {
        return Dealtime;
    }

}

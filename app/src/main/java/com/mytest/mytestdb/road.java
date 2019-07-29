package com.mytest.mytestdb;

public class road {
   private String ID;
   private String Roadname;
   private String Range;
   private String Dealunit1;
   private String Dealunit2;

   public road(String id,String roadname,String range,String dealunit1,String dealunit2){
       this.ID=id;
       this.Roadname=roadname;
       this.Range=range;
       this.Dealunit1=dealunit1;
       this.Dealunit2=dealunit2;
   }

   public String getid(){
       return ID;
   }

   public String getroadname() {
       return Roadname;
   }

   public String getrange() {
       return Range;
   }

   public String getdealunit1() {
      return Dealunit1;
   }

    public String getdealunit2() {
        return Dealunit2;
    }

}

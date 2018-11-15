package com.parkingLot.app;

public class Ticket {


    private int id;
    private String time_in;
    private String time_out;
    private boolean is_lost;
   // private String cost;


    public Ticket(int ID, String TIME_IN, String TIME_OUT, boolean IS_LOST) { //String Cost
        super();
        this.id = ID;
        this.time_in = TIME_IN;
        this.time_out = TIME_OUT;
        this.is_lost = IS_LOST;
       // this.cost = Cost;


    }

    public Ticket() {

    }


    public void setId(int ID) {
        this.id = ID;
    }

    public int getId() {

        return id;
    }

//    public void setCost(String Cost) {
//        this.cost = Cost;
//
//    }
//
//    public String getCost() {
//
//        return cost;
//    }


    public String getTimeIn() {
        return time_in;
    }

    public String getTimeOut() {

        return time_out;
    }

    public void setTime_in(String TIME_IN) {

        this.time_in = TIME_IN;
    }

    public void setTime_out(String TIME_OUT) {

        this.time_out = TIME_OUT;
    }


    public boolean getIs_lost() {

        return is_lost;
    }

    public void setIS_LOST(boolean IS_LOST) {

        this.is_lost = IS_LOST;
    }

    @Override
    public String toString() {
        return "parking [id=" + id + ", time in= " + time_in + ", time out= " + time_out + ", is lost="
                + is_lost + "]";
    }

}



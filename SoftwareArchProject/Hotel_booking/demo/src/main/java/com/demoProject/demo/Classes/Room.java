package com.demoProject.demo.Classes;



public class Room implements RoomPlan {
    private int BHK;
    private String television;
    private String view;

    public int getBHK() {
        return BHK;
    }

    public String getTelevision() {
        return television;
    }

    public String getView() {
        return view;
    }

    public String getFoodPlan() {
        return foodPlan;
    }

    public Boolean getAc() {
        return ac;
    }

    private String foodPlan;
    private Boolean ac;

    public void setBHK(int bhk)
    {
        this.BHK = bhk;

    }

    public void setTelevision(String television)
    {
        this.television = television;
    }

    public void setFoodPlan(String foodPlan)
    {
        this.foodPlan = foodPlan;
    }

    public void setView(String view)
    {
        this.view = view;
    }
    public void setAc(boolean t){
        this. ac = t;
    }


}

package com.demoProject.demo.Classes;

import java.util.Date;

public class Mobile implements  paymentStratergy{

    private  String mobilenumber;
    private  String cvv;

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getmobilenumber() {
        return mobilenumber;
    }



    public Mobile( String mobilenumber,
                  String cvv) {


        this.mobilenumber = mobilenumber;
        this.cvv = cvv;
    }


    @Override
    public boolean pay(String amount) {
        return true;
    }
}

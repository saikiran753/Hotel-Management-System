package com.demoProject.demo.Classes;

import java.util.Date;

public class Paypal implements paymentStratergy {
    private  String name;
    private  String cardnumber;
    private  String expires;
    private String  cvv;

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getname() {
        return name;
    }

    public String getcardnumber() {
        return cardnumber;
    }

    public String getexpires() {
        return expires;
    }

    public Paypal(String name, String cardnumber, String expires,String cvv) {

        this.name = name;
        this.cardnumber = cardnumber;
        this.expires = expires;
        this.cvv = cvv;
    }

    @Override
    public boolean pay(String amount) {
        return true;
    }


}

package com.demoProject.demo.Classes;

import java.util.Date;

public class CreditDebit implements paymentStratergy{
    private  String name;
    private  String cardnumber;
    private String expires;

    private String Cvv;

    public String getname() {
        return name;
    }

    public String getcardnumber() {
        return cardnumber;
    }

    public String getexpires() {
        return expires;
    }

    public CreditDebit(String name, String cardnumber, String expires, String cvv ) {

        this.name = name;
        this.cardnumber = cardnumber;
        this.expires = expires;
        this.Cvv = cvv;
    }


    @Override
    public boolean pay(String amount) {
        return true;
    }
}

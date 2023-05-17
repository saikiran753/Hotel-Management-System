package com.demoProject.demo.services;


import com.demoProject.demo.Classes.CreditDebit;
import com.demoProject.demo.Classes.Mobile;
import com.demoProject.demo.Classes.PaymentDetails;
import com.demoProject.demo.Classes.Paypal;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {


      public PaymentDetails makePayment(PaymentDetails paymentDetails) {

          System.out.println(paymentDetails.getPaymentType());

          if (paymentDetails.getPaymentType().startsWith("cre")) {
              CreditDebit payment = new CreditDebit(paymentDetails.getCardHolderName(),
                      paymentDetails.getCardNumber(), paymentDetails.getExpireDate(), paymentDetails.getCvv());

              payment.pay(paymentDetails.getAmount());
              return paymentDetails;
          }
          if (paymentDetails.getPaymentType().startsWith("pay")) {
              Paypal payment = new Paypal(paymentDetails.getCardHolderName(),
                      paymentDetails.getCardNumber(), paymentDetails.getExpireDate(), paymentDetails.getCvv());

              payment.pay(paymentDetails.getAmount());
              return paymentDetails;
          }
         return null;}


}

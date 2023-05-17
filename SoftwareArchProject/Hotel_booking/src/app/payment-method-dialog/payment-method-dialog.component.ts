import { HttpClient } from '@angular/common/http';
import { Component, Inject, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'app-payment-method-dialog',
  templateUrl: './payment-method-dialog.component.html',
  styleUrls: ['./payment-method-dialog.component.scss']
})
export class PaymentMethodDialogComponent implements OnInit {
  
  constructor(private http: HttpClient,private formBuilder: FormBuilder, public dialogRef: MatDialogRef<any>,
    @Inject(MAT_DIALOG_DATA) public data: any) { }
    payment = this.formBuilder.group({
      cardHolderName: ['', [Validators.required]],
      cardNumber: ['', [Validators.required]],
      expireDate: ['', [Validators.required]],
      cvv: ['', [Validators.required]],
      amount: [this.data.bookedDetails.amount, [Validators.required]],
      paymentType: ['']
    });

  ngOnInit(): void {
    console.log(this.data.bookedDetails)
  }


  conform(){
   console.log(this.payment.value);
   this.payment.value.paymentType = this.data.paymentType;
   
   this.http
   .post<any>(
     'http://localhost:8092/payments',
     this.payment.value
   )
   .subscribe((res) => {
    console.log(res);
    this.dialogRef.close(res);

  })
   
  }

}

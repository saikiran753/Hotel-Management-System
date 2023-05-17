import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { ActivatedRoute, Router } from '@angular/router';
import { PaymentMethodDialogComponent } from '../payment-method-dialog/payment-method-dialog.component';

@Component({
  selector: 'app-payments',
  templateUrl: './payments.component.html',
  styleUrls: ['./payments.component.scss'],
})
export class PaymentsComponent implements OnInit {
  bookingDetails: any;
  isDisabled: boolean = true;
  payment: any;
  radioGroup: boolean = false;

  constructor(
    private dialog: MatDialog,
    private route: ActivatedRoute,
    private formBuilder: FormBuilder
  ) {}
  paymentMethod = this.formBuilder.group({
    paymentType: ['', [Validators.required]],
  });

  ngOnInit(): void {
    console.log(this.route.snapshot);
    this.bookingDetails = this.route.snapshot.queryParams;
    this.isDisabled = this.paymentMethod.valid ? false : true;
  }

  onChange(event: any) {
    console.log(event);
    this.isDisabled = false;
    this.payment = event.value;
  }

  pay() {
    const dialogRef = this.dialog.open(PaymentMethodDialogComponent, {
      width: '250px',
      data: {
        paymentType: this.payment,
        bookedDetails: this.route.snapshot.queryParams,
      },
    });
    dialogRef.afterClosed().subscribe((res) => {
      console.log(res);
      if (res) {
        this.radioGroup = true;
      }
    });
  }
}

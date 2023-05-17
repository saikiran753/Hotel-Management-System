import { HttpClient } from '@angular/common/http';
import { Component, Input, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { ConformationDialogComponent } from '../conformation-dialog/conformation-dialog.component';

@Component({
  selector: 'app-hotel-lists',
  templateUrl: './hotel-lists.component.html',
  styleUrls: ['./hotel-lists.component.scss']
})
export class HotelListsComponent implements OnInit {

  bookRoom: FormGroup;
  bookingDetails:any = {};
  price :any;

  @Input() hotelList: any;
  constructor(private dialog : MatDialog,fb: FormBuilder,private http: HttpClient,private router : Router) { 
    {
      this.bookRoom = fb.group({
        room: ["", Validators.required],
        beds: ["", Validators.required],
        food: ["", Validators.required],
      });
  }
  }

  roomTypes :any [] = [
    {value: 'DeluxAc', viewValue: 'Delux Ac'},
    {value: 'DeluxNonAc', viewValue: 'Delux NonAc'},
    {value: 'SuiteAc', viewValue: 'Suite Ac'},
    {value: 'SuiteNonAc', viewValue: 'Suite NonAc'}
  ];
  bhks :any [] = [
    {value: '1', viewValue: '1bed'},
    {value: '2', viewValue: '2beds'}
  ];

  foods :any [] = [
    {value: 'veg', viewValue: 'veg'},
    {value: 'Nonveg', viewValue: 'Nonveg'}
  ];

  ngOnInit(): void {
    console.log(this.hotelList)
  }

  bookroom($event:any){
    this.bookingDetails.roomType = this.bookRoom.value.room;
    this.bookingDetails.bhk = this.bookRoom.value.beds;
    this.bookingDetails.foodPlan = this.bookRoom.value.food;
    this.bookingDetails.hotelName =  $event.hotelName;
    console.log(window.location.href)
    this.http
      .post<any>(
        'http://localhost:8092/account/check/mahiengg444',
        this.bookingDetails
      )
      .subscribe((res) => {
        if (res != null) {
          const dialogRef = this.dialog.open(ConformationDialogComponent, {
            data: { Details: this.bookingDetails, amount: res },
          });
        }
      });
  }

}

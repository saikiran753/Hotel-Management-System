import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { FormBuilder, FormControl, Validators } from '@angular/forms';
import { MatDialog, MatDialogRef } from '@angular/material/dialog';
import { HttpClient, HttpParams } from '@angular/common/http';
import * as moment from 'moment';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  searchRoom: FormGroup;
  constructor( fb: FormBuilder,private http: HttpClient)
    {
        this.searchRoom = fb.group({
          location: ["", Validators.required],
          fromDate: ["", Validators.required],
          toDate: ["", Validators.required],
        });
    }

  sideNav :boolean = false;
  path:any;
  hotelList:any  = [
    {
        "id": 57,
        "hotelId": "det1003",
        "hotelName": "Marriot",
        "hotelOwnerName": "Michelrichard",
        "hotelLocation": "Detroit",
        "hotelPhoneNumber": "9442356021",
        "totalNumberOfRooms": 10,
        "currentAvailableRooms": 6,
        "img":"https://i.insider.com/5767e7efdd089522388b485a?width=1067&format=jpeg"
    },
    {
        "id": 58,
        "hotelId": "det1001",
        "hotelName": "Fairlane",
        "hotelOwnerName": "Michelrichard",
        "hotelLocation": "Detroit",
        "hotelPhoneNumber": "9442356021",
        "totalNumberOfRooms": 10,
        "currentAvailableRooms": 7,
        "img":"https://img.particlenews.com/image.php?type=thumbnail_580x000&url=29dY70_0f3mEqe200"
    },
    {
        "id": 59,
        "hotelId": "det1053",
        "hotelName": "EverGreen Woods",
        "hotelOwnerName": "Michelrichard",
        "hotelLocation": "Detroit",
        "hotelPhoneNumber": "9442356021",
        "totalNumberOfRooms": 10,
        "currentAvailableRooms": 9,
        "img":"https://i.insider.com/5767e7efdd089522388b485a?width=1067&format=jpeg"
    },
    {
        "id": 60,
        "hotelId": "det1090",
        "hotelName": "Michigan Inn",
        "hotelOwnerName": "Michelrichard",
        "hotelLocation": "Detroit",
        "hotelPhoneNumber": "9442356021",
        "totalNumberOfRooms": 10,
        "currentAvailableRooms": 8,
        "img":"https://images.surfacemag.com/app/uploads/2018/05/03114121/made-hotel-manhattan-guestroom.jpg"
    },
    {
        "id": 64,
        "hotelId": "det1020",
        "hotelName": "Comfort Zone",
        "hotelOwnerName": "Michelrichard",
        "hotelLocation": "Detroit",
        "hotelPhoneNumber": "9442356021",
        "totalNumberOfRooms": 10,
        "currentAvailableRooms": 10,
        "img":"https://pix10.agoda.net/hotelImages/124/1246280/1246280_16061017110043391702.jpg"
    },
    {
        "id": 65,
        "hotelId": "det1022",
        "hotelName": "Valis Park",
        "hotelOwnerName": "Michelrichard",
        "hotelLocation": "Detroit",
        "hotelPhoneNumber": "9442356021",
        "totalNumberOfRooms": 10,
        "currentAvailableRooms": 10,
        "img":"https://media-cdn.tripadvisor.com/media/photo-s/03/8b/71/04/rosewood-hotel-georgia.jpg"
    },
    {
        "id": 66,
        "hotelId": "det1009",
        "hotelName": "confortInn",
        "hotelOwnerName": "Michelrichard",
        "hotelLocation": "Detroit",
        "hotelPhoneNumber": "9442356021",
        "totalNumberOfRooms": 10,
        "currentAvailableRooms": 0,
        "img":"https://media-cdn.tripadvisor.com/media/photo-s/25/04/93/1e/blossom-hotel-houston.jpg"
    }
]
 

  

  ngOnInit(): void {
    console.log(window.location.href)
    path:window.location.href;
    
  }

  sideNavOpen(){
    if(!this.sideNav){
    this.sideNav = true;
  }else{
    this.sideNav = false;
  }}

  search(){
     console.log("onsubmit")
     console.log(this.searchRoom.value.fromDate);
     console.log(moment(this.searchRoom.value.fromDate).format('yyyy-MM-DD'))
     const params = new HttpParams().set("start",moment(this.searchRoom.value.fromDate).format('yyyy-MM-DD')).set("end",moment(this.searchRoom.value.toDate).format('yyyy-MM-DD'))
     
     console.log(params)
     let queryParams = new HttpParams();
     queryParams = queryParams.append("start",moment(this.searchRoom.value.fromDate).format('yyyy-MM-DD'));
     queryParams = queryParams.append("end",moment(this.searchRoom.value.toDate).format('yyyy-MM-DD'));
     queryParams = queryParams.append("location","Detroit")
     this.http.get<any>('http://localhost:8080/account/hotel/location/datee',{
      params:queryParams
     })
      .subscribe((response)=>{
        console.log('repsonse ',response);
      })
    
  }
}

import { Component, OnInit } from '@angular/core';
import {MatDialog} from '@angular/material/dialog';
import { LoginDialogComponent } from '../login-dialog/login-dialog.component';
import { LoginUserComponent } from '../login-user/login-user.component';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.scss']
})
export class WelcomeComponent implements OnInit {

  constructor(private dialog : MatDialog) { }

  sideNav :boolean = false;

  ngOnInit(): void {
  }


  loginDialog(){
    const dialogRef = this.dialog.open(LoginDialogComponent);

    dialogRef.afterClosed().subscribe(result => {
      console.log(result.data);
      if(result.data ==='login'){
        const loginDialog = this.dialog.open(LoginUserComponent);
      }
    });
  }

  sideNavOpen(){
    if(!this.sideNav){
    this.sideNav = true;
  }else{
    this.sideNav = false;
  }}

}

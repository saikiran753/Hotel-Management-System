import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { MatDialog, MatDialogRef } from '@angular/material/dialog';

@Component({
  selector: 'app-login-dialog',
  templateUrl: './login-dialog.component.html',
  styleUrls: ['./login-dialog.component.scss']
})
export class LoginDialogComponent implements OnInit {

 
  profileForm: FormGroup;

    constructor( fb: FormBuilder,private http: HttpClient, private dialogref : MatDialogRef<any>)
    {
        this.profileForm = fb.group({
          firstName: ["", Validators.required],
          lastName: ["", Validators.required],
          phoneNumber: ["", Validators.required],
          email: ["", Validators.required]
        });
    }
  

  ngOnInit(): void {
  }

  onSubmit() {
    // TODO: Use EventEmitter with form value
    console.log(this.profileForm.value);
    this.http.post('http://localhost:8080/user', this.profileForm.value)
      .subscribe((response)=>{
        console.log('repsonse ',response);
      })


  }

  loginClick(){
    this.dialogref.close({data : "login"})
  }

}

import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialogRef } from '@angular/material/dialog';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login-user',
  templateUrl: './login-user.component.html',
  styleUrls: ['./login-user.component.scss'],
})
export class LoginUserComponent implements OnInit {
  loginForm: FormGroup;

  constructor(
    fb: FormBuilder,
    private http: HttpClient,
    private dialogref: MatDialogRef<any>,
    private router : Router
  ) {
    this.loginForm = fb.group({
      password: ['', Validators.required],
      email: ['', Validators.required],
    });
  }

  ngOnInit(): void {}

  login() {
    this.router.navigate(['/account/' + `${this.loginForm.value.email}`]);
    this.dialogref.close();
  }
}

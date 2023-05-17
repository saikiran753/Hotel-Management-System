import { HttpClient } from '@angular/common/http';
import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Router } from '@angular/router';

@Component({
  selector: 'app-conformation-dialog',
  templateUrl: './conformation-dialog.component.html',
  styleUrls: ['./conformation-dialog.component.scss']
})
export class ConformationDialogComponent implements OnInit {

  constructor(private router : Router,    private http: HttpClient,public dialogRef: MatDialogRef<any>,
    @Inject(MAT_DIALOG_DATA) public data: any) { }

  ngOnInit(): void {

    console.log(this.data)
  }

  conform(){
    this.http
    .post<any>(
      'http://localhost:8092/account/mahiengg444',
      this.data.Details
    )
    .subscribe((res) => {
      console.log(res)
      this.data.Details.amount = res;
     
        if(res!=null){
        console.log("working");
        this.router.navigate(['/payments'],{queryParams: this.data.Details})
        }

    });
 this.dialogRef.close();
  }
  cancel(){
    this.dialogRef.close();
  }

}

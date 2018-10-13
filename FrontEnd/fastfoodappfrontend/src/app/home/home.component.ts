import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import { HomeService } from '../service.component';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  public foodlist:any[];
  public sms:any;
  public email:any;
  public order:any;
  constructor(private _httpservice: HomeService, private router: Router) { }

  ngOnInit() {
    this.getFoodItems();
  }
  getFoodItems() {
    this._httpservice.getFoodList()
       .subscribe(
          data => {
            this.foodlist = data;
          },
          error => {
            this.router.navigate(['/home']);
          },
          () => {}
      );
}
sendSMS() {
  this._httpservice.sendSMSConfirmation()
     .subscribe(
        data => {
          this.sms = data.sms;
        },
        error => {
          this.router.navigate(['/home']);
        },
        () => {}
    );
}

getOrder(){
  this.order =  "Order Submitted Successfully";
}
sendEmail() {
  this._httpservice.sendEmailConfirmation()
     .subscribe(
        data => {
          this.email = data.email;
        },
        error => {
          this.router.navigate(['/home']);
        },
        () => {}
    );
}

}

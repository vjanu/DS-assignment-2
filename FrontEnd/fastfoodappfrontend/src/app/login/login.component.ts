import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';

import { HomeService } from '../service.component';
import { AuthguardService } from '../authguard.service';

@Component({
  selector: 'login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
private userlist:any;

  constructor(private router: Router,private _httpservice:HomeService,private authenticationservice:AuthguardService ) { }

  
  ngOnInit() {
    this.authenticationservice.logout();
  }

  btnClick= function () {
    this.router.navigateByUrl('/home');
};

//Authentication Service
Authenticate() {
  this._httpservice.getUserList()
     .subscribe(
        data => {
          this.userlist = data;
        },
        error => {
          this.router.navigate(['/home']);
        },
        () => {}
    );
}

}

import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import { map } from "rxjs/operators";
import { catchError } from "rxjs/operators";
import { HttpClient, HttpHeaders } from '@angular/common/http';

const httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  const url ='http://localhost:8080';
  const smsService ='http://localhost:8097';
  const emailService ='http://localhost:8098';

@Injectable()
export class HomeService {

    constructor(private http:HttpClient) {}
   

        //get 
    getFoodList(): Observable<any> {
        return this.http.get(url + '/foodlist');
    }

   //get 
   getUserList(): Observable<any> {
    return this.http.get(url + '/userlist');
}
        //get 
        sendSMSConfirmation(): Observable<any> {
            return this.http.get(smsService + '/sms');
        }

          //get 
        sendEmailConfirmation(): Observable<any> {
            return this.http.get(emailService + '/email');
        }

}


 

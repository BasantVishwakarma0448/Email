import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class HttpServiceService {
  constructor(private route: Router, private http: HttpClient) { }

  get(endpoint: any, callback: any) {
    return this.http.get(endpoint).subscribe((data: any) => {
      callback(data);
    });
  }


}

import { Component, OnInit } from '@angular/core';
import { HttpServiceService } from '../http-service.service';
import { ActivatedRoute, Route } from '@angular/router';

@Component({
  selector: 'app-email-list',
  templateUrl: './email-list.component.html',
  styleUrls: ['./email-list.component.css']
})
export class EmailListComponent implements OnInit {

  public form = {
    // list: {
    //   subject:null,
    //   date: null,
    //   from: null,
    //   content: null
    // },
    pageNo: 0

  }
  list: any[] = [];

  constructor(private http: HttpServiceService, private route: ActivatedRoute) {

  }

  ngOnInit(): void {
    this.getList();

  }
  getList() {
    var _self = this;
    this.http.get("http://localhost:8080/mail/getInbox", function (res: any) {
      _self.list = res.result.list;
    });
  }

}

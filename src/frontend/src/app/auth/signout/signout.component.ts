import {Component, OnInit} from "@angular/core";
import {AuthService} from "../auth.service";


@Component({
  templateUrl: './signout.component.html'
})
export class SignoutComponent implements OnInit{

  constructor(private authService: AuthService) {
  }

  ngOnInit(): void {
    this.authService.logout();
  }
}

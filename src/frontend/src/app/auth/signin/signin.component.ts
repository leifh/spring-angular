import {Component} from "@angular/core";
import {NgForm} from "@angular/forms";
import {AuthService} from "../auth.service";

@Component({
  templateUrl: './signin.component.html'
})
export class SigninComponent{

  constructor(private authService: AuthService ) {

  }

  onSignin(f: NgForm) {
    console.log(f);
  }
}

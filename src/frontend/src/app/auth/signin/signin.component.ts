import {Component} from "@angular/core";
import {NgForm} from "@angular/forms";
import {AuthService} from "../auth.service";

@Component({
  templateUrl: './signin.component.html'
})
export class SigninComponent{

  constructor(private authService: AuthService ) {

  }

  onSignin(form: NgForm) {
    const username = form.value.username;
    const password = form.value.password;

    this.authService.signin(username, password);
  }
}

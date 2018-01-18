import {NgModule} from "@angular/core";
import {AuthRoutingModule} from "./auth-routing.module";
import {SigninComponent} from "./signin/signin.component";
import {FormsModule} from "@angular/forms";
import {AuthService} from "./auth.service";

@NgModule({
  providers: [
    AuthService
  ],
  declarations: [
    SigninComponent
  ],
  imports: [
    AuthRoutingModule,
    FormsModule,
  ]
})
export class AuthModule{

}

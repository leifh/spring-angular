import {NgModule} from "@angular/core";
import {AuthRoutingModule} from "./auth-routing.module";
import {SigninComponent} from "./signin/signin.component";
import {FormsModule} from "@angular/forms";
import {AuthService} from "./auth.service";
import {HttpClientModule} from "@angular/common/http";
import {SignoutComponent} from "./signout/signout.component";

@NgModule({
  providers: [
    AuthService
  ],
  declarations: [
    SigninComponent,
    SignoutComponent
  ],
  imports: [
    AuthRoutingModule,
    FormsModule,
    HttpClientModule
  ]
})
export class AuthModule{

}

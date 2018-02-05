import {NgModule} from "@angular/core";
import {RouterModule, Routes} from "@angular/router";
import {SigninComponent} from "./signin/signin.component";
import {SignoutComponent} from "./signout/signout.component";

const authRoutes: Routes = [
  { path: 'signin', component: SigninComponent },
  { path: 'signout', component: SignoutComponent }
];

@NgModule({
  imports: [
    RouterModule.forChild(authRoutes)
  ],
  exports: [RouterModule]
})
export class AuthRoutingModule{

}

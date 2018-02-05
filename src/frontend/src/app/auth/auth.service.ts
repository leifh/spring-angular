import {Injectable} from "@angular/core";
import {HttpClient, HttpHeaders, HttpParams, HttpRequest} from "@angular/common/http";
import {Observable} from "rxjs/Observable";
import {Router} from "@angular/router";

@Injectable()
export class AuthService{

  private token : string;

  constructor(private httpClient: HttpClient,
              private router: Router) {
  }

  signin(username: string, password: string) {


    const body = new HttpParams()
      .set(`username`, username)
      .set(`password`, password);


    const response : Observable<string> =  this.httpClient.post("http://localhost:8080/auth/login", body.toString(), {
      headers: new HttpHeaders({ 'Content-Type': 'application/x-www-form-urlencoded' }),
      responseType: "text"
    });

    response.subscribe(
      (value) => {
        console.log(value);
        this.token = value;
        this.router.navigate(["/"]);
      },
      (error) => console.log(error)
    )
  }

  isAuthenticated() {
    return this.token != null;
  }

  logout() {
    this.token = null;
  }
}

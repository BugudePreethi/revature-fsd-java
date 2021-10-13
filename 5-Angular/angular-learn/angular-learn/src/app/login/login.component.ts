import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  username!: string;
  password!: string;
  message!: string;
  constructor(private router: Router, private authService: AuthService) { }

  ngOnInit(): void {
  }
  login() {
    if (this.username == 'admin' && this.password == 'pwd') {
      this.router.navigate(['/movie-list']);
      this.authService.login();
    } else {
      this.message = "Invalid Username / Password";
    }
  }

}

import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  loggedIn!: boolean;

  constructor() { }
  
  login(): void {
    this.loggedIn = true;
  }

  logout(): void {
    this.loggedIn = false;
  }

  get isLoggedIn(): boolean {
    return this.loggedIn;
  }
}

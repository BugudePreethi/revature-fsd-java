import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthGuard } from './auth/auth.guard';
import { EditMovieComponent } from './edit-movie/edit-movie.component';
import { HttpComponent } from './http/http.component';
import { LoginComponent } from './login/login.component';
import { MovieListComponent } from './movie-list/movie-list.component';
import { ProfileComponent } from './profile/profile.component';

const routes: Routes = [
  { path: 'movie-list', component: MovieListComponent, canActivate: [AuthGuard] },
  { path: 'edit-movie/:id', component: EditMovieComponent, canActivate: [AuthGuard] },
  { path: 'profile', component: ProfileComponent, canActivate: [AuthGuard] },
  { path: 'http', component: HttpComponent, canActivate: [AuthGuard] },
  { path: 'login', component: LoginComponent },
  { path: '',redirectTo: "/login", pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

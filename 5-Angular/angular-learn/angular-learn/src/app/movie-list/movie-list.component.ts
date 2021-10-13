import { Component, OnInit } from '@angular/core';
import { movies } from '../data';
import { Movie } from '../movie/model/movie';

@Component({
  selector: 'app-movie-list',
  templateUrl: './movie-list.component.html',
  styleUrls: ['./movie-list.component.css']
})
export class MovieListComponent implements OnInit {

  movies: Movie[] = movies;
  searchKey: string = "";
  constructor() { }

  ngOnInit(): void {
  }

  signalFromChild(): void{
    console.log("Signal from Child component received.");
  }
  
  findMovies(): void{
    let matchingMovies = [];
    for(let movie of movies){
      if(movie.title.includes(this.searchKey)){
        matchingMovies.push(movie);
      }
    }
    this.movies = matchingMovies;
  }

}

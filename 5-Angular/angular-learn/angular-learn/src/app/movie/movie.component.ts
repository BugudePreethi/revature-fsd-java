import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-movie',
  templateUrl: './movie.component.html',
  styleUrls: ['./movie.component.css']
})
export class MovieComponent implements OnInit {

  title: string = "Joker";
  genres: string[] = ["Drama", "Thriller"];
  constructor() { }

  ngOnInit(): void {
  }

}

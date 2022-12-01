import { Component } from '@angular/core';
import {Film} from "../../models/film";
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-film-view',
  templateUrl: './film-view.component.html',
  styleUrls: ['./film-view.component.css']
})
export class FilmViewComponent {
  baseUrl: string = "http://localhost:8080/api/v1";
  films: Film[] = [];

  constructor(private http: HttpClient) {
  }

  ngOnInit() {
    this.fetchAndDisplayFilms();
  }

  refreshFilmList() {
    this.fetchAndDisplayFilms();
  }

  fetchAndDisplayFilms(): void {
    this.http.get<Film[]>(`${this.baseUrl}/film`).subscribe((res) => {
      console.log(res);
      this.films = res;
    });
  }

  deleteFilm(id: number) {
    console.log(`delete ${id}`);
    this.http.delete(`${this.baseUrl}/film/${id}`).subscribe(() => this.fetchAndDisplayFilms());
  }
}

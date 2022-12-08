import { Component } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-add-film-form',
  templateUrl: './add-film-form.component.html',
  styleUrls: ['./add-film-form.component.css']
})
export class AddFilmFormComponent {
  baseUrl: string = "http://localhost:8080/api/v1";

  constructor(private http: HttpClient) {
  }

  addMovie(film: any) {
    this.http.post(`${this.baseUrl}/film`, film).subscribe((res: any) => {
      console.log(res.response)
    });
  }
}

import { Component } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-search-bar',
  templateUrl: './search-bar.component.html',
  styleUrls: ['./search-bar.component.css']
})
export class SearchBarComponent {
  baseUrl: string = "http://localhost:8080/api/v1";
  searchResults: any = [];
  searchResultsCache: any = [];

  constructor(private http: HttpClient) {
  }

  handleSearch(value: string) {
    if (value === "")
      return;

    this.http.get(`${this.baseUrl}/search-film/${value}`).subscribe((res: any) => {
      console.log(res);
      this.searchResultsCache = res;
    });
  }

  showSearchResults() {
    this.searchResults = this.searchResultsCache;
  }
}

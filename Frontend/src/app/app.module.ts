import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule} from "@angular/forms";

import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header.component';
import { FilmComponent } from './components/film/film.component';
import { FilmViewComponent } from './components/film-view/film-view.component';
import { AddFilmFormComponent } from './components/add-film-form/add-film-form.component';
import { SearchBarComponent } from './components/search-bar/search-bar.component';


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FilmComponent,
    FilmViewComponent,
    AddFilmFormComponent,
    SearchBarComponent
  ],
    imports: [
        BrowserModule,
        HttpClientModule,
        FormsModule
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

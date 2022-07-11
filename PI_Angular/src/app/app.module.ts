import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { headerSection } from './header-section/header-section';
import { BannerContainer } from './banner-container/banner-container.component'

@NgModule({
  declarations: [
    AppComponent,
    headerSection,
    BannerContainer
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

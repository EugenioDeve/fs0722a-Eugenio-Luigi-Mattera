import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { Route, RouterModule } from '@angular/router';

import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { PrimoComponent } from './components/primo/primo.component';
import { SecondoComponent } from './components/secondo/secondo.component';
import { SecondoAComponent } from './components/secondo-a/secondo-a.component';
import { SecondoBComponent } from './components/secondo-b/secondo-b.component';

const routes: Route[] = [
    {
        path: '',
        component: HomeComponent
    },
    {
        path: 'primo',
        component: PrimoComponent
    },
    {
        path: 'secondo',
        component: SecondoComponent,
        children: [
            {
                path: 'secondoA',
                component: SecondoAComponent
            },
            {
                path: 'secondoB',
                component: SecondoBComponent
            }
        ]
    }
]

@NgModule({
    declarations: [
        AppComponent,
        HomeComponent,
        NavbarComponent,
        PrimoComponent,
        SecondoComponent,
        SecondoAComponent,
        SecondoBComponent
    ],
    imports: [
        BrowserModule,
        RouterModule.forRoot(routes)
    ],
    providers: [],
    bootstrap: [AppComponent]
})
export class AppModule { }

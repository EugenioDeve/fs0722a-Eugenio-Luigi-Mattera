import { Component } from '@angular/core';

@Component({
    selector: 'app-root',
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.scss']
})
export class AppComponent {
    title = 'child';

    users = [
        {
            nome: 'Mario',
            cognome: 'Rossi'
        },
        {
            nome: 'Aldo',
            cognome: 'Bianchi'
        },
        {
            nome: 'Anna',
            cognome: 'Verdi'
        },
        {
            nome: 'Maria',
            cognome: 'Neri'
        },
        {
            nome: 'Giovanna',
            cognome: 'Gialli'
        }
    ]
}

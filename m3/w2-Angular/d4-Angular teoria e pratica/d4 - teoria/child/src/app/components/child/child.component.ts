import { Component, OnInit } from '@angular/core';

@Component({
    selector: 'app-child',
    templateUrl: './child.component.html',
    styleUrls: ['./child.component.scss']
})
export class ChildComponent implements OnInit {

    nome = 'Componente Child';
    calcolo = this.somma();

    somma() {
        return 3 + 5;
    }

    constructor() { }

    ngOnInit(): void {
    }

}

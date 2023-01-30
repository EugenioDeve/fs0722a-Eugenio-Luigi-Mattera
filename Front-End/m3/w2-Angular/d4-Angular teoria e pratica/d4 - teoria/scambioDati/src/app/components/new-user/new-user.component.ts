import { User } from './../../interface/user.interface';
import { Component, OnInit, Output, EventEmitter } from '@angular/core';

@Component({
    selector: 'app-new-user',
    templateUrl: './new-user.component.html',
    styleUrls: ['./new-user.component.scss']
})
export class NewUserComponent implements OnInit {

    @Output() onManCreated = new EventEmitter<User>();
    @Output() onWomanCreated = new EventEmitter<User>();

    newName = '';
    newSurname = '';
    newEta = 0;

    constructor() { }

    onAddMan() {
        this.onManCreated.emit({name: this.newName, surname: this.newSurname, sex: 'Uomo', eta: this.newEta});
    }

    onAddWoman() {
        this.onWomanCreated.emit({name: this.newName, surname: this.newSurname, sex: 'Donna', eta: this.newEta});
    }

    ngOnInit(): void {
    }

}

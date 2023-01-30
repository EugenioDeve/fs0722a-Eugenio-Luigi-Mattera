import { User } from './../../interface/user.interface';
import { Component, OnInit, Input } from '@angular/core';

@Component({
    selector: 'app-user-card',
    templateUrl: './user-card.component.html',
    styleUrls: ['./user-card.component.scss']
})
export class UserCardComponent implements OnInit {

    @Input('data') element!: User;

    constructor() { }

    ngOnInit(): void {
    }

}

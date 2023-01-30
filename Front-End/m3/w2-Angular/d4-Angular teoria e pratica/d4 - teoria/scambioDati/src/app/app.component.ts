import { Component } from '@angular/core';
import { User } from './interface/user.interface';

@Component({
    selector: 'app-root',
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.scss']
})
export class AppComponent {
    title = 'scambioDati';

    users: User[] = [];

    onAddMan(user: User) {
        this.users.push(user);
    }

    onAddWoman(user: User) {
        this.users.push(user);
    }
}

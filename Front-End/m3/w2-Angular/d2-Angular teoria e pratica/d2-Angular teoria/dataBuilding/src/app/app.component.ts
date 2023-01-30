import { Component } from '@angular/core';
import { UsersService } from './service/users.service';

@Component({
    selector: 'app-root',
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.scss']
})
export class AppComponent {
    title = 'lezione2';

    users = this.userSrv.users;

    constructor(private userSrv: UsersService) {}
}

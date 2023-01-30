import { Component, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms'

@Component({
    selector: 'app-root',
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.scss']
})
export class AppComponent {
    title = 'tdForm';
    stampa: boolean = false

    @ViewChild('form', {static: true}) form!: NgForm;

    userForm = {
        defUserName: '',
        email: '',
        question: ''
    }

    generi = [
        {
            label: 'uomo',
            value: 'uomo'
        },
        {
            label: 'donna',
            value: 'donna'
        }
    ]

    risposta = '';

    user: any = {
        username: '',
        email: '',
        secret: '',
        sesso: '',
        risposta: ''
    }

    ngOnInit(): void {
        //Called after the constructor, initializing input properties, and the first call to ngOnChanges.
        //Add 'implements OnInit' to the class.
        this.form.statusChanges?.subscribe(status => { // a ogni cambiamento nel form verrà stampato in console lo stato del form (valid/invalid)
            console.log('Stato del form: ', status);
        });
    }

    generateUsername() {
        this.form.form.patchValue({
            userInfo: {
                email: 'pippo@pippo.com',
                username: 'pippo'
            }
        });
    }

    submit() {
        console.log('Form inviato: ', this.form);
        this.stampa = true;
        this.user.username = this.form.value.userInfo.username;
        this.user.email = this.form.value.userInfo.email;
        this.user.secret = this.form.value.userInfo.secret;
        this.user.sesso = this.form.value.userInfo.sesso;
        this.user.risposta = this.form.value.userInfo.risposta;

        this.form.reset();
    }
}

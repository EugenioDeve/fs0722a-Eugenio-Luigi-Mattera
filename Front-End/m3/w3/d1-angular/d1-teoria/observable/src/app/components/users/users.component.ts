import { Component, OnInit } from '@angular/core';
import { Observable, Subscription } from 'rxjs';
import { map } from 'rxjs/operators';

@Component({
    selector: 'app-users',
    templateUrl: './users.component.html',
    styleUrls: ['./users.component.scss']
})
export class UsersComponent implements OnInit {

    sub!: Subscription; // L'oggetto che sottoscriverà l'observable
    conteggio: number = 0; // Variabile che ricevera il valore dell'observable (observer)

    constructor() { }

    ngOnInit(): void {

        const intervallo = new Observable(observer =>  { // Creo l'observable
            let count = 0;
            setInterval(() => {
                observer.next(count); // in una variabile chiamata observer l'observable emette un valore (riga 30)
                if (count === 5) {
                    observer.complete(); // completo l'observable al raggiungimento di un dato valore
                    console.log('Observer completato!');
                }
                if (count > 3) {
                    observer.error(new Error('Count è troppo grande'));
                }
                count++; // Incremento il valore emesso dall'observable
            }, 1000);
        });

        this.sub = intervallo.pipe(map((conta) => { // mappo l'observable
            this.conteggio = Number(conta); // Incremento la variabile conteggio con il valore dell'observable
            return `Siamo al numero ${conta}`;
        })).subscribe(numero => { // sottoscrivo l'observable memorizzando il valore in una variabile numero
            console.log(numero);
        },(error) => { // in caso di errore (riga 27 ss.) emetto l'errore, ma NON blocco il flusso
            console.log(error);
            alert(error);
        }, () => {
            console.log('Observable completato'); // Al completamento dell'observable (riga 23 ss.) stampo il cmopletamento
        });

    }

    ngOnDestroy(): void {
        //Called once, before the instance is destroyed.
        //Add 'implements OnDestroy' to the class.
        this.sub.unsubscribe();
        console.log('Observable scaricato!');
    }

}

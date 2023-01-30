import { Component, Input, OnInit } from '@angular/core';

var target = document.getElementById("target") as HTMLElement;
//var title = document.getElementById("title") as HTMLElement;
//var loadBtn = document.getElementById("loadBtn") as HTMLElement;

class Engages {
  id:number;
  title:string;

  constructor(_id:number, _title:string) {
      this.id = _id;
      this.title = _title;
  }

  listCreation() {
    console.log(this.title);
  }
}

@Component({
  selector: 'app-to-do-list',
  templateUrl: './to-do-list.component.html',
  styleUrls: ['./to-do-list.component.scss']
})
export class ToDoListComponent implements OnInit {

  constructor() {  }

  ngOnInit(): void {
    fetch ("http://localhost:4200/todos")
    .then((res) => {
        return res.json()
    })
    .then((res:Engages[]) => {
        res.forEach(element => {
            let engage = new Engages (element.id, element.title);
            engage.listCreation();
        });
    })
  }

}

/*function addEngage(data:any) {
  let response = fetch('http://localhost:3000/todos', {
  method: 'POST',
  headers: {
    'Content-Type': 'application/json;charset=utf-8',
  },
  body: JSON.stringify(data),
});
(document.getElementById("title") as HTMLInputElement).value = " ";
}

loadBtn.addEventListener("click", () => {
if ((document.getElementById("title") as HTMLInputElement).value != '') {
  var data = {
    title : (document.getElementById("title") as HTMLInputElement).value
  };
  addEngage(data);
} else {
  alert("Campo di input vuoto");
}
})*/

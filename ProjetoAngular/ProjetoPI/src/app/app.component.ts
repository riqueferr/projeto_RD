import { Component } from '@angular/core';
import { AppData } from './AppData';

@Component({
  selector: 'app-root',
  templateUrl:'./app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app';
  data = new AppData('');

}

// app.component.ts

// import { Component } from '@angular/core';
// import {NgForm} from '@angular/forms';
// @Component({
//   selector: 'app-root',
//   template: `
//     <form #it="ngForm" (ngSubmit)="onSubmit(it)" novalidate>
//       <input name="first" ngModel required #first="ngModel">
//       <input name="last" ngModel required #last="ngModel">
//       <button>Submit</button>
//     </form>
//     <p>First name value: {{ first.value }}</p>
//     <p>First name valid: {{ first.valid }}</p>
//     <p>last name value: {{ last.value }}</p>
//     <p>last name valid: {{ last.valid }}</p>
//     <p>Form value: {{ it.value | json }}</p>
//     <p>Form valid: {{ it.valid }}</p>
//   `,
//   styleUrls: ['./app.component.css']
// })
// export class AppComponent {
//   onSubmit(it: NgForm) {
//     console.log(it.value);  // { first: '', last: '' }
//     console.log(it.valid);  // false
//   }
// }

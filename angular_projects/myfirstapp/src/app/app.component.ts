import { Component } from '@angular/core';
import { Grade, students } from './students';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title = 'Student Grader';

  students = students;

  onNotify(event: any) {
    console.log(event);
    if (event >= 90) {
      alert("You performed extremely well! Your grade is A.");
    } else if (event >= 80) {
      alert("You performed pretty well! Your grade is B.");
    } else if (event >= 70) {
      alert("You performed okay! Your grade is C.");
    } else {
      alert("You did not perform so well this time! Your grade is F.");
    }
  }
}

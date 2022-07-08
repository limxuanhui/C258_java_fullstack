import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Student } from '../students';

@Component({
  selector: 'app-student-alerts',
  templateUrl: './student-alerts.component.html',
  styleUrls: ['./student-alerts.component.css']
})
export class StudentAlertsComponent implements OnInit {

  @Input() student : Student | undefined;
  @Output() notify = new EventEmitter<number>();

  constructor() { }

  ngOnInit(): void {
  }
  
  calculateGrade(subjects: any) {
    let totalScore : number = 0;
    for (const subject of subjects) {
      console.log(subject);
      totalScore += subject.score;
    }
    const avgScore = totalScore / subjects.length;
    this.notify.emit(avgScore);
  }
}

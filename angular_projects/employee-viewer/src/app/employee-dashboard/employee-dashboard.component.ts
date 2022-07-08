import { Component, OnInit } from '@angular/core';
import { Employee } from '../employee-list/employee-list.component';

@Component({
  selector: 'app-employee-dashboard',
  templateUrl: './employee-dashboard.component.html',
  styleUrls: ['./employee-dashboard.component.css']
})
export class EmployeeDashboardComponent implements OnInit {
  selectedEmployee!: Employee;

  constructor() { }

  ngOnInit(): void {
  }

  onSelect(employee: Employee) {
    this.selectedEmployee = employee;
  }
}

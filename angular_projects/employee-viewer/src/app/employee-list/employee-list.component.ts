import { EventEmitter } from '@angular/core';
import { Component, OnInit, Output } from '@angular/core';

import { EmployeeServiceService } from '../employee-service.service';

export interface Employee {
  employeeId: number;
  firstName: string;
  lastName: string;
  email: string;
  phoneNumber: string;
  hireDate: string;
  jobId: string;
  salary: number;
}

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css'],
})
export class EmployeeListComponent implements OnInit {
  employees!: Employee[];

  @Output() selectEmployee = new EventEmitter<Employee>();

  constructor(private employeeService: EmployeeServiceService) {}

  ngOnInit(): void {
    this.getEmployees();
  }

  getEmployees(): void {
    this.employeeService
      .getEmployees()
      .subscribe((employees) => (this.employees = employees));
  }

  onSelect(employee: Employee) {
    this.selectEmployee.emit(employee);
  }
}

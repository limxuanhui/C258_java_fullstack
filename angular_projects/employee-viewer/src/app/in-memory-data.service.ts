import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class InMemoryDataService implements InMemoryDataService {
  createDb() {
    const employees = [
      {
        employeeId: 100,
        firstName: 'Steven',
        lastName: 'King',
        email: 'SKING',
        phoneNumber: '515-123-4567',
        hireDate: '1987-06-17',
        jobId: 'AD_PRES',
        salary: 24000,
      },
      {
        employeeId: 101,
        firstName: 'Neena',
        lastName: 'Kochhar',
        email: 'NKOCHHAR',
        phoneNumber: '515-123-4568',
        hireDate: '1989-09-21',
        jobId: 'AD_VP',
        salary: 17000,
      },
      {
        employeeId: 102,
        firstName: 'Lex',
        lastName: 'De Haan',
        email: 'LDEHAAN',
        phoneNumber: '515-123-4569',
        hireDate: '1993-01-13',
        jobId: 'AD_VP',
        salary: 17000,
      },
      {
        employeeId: 103,
        firstName: 'Alexander',
        lastName: 'Hunold',
        email: 'AHUNOLD',
        phoneNumber: '590-423-4567',
        hireDate: '1990-01-03',
        jobId: 'IT_PROG',
        salary: 9000,
      },
      {
        employeeId: 104,
        firstName: 'Bruce',
        lastName: 'Ernst',
        email: 'BERNST',
        phoneNumber: '590-423-4568',
        hireDate: '1991-05-21',
        jobId: 'IT_PROG',
        salary: 6000,
      },
    ];
    return { employees };
  }

  constructor() {}
}

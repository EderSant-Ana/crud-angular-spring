import { Router } from '@angular/router';
import { Employee } from './../employee';
import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {

  employees: Employee[];
  employee: Employee;

  constructor(private employeeService: EmployeeService,
    private router: Router
    ) { }

  ngOnInit(): void {
    this.getEmployees();
    // this.postEmployee(
    //   {
    //     "id": null,
    //     "firstName": "Rosana",
    //     "lastName": "Angélica",
    //     "emailId": "ro@gmail.com",
    //   }
    // );
  }

  private getEmployees() {
    this.employeeService.getEmployeesList().subscribe(data => {
      this.employees = data;
    })
  }

  updateEmployee(id: number){
    this.router.navigate(['update-employee', id]);
  }

  employeeDetails(id: number){
    this.router.navigate(['employee-details', id]);
  }

  deleteEmployee(id: number){
    this.employeeService.deleteEmployee(id).subscribe(data =>{
      this.getEmployees();
    })
  }

  // [{
  //     "id": 1,
  //     "firstName": "José",
  //     "lastName": "Silva",
  //     "emailId": "jose@gmail.com"
  //   },
  //   {
  //     "id": 2,
  //     "firstName": "Maria",
  //     "lastName": "Silva",
  //     "emailId": "maria@gmail.com"
  //   }]
}



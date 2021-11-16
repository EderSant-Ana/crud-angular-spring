import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Employee } from './employee';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  private baseURL = "http://localhost:8080/api/v1/employees";

  constructor(private httpClient: HttpClient) { }

    private httpOptions = {
      headers: new HttpHeaders({
        'Content-Type':  'application/json'
      })
    }

    getEmployeesList(): Observable<Employee[]> {
      return this.httpClient.get<Employee[]>(`${this.baseURL}`)
    }

    getEmployeeById(id: number): Observable<Employee> {
      return this.httpClient.get<Employee>(`${this.baseURL}/${id}`)
      .pipe(
        catchError(this.handleError)
      )
    }

    postEmployee(employee: Employee): Observable<Employee> {
      return this.httpClient.post<Employee>(`${this.baseURL}`, employee, this.httpOptions)
      .pipe(
        catchError(this.handleError)
      )
    }

    updateEmployee(id: number, employee: Employee): Observable<Employee> {
      return this.httpClient.put<Employee>(`${this.baseURL}/${id}`, employee, this.httpOptions)
      .pipe(
        catchError(this.handleError)
      )
    }

    deleteEmployee(id: number): Observable<Employee>{
      return this.httpClient.delete<Employee>(`${this.baseURL}/${id}`, this.httpOptions)
        .pipe(
          catchError(this.handleError)
        )
    }


    private handleError(error: HttpErrorResponse) {
      //console.error(error.error.message);
      // Return an observable with a user-facing error message.
      return throwError(
        error.error.message);
    }

}

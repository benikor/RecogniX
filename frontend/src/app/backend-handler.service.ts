import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';
import { environment } from 'src/environments/environment';


@Injectable({
  providedIn: 'root'
})
export class BackendHandlerService {

  private backendUrl =  environment.BACKEND_URL;  // URL to web api

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  constructor(
    private http: HttpClient,
  ) { }



  getSymptomps(): Observable<any> {
    return (this.http.get<any>(`${this.backendUrl}/symptoms`))
    .pipe(
       tap(_ => console.log('fetched Symptomps')),
       catchError(this.handleError<any>('getSymptomps', []))
     )
  }

  getRequestTreatment(): Observable<any> {
    return (this.http.get<any>(`${this.backendUrl}/requestTreatment`))
    .pipe(
       tap(_ => console.log('fetched RequestTreatment')),
       catchError(this.handleError<any>('getRequestTreatment', []))
     )
  }

  getRequestPatientTreatmentById(id: number): Observable<any> {
    return (this.http.get<any>(`${this.backendUrl}/requestTreatment/patientId/${id}`))
    .pipe(
       tap(_ => console.log('fetched RequestPatientTreatmentById')),
       catchError(this.handleError<any>('getRequestPatientTreatmentById', []))
     )
  }

  getPatientById(id: number): Observable<any> {
    return (this.http.get<any>(`${this.backendUrl}/requestTreatment/${id}/patient`))
    .pipe(
       tap(_ => console.log('fetched PatientById')),
       catchError(this.handleError<any>('getPatientById', []))
     )
  }

  getSymptompsById(id: number): Observable<any> {
    return (this.http.get<any>(`${this.backendUrl}/requestTreatment/${id}/symptoms`))
    .pipe(
       tap(_ => console.log('fetched SymptompsById')),
       catchError(this.handleError<any>('getSymptompsById', []))
     )
  }

  getAutoTreatmentById(id: number): Observable<any> {
    return (this.http.get<any>(`${this.backendUrl}/autoTreatment/${id}`))
    .pipe(
       tap(_ => console.log('fetched AutoTreatment')),
       catchError(this.handleError<any>('getAutoTreatmentById', []))
     )
  }

  getRequestTreatmentByPatientId(id: number): Observable<any> {
    return (this.http.get<any>(`${this.backendUrl}/requestTreatment/${id}/treatments`))
    .pipe(
       tap(_ => console.log('fetched RequestTreatmentByPatientId')),
       catchError(this.handleError<any>('getRequestTreatmentByPatientId', []))
     )
  }






  postTreatmentWithId(itemFromComment: any): Observable<any> {
    return this.http.post<any>(`${this.backendUrl}/requestTreatment/`, itemFromComment, this.httpOptions).pipe(
      tap(_ => console.log('postTreatmentWithId')),
      catchError(this.handleError<any>('postTreatmentWithId'))
    )
  }
  

  /**
   * Handle Http operation that failed.
   * Let the app continue.
   * @param operation - name of the operation that failed
   * @param result - optional value to return as the observable result
   */
   private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead

      // TODO: better job of transforming error for user consumption
      console.log(`${operation} failed: ${error.message}`);

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }

}

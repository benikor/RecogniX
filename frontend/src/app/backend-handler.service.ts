import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';


@Injectable({
  providedIn: 'root'
})
export class BackendHandlerService {

  private backendUrl = 'http://localhost:8080/api';  // URL to web api

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  constructor(
    private http: HttpClient,
  ) { }



  getSymptomps(): Observable<any> {
    return (this.http.get<any>(`${this.backendUrl}/symptoms`))
    .pipe(
       tap(_ => console.log('fetched symptomps')),
       catchError(this.handleError<any>('getSymptomps', []))
     )
  }

  getRequestTreatment(): Observable<any> {
    return (this.http.get<any>(`${this.backendUrl}/requestTreatment`))
    .pipe(
       tap(_ => console.log('fetched requestTreatment')),
       catchError(this.handleError<any>('getRequestTreatment', []))
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

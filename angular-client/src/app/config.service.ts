import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError, tap, throwError } from 'rxjs';
import { LoggerService } from './logger.service';

@Injectable({
  providedIn: 'root'
})
export class ConfigService {

  constructor(private http: HttpClient, private logger: LoggerService) { }

  helloWorld() : Observable<string>  {

    this.logger.log("ConfigService:helloWorld() -> calling angular/helloworld ");

    return this.http.get('http://localhost:8080/angular/helloworld', {responseType: 'text'})
    .pipe(
      tap((data: string) => data),
      catchError(err => throwError(() => err))
    )
  }
}

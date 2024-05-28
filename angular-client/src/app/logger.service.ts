import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LoggerService {

  log(msg: unknown) {
    console.log("LOG --- " + msg);
  }

  error(msg: unknown) {
    console.error("LOG --- " +  msg);
  }

  warn(msg: unknown) {
    console.log("LOG --- " +  msg);
  }
}

import { Injectable } from "@angular/core";
import { Actions, createEffect, ofType } from "@ngrx/effects";
import { HelloWorldActions } from "./actions";
import { EMPTY, catchError, map, mergeMap, tap } from "rxjs";
import { ConfigService } from "../../config.service";

@Injectable()
export class HelloWorldEffects {

  constructor(
    private actions$: Actions,
    private configService: ConfigService
  ) {}

 getHelloWorldString$ = createEffect(() => {
    return this.actions$.pipe(
      ofType(HelloWorldActions.GET_HELLO_WORLD_STRING),
      mergeMap(() => this.configService.helloWorld()
      .pipe(
        map(message => ({ type: HelloWorldActions.SET_HELLO_WORLD_STRING, message})),
        catchError(() => EMPTY)
      ))
    )
  }, {dispatch: true}); 
  
}
import { createAction, props } from "@ngrx/store";

export enum HelloWorldActions {
  GET_HELLO_WORLD_STRING = '[Hello-World] Get Hello-World string',
  SET_HELLO_WORLD_STRING = '[Hello-World] Set Hello-World string',
}

export const gethelloWorldString = createAction(
  HelloWorldActions.GET_HELLO_WORLD_STRING,
);

export const sethelloWorldString = createAction(
  HelloWorldActions.SET_HELLO_WORLD_STRING,
  props<{message: string}>()
);
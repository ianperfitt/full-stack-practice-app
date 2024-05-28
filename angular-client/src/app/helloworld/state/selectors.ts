import { StoreModule, createFeatureSelector, createSelector } from "@ngrx/store"
import { HelloWorldState } from "./reducer"

export const selectAppState = createFeatureSelector<HelloWorldState>('helloWorldState')

export const selectMessage = () => createSelector(
  selectAppState,
  (state: HelloWorldState) => state.message
)
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { StoreModule } from '@ngrx/store';
import { EffectsModule } from '@ngrx/effects';
import { helloWorldReducer } from './state/reducer';
import { HelloWorldEffects } from './state/effect';
import { HelloworldComponent } from './components/helloworld/helloworld.component';
import { HelloWorldRoutingModule } from './hello-world-routing.module';



@NgModule({
  declarations: [
    HelloworldComponent
  ],
  imports: [
    CommonModule,
    HelloWorldRoutingModule,
    StoreModule.forFeature('helloWorldState', helloWorldReducer),
    EffectsModule.forFeature([HelloWorldEffects])
  ]
})
export class HelloworldModule { }

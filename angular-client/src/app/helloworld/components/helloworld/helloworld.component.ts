import { Component } from '@angular/core';
import { ConfigService } from '../../../config.service';
import { selectMessage } from '../../state/selectors';
import { GlobalState } from '../../../global.state';
import { Store } from '@ngrx/store';
import { HelloWorldActions } from '../../state/actions';

@Component({
  selector: 'app-helloworld',
  templateUrl: './helloworld.component.html',
  styleUrl: './helloworld.component.css'
})
export class HelloworldComponent {

  text$ = this.store.select(selectMessage());
  text = "";

  constructor(
    private configService : ConfigService,
    private store: Store<GlobalState>
  ) {}

  ngOnInit() {
    this.store.dispatch({type: HelloWorldActions.GET_HELLO_WORLD_STRING});
    this.helloWorld();
  }

  helloWorld() {
    this.text$.subscribe((data: string) => {
      //console.log(data);
      this.text = data;
    })
  }

}

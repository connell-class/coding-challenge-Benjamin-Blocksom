import { Component } from '@angular/core';

@Component({
  selector: 'app-container',
  // specifies the template string for the Listview component
    template: `<ejs-listview id='sample-list' [dataSource]='data'></ejs-listview>`
})

export class AppComponent {
    public data: Object = [
    { text: 'my list', id: '01' },
    { text: 'your list', id: '02' },
    { text: 'store list', id: '03' }];
}

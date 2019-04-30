import * as React from "react";
import * as ReactDOM from "react-dom";
import {Provider} from 'react-redux';
import {createStore} from 'redux';

import {Layout} from "./components/Layout";

const initialState = {
  count: 0
};

function reducer(state = initialState, action: any) {
  console.log('reducer', state, action);

  switch (action.type) {
    case 'INCREMENT':
      return {count: state.count + 1};
    case 'DECREMENT':
      return {copunt: state.count - 1};
    case 'RESET':
      return {count: 0};
    default:
      return state;
  }

}

const store = createStore(reducer);

store.dispatch({type: "INCREMENT"});
store.dispatch({type: "DECREMENT"});
store.dispatch({type: "RESET"});

ReactDOM.render(
  <Provider store={store}>
    <Layout compiler="TypeScript" framework="React"/>
  </Provider>,
    document.getElementById("layout")
);
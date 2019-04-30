import * as React from "react";
import * as ReactDOM from "react-dom";
import {Provider} from 'react-redux';
import {createStore} from 'redux';

import {Layout} from "./components/Layout";

import rootReducer from './reducers';


const store = createStore(rootReducer);

store.dispatch({type: "INCREMENT"});
store.dispatch({type: "DECREMENT"});
store.dispatch({type: "RESET"});

ReactDOM.render(
  <Provider store={store}>
    <Layout compiler="TypeScript" framework="React"/>
  </Provider>,
    document.getElementById("layout")
);
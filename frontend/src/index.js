import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import './bootstrap-override.scss';
import * as serviceWorker from './serviceWorker';
import './i18n';
import App from './container/App';
// import AuthenticationContext from './shared/AuthenticationContext';
import { Provider } from 'react-redux';
import { createStore } from 'redux';

const loggedInState = {
  isLoggedIn: true,
  username: 'user1',
  displayName: 'display1',
  image: null,
  password: 'P4ssword'
};

const defaultState = {
  isLoggedIn: false,
  username: undefined,
  displayName: undefined,
  image: undefined,
  password: undefined
};

const reducer = (state = { ...defaultState }, action) => {
  if (action.type === 'logout-success') {
    return defaultState;
  }
  return state;
};

const store = createStore(reducer, loggedInState);

ReactDOM.render(
  <Provider store={store}>
    <App />
  </Provider>,
  document.getElementById('root')
);

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA
serviceWorker.unregister();

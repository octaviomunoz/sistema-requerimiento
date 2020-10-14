import React from 'react';
import logo from './logo.svg';
import './App.css';

import Login from './components/login/Login';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>

        <section className="componentes">

          <Login />        

        </section>

      </header>
    </div>
  );
}

export default App;

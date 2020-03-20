import React from 'react';
import { BrowserRouter as Router, Switch, Route } from 'react-router-dom';

import Login from './pages/Login';
import Home from './pages/Home';
import Users from './pages/Users';
import { PrivateRoute } from './_components/PrivateRoute';

function App() {
  return (
    <div>
      <Router>
        <Switch>
          <Route exact path="/" component={Login} />
          <PrivateRoute path="/Home" component={Home} />
          <PrivateRoute path="/Users" component={Users} />
        </Switch>
      </Router>
    </div>
  );
}

export default App;

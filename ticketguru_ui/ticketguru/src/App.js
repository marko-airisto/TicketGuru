import React from 'react';
import './App.css';
import { AuthProvider } from './utils/AuthContext';
import { BrowserRouter as Router, Switch, Route } from 'react-router-dom';
import PrivateRoute from './components/PrivateRoute';
import Home from './pages/Home';
import Events from './pages/Events';
import Unauthorized from './pages/Unauthorized';
import Tickets from './pages/Tickets';
import Login from './pages/Login';
import Header from './components/Header';

function App() {
  return (
    <AuthProvider>
      <Router>
        <Header />
        <Switch>
          <Route exact path="/" component={Login} />
          <PrivateRoute path="/home">
            <Home />
          </PrivateRoute>
          <PrivateRoute path="/events">
            <Events />
          </PrivateRoute>
          <PrivateRoute path="/tickets">
            <Tickets />
          </PrivateRoute>
          <Route render={() => <Unauthorized />} />
        </Switch>
      </Router>
    </AuthProvider>
  );
}
export default App;

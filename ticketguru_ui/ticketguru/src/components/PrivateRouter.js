import React from 'react';
import { Switch, Route, Redirect } from 'react-router-dom';
import { useAuthContext } from '../utils/AuthContext';
import Home from '../pages/Home';
import Events from '../pages/Events';
import Tickets from '../pages/Tickets';
import Login from '../pages/Login';
import Unauthorized from '../pages/Unauthorized';

const PrivateRoute = ({ children, ...rest }) => {
  const { auth } = useAuthContext();
  return (
    <Route
      {...rest}
      render={({ location }) =>
        auth.isAuthenticated ? (
          children
        ) : (
          <Redirect to={{ pathname: '/', state: { from: 'location' } }} />
        )
      }
    />
  );
};

const PrivateRouter = () => (
  <Switch>
    <Route exact path="/" component={Login} />
    <PrivateRoute exact path="/home" component={Home} />
    <PrivateRoute exact path="/events" component={Events} />
    <PrivateRoute exact path="/tickets" component={Tickets} />
    <Route render={() => <Unauthorized />} />
  </Switch>
);

export default PrivateRouter;

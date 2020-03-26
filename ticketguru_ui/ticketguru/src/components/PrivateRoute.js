import React from 'react';
import { Route, Redirect } from 'react-router-dom';
import { useAuthContext } from '../utils/AuthContext';

export default function PrivateRoute({ children, ...rest }) {
  const { auth } = useAuthContext();
  return (
    <Route
      {...rest}
      render={({ location }) =>
        auth.isAuthenticated ? (
          children
        ) : (
          <Redirect to={{ pathname: '/', state: { from: location } }} />
        )
      }
    />
  );
}

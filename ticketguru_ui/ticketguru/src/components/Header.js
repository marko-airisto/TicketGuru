import React from 'react';
import AppBar from '@material-ui/core/AppBar';
import Toolbar from '@material-ui/core/Toolbar';
import IconButton from '@material-ui/core/IconButton';
import Typography from '@material-ui/core/Typography';
import { makeStyles } from '@material-ui/core/styles';
import MenuIcon from '@material-ui/icons/Menu';
import Button from '@material-ui/core/Button';
import { AuthContext } from '../App';

const useStyles = makeStyles(theme => ({
  root: {
    flexGrow: 1
  },
  menuButton: {
    paddingTop: theme.spacing(2),
    marginRight: theme.spacing(2)
  },
  toolbar: {
    alignItems: 'flex-start',
    paddingTop: theme.spacing(1),
    paddingBottom: theme.spacing(1),
    backgroundColor: '#d3d3d3',
    color: 'black'
  },
  title: {
    paddingTop: theme.spacing(1),
    paddingBottom: theme.spacing(1),
    flexGrow: 1,
    display: 'none',
    [theme.breakpoints.up('sm')]: {
      display: 'block'
    }
  },
  list: {
    width: 250
  },
  fab: {
    margin: theme.spacing(1)
  }
}));

export const Header = () => {
  const { state, dispatch } = React.useContext(AuthContext);
  const classes = useStyles();
  return (
    <AppBar position="static">
      <Toolbar>
        <div>
          {' '}
          {state.isAuthenticated ? (
            <IconButton
              edge="start"
              className={classes.menuButton}
              color="inherit"
              aria-label="menu"
            >
              <MenuIcon />
            </IconButton>
          ) : null}
        </div>

        <Typography variant="h6" className={classes.title}>
          TicketGuru
        </Typography>
        <div>
          {' '}
          {state.isAuthenticated ? (
            <Button
              variant="contained"
              color="secondary"
              onClick={() =>
                dispatch({
                  type: 'LOGOUT'
                })
              }
            >
              Logout
            </Button>
          ) : null}
        </div>
      </Toolbar>
    </AppBar>
  );
};
export default Header;

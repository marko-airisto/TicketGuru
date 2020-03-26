import React from 'react';
import { useAuthContext } from '../utils/AuthContext';
import { makeStyles } from '@material-ui/core/styles';
import Card from '@material-ui/core/Card';
import CardActions from '@material-ui/core/CardActions';
import CardContent from '@material-ui/core/CardContent';
import Button from '@material-ui/core/Button';
import Typography from '@material-ui/core/Typography';
import { QRCode } from 'react-qr-svg';

const useStyles = makeStyles(theme => ({
  root: {
    minWidth: 275,
    flexGrow: 1,
    textAlign: 'center',
    alignContent: 'center'
  },
  button: {
    textAlign: 'center',
    alignSelf: 'center',
    justifyContent: 'center',
    paddingBottom: theme.spacing(2)
  },
  title: {
    fontSize: 14
  }
}));

export const TicketContext = React.createContext();

const initialState = {
  tickets: [],
  isFetching: false,
  hasError: false,
  isTicketSubmitting: false,
  songHasError: false
};

const reducer = (state, action) => {
  switch (action.type) {
    case 'FETCH_TICKETS_REQUEST':
      return {
        ...state,
        isFetching: true,
        hasError: false
      };
    case 'FETCH_TICKETS_SUCCESS':
      return {
        ...state,
        isFetching: false,
        tickets: action.payload
      };
    case 'FETCH_TICKETS_FAILURE':
      return {
        ...state,
        hasError: true,
        isFetching: false
      };
    /* case 'ADD_SONG_REQUEST':
      return {
        ...state,
        isTicketSubmitting: true,
        songHasError: false
      };
    case 'ADD_SONG_SUCCESS':
      return {
        ...state,
        isTicketSubmitting: false,
        TICKETS: [...state.TICKETS, action.payload]
      };
    case 'ADD_SONG_FAILURE':
      return {
        ...state,
        isTicketSubmitting: false,
        songHasError: true
      }; */
    default:
      return state;
  }
};

export const Tickets = () => {
  const { auth } = useAuthContext();
  const [state, dispatch] = React.useReducer(reducer, initialState);
  const classes = useStyles();
  /* const [isAddSongModalVisible, setAddSongModalVisibility] = React.useState(
    false
  ); */

  /* const toggleAddSong = () => {
    setAddSongModalVisibility(!isAddSongModalVisible);
  }; */

  React.useEffect(() => {
    dispatch({
      type: 'FETCH_TICKETS_REQUEST'
    });
    fetch('http://localhost:8080/api/tickets', {
      headers: {
        Authorization: `Bearer ${auth.token}`
      }
    })
      .then(res => {
        if (res.ok) {
          return res.json();
        } else {
          throw res;
        }
      })
      .then(resJson => {
        //console.log(resJson._embedded.tickets);
        dispatch({
          type: 'FETCH_TICKETS_SUCCESS',
          payload: resJson._embedded.tickets
        });
      })
      .catch(error => {
        console.log(error);
        dispatch({
          type: 'FETCH_TICKETS_FAILURE'
        });
      });
  }, [auth.token]);

  return (
    <div className="tickets">
      {state.isFetching ? (
        <span className="loader">LOADING...</span>
      ) : state.hasError ? (
        <span className="error">AN ERROR HAS OCCURED</span>
      ) : (
        <>
          {state.tickets.map(row => (
            <Card
              key={row.checkSum}
              className={classes.root}
              variant="outlined"
            >
              <CardContent>
                <Typography
                  className={classes.title}
                  color="textSecondary"
                  gutterBottom
                >
                  {row.checkSum}
                </Typography>
                <QRCode
                  bgColor="#FFFFFF"
                  fgColor="#000000"
                  level="Q"
                  style={{ width: 256 }}
                  value={row.checkSum}
                />
              </CardContent>
              <CardActions className={classes.button}>
                <Button variant="contained" color="primary" size="small">
                  Mark as used
                </Button>
              </CardActions>
            </Card>
          ))}
        </>
      )}
    </div>
  );
};

export default Tickets;

# Show Accessible Accounts

Show all Accounts the active User can access and with what permission level.
Includes their own Account if they have one.

**URL** : `/api/accounts/`

**Method** : `GET`

**Auth required** : YES

**Permissions required** : None

**Data constraints** : `{}`

## Success Responses

**Condition** : User can not see any Accounts.

**Code** : `200 OK`

**Content** : `{[]}`

### OR

**Condition** : User can see one or more Accounts.

**Code** : `200 OK`

**Content** : In this example, the User can see three Accounts as AccountAdmin
`AA`, Viewer `VV`, and Owner `OO` - in that order:

```json
[
    {
        "id": 1,
        "name": "Mika koodaa ja muut juopottelee. Kannattaa tulla kauempaakin",
        "eventType": {
            "eventTypeName": "Silkkaa teatteria",
            "eventTypeInfo": "Teatteri",
            "eventType_ID": 1
        },
        "dateTime": "2020-03-01T20:00:00",
        "eventOrganizer": {
            "companyName": "09 7865566",
            "companyStreetAddress": "great@events.fi",
            "companyTel": "www.greatevents.com",
            "companyEmail": "Tapahtumakatu 16 a 78",
            "companyWWW": "Texas Ted",
            "companyContactPerson": "GREAT EVENTS OY",
            "postcode_ID": 5,
            "eventOrganizer_ID": 1
        },
        "venue": {
            "id": 1,
            "name": "teatteri@teatteri.fi",
            "address": "Helsingin Teatteri",
            "tel": "www.helsinginteatteri.com",
            "email": "09 1234566",
            "www": "John Wayne",
            "contactPerson": "Kekkosenkatu 3"
        },
        "ticketCapacity": 1000,
        "info": "Ihan pirun kovat bileet",
        "eventTickets": []
    }
]
```

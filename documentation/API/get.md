# Show Accessible Events

Show all Events the active User can access and with what permission level.
Includes their own Account if they have one.

**URL** : `/api/events/`

**Method** : `GET`

**Auth required** : NO

**Permissions required** : None

**Data constraints** : `{}`

## Success Responses

**Condition** : User can not see any Events.

**Code** : `200 OK`

**Content** : `{[]}`

### OR

**Condition** : User can see one or more Events.

**Code** : `200 OK`

**Content** : In this example, the User can see one Event as regular user

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

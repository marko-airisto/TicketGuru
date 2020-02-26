# Create an Event

Create an Event.

**URL** : `/api/events/`

**Method** : `POST`

**Auth required** : NO

**Permissions required** : None

**Data constraints**

Provide name of Account to be created.

```json
{
    "name": "[VARCHAR 250 chars max]"
    "eventType": "[eventType_ID]"
    "dateTime": "[ISO 8601]"
    "eventOrganizer": "[eventOrganizer_ID]"
    "venue": "[venue_ID]"
    "ticketCapacity":: "[INT]"
    "ageLimit": "[ageLimit_ID]"
    "info": "[VARCHAR 500 CHARS MAX]"
}
```

**Data example** All fields must be sent.

```json
{
    "name": "Mika koodaa ja muut juopottelee. Kannattaa tulla kauempaakin"
    "eventType": "1"
    "dateTime": "2020-03-01T20:00:00"
    "eventOrganizer": "1"
    "venue": "1"
    "ticketCapacity": "1000"
    "ageLimit": "1"
    "info": "Ihan pirun kovat bileet"
}
```

## Success Response

**Condition** : If everything is OK.

**Code** : `200 OK`

**Content example**

```json
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
    },
    {
        "id": 1,
        "name": "K7",
        "specifier": "Tapahtuma kielletty alle 7-vuotiailta"
        }
```

## Error Responses

**Condition** : 

**Code** : 

**Headers** : 

**Content** : 

### Or

**Condition** : If fields are missed.

**Code** : `400 BAD REQUEST`

**Content example**

```json
{
    "dateTime": [
        "Event datetime is required"
    ]
}
```

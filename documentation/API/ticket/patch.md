# Edit a ticket

Edit a Ticket.

**URL** : `https://rbmk-ticketguru-backend.herokuapp.com/api/tickets/{id}`

**Method** : `PATCH`

**Content-Type** : `application/json`

**Auth required** : Yes

**Permissions required** : None

**Data constraints**

Provide ID and values to modify.

```json
{
    "ticketStatus": "ticket_status_id"
}
```

**Data example**

```json
{
    "ticketStatus": "https://rbmk-ticketguru-backend.herokuapp.com/api/ticketStatuses/2"
}
```

## Success Response

**Condition** : If everything is OK.

**Code** : `200 OK`

**Content example**

```json
{
  "checksum": "65b189ckqlnag8ltmmdv2q39nf",
  "created": "2020-04-22T10:41:57.924",
  "invalid": null,
  "_links": {
    "self": {
      "href": "https://rbmk-ticketguru-backend.herokuapp.com/api/tickets/20"
    },
    "eventTicket": {
      "href": "https://rbmk-ticketguru-backend.herokuapp.com/api/tickets/20/eventTicket"
    },
    "ticketStatus": {
      "href": "https://rbmk-ticketguru-backend.herokuapp.com/api/tickets/20/ticketStatus"
    }
  }
}
```

## Error Responses

**Condition** : ID is missing.

**Code** : `405 Method not allowed`

**Content example**

```json
{
    "timestamp": "LocalDateTime",
    "status": 405,
    "error": "Method Not Allowed",
    "message": "Request method 'PATCH' not supported",
    "path": "/api/tickets/"
}
```
</br>

**Condition** : Invalid ID.

**Code** : `404 Not Found`

**Content example**

```json
{
    "timestamp": "LocalDateTime",
    "status": 404,
    "error": "Not Found",
    "message": "Invalid ID: {id}",
    "path": "/api/tickets/{id}"
}
```
</br>

**Condition** : Ticket is marked as deleted.

**Code** : `400 Bad Request`

**Content example**

```json
{
    "timestamp": "LocalDateTime",
    "status": 400,
    "error": "Bad Request",
    "message": "Cannot modify Ticket that is marked as deleted",
    "path": "/api/tickets/{id}"
}
```

</br>

**Condition** : Invalid ticket_status_id.

**Code** : `400 Bad Request`

**Content example**

```json
{
    "timestamp": "LocalDateTime",
    "status": 400,
    "error": "Bad Request",
    "errors": [
        {
            "defaultMessage": "TicketStatus is required",
            "field": "ticketStatus",
            "rejectedValue": "null"
        }
    ]
}
```
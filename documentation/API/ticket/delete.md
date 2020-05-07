# Delete a ticket

Delete a Ticket

**URL** : `https://rbmk-ticketguru-backend.herokuapp.com/api/tickets/{id}`

**Method** : `DELETE`

**Auth required** : Yes

**Permissions required** : None

**Data constraints**

Provide the URL of Ticket to be deleted e.g. https://rbmk-ticketguru-backend.herokuapp.com/api/tickets/4

## Success Response

**Condition** : If everything is OK.

**Code** : `204 No Content`

**Content example**

```json
{}
```
</br>

## Error Responses

**Condition** : ID is missing.

**Code** : `405 Method not allowed`

**Content example**

```json
{
    "timestamp": "LocalDateTime",
    "status": 405,
    "error": "Method Not Allowed",
    "message": "Request method 'DELETE' not supported",
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

**Condition** : Ticket is already marked as deleted.

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
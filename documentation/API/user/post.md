# Create a User

Create a User.

**URL** : `/api/users/`

**Method** : `POST`

**Auth required** : YES

**Permissions required** : None

**Data constraints**

Provide name of User to be created.

```json
{
    "username": "[VARCHAR 50 chars max]"
    "password": "[VARCHAR 100 chars max]"
    "active": "[Boolean]"
    "userGroup": "[userGoup href]"
}
```

**Data example** All fields must be sent.

```json
{
    "username": "Igor",
    "password": "UliUli",
    "active": "true",
    "userGroup" : "https://rbmk-ticketguru-backend.herokuapp.com/api/userGroups/10"
}
```

## Success Response

**Condition** : If everything is OK.

**Code** : `200 OK`

**Content example**

```json
{
  "username": "Igor",
  "name": "Igor",
  "created": "2020-05-04T07:58:12.202",
  "invalid": null,
  "active": true,
  "_links": {
    "self": {
      "href": "https://rbmk-ticketguru-backend.herokuapp.com/api/users/6"
    },
    "userGroup": {
      "href": "https://rbmk-ticketguru-backend.herokuapp.com/api/users/6/userGroup"
    },
    "saleEvent": {
      "href": "https://rbmk-ticketguru-backend.herokuapp.com/api/users/6/saleEvents"
    }
  }
}
```

## Error Responses

**Condition** : If fields are missed.

**Code** : `400 BAD REQUEST`

**Content example**

```json
{
    "timestamp": "2020-03-12T11:51:35.015+0000",
    "status": 400,
    "error": "Bad Request",
    "errors": [
        {
            "codes": [
                "NotNull.user.userGroup",
                "NotNull.userGroup",
                "NotNull.fi.rbmk.ticketguru.userGroup.UserGroup",
                "NotNull"
            ],
            "arguments": [
                {
                    "codes": [
                        "user.userGroup",
                        "userGroup"
                    ],
                    "arguments": null,
                    "defaultMessage": "userGroup",
                    "code": "userGroup"
                }
            ],
            "defaultMessage": "User Group is required",
            "objectName": "user",
            "field": "userGroup",
            "rejectedValue": null,
            "bindingFailure": false,
            "code": "NotNull"
        }
    ],
    "path": "/api/users"
```


# Authentication

All endpoints require authentication. Authentication is done by using JSON Web Token. After signing in you must use the response token in every query.

**URL** : `/api/login`

**Method** : `POST`

**Data example** All fields must be sent.

```json
{
    "username": "YOUR_GIVEN_USERNAME",
    "password": "******",
}
```

## Success Response

**Condition** : If everything is OK.

**Code** : `20O OK

**Content example**

```json
{
    "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJwZXBlIiwiZXhwIjoxNTg4NTkxOTA2LCJpYXQiOjE1ODg1NzM5MDZ9.4_fRf7tDGj1zjqXqCxZz2Q1_UaS6b_aOSA5RyhaOX-l-cukIDvSJLOR81B6Vj3ASvnMbo2r-uZ7ptlrnqroyKg"
}
```

## Error Responses

**Condition** : If fields are missed.

**Code** : `401 UNAUTHORIZED`

**Content example**

```json
{
    "timestamp": "2020-05-04T06:43:11.906+0000",
    "status": 401,
    "error": "Unauthorized",
    "message": "Unauthorized",
    "path": "/api/login"
}
```

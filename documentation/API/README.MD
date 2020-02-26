# TicketGuru REST API

Here's documentation for TicketGuru REST API.

## Base path

`GET /api/`

## Open Endpoints

Open endpoints require no Authentication.

At the moment all endpoints are open. Authentication will be added soon.

## Endpoints that require Authentication

Closed endpoints require a valid Token to be included in the header of the
request.

### Current Endpoints

Each endpoint manipulates or displays information::

* [Show events](get.md) : `GET /api/events/`
* [Create event](post.md) : `PUT /api/events/`

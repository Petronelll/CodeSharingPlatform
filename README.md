<h1>Code Sharing Platform</h1>

This project is an online content-hosting service where users can store code snippets. The snippets are stored in a database and deleted if they have a time and/or views restriction that is met.

<h2>API Endpoints</h2>

- `POST /api/code/new`  takes a JSON object with a field `code` and two other fields:

  -  `time` field contains the time (in seconds) during which the snippet is accessible.
  -  `views` field contains a number of views allowed for this snippet.

  A zero value (0) for time or views corresponds to the absence of the restriction.

  Returns a JSON object which contains the generated unique id for the uploaded code snippet.

- `GET /api/code/{id}` returns a JSON object which contains the code, the date when it was created, the time left and the views left. If the UUID does not exist or one of the restrictions is triggered, then it returns `404 not found`.

- `GET /api/code/latest` returns a JSON array which contains 10 most recently uploaded unrestricted code snippets.

Examples:

Request `POST /api/code/new` with the following body:

```json
{
    "code": "#include <iostream> ...",
    "time": 1000,
    "views": 3
}
```

Response: `{ "id" : "2187c46e-03ba-4b3a-828b-963466ea348c" }`

Request: `GET /api/code/2187c46e-03ba-4b3a-828b-963466ea348c`

Response:

```json
{
    "code": "#include <iostream> ...",
    "date": "2021/08/06 12:00:05",
    "time": 968,
    "views": 2
}
```

Request `POST /api/code/new` with the following body:

```json
{
    "code": "def myFunction() ...",
    "time": 0,
    "views": 0
}
```

Response: `{ "id" : "7dc53df5-703e-49b3-8670-b1c468f47f1f" }`.

Request `POST /api/code/new` with the following body:

```json
{
    "code": "#! /bin/bash ...",
    "time": 0,
    "views": 0
}
```

Response: `{ "id" : "e6780274-c41c-4ab4-bde6-b32c18b4c489" }`.

Request: `GET /api/code/latest`

Response:

```json
[
    {
        "code": "def myFunction() ...",
        "date": "2021/08/06 12:04:51",
        "time": 0,
        "views": 0
    },
    {
        "code": "#! /bin/bash ...",
        "date": "2021/08/06 12:05:47",
        "time": 0,
        "views": 0
    }
]
```

<h2>Web endpoints</h2>

- `GET /code/new` returns the page that allows a user to save new code snippets.

  <img src="/images/new1.PNG">

  <img src="/images/new2.PNG">

- `GET: /code/{id}` returns the page with associated code snippet.

  <img src="/images/id1.PNG">

- `GET /code/latest` returns the page with 10 most recently uploaded unrestricted code snippets.

  <img src="/images/latest1.PNG">


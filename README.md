# Crud spring

[![CircleCI](https://circleci.com/gh/kishaningithub/crudspring.svg?style=shield)](https://circleci.com/gh/kishaningithub/crudspring)
[![Codecov](https://img.shields.io/codecov/c/github/kishaningithub/crudspring.svg)](https://codecov.io/gh/kishaningithub/crudspring)
[![Join the chat at https://gitter.im/crudspring/Lobby](https://badges.gitter.im/crudspring/Lobby.svg)](https://gitter.im/crudspring/Lobby?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)

A CRUD application using spring boot.

# Features
- Your note (A basic crud version of evernote)
    - GET `/api/yournote/v1/notes` Will give you the list of notes
    - POST `/api/yournote/v1/notes` will add a note to the list
    - DELETE `/api/yournote/v1/notes` Will delete all the notes
    - DELETE `/api/yournote/v1/notes/2` Will delete note with id 2
    - PUT `/api/yournote/v1/notes/5` Will replace note with id 5
- Service level
    - `/health` Returns server's health condition (Use of spring actuator)

# Try it out
[![Run in Postman](https://run.pstmn.io/button.svg)](https://app.getpostman.com/run-collection/776b6fa63a1349a47db1)

# Deploy
[![Deploy](https://www.herokucdn.com/deploy/button.svg)](https://heroku.com/deploy)

# System requirements (For development)
- Docker
- Git

# Set up instructions (For development)
- Clone this repo
- ./run
- Point to localhost:5000 and mess with the API
- ./test (Only while running tests)

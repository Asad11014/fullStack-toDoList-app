# To-Do List Application

This is a full-stack To-Do List application built with Spring Boot for the backend, React for the frontend, and PostgreSQL as the database.


## Introduction

The To-Do List application allows users to create, read, and delete tasks. It is designed to help users manage their tasks effectively and ensure productivity.

## Features

- Add a new task
- View all tasks
- Delete a task

## Prerequisites

Ensure you have met the following requirements:

- Java 8 or higher (I used java 17)
- Node.js and npm
- PostgreSQL

## Installation and setup

### Backend (Spring Boot)

1. Clone the repository:

```sh
git clone https://github.com/Asad11014/fullStack-toDoList-app.git
cd fullStack-toDoList-app/todo-backend
```

2. Set up the Postgresql database:
```sh
psql -U postgres
CREATE DATABASE todo_app;
CREATE USER todo_user WITH ENCRYPTED PASSWORD 'yourpassword'; //you can use any existing user instead of creating a new one
GRANT ALL PRIVILEGES ON DATABASE todo_app TO todo_user;
```

3. Configure the database connection in 'src/main/resources/application.properties':
```sh
spring.datasource.url=jdbc:postgresql://localhost:5432/todo_app
spring.datasource.username=todo_user
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
```

4. Run the backend:

Navigate to 'TodoAppApplication' in an IDE of your choosing and run it.

### Frontend (React)

1. In a separate terminal cd into 'todo-frontend' and run the following commands:

```sh
npm install
npm start
```

2. Open your web browser and go to http://localhost:3000 to access the frontend application.

# Movies

## Project Overview

This project is a Java application developed using Spring Boot that integrates with a SQL database. It handles a collection of movie entities, providing essential sorting & pagination functionalities. The system leverages JPA (Java Persistence API) for entity management.

## Technologies Used

- Java
- Spring Boot
- JPA (Java Persistence API)
- SQL
- Thymeleaf (for templating)

## Project Structure

The application consists of several primary components:

### Model (`com.glooneltharion.movie.model`)

Defines the structure of the Movie entity with attributes like title, director, and year. JPA annotations are used for entity mapping.

### Repository (`com.glooneltharion.movie.repository`)

Contains the `MovieRepository` interface, extending `JpaRepository`. It provides methods to perform various operations on the Movie entity, including custom queries and sorting.

### Service (`com.glooneltharion.movie.service`)

Implements business logic related to movie operations. The `MovieServiceImpl` class holds methods to interact with `MovieRepository` and execute CRUD operations.

### Controller (`com.glooneltharion.movie.controller`)

Handles incoming HTTP requests and serves as the interface between the frontend and backend. The `MovieController` and other controllers define endpoints to manage movie entities, such as fetching, sorting, and filtering.

## How to Run the Application

1. Clone the project repository.
2. Ensure Java and Gradle (or Maven) are installed on your machine.
3. Configure your SQL database settings in the `application.properties` file.
4. Build the project using Gradle. Run ./gradlew build in the project root directory.
5. Run the application using the appropriate Gradle command. You can use ./gradlew bootRun to start the application.

## Available Endpoints

- `GET /`: Displays a list of all movies.
- `GET /stream`: Retrieves movies sorted by director descending and title ascending.
- `GET /query`: Retrieves movies sorted by director descending and title ascending (query method).
- `GET /object`: Retrieves movies sorted using Sort object with director descending and title ascending.
- `GET /query/title`: Retrieves movies sorted by title (query method).
- `GET /query/director`: Retrieves movies sorted by director (query method).
- `GET /query/year`: Retrieves movies sorted by year (query method).
- `GET /object/title`: Retrieves movies sorted using Sort object by title.
- `GET /object/director`: Retrieves movies sorted using Sort object by director.
- `GET /object/year`: Retrieves movies sorted using Sort object by year.
- 
Each endpoint performs different operations like fetching all movies, sorting by specific attributes, and handling various HTTP request methods.

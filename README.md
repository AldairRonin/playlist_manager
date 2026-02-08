#***A. Project Overview***

This project is a Spring Boot REST API designed to manage media content such as songs and podcasts, as well as playlists that store multiple media items. The system allows users to create media, manage playlists, and organize media inside playlists.

---
B. REST API Documentation
Media Endpoints

GET /media
Retrieves all media items.

GET /media/{id}
Retrieves media by ID.

POST /media
Creates new media.

```
Sample Request:

{
  "title": "New Song",
  "duration": 180,
  "type": "song"
}
```

```
Sample Response:

{
  "id": 1,
  "title": "New Song",
  "duration": 180
}
```

DELETE /media/{id}
Deletes media by ID.

Playlist Endpoints

GET /playlists
Retrieves all playlists.

POST /playlists
Creates a new playlist.
```
Sample Request:

{
  "name": "My Playlist"
}
```

GET /playlists/{id}/media
Retrieves media inside playlist.

POST /playlists/{playlistId}/media/{mediaId}
Adds media to playlist.

DELETE /playlists/{playlistId}/media/{mediaId}
Removes media from playlist.

Postman Screenshots

***get all media***
![img](https://github.com/AldairRonin/playlist_manager/blob/main/docs/getmedia.png?raw=true)

---

***add media by id to playlist***
![img](https://github.com/AldairRonin/playlist_manager/blob/main/docs/addmedia.png?raw=true)

---

***delete media***
![img](https://github.com/AldairRonin/playlist_manager/blob/main/docs/deletemedia.png?raw=true)

---

***post media***
![img](https://github.com/AldairRonin/playlist_manager/blob/main/docs/postmedia.png?raw=true)

---

***get media by id***
![img](https://github.com/AldairRonin/playlist_manager/blob/main/docs/getmediabyid.png?raw=true)

***get playlists***
![img](https://github.com/AldairRonin/playlist_manager/blob/main/docs/getplaylist.png?raw=true)

***post playlist***
![img](https://github.com/AldairRonin/playlist_manager/blob/main/docs/postplaylist.png?raw=true)

---

***C. Design Patterns Section***
Singleton Pattern

Spring Boot automatically manages service and repository classes as single instances using dependency injection.

Factory Pattern

Factory logic is used when creating media objects dynamically based on media type (song or podcast).

Builder Pattern

DTO classes act as builders to safely transfer structured data between layers of the application.

---

***D. Component Principles Section***

The application follows layered architecture:

Controller Layer – Handles HTTP requests and responses.

Service Layer – Contains business logic.

Repository Layer – Communicates with the database using Spring Data JPA.

Model Layer – Represents database entities.

DTO and Mapper Layers – Convert entities into safe API responses.

Dependency Injection is used to reduce coupling between components.

---

***E. SOLID & OOP Summary***

The project applies SOLID principles:

Single Responsibility Principle – Each class has a single responsibility.

Open/Closed Principle – Media class is extended by Song and Podcast without modifying base class.

Liskov Substitution Principle – Song and Podcast objects can be used as Media objects.

Interface Segregation Principle – Interfaces such as Playable are separated by functionality.

Dependency Inversion Principle – Controllers depend on services rather than repositories.

---

F. Database Schema

The database contains three main tables:

1.media – stores songs and podcasts

2.playlists – stores playlist information

3.playlist_media – many-to-many relationship between playlists and media

---

***G. System Architecture Diagram***

The system follows this structure:

Client → Controller → Service → Repository → Database

The layered design improves code organization and scalability.


---

***H. Instructions to Run the Spring Boot Application***

Requirements:

Java 17 or higher

Maven

PostgreSQL or H2 database

Steps to run:

1.Clone the repository.

2.Open the project in an IDE.

3.Run PlaylistApiApplication.

4.Test endpoints using Postman.

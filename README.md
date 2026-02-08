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


# Event manager

Spring Boot CRUD Rest API

### How to use
**1. Clone the application**
```bash
https://github.com/ShabunyaPolina/event-manager-modsen-task.git
```
**2. Set up the app**

Before launching the application enter your postgresql **username** and **password**
into `application.properties` and `docker-compose.yml` files.

**3. Run the app**

Then run `run.bat` or `run.sh` from the root folder of the project to start application.  
The app will start running at http://localhost:8080.

#### Routes API

| Route            | HTTP     | Description              |
|------------------|----------|--------------------------|
| **/events**      | `GET`    | Get all events           |
| **/events/{id}** | `GET`    | Get single event         |
| **/events**      | `POST`   | Create an event          |
| **/events/{id}** | `DELETE` | Delete the event         |
| **/events/{id}** | `PUT`    | Update data of the event |


#### Filtering
To filter events by **theme**, **organizer**, **date** and **time**
add corresponding parameters to `/events` route of GET request.
Examples of parameters usage are:

    GET /events?theme=Halloween&date=2022-10-31  
    GET /events?organizer=Someone&date=2022-12-23time=15:00:00


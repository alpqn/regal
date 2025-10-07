# Regal
 A virtual book management API.
### Installation
Clone the repository and install with Docker:
```bash
PG_DB=YOUR_DB_NAME \
PG_USER=YOUR_DB_USERNAME \
PG_PASSWORD=YOUR_DB_PASSWORD \
docker compose up -d
```
(the server starts on localhost:8080 by default).

Or:
- Have Java 25 on your machine
- Run a PostgreSQL server

compile and run with:
```bash
PG_DB=YOUR_DB_NAME \
PG_USER=YOUR_DB_USERNAME \
PG_PASSWORD=YOUR_DB_PASSWORD \
./mvnw spring-boot:run
```
### Documentation
API documentation is on GitHub Pages and can be found [here](https://alpqn.github.io/regal/).

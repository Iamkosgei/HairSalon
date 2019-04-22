# The Salon
A java spark app for a hair salon. Where the owner is able to add a list of the stylists, and for each stylist, 
add clients who see that stylist. The stylists work independently, so each client only belongs to a single stylist.

## Technologies and frameworks used
    1. java 11
    2. spark core 2.12
    3. Gradle 4.10
    4. Spark Template Velocity
    5. Junit 5
    6. Postgres database

## Database

In PSQL:

     CREATE DATABASE to_do;`
     CREATE TABLE categories (id serial PRIMARY KEY, name varchar);
     CREATE TABLE tasks (id serial PRIMARY KEY, description varchar);

## Testing

   ```java
    gradle test
```

## License
The Salon was released under [MIT](LICENSE)
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

     CREATE DATABASE hair_salon;
     CREATE TABLE stylists(id int,firstname varchar,lastname varchar,age int,email varchar);
     CREATE TABLE clients(id int,first_name varchar,last_name varchar,phone varchar,email varchar,country varchar,county varchar,stylistid int);

## Testing

   ```java
    gradle test
```
## Screenshots

![Landing Page](https://user-images.githubusercontent.com/14147462/56518360-e9235100-6547-11e9-984d-ccfdd4a68e11.png)
This is the landing page.

![Stlist](https://user-images.githubusercontent.com/14147462/56518543-6d75d400-6548-11e9-8760-604778c767ab.png)
This is where the user can view a list of all stylist and can add new stylist by click on the new stylist button.

![Clients](https://user-images.githubusercontent.com/14147462/56518555-72d31e80-6548-11e9-80cf-7af0f4add50c.png)
On this page the user can view all the clients and can add new clients by clicking on the new client button.

![Add Stylist](https://user-images.githubusercontent.com/14147462/56518556-72d31e80-6548-11e9-8ebe-d9863a51ca55.png)
This is where a new stylist can be added to the salon.

![Add Client](https://user-images.githubusercontent.com/14147462/56518557-736bb500-6548-11e9-93d2-bda7f02bcf45.png)
On this page the user can add new client to the salon and assign them to a given stylist by selecting one of the stylists from the stylist drop down.


## License
The Salon was released under [MIT](LICENSE)
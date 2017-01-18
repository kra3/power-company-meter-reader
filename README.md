# springboot_sampler
Spring boot - CRUD - JPA - experiment


Available CRUD endpoints are: 

    - http://localhost:8080/api/meterReadings
    - http://localhost:8080/api/profiles


They are HATEOS ready, hence will act as self documentation. 
Appending `/search` to the endpoints will reveal available custom functions.

A custom method is exposed from controller as well, to access it follow
http://localhost:8080/api/meterReadings/getConsumptionForMonth?month=<3 letter month, eg: JAN>


Allowed inputs fields for creating a profile is: profile, month, fraction 
Allowed inputs fields for creating a meter reading is: connectionId, profile, month, reading 

Eg: 

- Creating a profile using CRUD
``` curl localhost:8080/api/profiles/ -X POST -H "Content-Type: application/json" -d '{"profile": "A", "month": "JAN", "fraction": 0.1}' ```

- Getting an object with id
``` curl localhost:8080/api/profiles/1 ```

# How to run

`mvn spring-boot:run` will launch the application at http://localhost:8080/api/

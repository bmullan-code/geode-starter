# geode-starter
A basic geode/gemfire hello world type application.


## To run locally (using docker)

Start Apache Geode
```
docker run -it -p 7070:7070 -p 40404:40404 -p 10334:10334 -p 7575:7575 -p 1099:1099  apachegeode/geode gfsh

gfsh>start locator

gfsh>start server
```

Start your server
```
mvn clean pacakge
java -jar target/target/geode-arter-0.0.1-SNAPSHOT.jar
```

Test the server
```
curl localhost:8080/hello
```

See the results in gfsh
```
gfsh>list regions
List of regions
---------------
MyService

gfsh>describe region --name=/MyService
..........................................................
Name            : MyService
Data Policy     : partition
Hosting Members : pass-gentle-book

Non-Default Attributes Shared By Hosting Members

 Type  |    Name     | Value
------ | ----------- | ---------
Region | size        | 1
       | data-policy | PARTITION
```


# geode-starter
A basic geode/gemfire hello world type application.


# To run locally 

```
docker run -it -p 7070:7070 -p 40404:40404 -p 10334:10334 -p 7575:7575 -p 1099:1099  apachegeode/geode gfsh

gfsh>start locator

gfsh>start server
```


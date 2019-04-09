# Time management app

The app allows the user to log the amount of time spent on certain tasks. 

## Documentation

[Requirement specification](https://github.com/riiraty/ot-harjoitustyo/blob/master/dokumentointi/requirement_specification.md)

[Work time log](https://github.com/riiraty/ot-harjoitustyo/blob/master/dokumentointi/work_time_log.md)

## Command line commands

### Testing

Tests can be run with a command

```
mvn test
```

Test coverage raport can be created with a command 

```
mvn jacoco:report
```

This works if older version(8) of Java is in use. Other option is to run tests through Netbeans by right clicking the project, then choosing Run Maven >testcoverage

The raport can be viewed by opening a file _target/site/jacoco/index.html_ with a browser

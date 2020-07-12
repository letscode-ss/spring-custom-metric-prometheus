#spring-custom-metric-prometheus
This repo have example of how to add counter with java exceptions and publish it to prometheus


### compile and run app

```
mvn clean package
java -jar target/spring-custom-metric-prometheus-0.1-SNAPSHOT.jar
```

### access metrics

```
wget localhost:8080/exceptioncounter
wget localhost:8080/exceptioncounter
wget localhost:8080/exceptioncounter
wget localhost:8080/actuator/metrics
cat metrics
# HELP exception_count exception
# TYPE exception_count gauge
exception_count{errorcode="EXCEPTION__101",errormessage="exception 1",} 3.0
exception_count{errorcode="EXCEPTION__102",errormessage="exception 2",} 3.0
exception_count{errorcode="EXCEPTION__103",errormessage="exception 3",} 3.0

sleep 100
wget localhost:8080/actuator/metrics
cat metrics
# HELP exception_count exception
# TYPE exception_count gauge
exception_count{errorcode="EXCEPTION__101",errormessage="exception 1",} 0.0
exception_count{errorcode="EXCEPTION__102",errormessage="exception 2",} 0.0
exception_count{errorcode="EXCEPTION__103",errormessage="exception 3",} 0.0
```
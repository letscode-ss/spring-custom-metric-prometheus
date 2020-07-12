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
wget localhost:8080/actuator/metrics
cat metrics |grep exception_count
# HELP exception_counter_total  
# TYPE exception_counter_total counter
exception_counter_total{errorType="internal",errorcode="EXCEPTION__101",errormessage="exception 1",} 1.0
exception_counter_total{errorType="internal",errorcode="EXCEPTION__102",errormessage="exception 2",} 1.0
exception_counter_total{errorType="internal",errorcode="EXCEPTION__103",errormessage="exception 3",} 1.0
```
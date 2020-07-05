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
wget localhost:8080/prometheus
cat prometheus
# HELP exception_counter exception count of this app.
# TYPE exception_counter counter
exception_counter{errorcode="EXCEPTION__103",} 1.0
exception_counter{errorcode="EXCEPTION__101",} 1.0
exception_counter{errorcode="EXCEPTION__102",} 1.0
```
package com.spring.prometheus;

import io.prometheus.client.Counter;
import io.prometheus.client.spring.boot.EnablePrometheusEndpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Component;

@Component
public class PrometheusUtil {

    private static Counter promRequestsTotal = Counter.build()
            .name("exception_counter")
            .help("exception count of this app.")
            .labelNames("errorcode")
            .register();
    private final CounterService springRequestsTotal;

    public PrometheusUtil(@Autowired CounterService sprintRequestsTotal) {
        this.springRequestsTotal = sprintRequestsTotal;
    }

    public static void IncrementExceptionCounter(String exp) {
        promRequestsTotal.labels(exp).inc();
    }

}

package com.spring.prometheus;

import io.prometheus.client.Gauge;

import io.prometheus.client.CollectorRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import java.util.Map;
import java.util.HashMap;

// PrometheusUtil class add counter to all exception which have a proper code
@Component
@EnableScheduling
public class PrometheusUtil {

    CollectorRegistry registry;

    private static Gauge exceptionGauge;
    private static Map mymap = new HashMap();

    @Autowired
    private void PrometheusUtil(CollectorRegistry registry) {
        this.registry = registry;
        if(exceptionGauge == null) {
            exceptionGauge = Gauge.build()
                    .name("exception_count")
                    .labelNames("errorcode","errormessage")
                    .help("exception")
                    .register(registry);
        }
    }

    //Gauge will be reset after 100 sec
    @Scheduled(fixedRate = 100000)
    public void resetGauge() {
        mymap.forEach((code, msg) -> {
            exceptionGauge.labels(code.toString(),msg.toString()).set(0);
        });
    }

    public static void incrementExceptionCounter(String errorcode,String errorMsg){
        if(!mymap.containsKey(errorcode)) {
            mymap.put(errorcode,errorMsg);
        }
        exceptionGauge.labels(errorcode,errorMsg).inc();
    }

}

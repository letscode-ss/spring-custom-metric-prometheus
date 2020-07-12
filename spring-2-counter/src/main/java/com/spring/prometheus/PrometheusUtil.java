package com.spring.prometheus;

import io.micrometer.core.instrument.Metrics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Component;

// PrometheusUtil class add counter to all exception which have a proper code
@Component
public class PrometheusUtil {

    public static void incrementExceptionCounter(String errorcode,String errorMsg, String errorType){
        Metrics.counter("exception_counter","errorcode",errorcode,"errormessage",errorMsg,"errorType",errorType).increment();
    }

}

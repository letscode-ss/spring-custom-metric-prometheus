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
import com.spring.prometheus.PrometheusUtil;

@Controller
public class GenerateMetrics {

    @RequestMapping(path = "/exceptioncounter")
    public @ResponseBody String genException() {
        PrometheusUtil.IncrementExceptionCounter("EXCEPTION__101");
        PrometheusUtil.IncrementExceptionCounter("EXCEPTION__102");
        PrometheusUtil.IncrementExceptionCounter("EXCEPTION__103");
        return "Counter updated";
    }

}

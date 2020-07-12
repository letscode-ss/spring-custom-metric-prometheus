package com.spring.prometheus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.spring.prometheus.PrometheusUtil;

@Controller
public class GenerateMetrics {

    @RequestMapping(path = "/exceptioncounter")
    public @ResponseBody String genException() {
        PrometheusUtil.incrementExceptionCounter("EXCEPTION__101","exception 1");
        PrometheusUtil.incrementExceptionCounter("EXCEPTION__102","exception 2");
        PrometheusUtil.incrementExceptionCounter("EXCEPTION__103","exception 3");
        return "Counter updated";
    }

}

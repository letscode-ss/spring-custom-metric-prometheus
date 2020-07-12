package com.spring.prometheus;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GenerateMetrics {

    @RequestMapping(path = "/exceptioncounter")
    public @ResponseBody String genException() {
        PrometheusUtil.incrementExceptionCounter("EXCEPTION__101","exception 1","internal");
        PrometheusUtil.incrementExceptionCounter("EXCEPTION__102","exception 2","internal");
        PrometheusUtil.incrementExceptionCounter("EXCEPTION__103","exception 3","internal");
        return "Counter updated";
    }

}

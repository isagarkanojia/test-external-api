package com.example.testexternalapi.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.naming.ServiceUnavailableException;

@RestController
@RequestMapping("test")
public class FiveXErrorController {

    @GetMapping("all-good")
    @ResponseStatus(HttpStatus.OK)
    public String allGood() throws Exception {
        return "I'm Good! Thanks!";
    }

    @GetMapping("internal-server-error-get")
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String testGetInternalServerError() throws Exception {
        throw new Exception();
    }


    @PostMapping("internal-server-error")
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String testInternalServerError() throws Exception {
        throw new Exception();
    }

    @PostMapping("time-out/{time}")
    @ResponseStatus(HttpStatus.GATEWAY_TIMEOUT)
    public String testTimeOut(@PathVariable("time") Integer time)  {

        try {
            Thread.sleep(time);
        } catch (Exception e) {
            return "I'm Dead";
        }

        return "Thanks for waiting!";
    }

    @PostMapping("service-unavailable")
    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    public String testServiceUnavailableException()  {
        return "The HTTP Status will be SERVICE_UNAVAILABLE (CODE 503)\n";
    }


}

package com.example.testexternalapi.controllers;

import org.springframework.web.bind.annotation.*;

import javax.naming.ServiceUnavailableException;

@RestController
@RequestMapping("test")
public class FiveXErrorController {

    @GetMapping("all-good")
    public String allGood() throws Exception {
        return "I'm Good! Thanks!";
    }

    @GetMapping("internal-server-error-get")
    public String testGetInternalServerError() throws Exception {
        throw new Exception();
    }


    @PostMapping("internal-server-error")
    public String testInternalServerError() throws Exception {
        throw new Exception();
    }

    @PostMapping("time-out/{time}")
    public String testTimeOut(@PathVariable("time") Integer time)  {

        try {
            Thread.sleep(time);
        } catch (Exception e) {
            return "I'm Dead";
        }

        return "Thanks for waiting!";
    }

    @PostMapping("service-unavailable")
    public String testServiceUnavailableException() throws ServiceUnavailableException {
        throw new ServiceUnavailableException();
    }


}

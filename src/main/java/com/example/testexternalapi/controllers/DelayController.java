package com.example.testexternalapi.controllers;

import com.example.testexternalapi.dtos.CDto;
import com.example.testexternalapi.dtos.Request;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("delay")
public class DelayController {


    @PostMapping("/{time}")
    public CDto delayTest(@RequestBody Request request, @PathVariable("time") Integer time) {

        CDto dto = getResponse(request);

        try {
            Thread.sleep(time);
        } catch (Exception e) {
            return dto;
        }

        return dto;
    }

    private static CDto getResponse(Request request) {

        String response = "{\n" +
                "\t\"requestId\": \"052546f5-67b3-4ef6-9f5c-9ea0442657d0\",\n" +
                "\t\"result\": {\n" +
                "\t\t\"pan\": \"DUMYKB313C\",\n" +
                "\t\t\"name\": \"SAGAT KANOJIA\",\n" +
                "\t\t\"firstName\": \"SAGAR\",\n" +
                "\t\t\"middleName\": \"KANOJIA\",\n" +
                "\t\t\"lastName\": \"KANOJIA\",\n" +
                "\t\t\"gender\": \"male\",\n" +
                "\t\t\"aadhaarLinked\": true,\n" +
                "\t\t\"aadhaarMatch\": true,\n" +
                "\t\t\"dob\": \"1995-07-14\",\n" +
                "\t\t\"address\": {\n" +
                "\t\t\t\"buildingName\": \"ABC ROAD NEAR MAULI MANDIR\",\n" +
                "\t\t\t\"locality\": \"\",\n" +
                "\t\t\t\"streetName\": \"JANTAR ABC\",\n" +
                "\t\t\t\"pinCode\": \"440036\",\n" +
                "\t\t\t\"city\": \"NAGPUR\",\n" +
                "\t\t\t\"state\": \"MAHARASHTRA\",\n" +
                "\t\t\t\"country\": \"\"\n" +
                "\t\t},\n" +
                "\t\t\"mobileNo\": \"7219102594\",\n" +
                "\t\t\"emailId\": \"\",\n" +
                "\t\t\"profileMatch\": [],\n" +
                "\t\t\"authorizedSignatory\": {}\n" +
                "\t},\n" +
                "\t\"statusCode\": 101\n" +
                "}";


        Gson g = new Gson();

        CDto dto = g.fromJson(response, CDto.class);

        dto.getResult().setPan(request.getPan());

        return dto;
    }

}

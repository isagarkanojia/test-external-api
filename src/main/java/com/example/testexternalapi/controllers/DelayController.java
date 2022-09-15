package com.example.testexternalapi.controllers;

import com.example.testexternalapi.dtos.CDto;
import com.example.testexternalapi.dtos.Request;
import com.google.gson.Gson;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
@RequestMapping("delay")
public class DelayController {


    @PostMapping("test/{time}")
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
                "\t\"requestId\": \"737373-663663-4ef6-9f5c-9ea0442657d0\",\n" +
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


    private final String LOCALHOST_IPV4 = "127.0.0.1";
    private final String LOCALHOST_IPV6 = "0:0:0:0:0:0:0:1";


    class IpDto{
       String xforwardFor;
       String proxyClientIp;
       String wlproxyClientIp;
       String remoteAddr;
       String hostAddress;

        public String getHostAddress() {
            return hostAddress;
        }

        public void setHostAddress(String hostAddress) {
            this.hostAddress = hostAddress;
        }

        public String getXforwardFor() {
            return xforwardFor;
        }

        public void setXforwardFor(String xforwardFor) {
            this.xforwardFor = xforwardFor;
        }

        public String getProxyClientIp() {
            return proxyClientIp;
        }

        public void setProxyClientIp(String proxyClientIp) {
            this.proxyClientIp = proxyClientIp;
        }

        public String getWlproxyClientIp() {
            return wlproxyClientIp;
        }

        public void setWlproxyClientIp(String wlproxyClientIp) {
            this.wlproxyClientIp = wlproxyClientIp;
        }

        public String getRemoteAddr() {
            return remoteAddr;
        }

        public void setRemoteAddr(String remoteAddr) {
            this.remoteAddr = remoteAddr;
        }
    }


    @GetMapping("client-ip")
    public String clientIP(HttpServletRequest request) {
        String ipAddress = request.getHeader("X-Forwarded-For");
        if(StringUtils.isEmpty(ipAddress) || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("Proxy-Client-IP");
        }

        if(StringUtils.isEmpty(ipAddress) || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("WL-Proxy-Client-IP");
        }

        if(StringUtils.isEmpty(ipAddress) || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getRemoteAddr();
            if(LOCALHOST_IPV4.equals(ipAddress) || LOCALHOST_IPV6.equals(ipAddress)) {
                try {
                    InetAddress inetAddress = InetAddress.getLocalHost();
                    ipAddress = inetAddress.getHostAddress();
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }
            }
        }

        if(!StringUtils.isEmpty(ipAddress)
                && ipAddress.length() > 15
                && ipAddress.indexOf(",") > 0) {
            ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
        }

        return ipAddress;

    }


    @GetMapping("v2/client-ip")
    public IpDto clientIPV2(HttpServletRequest request) {
        IpDto dto = new IpDto();

        dto.setXforwardFor(request.getHeader("X-Forwarded-For"));
        dto.setProxyClientIp(request.getHeader("Proxy-Client-IP"));
        dto.setWlproxyClientIp(request.getHeader("WL-Proxy-Client-IP"));
        dto.setRemoteAddr(request.getRemoteAddr());


        if (LOCALHOST_IPV4.equals(dto.getRemoteAddr()) || LOCALHOST_IPV6.equals(dto.getRemoteAddr())) {
            try {
                InetAddress inetAddress = InetAddress.getLocalHost();
                dto.setHostAddress(inetAddress.getHostAddress());
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
        }

        return dto;

    }
}

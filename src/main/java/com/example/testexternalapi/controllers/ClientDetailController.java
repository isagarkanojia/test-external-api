package com.example.testexternalapi.controllers;

import com.example.testexternalapi.dtos.IpDto;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
@RequestMapping("client-detail")
public class ClientDetailController {

    private final String LOCALHOST_IPV4 = "127.0.0.1";
    private final String LOCALHOST_IPV6 = "0:0:0:0:0:0:0:1";


    @GetMapping("ip")
    public String clientIP(HttpServletRequest request) {
        String ipAddress = request.getHeader("X-Forwarded-For");
        if (StringUtils.isEmpty(ipAddress) || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("Proxy-Client-IP");
        }

        if (StringUtils.isEmpty(ipAddress) || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("WL-Proxy-Client-IP");
        }

        if (StringUtils.isEmpty(ipAddress) || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getRemoteAddr();
            if (LOCALHOST_IPV4.equals(ipAddress) || LOCALHOST_IPV6.equals(ipAddress)) {
                try {
                    InetAddress inetAddress = InetAddress.getLocalHost();
                    ipAddress = inetAddress.getHostAddress();
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }
            }
        }

        if (!StringUtils.isEmpty(ipAddress)
                && ipAddress.length() > 15
                && ipAddress.indexOf(",") > 0) {
            ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
        }

        return ipAddress;

    }


    @GetMapping("v2/ip")
    public IpDto clientIPV2(HttpServletRequest request) {
        IpDto dto = new IpDto();

        dto.setXforwardFor(request.getHeader("X-Forwarded-For"));
        dto.setProxyClientIp(request.getHeader("Proxy-Client-IP"));
        dto.setWlProxyClientIp(request.getHeader("WL-Proxy-Client-IP"));
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

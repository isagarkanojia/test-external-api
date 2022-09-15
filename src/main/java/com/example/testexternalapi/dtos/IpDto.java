package com.example.testexternalapi.dtos;

import lombok.Data;

@Data
public class IpDto {
    String xforwardFor;
    String proxyClientIp;
    String wlProxyClientIp;
    String remoteAddr;
    String hostAddress;
}

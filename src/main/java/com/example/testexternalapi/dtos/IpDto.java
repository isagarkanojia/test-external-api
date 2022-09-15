package com.example.testexternalapi.dtos;

public class IpDto{
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

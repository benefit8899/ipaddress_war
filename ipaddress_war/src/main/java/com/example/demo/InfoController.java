package com.example.demo;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoController {

	@RequestMapping("/info")
	public String hello(HttpServletRequest request) {
		if (request == null) {
            return "";
        }

        String remoteAddress = request.getRemoteAddr();
        String xForwardedFor = request.getHeader("X-Forwarded-For");
        if (xForwardedFor != null) {
            String[] splitRemoteAddress = xForwardedFor.split(", \r\n\t");
            if (splitRemoteAddress.length >= 1) {
                remoteAddress = splitRemoteAddress[splitRemoteAddress.length - 1];
            }
        }
        return remoteAddress;
	}
}

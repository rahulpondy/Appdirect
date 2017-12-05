package com.appdirect.skillassesment.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.MediaType;
import java.net.URLDecoder;
import java.util.Enumeration;

/**
 * Created by RahulGupta on 2017-12-02.
 */
@RestController
@RequestMapping("/api")
public class Test {


    @RequestMapping(value = "/create", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON})
    public Response getMessage(HttpServletRequest request, @RequestParam("url") String url){
        Response response = new Response();
        try{
            Enumeration headerNames = request.getHeaderNames();
            System.out.print("===================================================");
            System.out.println("OAuth Header");
            while (headerNames.hasMoreElements()) {
                String key = (String) headerNames.nextElement();
                String value = request.getHeader(key);
                System.out.println("key = " + key + " value = " + value);
            }
            System.out.print("===================================================");

            System.out.print("===================================================");
            System.out.println("Event URl");
            String urlDecoder = URLDecoder.decode(url, "UTF-8");
            System.out.println(urlDecoder);
            System.out.print("===================================================");


            response.setSuccess(true);
            response.setAccountIdentifier("new-account-identifier");

        }
        catch (Exception e){
            response.setSuccess(false);
            response.setErrorCode("ACCOUNT_NOT_FOUND");
            response.setMessage("The account TEST123 could not be found.");
            response.setAccountIdentifier("new-account-identifier");
            e.printStackTrace();
        }
        //return "Hello controller has been started";
        return response;
    }
}

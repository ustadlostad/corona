package com.project.corona.api;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiCaller {

    static URL url1;
    static URL url2;

    public static void globalApiHealthCheck(String endPoint) throws IOException {

        url1 = new URL(endPoint);

        HttpURLConnection conn = (HttpURLConnection) url1.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();
        int statusCodeGlobal = conn.getResponseCode();

        if(statusCodeGlobal==200){
            System.out.println("API is alive");
        }else {
            System.out.println("API fucked up!!");
        }


    }

    public static void turkeyApiHealthCheck(String endPoint) throws IOException {

        url2 = new URL(endPoint);

        HttpURLConnection conn = (HttpURLConnection) url2.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();
        int statusCodeTurkey = conn.getResponseCode();

        if(statusCodeTurkey==200){
            System.out.println("API is alive");
        }else {
            System.out.println("API fucked up!!");
        }
    }

}



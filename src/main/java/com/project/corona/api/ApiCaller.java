package com.project.corona.api;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiCaller {

    static URL url1;
    static URL url2;
    static URL url3;
    static URL url4;


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

    public static void countryNamesApi(String endPoint) throws IOException {

        url3 = new URL(endPoint);

        HttpURLConnection conn = (HttpURLConnection) url3.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();
        int statusCodeTurkey = conn.getResponseCode();

        if(statusCodeTurkey==200){
            System.out.println("API is alive");
        }else {
            System.out.println("API fucked up!!");
        }
    }

    public static void countryApiHealthCheck(String endPoint) throws IOException {

        url4 = new URL(endPoint);
        System.out.println("API : " +url4);

        HttpURLConnection conn = (HttpURLConnection) url4.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();
        int statusCodeCountry = conn.getResponseCode();

        if(statusCodeCountry==200){
            System.out.println("API is alive");
        }else {
            System.out.println("API fucked up!!");
        }
    }

}



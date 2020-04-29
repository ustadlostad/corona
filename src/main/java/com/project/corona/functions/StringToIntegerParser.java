package com.project.corona.functions;

public class StringToIntegerParser {

    static public Integer parser(String jsonValue){

           int parsedValue = Integer.parseInt(jsonValue);

        return parsedValue;
    }
}

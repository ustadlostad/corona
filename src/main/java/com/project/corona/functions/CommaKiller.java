package com.project.corona.functions;

public class CommaKiller {

    static public String killerComma(String jsonValue){

        String commaKilledValue = jsonValue.replace(",","");

        return commaKilledValue;
    }

}

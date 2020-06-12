package com.project.corona.api;

import com.project.corona.controller.HomeController;
import com.project.corona.functions.DateDataArrenger;
import com.project.corona.functions.StringToIntegerParser;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class ApiData {

    static public String inline;
    static public String inline2;
    static public String inline3;
    static public String inline4;
    static public String inline4Sub;
    static public String a;

    static public int intTotalConfirmed;
    static public int intTotalDeaths;
    static public int intTotalRecovered;
    static public int intActiveCases;

    static public int intTurkeyConfirmedCases;
    static public int intTurkeyDeaths;
    static public int intTurkeyRecoveredCases;
    static public int intTurkeyActiveCases;

    static public int intCountryConfirmedCases;
    static public int intCountryDeaths;
    static public int intCountryRecoveredCases;
    static public int intCountryActiveCases;

    static public String formattedTotalConfirmed;
    static public String formattedTotalDeaths;
    static public String formattedTotalRecovered;
    static public String formattedTotalActiveCases;


    static public String formattedTurkeyConfirmedCases;
    static public String formattedTurkeyDeaths;
    static public String formattedTurkeyRecoveredCases;
    static public String formattedTurkeyActiveCases;
    static public String countryName;

    static public String formattedCountryConfirmedCases;
    static public String formattedCountryDeaths;
    static public String formattedCountryRecoveredCases;
    static public String formattedCountryActiveCases;


   static ApiCaller apiCaller = new ApiCaller();
   static StringToIntegerParser stringToIntegerParser = new StringToIntegerParser();
   static DecimalFormat formatter = new DecimalFormat("#,###,###");

   static public ArrayList<Integer> arrlistIntiger = new ArrayList<Integer>();
   static public ArrayList<String> dataDateArrayList = new ArrayList<String>();
   static public ArrayList<String> dataDateArrayListCountry = new ArrayList<String>();
   static public ArrayList<Integer> turkeyDeathData = new ArrayList<Integer>();
   static public ArrayList<Integer> turkeyRecoveredData = new ArrayList<Integer>();
   static public ArrayList<String> countryArrayList = new ArrayList<String>();
   static public Map<String,String> countryMap = new HashMap<>();
   //static public List<String> countryListDeneme = new ArrayList<String>();

   static public String graphXaxis;

    public static void apiDataCollectorGlobal() throws IOException, JSONException {

        Scanner scanner = new Scanner(apiCaller.url1.openStream());

        while (scanner.hasNext()){
            inline = inline + scanner.nextLine();
        }

        String inlinesub =  inline.substring(4);

        //JsonParser General Stats
        JSONObject jsonObject = new JSONObject(inlinesub);

        //String totalConfirmed = jsonObject.getJSONObject("Global").getString("TotalConfirmed");
        //String totalDeaths = jsonObject.getJSONObject("Global").getString("TotalDeaths");
        //String totalRecovered = jsonObject.getJSONObject("Global").getString("TotalRecovered");

        //String to Integer General Stats
        intTotalConfirmed = stringToIntegerParser.parser(jsonObject.getJSONObject("Global").getString("TotalConfirmed"));
        intTotalDeaths = stringToIntegerParser.parser(jsonObject.getJSONObject("Global").getString("TotalDeaths"));
        intTotalRecovered = stringToIntegerParser.parser(jsonObject.getJSONObject("Global").getString("TotalRecovered"));
        intActiveCases = intTotalConfirmed - intTotalDeaths - intTotalRecovered;


        //formatter object
        formattedTotalConfirmed = formatter.format(stringToIntegerParser.parser(jsonObject.getJSONObject("Global").getString("TotalConfirmed")));
        formattedTotalDeaths = formatter.format(stringToIntegerParser.parser(jsonObject.getJSONObject("Global").getString("TotalDeaths")));
        formattedTotalRecovered = formatter.format(stringToIntegerParser.parser(jsonObject.getJSONObject("Global").getString("TotalRecovered")));
        formattedTotalActiveCases = formatter.format(intActiveCases);
        System.out.println("formatted total active vases : "+formattedTotalActiveCases);

    }

    static public void apiDataCollectorTurkey() throws IOException, JSONException {

        Scanner scanner = new Scanner(apiCaller.url2.openStream());

        while(scanner.hasNext()){
            inline2 = inline2 + scanner.nextLine();
        }

        String inlinesub2 =  inline2.substring(4);

        //JSON Parser for Turkey (It is an array)
        JSONArray jsonArray = new JSONArray(inlinesub2);

        countryName = jsonArray.getJSONObject(jsonArray.length()-1).getString("Country");

        /*String confirmedCase = jsonArray.getJSONObject(jsonArray.length()-1).getString("Confirmed");
        String deaths = jsonArray.getJSONObject(jsonArray.length()-1).getString("Deaths");
        String recoveredCase = jsonArray.getJSONObject(jsonArray.length()-1).getString("Recovered");*/

        //String to Integer Parser
        intTurkeyConfirmedCases = stringToIntegerParser.parser(jsonArray.getJSONObject(jsonArray.length()-1).getString("Confirmed"));
        intTurkeyDeaths = stringToIntegerParser.parser(jsonArray.getJSONObject(jsonArray.length()-1).getString("Deaths"));
        intTurkeyRecoveredCases = stringToIntegerParser.parser(jsonArray.getJSONObject(jsonArray.length()-1).getString("Recovered"));
        intTurkeyActiveCases = intTurkeyConfirmedCases - intTurkeyRecoveredCases - intTurkeyDeaths;
        System.out.println("turkey active cases : "+intTurkeyActiveCases);


        formattedTurkeyConfirmedCases = formatter.format(stringToIntegerParser.parser(jsonArray.getJSONObject(jsonArray.length()-1).getString("Confirmed")));
        formattedTurkeyDeaths = formatter.format( stringToIntegerParser.parser(jsonArray.getJSONObject(jsonArray.length()-1).getString("Deaths")));
        formattedTurkeyRecoveredCases = formatter.format(stringToIntegerParser.parser(jsonArray.getJSONObject(jsonArray.length()-1).getString("Recovered")));
        formattedTurkeyActiveCases = formatter.format(intTurkeyActiveCases);

    }

    static public void turkeyGraphConfirmedCases() throws IOException, JSONException {

        arrlistIntiger.clear();
        dataDateArrayList.clear();
        turkeyDeathData.clear();
        turkeyRecoveredData.clear();
        inline3 = "";

        Scanner scanner = new Scanner(apiCaller.url2.openStream());

        while(scanner.hasNext()){
            inline3 = inline3 + scanner.nextLine();
        }
        System.out.println(inline3);
        //String inline3sub = inline3.substring(4);

        //JSON Parser for Turkey (It is an array)
        JSONArray jsonArray = new JSONArray(inline3);

        for(int i=0;i<jsonArray.length();i++){
        String confirmedNumberString = jsonArray.getJSONObject(i).getString("Confirmed");
        String deathNumberString = jsonArray.getJSONObject(i).getString("Deaths");
        String recoveredNumberString = jsonArray.getJSONObject(i).getString("Recovered");

        int confirmedNumberInteger = stringToIntegerParser.parser(confirmedNumberString);
        int deathNumberInt = stringToIntegerParser.parser(deathNumberString);
        int recoveredNumberInt = stringToIntegerParser.parser(recoveredNumberString);

        arrlistIntiger.add(confirmedNumberInteger);
        turkeyDeathData.add(deathNumberInt);
        turkeyRecoveredData.add(recoveredNumberInt);


    }

        System.out.println(arrlistIntiger);

        for(int i=0;i<jsonArray.length();i++){
            String dataDates = jsonArray.getJSONObject(i).getString("Date");
            String dataDatesTrimmed = DateDataArrenger.arrenger(dataDates);
            dataDateArrayList.add(dataDatesTrimmed);

        }

        a = dataDateArrayList.get(jsonArray.length()-1);
        System.out.println(a);

        System.out.println(dataDateArrayList);

        graphXaxis = dataDateArrayList.stream().collect(Collectors.joining("','", "'", "'"));
        System.out.println(graphXaxis);

    }

    static public void getCountryNames() throws IOException, JSONException {

        Scanner scanner = new Scanner(apiCaller.url3.openStream());

        while (scanner.hasNext()){
            inline4 = inline4+scanner.nextLine();
        }
        //System.out.println(inline4);
        inline4Sub = inline4.substring(4);
        System.out.println(inline4Sub);

        JSONArray jsonArray = new JSONArray(inline4Sub);

        for(int i=0; i<jsonArray.length(); i++){

            String countriesSlug = jsonArray.getJSONObject(i).getString("Slug");
            String countries = jsonArray.getJSONObject(i).getString("Country");
            System.out.println(countries);
            countryArrayList.add(countriesSlug);
            countryMap.put(countriesSlug,countries);

        }

    }

    static public void apiDataCollectorCountries() throws IOException, JSONException {

        String yeni = "";

        Scanner scanner = new Scanner(new URL(HomeController.countryApiUrl).openStream());

        while(scanner.hasNext()){
           yeni = yeni + scanner.nextLine();
        }
        System.out.println(yeni);

        System.out.println("yeni array : " +yeni);

        //JSON Parser for Turkey (It is an array)
        JSONArray jsonArray2 = new JSONArray(yeni);

        countryName = jsonArray2.getJSONObject(jsonArray2.length()-1).getString("Country");
        /*String confirmedCase2 = jsonArray2.getJSONObject(jsonArray2.length()-1).getString("Confirmed");
        String deaths2 = jsonArray2.getJSONObject(jsonArray2.length()-1).getString("Deaths");
        String recoveredCase2 = jsonArray2.getJSONObject(jsonArray2.length()-1).getString("Recovered");*/

        //String to Integer Parser
        intCountryConfirmedCases = stringToIntegerParser.parser(jsonArray2.getJSONObject(jsonArray2.length()-1).getString("Confirmed"));
        intCountryDeaths = stringToIntegerParser.parser(jsonArray2.getJSONObject(jsonArray2.length()-1).getString("Deaths"));
        intCountryRecoveredCases = stringToIntegerParser.parser(jsonArray2.getJSONObject(jsonArray2.length()-1).getString("Recovered"));
        intCountryActiveCases = intCountryConfirmedCases - intCountryRecoveredCases - intCountryDeaths;

        formattedCountryConfirmedCases = formatter.format(stringToIntegerParser.parser(jsonArray2.getJSONObject(jsonArray2.length()-1).getString("Confirmed")));
        formattedCountryDeaths = formatter.format(stringToIntegerParser.parser(jsonArray2.getJSONObject(jsonArray2.length()-1).getString("Deaths")));
        formattedCountryRecoveredCases = formatter.format(stringToIntegerParser.parser(jsonArray2.getJSONObject(jsonArray2.length()-1).getString("Recovered")));
        formattedCountryActiveCases = formatter.format(intCountryActiveCases);

        /*for(int i=0;i<jsonArray2.length();i++){
            String dataDates = jsonArray2.getJSONObject(i).getString("Date");
            String dataDatesTrimmed = DateDataArrenger.arrenger(dataDates);
            dataDateArrayListCountry.add(dataDatesTrimmed);
        }

        System.out.println();

        a = dataDateArrayListCountry.get(jsonArray2.length()-1);
        System.out.println("last update : "+a);*/

    }

    static public void countryGraphConfirmedCases() throws IOException, JSONException {

        arrlistIntiger.clear();
        dataDateArrayList.clear();
        turkeyDeathData.clear();
        turkeyRecoveredData.clear();
        inline3 = "";

        Scanner scanner = new Scanner(new URL(HomeController.countryApiUrl).openStream());

        while(scanner.hasNext()){
            inline3 = inline3 + scanner.nextLine();
        }
        System.out.println("country inline 3 :"+inline3);
        //String inline3sub = inline3.substring(4);

        //JSON Parser for Turkey (It is an array)
        JSONArray jsonArray = new JSONArray(inline3);

        for(int i=0;i<jsonArray.length();i++){
            String confirmedNumberString = jsonArray.getJSONObject(i).getString("Confirmed");
            String deathNumberString = jsonArray.getJSONObject(i).getString("Deaths");
            String recoveredNumberString = jsonArray.getJSONObject(i).getString("Recovered");

            int confirmedNumberInteger = stringToIntegerParser.parser(confirmedNumberString);
            int deathNumberInt = stringToIntegerParser.parser(deathNumberString);
            int recoveredNumberInt = stringToIntegerParser.parser(recoveredNumberString);

            arrlistIntiger.add(confirmedNumberInteger);
            turkeyDeathData.add(deathNumberInt);
            turkeyRecoveredData.add(recoveredNumberInt);

        }

        System.out.println(arrlistIntiger);

        for(int i=0;i<jsonArray.length();i++){
            String dataDates = jsonArray.getJSONObject(i).getString("Date");
            String dataDatesTrimmed = DateDataArrenger.arrenger(dataDates);
            dataDateArrayList.add(dataDatesTrimmed);

        }

        a = dataDateArrayList.get(jsonArray.length()-1);
        System.out.println(a);

        System.out.println(dataDateArrayList);

        graphXaxis = dataDateArrayList.stream().collect(Collectors.joining("','", "'", "'"));
        System.out.println(graphXaxis);

    }

}

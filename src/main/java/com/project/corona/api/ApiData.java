package com.project.corona.api;

import com.project.corona.functions.DateDataArrenger;
import com.project.corona.functions.StringToIntegerParser;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;

import java.io.IOException;
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

    static public int intNewConfirmed;
    static public int intTotalConfirmed;
    static public int intNewDeaths;
    static public int intTotalDeaths;
    static public int intNewRecovered;
    static public int intTotalRecovered;

    static public int intTurkeyConfirmedCases;
    static public int intTurkeyDeaths;
    static public int intTurkeyRecoveredCases;

    static public String formattedNewConfirmed;
    static public String formattedTotalConfirmed;
    static public String formattedNewDeaths;
    static public String formattedTotalDeaths;
    static public String formattedNewRecovered;
    static public String formattedTotalRecovered;

    static public String formattedTurkeyConfirmedCases;
    static public String formattedTurkeyDeaths;
    static public String formattedTurkeyRecoveredCases;

   static ApiCaller apiCaller = new ApiCaller();
   static StringToIntegerParser stringToIntegerParser = new StringToIntegerParser();
   static DecimalFormat formatter = new DecimalFormat("#,###,###");

   static public ArrayList<Integer> arrlistIntiger = new ArrayList<Integer>();
   static public ArrayList<String> dataDateArrayList = new ArrayList<String>();
   static public ArrayList<Integer> turkeyDeathData = new ArrayList<Integer>();
   static public ArrayList<Integer> turkeyRecoveredData = new ArrayList<Integer>();
   static public ArrayList<String> countryArrayList = new ArrayList<String>();
   static public Map<String,String> countryMap = new HashMap<>();
   //static public List<String> countryListDeneme = new ArrayList<String>();

   static public String graphXaxis;

    public ApiData() throws JSONException {
    }

    public static void apiDataCollectorGlobal() throws IOException, JSONException {

        Scanner scanner = new Scanner(apiCaller.url1.openStream());

        while (scanner.hasNext()){
            inline = inline + scanner.nextLine();
        }

        System.out.println("inline :" +inline);
        String inlinesub =  inline.substring(4);
        System.out.println(inlinesub);

        //JsonParser General Stats
        JSONObject jsonObject = new JSONObject(inlinesub);
        String newConfirmed = jsonObject.getJSONObject("Global").getString("NewConfirmed");
        String totalConfirmed = jsonObject.getJSONObject("Global").getString("TotalConfirmed");
        String newDeaths = jsonObject.getJSONObject("Global").getString("NewDeaths");
        String totalDeaths = jsonObject.getJSONObject("Global").getString("TotalDeaths");
        String newRecovered = jsonObject.getJSONObject("Global").getString("NewRecovered");
        String totalRecovered = jsonObject.getJSONObject("Global").getString("TotalRecovered");

        System.out.println(newConfirmed);
        System.out.println(totalConfirmed);
        System.out.println(newDeaths);
        System.out.println(totalDeaths);
        System.out.println(newRecovered);
        System.out.println(totalRecovered);

        //String to Integer General Stats
        intNewConfirmed = stringToIntegerParser.parser(newConfirmed);
        intTotalConfirmed = stringToIntegerParser.parser(totalConfirmed);
        intNewDeaths = stringToIntegerParser.parser(newDeaths);
        intTotalDeaths = stringToIntegerParser.parser(totalDeaths);
        intNewRecovered = stringToIntegerParser.parser(newRecovered);
        intTotalRecovered = stringToIntegerParser.parser(totalRecovered);

        //formatter object

        formattedNewConfirmed = formatter.format(intNewConfirmed);
        formattedTotalConfirmed = formatter.format(intTotalConfirmed);
        formattedNewDeaths = formatter.format(intNewDeaths);
        formattedTotalDeaths = formatter.format(intTotalDeaths);
        formattedNewRecovered = formatter.format(intNewRecovered);
        formattedTotalRecovered = formatter.format(intTotalRecovered);

    }

    static public void apiDataCollectorTurkey() throws IOException, JSONException {

        Scanner scanner = new Scanner(apiCaller.url2.openStream());

        while(scanner.hasNext()){
            inline2 = inline2 + scanner.nextLine();
        }
        System.out.println(inline2);

        String inlinesub2 =  inline2.substring(4);
        System.out.println(inlinesub2);
        //JSON Parser for Turkey (It is an array)
        JSONArray jsonArray = new JSONArray(inlinesub2);

        String confirmedCase = jsonArray.getJSONObject(jsonArray.length()-1).getString("Confirmed");
        String deaths = jsonArray.getJSONObject(jsonArray.length()-1).getString("Deaths");
        String recoveredCase = jsonArray.getJSONObject(jsonArray.length()-1).getString("Recovered");

        System.out.println(confirmedCase);
        System.out.println(deaths);
        System.out.println(recoveredCase);

        //String to Integer Parser
        intTurkeyConfirmedCases = stringToIntegerParser.parser(confirmedCase);
        intTurkeyDeaths = stringToIntegerParser.parser(deaths);
        intTurkeyRecoveredCases = stringToIntegerParser.parser(recoveredCase);

        formattedTurkeyConfirmedCases = formatter.format(intTurkeyConfirmedCases);
        formattedTurkeyDeaths = formatter.format(intTurkeyDeaths);
        formattedTurkeyRecoveredCases = formatter.format(intTurkeyRecoveredCases);

    }

    static public void turkeyGraphConfirmedCases() throws IOException, JSONException {

        arrlistIntiger.clear();
        dataDateArrayList.clear();

        Scanner scanner = new Scanner(apiCaller.url2.openStream());

        while(scanner.hasNext()){
            inline3 = inline3 + scanner.nextLine();
        }
        System.out.println(inline3);
        String inline3sub = inline3.substring(4);

        //JSON Parser for Turkey (It is an array)
        JSONArray jsonArray = new JSONArray(inline3sub);

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


}

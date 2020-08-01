package com.project.corona.controller;

import com.project.corona.api.ApiCaller;
import com.project.corona.api.ApiData;
import com.project.corona.functions.Scrapper;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.ParseException;

@Controller
public class HomeController {

    static public String summaryUrl = "https://api.covid19api.com/summary";
    public String turkeyApi = "https://api.covid19api.com/total/dayone/country/turkey";
    static public String countryApiUrl;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homePage(Model model, @RequestParam(required = false) String country, HttpServletRequest request) throws IOException, JSONException, ParseException {

        if (country == null) {

            Scrapper.topFiveElements();

            model.addAttribute("usa",Scrapper.intUsa);
            model.addAttribute("brasil",Scrapper.intBrasil);
            model.addAttribute("india",Scrapper.intIndia);
            model.addAttribute("russia",Scrapper.intRussia);
            model.addAttribute("peru",Scrapper.intPeru);

            ApiCaller.globalApiHealthCheck(summaryUrl);
            ApiData.apiDataCollectorGlobal();

            ApiCaller.turkeyApiHealthCheck(turkeyApi);
            ApiData.apiDataCollectorTurkey();

            ApiData.turkeyGraphConfirmedCases();

            model.addAttribute("totalConfirmed", ApiData.formattedTotalConfirmed);
            model.addAttribute("totalDeaths", ApiData.formattedTotalDeaths);
            model.addAttribute("totalRecovered", ApiData.formattedTotalRecovered);
            model.addAttribute("totalActive", ApiData.formattedTotalActiveCases);

            model.addAttribute("countryName", ApiData.countryName);
            model.addAttribute("countryRecovered", ApiData.formattedTurkeyRecoveredCases);
            model.addAttribute("countryDeaths", ApiData.formattedTurkeyDeaths);
            model.addAttribute("countryConfirmed", ApiData.formattedTurkeyConfirmedCases);
            model.addAttribute("countryActive", ApiData.formattedTurkeyActiveCases);

            model.addAttribute("confirmedCasesDayByDay", ApiData.arrlistIntiger);
            model.addAttribute("xAxis", ApiData.graphXaxis);
            model.addAttribute("deathsNumbersDayByDay", ApiData.turkeyDeathData);
            model.addAttribute("recoveredNumbersDayByDay", ApiData.turkeyRecoveredData);
            model.addAttribute("lastUpdate", ApiData.a);

            ApiCaller.countryNamesApi("https://api.covid19api.com/countries");
            ApiData.getCountryNames();
            model.addAttribute("countries", ApiData.countryArrayList);

            model.addAttribute("countryMap", ApiData.countryMap);

        } else {

            model.addAttribute("parameter", country);

            //url initilize
            String baseUrl = "https://api.covid19api.com/total/dayone/country/";
            String countryKey = country;
            countryApiUrl = baseUrl + country;

            Scrapper.topFiveElements();

            model.addAttribute("usa",Scrapper.intUsa);
            model.addAttribute("brasil",Scrapper.intBrasil);
            model.addAttribute("india",Scrapper.intIndia);
            model.addAttribute("russia",Scrapper.intRussia);
            model.addAttribute("peru",Scrapper.intPeru);


            //api chack for summary

            ApiCaller.globalApiHealthCheck(summaryUrl);
            ApiData.apiDataCollectorGlobal();
            //summary api results
            model.addAttribute("totalConfirmed", ApiData.formattedTotalConfirmed);
            model.addAttribute("totalDeaths", ApiData.formattedTotalDeaths);
            model.addAttribute("totalRecovered", ApiData.formattedTotalRecovered);
            model.addAttribute("totalActive", ApiData.formattedTotalActiveCases);

            //country info pull
            ApiCaller.countryNamesApi("https://api.covid19api.com/countries");
            ApiData.getCountryNames();

            model.addAttribute("countries", ApiData.countryArrayList);
            model.addAttribute("countryMap", ApiData.countryMap);

            ApiCaller.countryApiHealthCheck(countryApiUrl);
            ApiData.apiDataCollectorCountries();

            model.addAttribute("countryName", ApiData.countryName);
            model.addAttribute("countryRecovered", ApiData.formattedCountryRecoveredCases);
            model.addAttribute("countryDeaths", ApiData.formattedCountryDeaths);
            model.addAttribute("countryConfirmed", ApiData.formattedCountryConfirmedCases);
            model.addAttribute("countryActive", ApiData.formattedCountryActiveCases);
            model.addAttribute("lastUpdate", ApiData.a);

            ApiData.countryGraphConfirmedCases();

            model.addAttribute("confirmedCasesDayByDay", ApiData.arrlistIntiger);
            model.addAttribute("xAxis", ApiData.graphXaxis);
            model.addAttribute("deathsNumbersDayByDay", ApiData.turkeyDeathData);
            model.addAttribute("recoveredNumbersDayByDay", ApiData.turkeyRecoveredData);

        }

        return "homepage";
    }

}


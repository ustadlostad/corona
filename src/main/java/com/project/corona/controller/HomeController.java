package com.project.corona.controller;

import com.project.corona.api.ApiCaller;
import com.project.corona.api.ApiData;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.jws.WebParam;
import java.io.IOException;
import java.text.ParseException;

@Controller
public class HomeController {

    public String summaryUrl = "https://api.covid19api.com/summary" ;
    public String turkeyApi = "https://api.covid19api.com/total/dayone/country/turkey";

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homePage(Model model) throws IOException, JSONException, ParseException {
        ApiCaller.globalApiHealthCheck(summaryUrl);
        ApiData.apiDataCollectorGlobal();

        ApiCaller.turkeyApiHealthCheck(turkeyApi);
        ApiData.apiDataCollectorTurkey();

        ApiData.turkeyGraphConfirmedCases();

        model.addAttribute("newConfirmed", ApiData.formattedNewConfirmed);
        model.addAttribute("totalConfirmed", ApiData.formattedTotalConfirmed);
        model.addAttribute("newDeaths", ApiData.formattedNewDeaths);
        model.addAttribute("totalDeaths", ApiData.formattedTotalDeaths);
        model.addAttribute("newRecovered", ApiData.formattedNewRecovered);
        model.addAttribute("totalRecovered", ApiData.formattedTotalRecovered);
        model.addAttribute("turkeyRecovered",ApiData.formattedTurkeyRecoveredCases);
        model.addAttribute("turkeyDeaths",ApiData.formattedTurkeyDeaths);
        model.addAttribute("turkeyConfirmed",ApiData.formattedTurkeyConfirmedCases);

        model.addAttribute("confirmedCasesDayByDay", ApiData.arrlistIntiger);
        model.addAttribute("xAxis",ApiData.graphXaxis);
        model.addAttribute("deathsNumbersDayByDay",ApiData.turkeyDeathData);
        model.addAttribute("recoveredNumbersDayByDay",ApiData.turkeyRecoveredData);
        model.addAttribute("lastUpdate",ApiData.a);

        ApiCaller.countryNamesApi("https://api.covid19api.com/countries");
        ApiData.getCountryNames();
        model.addAttribute("countries",ApiData.countryArrayList);

        model.addAttribute("countryMap",ApiData.countryMap);

        return "homepage";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String bringCountryData(Model model, @RequestParam String key) throws IOException, JSONException {

        String mainUrl = "https://api.covid19api.com/total/country/";
        String apiTest = mainUrl + key;

        ApiCaller.globalApiHealthCheck(summaryUrl);
        //ApiData.apiDataCollectorGlobal();

        System.out.println(key);

        //ApiCaller.countryApiHealthCheck();


        return "homepage";
    }
}


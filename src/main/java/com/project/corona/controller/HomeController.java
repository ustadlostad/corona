package com.project.corona.controller;

import com.project.corona.api.ApiCaller;
import com.project.corona.api.ApiData;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.io.IOException;
import java.text.ParseException;

@Controller
public class HomeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homePage(Model model) throws IOException, JSONException, ParseException {
        ApiCaller.globalApiHealthCheck("https://api.covid19api.com/summary");
        ApiData.apiDataCollectorGlobal();

        ApiCaller.turkeyApiHealthCheck("https://api.covid19api.com/total/dayone/country/turkey");
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

        model.addAttribute("yAxis", ApiData.arrlistIntiger);
        model.addAttribute("xAxis",ApiData.dataDateArrayList);


        return "homepage";
    }

}


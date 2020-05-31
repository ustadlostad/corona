package com.project.corona.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class errorPageController {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String errorPage(Model model){


        return "errorPage";
    }

}

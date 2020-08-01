package com.project.corona.functions;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class Scrapper {

    static public Element pageElement1;
    static public Element pageElement2;
    static public Element pageElement3;
    static public Element pageElement4;
    static public Element pageElement5;

    static public int intUsa;
    static public int intBrasil;
    static public int intIndia;
    static public int intRussia;
    static public int intPeru;

    static public void topFiveElements() throws IOException {

        String url = "https://covid-track-turkmen.herokuapp.com/";
        String usaSelector = "div.container:nth-child(1) table.table.table-bordered.table-striped.table-dark tbody:nth-child(2) tr:nth-child(178) > td:nth-child(2)";
        String brasilSelector = "div.container:nth-child(1) table.table.table-bordered.table-striped.table-dark tbody:nth-child(2) tr:nth-child(24) > td:nth-child(2)";
        String indiaSelector = "div.container:nth-child(1) table.table.table-bordered.table-striped.table-dark tbody:nth-child(2) tr:nth-child(77) > td:nth-child(2)";
        String russiaSelector = "div.container:nth-child(1) table.table.table-bordered.table-striped.table-dark tbody:nth-child(2) tr:nth-child(77) > td:nth-child(2)";
        String peruSelector = "div.container:nth-child(1) table.table.table-bordered.table-striped.table-dark tbody:nth-child(2) tr:nth-child(132) > td:nth-child(2)";

        Document doc = Jsoup.connect(url).get();
        pageElement1 = doc.selectFirst(usaSelector);
        pageElement2 = doc.selectFirst(brasilSelector);
        pageElement3 = doc.selectFirst(indiaSelector);
        pageElement4 = doc.selectFirst(russiaSelector);
        pageElement5 = doc.selectFirst(peruSelector);

        String usa = TagKiller.killTag(pageElement1.toString());
        String brasil = TagKiller.killTag(pageElement2.toString());
        String india = TagKiller.killTag(pageElement3.toString());
        String russia = TagKiller.killTag(pageElement4.toString());
        String peru = TagKiller.killTag(pageElement5.toString());

        System.out.println(usa);

        intUsa = StringToIntegerParser.parser(usa);
        intBrasil = StringToIntegerParser.parser(brasil);
        intIndia = StringToIntegerParser.parser(india);
        intRussia = StringToIntegerParser.parser(russia);
        intPeru = StringToIntegerParser.parser(peru);

    }

}

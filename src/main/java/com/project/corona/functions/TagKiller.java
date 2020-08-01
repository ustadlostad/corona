package com.project.corona.functions;

public class TagKiller {

    static public String killTag(String scrappedValue){

        String firstRemove =scrappedValue.replace("<td>","");
        String secondRemove = firstRemove.replace("</td>","");

        System.out.println(firstRemove);
        System.out.println(secondRemove);

        return secondRemove;
    }

}

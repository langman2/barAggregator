package edu.illinois.cs.cs125.baraggregator;


import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.apache.commons.lang3.ArrayUtils;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class HTMLPull {

    public static Document pullHTML(String url) {
        Document document = null;
        try {
            Document doc = Jsoup.connect(url).get();
            String title = doc.title();
            System.out.println(title);
            document = doc;
        } catch (IOException e) {
            System.out.println("io - " + e);
        }
        return document;

    }

    public static String[][] getSpecials(Document document){
        Elements text = document.select("div[class=dealRep]");
        String[] specials = new String[text.size()];

        for (int i =0; i < text.size(); i++) {
            specials[i] = text.get(i).html();
        }
        String[][] specialsSplit = new String[text.size()][];
        for (int i =0; i < text.size(); i++) {
            String[] temp = specials[i].split("<br>");
            temp = StringUtils.stripAll(temp);
            List<String> list = new ArrayList<String>(Arrays.asList(temp));
            list.removeAll(Collections.singleton(null));
            list.removeAll(Collections.singleton(""));
            String[] finalTemp = new String[list.size()];
            for(int y = 0; y < list.size(); y++){
                finalTemp[y] = list.get(y);
            }
            specialsSplit[i] = finalTemp;


        }
        return specialsSplit;
    }
    public static String[] getBars(Document document){
        Elements text = document.select("div[class=titleRep]");
        String[] bars = new String[text.size()];

        for (int i =0; i < text.size(); i++) {
            bars[i] = text.get(i).text();
        }

        return bars;
    }

}

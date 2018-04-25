package edu.illinois.cs.cs125.baraggregator;

import org.jsoup.nodes.Document;
import static edu.illinois.cs.cs125.baraggregator.HTMLPull.getSpecials;
import static edu.illinois.cs.cs125.baraggregator.HTMLPull.pullHTML;

public class MainRun {

    public static void main(String[] args) {


        Document fridaySpecials = pullHTML("http://www.drinkspecialschampaign.com/friday-drink-specials.html");
        String[][] fridaySplit = getSpecials(fridaySpecials);
        String[] bars = HTMLPull.getBars(fridaySpecials);
        for (int i = 0; i < fridaySplit.length; i++) {
            System.out.println(bars[i]);
            String[] temp = fridaySplit[i];
            for (String inner : temp) {
                System.out.println(inner);
            }
        }


    }
}

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class StateCap {
    public static void main(String[] args)
    {
        Map<String, String> capitols = new HashMap<>();
        capitols.put("Alabama", "Montgomery");
        capitols.put("Alaska", "Juneau");
        capitols.put("Arizona", "Phoenix");
        capitols.put("Arkansas", "Little Rock");
        capitols.put("California", "Sacramento");
        capitols.put("Colorado", "Denver");
        capitols.put("Connecticut", "Hartford");
        capitols.put("Delaware", "Dover");
        capitols.put("Florida", "Tallahassee");
        capitols.put("Georgia", "Atlanta");
        capitols.put("Hawaii", "Honolulu");
        capitols.put("Idaho", "Boise");
        capitols.put("Illinois", "Springfield");
        capitols.put("Indiana", "Indianapolis");
        capitols.put("Iowa", "Des Moines");
        capitols.put("Kansas", "Topeka");
        capitols.put("Kentucky", "Frankfort");
        capitols.put("Louisiana", "Baton Rouge");
        capitols.put("Maine", "Augusta");
        capitols.put("Maryland", "Annapolis");
        capitols.put("Massachusetts", "Boston");
        capitols.put("Michigan", "Lansing");
        capitols.put("Minnesota", "Saint Paul");
        capitols.put("Mississippi", "Jackson");
        capitols.put("Missouri", "Jefferson City");
        capitols.put("Montana", "Helena");
        capitols.put("Nebraska", "Lincoln");
        capitols.put("Nevada", "Carson City");
        capitols.put("New Hampshire", "Concord");
        capitols.put("New Jersey", "Trenton");
        capitols.put("New Mexico", "Santa Fe");
        capitols.put("New York", "Albany");
        capitols.put("North Carolina", "Raleigh");
        capitols.put("North Dakota", "Bismark");
        capitols.put("Ohio", "Columbus");
        capitols.put("Oklahoma", "Oklahoma City");
        capitols.put("Oregon", "Salem");
        capitols.put("Pennsylvania", "Harrisburg");
        capitols.put("Rhode Island", "Providence");
        capitols.put("South Carolina", "Columbia");
        capitols.put("South Dakota", "Pierre");
        capitols.put("Tennessee", "Nashville");
        capitols.put("Texas", "Austin");
        capitols.put("Utah", "Salt Lake City");
        capitols.put("Vermont", "Montpelier");
        capitols.put("Virginia", "Richmond");
        capitols.put("Washington", "Olympia");
        capitols.put("West Virginia", "Charleston");
        capitols.put("Wisconsin", "Madison");
        capitols.put("Wyoming", "Cheyenne");

        Set<String> keys = capitols.keySet();

        for(String states: keys)
        {
            System.out.println(states);
        }

        System.out.println("------------------");

        for(String caps: keys)
        {
            System.out.println(capitols.get(caps));
        }

        System.out.println("------------------");

        for(String k: keys)
        {
            System.out.println(k + ", " + capitols.get(k));
        }
    }
}

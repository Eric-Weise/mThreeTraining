import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class StateCapitalsApp {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new BufferedReader(new FileReader("MoreStateCapitals.txt")));
        Map<String, Capital> states = new HashMap<>();

        while(sc.hasNextLine())
        {
            String currentLine = sc.nextLine();
            String[] temp = currentLine.split("::");
            Capital eachState = new Capital();
            eachState.setName(temp[1]);
            eachState.setPopulation(temp[2]);
            eachState.setSquareMileage(temp[3]);
            states.put(temp[0], eachState);
            Set<String> keys = states.keySet();
            //System.out.println(eachState.getName().toString());
        }
        System.out.println("\n" + states.size() + " State/capital pairs loaded.");
        System.out.println("===============");
        Set<String> keys = states.keySet();
//        for(String state: keys)
//        {
//            System.out.println(state);
//        }
        for(String caps: keys)
        {
            System.out.println(caps + " - " + states.get(caps).toString());
        }
    }
}

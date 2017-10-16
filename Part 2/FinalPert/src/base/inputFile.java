package base;

import Controller.Controller;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Yahkiller
 */
public class inputFile {

    public static void getLista(Controller controller, String localizacao) throws FileNotFoundException, IOException {
        int paramFixed = 6;
        int paramVar=7;

        BufferedReader br = new BufferedReader(new FileReader(localizacao));
        try {

            String line = br.readLine();

            while (line != null) {
                String[] parts = line.split(",");

                if (parts[1].equalsIgnoreCase("fca")) {

                    if (parts.length > paramFixed) { 
                        addActivFixed(paramFixed, parts, controller);

                    } else {
                        fixedCost fixed = new fixedCost(parts[0], parts[1], parts[2], Integer.parseInt(parts[3]),
                                parts[4], Integer.parseInt(parts[5]));
                        controller.addActiv(fixed);
                    }

                }

                if (parts[1].equalsIgnoreCase("vca")) {

                    if (parts.length > paramVar) {
                        addActivVar(paramVar, parts, controller);
                    }else{
                        variableCost variable = new variableCost(parts[0], parts[1], parts[2], Integer.parseInt(parts[3]), parts[4], Integer.parseInt(parts[5]), Integer.parseInt(parts[6]));
                        controller.addActiv(variable);
                    }
                }
                line = br.readLine();
            }

        } finally {
            br.close();
        }

    }
    
    public static void addActivFixed(int paramFixed, String[] parts, Controller controller) {
        List<String> listPrevActKeys = new ArrayList();
        for (int i = paramFixed; i < parts.length; i++) {
            String prevKey = parts[i];
            if (controller.hasActivity(prevKey) && (!listPrevActKeys.contains(prevKey))) {
                listPrevActKeys.add(prevKey);
            } else {
                System.out.println("A prevKey '" + prevKey + "' da Actividade '" + parts[0] + "'  n existe!");
            }
        }

        fixedCost fixed = new fixedCost(parts[0], parts[1], parts[2], Integer.parseInt(parts[3]),
                parts[4], Integer.parseInt(parts[5]), listPrevActKeys);
        controller.addActiv(fixed);
    }
   
    public static void addActivVar(int paramVar, String[] parts, Controller controller) {
        List<String> listPrevActKeys = new ArrayList();
        for (int i = paramVar; i < parts.length; i++) {
            String prevKey = parts[i];
            if (controller.hasActivity(prevKey) && (!listPrevActKeys.contains(prevKey))) {
                listPrevActKeys.add(prevKey);
            } else {
                System.out.println("A prevKey '" + prevKey + "' da Actividade '" + parts[0] + "' não é válida!");
            }
        }
        if (validacaoUnid(parts[4])) {
            variableCost variable = new variableCost(parts[0], parts[1], parts[2], Integer.parseInt(parts[3]), parts[4], Integer.parseInt(parts[5]), Integer.parseInt(parts[6]), listPrevActKeys);
            controller.addActiv(variable);
        }
    }

    

    public static boolean validacaoUnid(String str) {
        if (str.equalsIgnoreCase("minute") || str.equalsIgnoreCase("hour") || str.equalsIgnoreCase("day") || str.equalsIgnoreCase("week") || str.equalsIgnoreCase("month"))  {
            return true;
        }
        return false;
    }

}

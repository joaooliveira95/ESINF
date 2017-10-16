package Controller;

import base.Activity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Yahkiller
 */
public class Controller {

    private ArrayList<Activity> lActiv;

    public Controller() {
        this.lActiv = new ArrayList();
    }

    public boolean hasActivity(String key) {
        for (int i = 0; i < lActiv.size(); i++) {
            if (key.equalsIgnoreCase(lActiv.get(i).getKey())) {
                return true;
            }
        }

        return false;
    }
    
    public Activity getActivity(String key) {
        for (int i = 0; i < lActiv.size(); i++) {
            if (key.equalsIgnoreCase(lActiv.get(i).getKey())) {
                return lActiv.get(i);
            }
        }

        return null;
    }
    

    public void printActivs() {
        System.out.println("\nLista de Actividades: ");
        for (int i = 0; i < lActiv.size(); i++) {
            System.out.print(lActiv.get(i).getKey() + "," + lActiv.get(i).getDescription() + "," + lActiv.get(i).getTypeActivity() + ',');

            Activity var = lActiv.get(i);
            List<String> lPrevs = var.getListPrevActivityKey();
            for (int j = 0; j < lPrevs.size(); j++) {
                System.out.print(lPrevs.get(j).toString());
            }

            System.out.println();
        }
    }

    public boolean addActiv(Activity a) {
        if (!hasActivity(a.getKey())) {
            lActiv.add(a);
            return true;
        } else {
            return false;
        }
    }

    /**
     * @return the lActiv
     */
    public ArrayList<Activity> getlActiv() {
        return lActiv;
    }

    /**
     * @param lActiv the lActiv to set
     */
    public void setlActiv(ArrayList<Activity> lActiv) {
        this.lActiv = lActiv;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esinf_project;

import java.util.List;

/**
 *
 * @author Yahkiller
 */
public class fixedCost extends Activity{
    
    private int activityCost;
    
        public fixedCost(String key, String typeActivity, String description, int duration, String timeUnit, int activityCost, List<String> listPrevActivityKey) {
        super(key, typeActivity, description, duration, timeUnit, listPrevActivityKey);
        this.activityCost = activityCost;
    }

    public fixedCost(String key, String typeActivity, String description, int duration, String timeUnit, int activityCost) {
        super(key, typeActivity, description, duration, timeUnit);
        this.activityCost = activityCost;
    }

    /**
     * @return the activityCost
     */
    public int getActivityCost() {
        
        return activityCost;
    }

    /**
     * @param activityCost the activityCost to set
     */
    public void setActivityCost(int activityCost) {
        this.activityCost = activityCost;
    }
    
    
}
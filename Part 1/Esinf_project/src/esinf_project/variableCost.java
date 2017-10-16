/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esinf_project;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Yahkiller
 */
public class variableCost extends Activity{
    
    private int costTime;
    private int totalTime;

   public variableCost(String key, String typeActivity, String description, int duration, String timeUnit, int costTime, int totalTime, List listPrevActivityKey) {
        super(key, typeActivity, description, duration, timeUnit, listPrevActivityKey);
        this.costTime=costTime;
        this.totalTime=totalTime;
    }

    public variableCost(String key, String typeActivity, String description, int duration, String timeUnit, int costTime, int totalTime) {
        super(key, typeActivity, description, duration, timeUnit);
        this.costTime=costTime;
        this.totalTime=totalTime;
    }
    
    
    
    public int calculateTotalCost(){
        return this.costTime * this.totalTime;
    }

    /**
     * @return the costTime
     */
    public int getCostTime() {
        return costTime;
    }

    /**
     * @param costTime the costTime to set
     */
    public void setCostTime(int costTime) {
        this.costTime = costTime;
    }

    /**
     * @return the totalTime
     */
    public int getTotalTime() {
        return totalTime;
    }

    /**
     * @param totalTime the totalTime to set
     */
    public void setTotalTime(int totalTime) {
        this.totalTime = totalTime;
    }

  
   
    
}
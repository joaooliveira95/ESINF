
package base;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Yahkiller
 */
public class Activity{
    
    private String key;
    private String typeActivity;
    private String description;
    private int duration;
    private String timeUnit;
    private List<String> listPrevActivityKey;

    
    public Activity(String key){
      this.key= key;
      this.duration = 0;
    }
    
    public Activity(String key, String typeActivity, String description, int duration, String timeUnit, List<String> listPrevActivityKey){
        this.key = key;
        this.typeActivity = typeActivity;
        this.description = description;
        this.duration = duration;
        this.timeUnit = timeUnit;
        this.listPrevActivityKey=listPrevActivityKey;
    }
    
        public Activity(String key, String typeActivity, String description, int duration, String timeUnit){
        this.key = key;
        this.typeActivity = typeActivity;
        this.description = description;
        this.duration = duration;
        this.timeUnit = timeUnit;
        this.listPrevActivityKey=new ArrayList();
    }
    

    /**
     * @return the key
     */
    public String getKey() {
        return key;
    }

    /**
     * @param key the key to set
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * @return the typeActivity
     */
    public String getTypeActivity() {
        return typeActivity;
    }

    /**
     * @param typeActivity the typeActivity to set
     */
    public void setTypeActivity(String typeActivity) {
        this.typeActivity = typeActivity;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the duation
     */
    public int getDuration() {
        return duration;
    }

    /**
     * @param duation the duation to set
     */
    public void setDuration(int duation) {
        this.duration = duation;
    }

    /**
     * @return the timeUnit
     */
    public String getTimeUnit() {
        return timeUnit;
    }

    /**
     * @param timeUnit the timeUnit to set
     */
    public void setTimeUnit(String timeUnit) {
        this.timeUnit = timeUnit;
    }

    /**
     * @return the listPrevActivityKey
     */
    public List<String> getListPrevActivityKey() {
        return listPrevActivityKey;
    }

    /**
     * @param listPrevActivityKey the listPrevActivityKey to set
     */
    public void setListPrevActivityKey(List<String> listPrevActivityKey) {
        this.listPrevActivityKey = listPrevActivityKey;
    }

 
}

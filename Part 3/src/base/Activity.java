package base;

/**
 *
 * @author Yahkiller
 */
public class Activity implements Comparable<Activity> {

    private String project_key;
    private String activity_key;
    private String activity_type;
    private int activity_completion;
    private int activity_delay;

    public Activity(String project, String key, String type, int completion, int delay) {
        this.project_key = project;
        this.activity_key = key;
        this.activity_type = type;
        this.activity_completion = completion;
        this.activity_delay = delay;
    }

    /**
     * @return the project_key
     */
    public String getProject_key() {
        return project_key;
    }

    /**
     * @param project_key the project_key to set
     */
    public void setProject_key(String project_key) {
        this.project_key = project_key;
    }

    /**
     * @return the activity_key
     */
    public String getActivity_key() {
        return activity_key;
    }

    /**
     * @param activity_key the activity_key to set
     */
    public void setActivity_key(String activity_key) {
        this.activity_key = activity_key;
    }

    /**
     * @return the activity_type
     */
    public String getActivity_type() {
        return activity_type;
    }

    /**
     * @param activity_type the activity_type to set
     */
    public void setActivity_type(String activity_type) {
        this.activity_type = activity_type;
    }

    /**
     * @return the activity_completion
     */
    public int getActivity_completion() {
        return activity_completion;
    }

    /**
     * @param activity_completion the activity_completion to set
     */
    public void setActivity_completion(int activity_completion) {
        this.activity_completion = activity_completion;
    }

    /**
     * @return the activity_delay
     */
    public int getActivity_delay() {
        return activity_delay;
    }

    /**
     * @param activity_delay the activity_delay to set
     */
    public void setActivity_delay(int activity_delay) {
        this.activity_delay = activity_delay;
    }

    @Override
    public int compareTo(Activity o) {
        return activity_key.compareTo(o.activity_key);
    }
    
    
}

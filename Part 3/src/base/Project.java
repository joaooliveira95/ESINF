/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base;

/**
 *
 * @author Yahkiller
 */
public class Project implements Comparable<Project>{
    
    private String project_key;
    private String project_type;
    private int project_completion;
    private int project_delay;
    
    
    public Project(String key, String type, int completion, int delay){
        this.project_key=key;
        this.project_type=type;
        this.project_completion=completion;
        this.project_delay=delay;
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
     * @return the project_type
     */
    public String getProject_type() {
        return project_type;
    }

    /**
     * @param project_type the project_type to set
     */
    public void setProject_type(String project_type) {
        this.project_type = project_type;
    }

    /**
     * @return the project_completion
     */
    public int getProject_completion() {
        return project_completion;
    }

    /**
     * @param project_completion the project_completion to set
     */
    public void setProject_completion(int project_completion) {
        this.project_completion = project_completion;
    }

    /**
     * @return the project_delay
     */
    public int getProject_delay() {
        return project_delay;
    }

    /**
     * @param project_delay the project_delay to set
     */
    public void setProject_delay(int project_delay) {
        this.project_delay = project_delay;
    }

    @Override
    public int compareTo(Project o) {
        return project_key.compareTo(o.project_key);
    }
}

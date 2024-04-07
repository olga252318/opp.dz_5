package model;

public abstract class StudyGroup{

    public StudyGroup(String fistName, String lastName, String middleName) {
        this.fistName = fistName;
        this.lastName = lastName;
        this.middleName = middleName;
        
    }

    private String fistName;
    private String lastName;
    private String middleName;
    
    public String getFistName() {
        return fistName;
    }
    public void setFistName(String fistName) {
        this.fistName = fistName;
    }
    
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getMiddleName() {
        return middleName;
    }
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }


}
package Entities;
// Generated Sep 9, 2016 6:59:56 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Category generated by hbm2java
 */
public class Category  implements java.io.Serializable {


     private Integer idcategory;
     private Apptype apptype;
     private String category;
     private boolean state;
     private Set<Application> applications = new HashSet<Application>(0);

    public Category() {
    }

	
    public Category(Apptype apptype, String category, boolean state) {
        this.apptype = apptype;
        this.category = category;
        this.state = state;
    }
    public Category(Apptype apptype, String category, boolean state, Set<Application> applications) {
       this.apptype = apptype;
       this.category = category;
       this.state = state;
       this.applications = applications;
    }
   
    public Integer getIdcategory() {
        return this.idcategory;
    }
    
    public void setIdcategory(Integer idcategory) {
        this.idcategory = idcategory;
    }
    public Apptype getApptype() {
        return this.apptype;
    }
    
    public void setApptype(Apptype apptype) {
        this.apptype = apptype;
    }
    public String getCategory() {
        return this.category;
    }
    
    public void setCategory(String category) {
        this.category = category;
    }
    public boolean isState() {
        return this.state;
    }
    
    public void setState(boolean state) {
        this.state = state;
    }
    public Set<Application> getApplications() {
        return this.applications;
    }
    
    public void setApplications(Set<Application> applications) {
        this.applications = applications;
    }




}



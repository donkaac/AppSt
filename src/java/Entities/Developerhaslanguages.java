package Entities;
// Generated Oct 2, 2016 12:23:07 PM by Hibernate Tools 4.3.1



/**
 * Developerhaslanguages generated by hbm2java
 */
public class Developerhaslanguages  implements java.io.Serializable {


     private Integer idDeveloperHasLanguages;
     private Developer developer;
     private Developinglanguages developinglanguages;

    public Developerhaslanguages() {
    }

    public Developerhaslanguages(Developer developer, Developinglanguages developinglanguages) {
       this.developer = developer;
       this.developinglanguages = developinglanguages;
    }
   
    public Integer getIdDeveloperHasLanguages() {
        return this.idDeveloperHasLanguages;
    }
    
    public void setIdDeveloperHasLanguages(Integer idDeveloperHasLanguages) {
        this.idDeveloperHasLanguages = idDeveloperHasLanguages;
    }
    public Developer getDeveloper() {
        return this.developer;
    }
    
    public void setDeveloper(Developer developer) {
        this.developer = developer;
    }
    public Developinglanguages getDevelopinglanguages() {
        return this.developinglanguages;
    }
    
    public void setDevelopinglanguages(Developinglanguages developinglanguages) {
        this.developinglanguages = developinglanguages;
    }




}



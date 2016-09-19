package Entities;
// Generated Sep 9, 2016 6:59:56 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Emailvarified generated by hbm2java
 */
public class Emailvarified  implements java.io.Serializable {


     private Integer id;
     private String email;
     private String token;
     private Boolean state;
     private Date emailvarifiedDate;
     private Set<Staff> staffs = new HashSet<Staff>(0);
     private Set<Developer> developers = new HashSet<Developer>(0);
     private Set<Customer> customers = new HashSet<Customer>(0);

    public Emailvarified() {
    }

	
    public Emailvarified(String email, String token) {
        this.email = email;
        this.token = token;
    }
    public Emailvarified(String email, String token, Boolean state, Date emailvarifiedDate, Set<Staff> staffs, Set<Developer> developers, Set<Customer> customers) {
       this.email = email;
       this.token = token;
       this.state = state;
       this.emailvarifiedDate = emailvarifiedDate;
       this.staffs = staffs;
       this.developers = developers;
       this.customers = customers;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public String getToken() {
        return this.token;
    }
    
    public void setToken(String token) {
        this.token = token;
    }
    public Boolean getState() {
        return this.state;
    }
    
    public void setState(Boolean state) {
        this.state = state;
    }
    public Date getEmailvarifiedDate() {
        return this.emailvarifiedDate;
    }
    
    public void setEmailvarifiedDate(Date emailvarifiedDate) {
        this.emailvarifiedDate = emailvarifiedDate;
    }
    public Set<Staff> getStaffs() {
        return this.staffs;
    }
    
    public void setStaffs(Set<Staff> staffs) {
        this.staffs = staffs;
    }
    public Set<Developer> getDevelopers() {
        return this.developers;
    }
    
    public void setDevelopers(Set<Developer> developers) {
        this.developers = developers;
    }
    public Set<Customer> getCustomers() {
        return this.customers;
    }
    
    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }




}



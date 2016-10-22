package Entities;
// Generated Oct 22, 2016 1:21:43 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Developer generated by hbm2java
 */
public class Developer  implements java.io.Serializable {


     private Integer idDeveloper;
     private City city;
     private Emailvarified emailvarified;
     private Gender gender;
     private String username;
     private String developerFname;
     private String developerMname;
     private String developerLname;
     private String password;
     private String developerPhone;
     private String developerMobile;
     private String address;
     private boolean state;
     private Date developerRegdate;
     private String developerImage;
     private int developercreditcartNo;
     private Set<Commenthasreply> commenthasreplies = new HashSet<Commenthasreply>(0);
     private Set<Delopercokie> delopercokies = new HashSet<Delopercokie>(0);
     private Set<Application> applications = new HashSet<Application>(0);
     private Set<Developerhaslanguages> developerhaslanguageses = new HashSet<Developerhaslanguages>(0);
     private Set<Developervalid> developervalids = new HashSet<Developervalid>(0);

    public Developer() {
    }

	
    public Developer(City city, Gender gender, String username, String developerFname, String password, String address, boolean state, Date developerRegdate, int developercreditcartNo) {
        this.city = city;
        this.gender = gender;
        this.username = username;
        this.developerFname = developerFname;
        this.password = password;
        this.address = address;
        this.state = state;
        this.developerRegdate = developerRegdate;
        this.developercreditcartNo = developercreditcartNo;
    }
    public Developer(City city, Emailvarified emailvarified, Gender gender, String username, String developerFname, String developerMname, String developerLname, String password, String developerPhone, String developerMobile, String address, boolean state, Date developerRegdate, String developerImage, int developercreditcartNo, Set<Commenthasreply> commenthasreplies, Set<Delopercokie> delopercokies, Set<Application> applications, Set<Developerhaslanguages> developerhaslanguageses, Set<Developervalid> developervalids) {
       this.city = city;
       this.emailvarified = emailvarified;
       this.gender = gender;
       this.username = username;
       this.developerFname = developerFname;
       this.developerMname = developerMname;
       this.developerLname = developerLname;
       this.password = password;
       this.developerPhone = developerPhone;
       this.developerMobile = developerMobile;
       this.address = address;
       this.state = state;
       this.developerRegdate = developerRegdate;
       this.developerImage = developerImage;
       this.developercreditcartNo = developercreditcartNo;
       this.commenthasreplies = commenthasreplies;
       this.delopercokies = delopercokies;
       this.applications = applications;
       this.developerhaslanguageses = developerhaslanguageses;
       this.developervalids = developervalids;
    }
   
    public Integer getIdDeveloper() {
        return this.idDeveloper;
    }
    
    public void setIdDeveloper(Integer idDeveloper) {
        this.idDeveloper = idDeveloper;
    }
    public City getCity() {
        return this.city;
    }
    
    public void setCity(City city) {
        this.city = city;
    }
    public Emailvarified getEmailvarified() {
        return this.emailvarified;
    }
    
    public void setEmailvarified(Emailvarified emailvarified) {
        this.emailvarified = emailvarified;
    }
    public Gender getGender() {
        return this.gender;
    }
    
    public void setGender(Gender gender) {
        this.gender = gender;
    }
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    public String getDeveloperFname() {
        return this.developerFname;
    }
    
    public void setDeveloperFname(String developerFname) {
        this.developerFname = developerFname;
    }
    public String getDeveloperMname() {
        return this.developerMname;
    }
    
    public void setDeveloperMname(String developerMname) {
        this.developerMname = developerMname;
    }
    public String getDeveloperLname() {
        return this.developerLname;
    }
    
    public void setDeveloperLname(String developerLname) {
        this.developerLname = developerLname;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public String getDeveloperPhone() {
        return this.developerPhone;
    }
    
    public void setDeveloperPhone(String developerPhone) {
        this.developerPhone = developerPhone;
    }
    public String getDeveloperMobile() {
        return this.developerMobile;
    }
    
    public void setDeveloperMobile(String developerMobile) {
        this.developerMobile = developerMobile;
    }
    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    public boolean isState() {
        return this.state;
    }
    
    public void setState(boolean state) {
        this.state = state;
    }
    public Date getDeveloperRegdate() {
        return this.developerRegdate;
    }
    
    public void setDeveloperRegdate(Date developerRegdate) {
        this.developerRegdate = developerRegdate;
    }
    public String getDeveloperImage() {
        return this.developerImage;
    }
    
    public void setDeveloperImage(String developerImage) {
        this.developerImage = developerImage;
    }
    public int getDevelopercreditcartNo() {
        return this.developercreditcartNo;
    }
    
    public void setDevelopercreditcartNo(int developercreditcartNo) {
        this.developercreditcartNo = developercreditcartNo;
    }
    public Set<Commenthasreply> getCommenthasreplies() {
        return this.commenthasreplies;
    }
    
    public void setCommenthasreplies(Set<Commenthasreply> commenthasreplies) {
        this.commenthasreplies = commenthasreplies;
    }
    public Set<Delopercokie> getDelopercokies() {
        return this.delopercokies;
    }
    
    public void setDelopercokies(Set<Delopercokie> delopercokies) {
        this.delopercokies = delopercokies;
    }
    public Set<Application> getApplications() {
        return this.applications;
    }
    
    public void setApplications(Set<Application> applications) {
        this.applications = applications;
    }
    public Set<Developerhaslanguages> getDeveloperhaslanguageses() {
        return this.developerhaslanguageses;
    }
    
    public void setDeveloperhaslanguageses(Set<Developerhaslanguages> developerhaslanguageses) {
        this.developerhaslanguageses = developerhaslanguageses;
    }
    public Set<Developervalid> getDevelopervalids() {
        return this.developervalids;
    }
    
    public void setDevelopervalids(Set<Developervalid> developervalids) {
        this.developervalids = developervalids;
    }




}



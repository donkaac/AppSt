package Entities;
// Generated Oct 22, 2016 1:21:43 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Application generated by hbm2java
 */
public class Application  implements java.io.Serializable {


     private Integer idApplication;
     private Category category;
     private Developer developer;
     private String applicationName;
     private double price;
     private String description;
     private String userManualUrl;
     private String videoUrl;
     private String interface1;
     private String interface2;
     private String interface3;
     private Date lastmodifiedDate;
     private Date applicationLuanchDate;
     private boolean state;
     private String appurl;
     private String appImage;
     private Set<Customerhasapplication> customerhasapplications = new HashSet<Customerhasapplication>(0);
     private Set<Serialkeys> serialkeyses = new HashSet<Serialkeys>(0);
     private Set<Wishlist> wishlists = new HashSet<Wishlist>(0);
     private Set<Comment> comments = new HashSet<Comment>(0);
     private Set<Cart> carts = new HashSet<Cart>(0);
     private Set<Apphasstaffvalid> apphasstaffvalids = new HashSet<Apphasstaffvalid>(0);

    public Application() {
    }

	
    public Application(Category category, Developer developer, String applicationName, double price, String description, String interface1, String interface2, String interface3, Date applicationLuanchDate, boolean state, String appurl, String appImage) {
        this.category = category;
        this.developer = developer;
        this.applicationName = applicationName;
        this.price = price;
        this.description = description;
        this.interface1 = interface1;
        this.interface2 = interface2;
        this.interface3 = interface3;
        this.applicationLuanchDate = applicationLuanchDate;
        this.state = state;
        this.appurl = appurl;
        this.appImage = appImage;
    }
    public Application(Category category, Developer developer, String applicationName, double price, String description, String userManualUrl, String videoUrl, String interface1, String interface2, String interface3, Date lastmodifiedDate, Date applicationLuanchDate, boolean state, String appurl, String appImage, Set<Customerhasapplication> customerhasapplications, Set<Serialkeys> serialkeyses, Set<Wishlist> wishlists, Set<Comment> comments, Set<Cart> carts, Set<Apphasstaffvalid> apphasstaffvalids) {
       this.category = category;
       this.developer = developer;
       this.applicationName = applicationName;
       this.price = price;
       this.description = description;
       this.userManualUrl = userManualUrl;
       this.videoUrl = videoUrl;
       this.interface1 = interface1;
       this.interface2 = interface2;
       this.interface3 = interface3;
       this.lastmodifiedDate = lastmodifiedDate;
       this.applicationLuanchDate = applicationLuanchDate;
       this.state = state;
       this.appurl = appurl;
       this.appImage = appImage;
       this.customerhasapplications = customerhasapplications;
       this.serialkeyses = serialkeyses;
       this.wishlists = wishlists;
       this.comments = comments;
       this.carts = carts;
       this.apphasstaffvalids = apphasstaffvalids;
    }
   
    public Integer getIdApplication() {
        return this.idApplication;
    }
    
    public void setIdApplication(Integer idApplication) {
        this.idApplication = idApplication;
    }
    public Category getCategory() {
        return this.category;
    }
    
    public void setCategory(Category category) {
        this.category = category;
    }
    public Developer getDeveloper() {
        return this.developer;
    }
    
    public void setDeveloper(Developer developer) {
        this.developer = developer;
    }
    public String getApplicationName() {
        return this.applicationName;
    }
    
    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }
    public double getPrice() {
        return this.price;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    public String getUserManualUrl() {
        return this.userManualUrl;
    }
    
    public void setUserManualUrl(String userManualUrl) {
        this.userManualUrl = userManualUrl;
    }
    public String getVideoUrl() {
        return this.videoUrl;
    }
    
    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }
    public String getInterface1() {
        return this.interface1;
    }
    
    public void setInterface1(String interface1) {
        this.interface1 = interface1;
    }
    public String getInterface2() {
        return this.interface2;
    }
    
    public void setInterface2(String interface2) {
        this.interface2 = interface2;
    }
    public String getInterface3() {
        return this.interface3;
    }
    
    public void setInterface3(String interface3) {
        this.interface3 = interface3;
    }
    public Date getLastmodifiedDate() {
        return this.lastmodifiedDate;
    }
    
    public void setLastmodifiedDate(Date lastmodifiedDate) {
        this.lastmodifiedDate = lastmodifiedDate;
    }
    public Date getApplicationLuanchDate() {
        return this.applicationLuanchDate;
    }
    
    public void setApplicationLuanchDate(Date applicationLuanchDate) {
        this.applicationLuanchDate = applicationLuanchDate;
    }
    public boolean isState() {
        return this.state;
    }
    
    public void setState(boolean state) {
        this.state = state;
    }
    public String getAppurl() {
        return this.appurl;
    }
    
    public void setAppurl(String appurl) {
        this.appurl = appurl;
    }
    public String getAppImage() {
        return this.appImage;
    }
    
    public void setAppImage(String appImage) {
        this.appImage = appImage;
    }
    public Set<Customerhasapplication> getCustomerhasapplications() {
        return this.customerhasapplications;
    }
    
    public void setCustomerhasapplications(Set<Customerhasapplication> customerhasapplications) {
        this.customerhasapplications = customerhasapplications;
    }
    public Set<Serialkeys> getSerialkeyses() {
        return this.serialkeyses;
    }
    
    public void setSerialkeyses(Set<Serialkeys> serialkeyses) {
        this.serialkeyses = serialkeyses;
    }
    public Set<Wishlist> getWishlists() {
        return this.wishlists;
    }
    
    public void setWishlists(Set<Wishlist> wishlists) {
        this.wishlists = wishlists;
    }
    public Set<Comment> getComments() {
        return this.comments;
    }
    
    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }
    public Set<Cart> getCarts() {
        return this.carts;
    }
    
    public void setCarts(Set<Cart> carts) {
        this.carts = carts;
    }
    public Set<Apphasstaffvalid> getApphasstaffvalids() {
        return this.apphasstaffvalids;
    }
    
    public void setApphasstaffvalids(Set<Apphasstaffvalid> apphasstaffvalids) {
        this.apphasstaffvalids = apphasstaffvalids;
    }




}



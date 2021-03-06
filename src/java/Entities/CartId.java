package Entities;
// Generated Oct 22, 2016 1:21:43 PM by Hibernate Tools 4.3.1



/**
 * CartId generated by hbm2java
 */
public class CartId  implements java.io.Serializable {


     private int customerIdCustomer;
     private int applicationIdApplication;

    public CartId() {
    }

    public CartId(int customerIdCustomer, int applicationIdApplication) {
       this.customerIdCustomer = customerIdCustomer;
       this.applicationIdApplication = applicationIdApplication;
    }
   
    public int getCustomerIdCustomer() {
        return this.customerIdCustomer;
    }
    
    public void setCustomerIdCustomer(int customerIdCustomer) {
        this.customerIdCustomer = customerIdCustomer;
    }
    public int getApplicationIdApplication() {
        return this.applicationIdApplication;
    }
    
    public void setApplicationIdApplication(int applicationIdApplication) {
        this.applicationIdApplication = applicationIdApplication;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof CartId) ) return false;
		 CartId castOther = ( CartId ) other; 
         
		 return (this.getCustomerIdCustomer()==castOther.getCustomerIdCustomer())
 && (this.getApplicationIdApplication()==castOther.getApplicationIdApplication());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getCustomerIdCustomer();
         result = 37 * result + this.getApplicationIdApplication();
         return result;
   }   


}



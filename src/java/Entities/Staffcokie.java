package Entities;
// Generated Oct 19, 2016 3:46:26 PM by Hibernate Tools 4.3.1



/**
 * Staffcokie generated by hbm2java
 */
public class Staffcokie  implements java.io.Serializable {


     private Integer idStaffCokie;
     private Staff staff;
     private String staffCokiecol;

    public Staffcokie() {
    }

    public Staffcokie(Staff staff, String staffCokiecol) {
       this.staff = staff;
       this.staffCokiecol = staffCokiecol;
    }
   
    public Integer getIdStaffCokie() {
        return this.idStaffCokie;
    }
    
    public void setIdStaffCokie(Integer idStaffCokie) {
        this.idStaffCokie = idStaffCokie;
    }
    public Staff getStaff() {
        return this.staff;
    }
    
    public void setStaff(Staff staff) {
        this.staff = staff;
    }
    public String getStaffCokiecol() {
        return this.staffCokiecol;
    }
    
    public void setStaffCokiecol(String staffCokiecol) {
        this.staffCokiecol = staffCokiecol;
    }




}



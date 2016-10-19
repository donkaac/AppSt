package Entities;
// Generated Oct 19, 2016 3:46:26 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Submenu generated by hbm2java
 */
public class Submenu  implements java.io.Serializable {


     private int idsubmenu;
     private Menu menu;
     private String submenu;
     private String pageurl;
     private Set<Rolehassubmenu> rolehassubmenus = new HashSet<Rolehassubmenu>(0);

    public Submenu() {
    }

	
    public Submenu(int idsubmenu, Menu menu, String submenu) {
        this.idsubmenu = idsubmenu;
        this.menu = menu;
        this.submenu = submenu;
    }
    public Submenu(int idsubmenu, Menu menu, String submenu, String pageurl, Set<Rolehassubmenu> rolehassubmenus) {
       this.idsubmenu = idsubmenu;
       this.menu = menu;
       this.submenu = submenu;
       this.pageurl = pageurl;
       this.rolehassubmenus = rolehassubmenus;
    }
   
    public int getIdsubmenu() {
        return this.idsubmenu;
    }
    
    public void setIdsubmenu(int idsubmenu) {
        this.idsubmenu = idsubmenu;
    }
    public Menu getMenu() {
        return this.menu;
    }
    
    public void setMenu(Menu menu) {
        this.menu = menu;
    }
    public String getSubmenu() {
        return this.submenu;
    }
    
    public void setSubmenu(String submenu) {
        this.submenu = submenu;
    }
    public String getPageurl() {
        return this.pageurl;
    }
    
    public void setPageurl(String pageurl) {
        this.pageurl = pageurl;
    }
    public Set<Rolehassubmenu> getRolehassubmenus() {
        return this.rolehassubmenus;
    }
    
    public void setRolehassubmenus(Set<Rolehassubmenu> rolehassubmenus) {
        this.rolehassubmenus = rolehassubmenus;
    }




}



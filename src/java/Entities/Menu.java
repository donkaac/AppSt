package Entities;
// Generated Oct 2, 2016 12:23:07 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Menu generated by hbm2java
 */
public class Menu  implements java.io.Serializable {


     private Integer idmenu;
     private String menu;
     private Set<Submenu> submenus = new HashSet<Submenu>(0);

    public Menu() {
    }

	
    public Menu(String menu) {
        this.menu = menu;
    }
    public Menu(String menu, Set<Submenu> submenus) {
       this.menu = menu;
       this.submenus = submenus;
    }
   
    public Integer getIdmenu() {
        return this.idmenu;
    }
    
    public void setIdmenu(Integer idmenu) {
        this.idmenu = idmenu;
    }
    public String getMenu() {
        return this.menu;
    }
    
    public void setMenu(String menu) {
        this.menu = menu;
    }
    public Set<Submenu> getSubmenus() {
        return this.submenus;
    }
    
    public void setSubmenus(Set<Submenu> submenus) {
        this.submenus = submenus;
    }




}



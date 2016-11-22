/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Oparation;

import Entities.Application;
import java.util.ArrayList;
import sun.nio.cs.ext.GB18030;

/**
 *
 * @author Ish
 */
public class GetTopSellApps {
GetTopSellApps getTopSellApps;
    private GetTopSellApps GetTopSellApps() {
        if(getTopSellApps.equals(null)){
            getTopSellApps=new GetTopSellApps();
        }
        return getTopSellApps;
    }
    
     public static Application [] getTopSellingApps() {
          Application [] topsellapp=new Application[10];
          try{
        ArrayList ar = Datacontroller.DataParser.Searchdata(new Application());
        int Max1 = 0, Max2 = 0, Max3 = 0, Max4 = 0, Max5 = 0, Max6 = 0, Max7 = 0, Max8 = 0, Max9 = 0, Max10 = 0;
      
        for (Object object : ar) {
            Application ap = (Application) object;

            if (Max1 < ap.getCustomerhasapplications().size()) {
                Max1 = ap.getIdApplication();
                topsellapp[0]=ap;
            } else if (Max2 < ap.getCustomerhasapplications().size()) {
                Max2 = ap.getIdApplication();
                topsellapp[1]=ap;
            } else if (Max3 < ap.getCustomerhasapplications().size()) {
                Max3 = ap.getIdApplication();
                topsellapp[2]=ap;
            } else if (Max4 < ap.getCustomerhasapplications().size()) {
                Max4 = ap.getIdApplication();
                topsellapp[3]=ap;
            } else if (Max5 < ap.getCustomerhasapplications().size()) {
                Max5 = ap.getIdApplication();
                topsellapp[4]=ap;
            } else if (Max6 < ap.getCustomerhasapplications().size()) {
                Max6 = ap.getIdApplication();
                topsellapp[5]=ap;
            } else if (Max7 < ap.getCustomerhasapplications().size()) {
                Max7 = ap.getIdApplication();
                topsellapp[6]=ap;
            } else if (Max8 < ap.getCustomerhasapplications().size()) {
                Max8 = ap.getIdApplication();
                topsellapp[7]=ap;
            } else if (Max9 < ap.getCustomerhasapplications().size()) {
                Max9 = ap.getIdApplication();
                topsellapp[8]=ap;
            } else if (Max10 < ap.getCustomerhasapplications().size()) {
                Max10 = ap.getIdApplication();
                topsellapp[9]=ap;
            }

        }
        
        
       
          }catch(NullPointerException e){
              System.out.println("All List Cout :"+topsellapp.length);
          }
        return topsellapp;
    }
}

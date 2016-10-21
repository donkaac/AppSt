/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Oparation;
import Entities.Application;
import Entities.Customerhasapplication;
import java.util.Set;

/**
 *
 * @author Ish
 */
public class getRates {
public static getRates getRates;
    private getRates() {
        if(getRates.equals(null))
            getRates=new getRates();
    }
    public static void main(String[] args) {
        System.out.println(getRate(8));
    }
    public static int getRate(int appid){
    Application uniqeresault = (Application) Datacontroller.DataParser.getuniqeresault(new Application(), appid);
    Set<Customerhasapplication> customerhasapplications = uniqeresault.getCustomerhasapplications();
    double totalrate=0;
    int rateqty=0;
        for (Customerhasapplication customerhasapplication : customerhasapplications) {
            totalrate+=customerhasapplication.getRate();
            rateqty++;
        }
  int rate=(int) (totalrate/rateqty);
        return rate;
    }
}
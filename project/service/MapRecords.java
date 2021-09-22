package edu.citytech.cst.project.service;

import com.google.gson.Gson;
import edu.citytech.cst.project.record.CustomerPurchase;
import edu.citytech.cst.project.record.Location;
import edu.citytech.cst.project.record.ShortDate;

public class MapRecords {

    private static Gson gson = new Gson();
    public static CustomerPurchase mapToJSON (String json){

        CustomerPurchase cp = gson.fromJson(json, CustomerPurchase.class);

        return cp;


    }
    public static CustomerPurchase mapToText (String row){
        String [] columns = row.split("\\|");

        int _id =Integer.parseInt(columns[0]);
        String customerId = columns[1];
        int totalItems = Integer.parseInt(columns[2]);
        float totalPrice = Float.parseFloat(columns[3]);
        String dateParts [] = columns[4].split("\\.");
        int year = Integer.parseInt(dateParts[0]);
        int month = Integer.parseInt(dateParts[1]);
        int day = Integer.parseInt(dateParts[2]);
        var shortDate = new ShortDate(year,month,day);
        var location = new Location(columns[5]);




        var customerPurchases = new CustomerPurchase(_id,customerId,totalItems,totalPrice,shortDate,location);
        return customerPurchases;
    }

}

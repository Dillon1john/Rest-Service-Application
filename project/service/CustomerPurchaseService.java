package edu.citytech.cst.project.service;


import edu.citytech.cst.project.record.CustomerPurchase;
import edu.citytech.cst.project.utility.FormatUtility;
import edu.citytech.cst.project.utility.ResourceUtility;

import java.util.*;

public class CustomerPurchaseService {

//    static List<CustomerPurchase> textList = ResourceUtility
//            .get("files/2020.Purchases.txt",1,MapRecords::mapToText);

    static List<CustomerPurchase> jsonList1 = ResourceUtility
            .get("files/E01.json",0,MapRecords::mapToJSON);

    static List<CustomerPurchase> jsonList2 = ResourceUtility
            .get("files/E02.json",0,MapRecords::mapToJSON);

    static List<CustomerPurchase> jsonList3 = ResourceUtility
            .get("files/E03.json",0,MapRecords::mapToJSON);

static String modeOutput = "";
    public static List<CustomerPurchase> modeSelection(String mode) {

        List<CustomerPurchase> answer = new ArrayList<>();

        mode = mode.toLowerCase();
        modeOutput = mode;

        if (mode.equalsIgnoreCase("e01"))  {
            answer.addAll(jsonList1);

        }
        else if (mode.equalsIgnoreCase("e02")){
            answer.addAll(jsonList2);

        }
        else if (mode.equalsIgnoreCase("e03")){
            answer.addAll(jsonList3);
        }
        else if (mode.equalsIgnoreCase("merge")){
            answer.addAll(jsonList1);
            answer.addAll(jsonList2);
            answer.addAll(jsonList3);

        }
        return answer;
    }




    public static Map<String,Object> task(String mode, String task){
//        var rule = TaskRule.map.getOrDefault(task,e->true);
        var function =
                TaskRule.tasks.getOrDefault(task, e->1.0);

//        var max = modeSelection(mode).stream().mapToDouble(CustomerPurchase::totalPrice).max().getAsDouble();
        List<CustomerPurchase> data = modeSelection(mode);
        Number value = function.apply(data);



        Map<String,Object> map = new HashMap<>();



//        var value = modeSelection(mode).stream().filter(rule)
//                .mapToDouble(mapNumber).sum();


        map.put(mode,task);
        map.put("value",value);
        map.put("value-formatted", FormatUtility.customFormat("#,###,###,###.00",value));
        map.put("Big-O", 0);
        return map;

    }

}

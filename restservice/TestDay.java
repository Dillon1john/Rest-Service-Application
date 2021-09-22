package edu.citytech.cst.project.restservice;

import edu.citytech.cst.project.record.ShortDate;
import edu.citytech.cst.project.service.TaskRule;
import edu.citytech.cst.project.webcontroller.CustomerPurchasesWebController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDay {

    @Test
    @DisplayName("Test March 19, 2021")
    void t1(){
        ShortDate shortDate = new ShortDate(2021,03,20);
        var actual = TaskRule.isDay(shortDate,"saturday");
        var expected = true;

        assertEquals(expected,actual);
    }

    @Test
    void t2(){
        System.out.println("Test code: ");
//        TaskRule.taskPriceMax("json");

        //TaskRule.totalItemsonMonths(e)

        CustomerPurchasesWebController curr = new CustomerPurchasesWebController();
        System.out.println(curr.getData("e01","t2"));
    }


}


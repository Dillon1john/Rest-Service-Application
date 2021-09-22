package edu.citytech.cst.project.service;

import edu.citytech.cst.project.record.CustomerPurchase;
import edu.citytech.cst.project.record.ShortDate;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;

import static java.time.DayOfWeek.FRIDAY;
import static java.time.DayOfWeek.TUESDAY;
import static java.time.Month.*;
import static java.util.Arrays.asList;

public class TaskRule {

//    static Map<String, Predicate<CustomerPurchase>> map = new HashMap<>();

//    static Map<String, ToDoubleFunction<CustomerPurchase>> mapNumber = new HashMap<>();

    static Map<String, Function<List<CustomerPurchase>, Number>> tasks = new HashMap<>();

    // 1. How many transactions (row count)  are in the file? Each row in the file represents one transaction.
    // 2. How many transactions (row count) occurred in location C?
    // 3. How many transactions (row count) occurred in location B?
    // 4. How many transactions (row count) occurred on a Tuesday?
    // 5. How much money was made? See field totalPrice.
    // 6. How many money (totalPrice) was made on a Friday?
    // 7. How many items where purchased (totalItems) ?
    // 8. How many items where purchased (totalItems)  in the month of Dec, Jan, and Nov ?
    // 9. How many transactions (row count) occurred in the year 2012?
    // 10. The totalPrice made on  the Friday, Saturday, and Sunday?
    // 11. What is the most amount of money spent (use totalPrice field)



    static {
        tasks.put("t1", TaskRule::countRows);
        tasks.put("t2", purchases -> purchases.stream().filter(e->e.location().code().equalsIgnoreCase("C")).count());
        tasks.put("t3", purchases -> purchases.stream().filter(e->e.location().code().equalsIgnoreCase("B")).count());
        tasks.put("t4", purchases -> purchases.stream().filter(e->toLocalDate(e.shortDate()).getDayOfWeek() == TUESDAY).count());
        tasks.put("t5", TaskRule::getPrice);
        tasks.put("t6", TaskRule::totalPriceOnFriday);
        tasks.put("t7", TaskRule::getItems);
        tasks.put("t8", TaskRule::totalItemsonMonths);
        tasks.put("t9", purchases -> purchases.stream().filter(e->toLocalDate(e.shortDate()).getYear() == 2012).count());
        tasks.put("t10", TaskRule::totalPriceOnDays);
        tasks.put("t11", TaskRule::maxPrice);

    }

    public static Integer countRows(List<CustomerPurchase> purchases) {
        return purchases.size();
    }

//    public static Predicate filterByLocation(CustomerPurchase purchase, String location){
//        return (purchase) -> purchase.lo;
//    }

    public static Double getItems(List<CustomerPurchase> purchases){
        return purchases.stream().mapToDouble(CustomerPurchase::totalItems).sum();
    }

    public static Double getPrice(List<CustomerPurchase> purchases){

        return purchases.stream().mapToDouble(CustomerPurchase::totalPrice).sum();
    }


    public  static Double maxPrice (List<CustomerPurchase> purchases){
        return purchases.stream().mapToDouble(CustomerPurchase::totalPrice).max().getAsDouble();
    }



    public static boolean compareYear(CustomerPurchase e, int year) {

        boolean pass = false;
        if (e.shortDate().year() == year) {
            pass = true;
        }
        return pass;
    }


    public static double totalItemsonMonths(List<CustomerPurchase> purchases) {
       return purchases.stream()
               .filter(e -> asList(JANUARY, NOVEMBER, DECEMBER).contains(toLocalDate(e.shortDate()).getMonth()))
               .mapToDouble(CustomerPurchase::totalItems).sum();
    }

//    public static boolean isMonths(ShortDate shortDate, int month1, int month2, int month3) {
//        boolean pass = false;
//        if (shortDate.month() == month1 || shortDate.month() == month2
//                || shortDate.month() == month3) {
//            pass = true;
//        }
//        return pass;
//    }

    public static Double totalPriceOnFriday(List<CustomerPurchase> purchases) {
        return purchases.stream()
                .filter(e -> toLocalDate(e.shortDate()).getDayOfWeek() == FRIDAY)
                .mapToDouble(CustomerPurchase::totalPrice).sum();
    }

//    public Float givePrice(CustomerPurchase e) {
//        return e.totalPrice();
//    }

    public static LocalDate toLocalDate(ShortDate shortDate) {
        return LocalDate.of(shortDate.year(), shortDate.month(), shortDate.day());
    }

    public static boolean isDay(ShortDate shortDate, String day) {
        var date = LocalDate.of(shortDate.year(), shortDate.month(), shortDate.day());
        var status = (date.getDayOfWeek().name().equalsIgnoreCase(day));
        return status;
    }

    public static boolean isDays(ShortDate shortDate, String day1, String day2, String day3) {
        var date = LocalDate.of(shortDate.year(), shortDate.month(), shortDate.day());
        var status = (date.getDayOfWeek().name().equalsIgnoreCase(day1) || date.getDayOfWeek().name().equalsIgnoreCase(day2) || date.getDayOfWeek().name().equalsIgnoreCase(day3));
        return status;
    }

    public static double totalPriceOnDays(List<CustomerPurchase> purchases) {


       return purchases.stream().filter(e -> isDays(e.shortDate(), "Friday", "Saturday", "Sunday")).mapToDouble(CustomerPurchase::totalPrice).sum();


    }
}

//        if (isDays(e.shortDate(),"Friday","Saturday","Sunday")){
//            e.totalPrice();
//        }
//        return e.totalPrice();



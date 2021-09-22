package edu.citytech.cst.project.record;

public record CustomerPurchase(int _id, String customerId, int totalItems, float totalPrice, ShortDate shortDate, Location location) {

}

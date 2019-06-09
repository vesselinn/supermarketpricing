package com.vpetkov.policyexpert.marketpricing;

import com.vpetkov.policyexpert.marketpricing.cashier.Cashier;
import com.vpetkov.policyexpert.marketpricing.goods.Product;
import com.vpetkov.policyexpert.marketpricing.goods.ProductFactory;

import java.util.Arrays;

public class Application {

    public static void main(String [] args) {

        if (args == null || args.length == 0) {
            throw new IllegalArgumentException("Please provide at least one product");
        }

        Cashier cashier = new Cashier();

        Arrays.asList(args).stream().forEach(line -> {
            String[] condition = line.split(":");
            Product product = ProductFactory.getProduct(condition[0], condition[1]);
            cashier.add(product);
        });

        cashier.print();

    }

}

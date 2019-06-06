package com.vpetkov.policyexpert.marketpricing;

import com.vpetkov.policyexpert.marketpricing.cashier.Cashier;
import com.vpetkov.policyexpert.marketpricing.goods.Product;
import com.vpetkov.policyexpert.marketpricing.goods.ProductFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Application {

    public static void main(String [] args) {

        if (args == null || args.length == 0) {
            throw new IllegalArgumentException("File with products is not provided");
        }

        String fileName = args[0];
        Cashier cashier = new Cashier();

        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            stream.forEach(line -> {
                String[] condition = line.split(":");
                Product product = ProductFactory.getProduct(condition[0], condition[1]);
                cashier.add(product);
            });

            cashier.print();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

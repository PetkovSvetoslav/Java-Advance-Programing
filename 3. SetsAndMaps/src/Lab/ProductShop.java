package Lab;

import java.util.*;

public class ProductShop {
    private static class Product {
        String name;
        double price;

        Product(String name, double price) {
            this.name = name;
            this.price = price;
        }

        private String getName() {
            return this.name;
        }

        private double getPrice() {
            return this.price;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<Product>> shops = new TreeMap<>();

        String input;
        while (!"Revision".equals(input = scanner.nextLine())) {
            String[] tokens = input.split(",\\s+");
            String shopName = tokens[0];
            String productName = tokens[1];
            double price = Double.parseDouble(tokens[2]);

            List<Product> productsList = shops.get(shopName);
            if (productsList == null) {
                productsList = new ArrayList<>();
            }
            Product p = new Product(productName, price);
            productsList.add(p);
            shops.put(shopName, productsList);
        }

        shops.forEach((key, value) -> {
            System.out.println(key + "->");
            value.forEach(p -> System.out.printf("Product: %s, Price: %.1f%n"
                    , p.getName(), p.getPrice()));
        });
    }
}

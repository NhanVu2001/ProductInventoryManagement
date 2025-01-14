import java.util.*;

public static void main(String[] args) {
    List<Product> products = new ArrayList<>();
    products.add(new Product("Laptop", 999.99, 5));
    products.add(new Product("Smartphone", 499.99, 10));
    products.add(new Product("Tablet", 299.99, 0));
    products.add(new Product("Smartwatch", 199.99, 3));

    double totalValue = totalValue(products);
    String mostExpensiveOutput = String.format("Most Expensive Product: %s", mostExpensive(products));
    Boolean productExists = productExists("Headphones", products);

    // Print answers
    String totalValueOutput = String.format("Total Inventory Value: $%.2f", totalValue);
    System.out.println(totalValueOutput);
    System.out.println(mostExpensiveOutput);
    System.out.println(productExists);
    System.out.println();
    //Example of sort by ascending price, change values accordingly
    sortProducts(products, "price", "asc");
    System.out.println("Products sorted by price (ascending):");
    for (Product product : products) {
        System.out.println(product);
    }
}


// Function to calculate total inventory value
public static double totalValue(List<Product> products) {
    double total = 0.0;
    for (Product product : products) {
        total += product.getPrice() * product.getQuantity();
    }
    return total;
}

// Function to find most expensive product
public static String mostExpensive(List<Product> products) {
    Product mostExpensive = products.getFirst();
    for (Product product : products) {
        if (product.getPrice() > mostExpensive.getPrice()) {
            mostExpensive = product;
        }
    }
    return mostExpensive.getName();
}

public static boolean productExists(String productName, List<Product> products) {
    for (Product product : products) {
        if (product.getName().equalsIgnoreCase(productName)) {
            return true;
        }
    }
    return false;
}

public static void sortProducts(List<Product> products, String sortBy, String order) {
    Comparator<Product> comparator = null;

    // Decide which attribute to sort by
    if ("price".equalsIgnoreCase(sortBy)) {
        comparator = Comparator.comparing(Product::getPrice); // Sort by price
    } else if ("quantity".equalsIgnoreCase(sortBy)) {
        comparator = Comparator.comparing(Product::getQuantity); // Sort by quantity
    }
    if ("desc".equalsIgnoreCase(order)) {
        assert comparator != null;
        comparator = comparator.reversed();
    }
    products.sort(comparator);
}

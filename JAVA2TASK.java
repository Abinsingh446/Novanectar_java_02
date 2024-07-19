
import java.util.ArrayList;
import java.util.List;

public class InvoiceGenerator {

    public static void main(String[] args) {
        // Create a list of products
        List<Product> products = new ArrayList<>();
        products.add(new Product("Product 1", 20.0, 2));
        products.add(new Product("Product 2", 15.0, 3));
        products.add(new Product("Product 3", 10.0, 1));

        // Create an invoice
        Invoice invoice = new Invoice(products);

        // Generate the invoice
        String generatedInvoice = invoice.generateInvoice();

        // Print the invoice
        System.out.println(generatedInvoice);
    }
}

class Product {
    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}

class Invoice {
    private List<Product> products;

    public Invoice(List<Product> products) {
        this.products = products;
    }

    public String generateInvoice() {
        StringBuilder invoice = new StringBuilder();
        invoice.append("Invoice\n");
        invoice.append("---------\n");

        for (Product product : products) {
            invoice.append(product.getName()).append(" x ").append(product.getQuantity()).append(" = ").append(product.getPrice() * product.getQuantity()).append("\n");
        }

        invoice.append("Total: ").append(calculateTotal());

        return invoice.toString();
    }

    private double calculateTotal() {
        return products.stream().mapToDouble(product -> product.getPrice() * product.getQuantity()).sum();
    }
}
package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);

        System.out.println("Entre client data: ");
        System.out.print("Name: ");
        String name = sc.nextLine();    
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Birth date (DD/MM/YYYY): ");
        Date birthDate = sdf.parse(sc.next());

        System.out.println("Enter order data:");
        System.out.print("Status: ");
        OrderStatus os = OrderStatus.valueOf(sc.next());
        System.out.print("How many items to this order? ");
        int n = sc.nextInt();
        Date moment = new Date();
        Order order = new Order(moment, os, new Client(name, email, birthDate) );
        
        for (int i = 1; i <= n; i++){
            sc.nextLine();
            System.out.println("Enter #" + i + " item data");
            System.out.print("Product name: ");
            String productName = sc.nextLine();
            System.out.print("Product price: ");
            Double productPrice = sc.nextDouble();
            System.out.print("Quantity: ");
            int quantity = sc.nextInt();
            
            order.addItem(new OrderItem(quantity, new Product(productName, productPrice)));
        }

        System.out.println();
        System.out.println(order);


        sc.close();
    }

}

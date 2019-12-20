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

		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
		// -------------------------------------------------------------------- >
		System.out.println("Enter client data: ");
		System.out.print("Name: ");
		String clientName = sc.nextLine();
		System.out.print("Email: ");
		String clientEmail = sc.next();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date clientBirthDate = sdf1.parse(sc.next());
		System.out.println("Enter order data: ");
		System.out.print("Status: ");
		String status = sc.next().toUpperCase();

		Client client = new Client(clientName, clientEmail, clientBirthDate);

		Order order = new Order(OrderStatus.valueOf(status), client);
		// -------------------------------------------------------------------- >
		System.out.println("How many items to this order? ");
		int N = sc.nextInt();
		// -------------------------------------------------------------------- >
		for (int i = 1; i <= N; i++) {
			// Enter #1 item data:
			System.out.println("Enter #" + i + " item data: ");

			sc.nextLine(); // após o int
			System.out.print("Product name: ");
			String productName = sc.nextLine();
			System.out.print("Product price: ");
			double productPrice = sc.nextDouble();
			System.out.print("Product quantity: ");
			int productQuantity = sc.nextInt();

			order.addItem(new OrderItem(productQuantity, productPrice, new Product(productName, productPrice)));

		}
		// -------------------------------------------------------------------- >
		System.out.println();
		System.out.println(order);
		// -------------------------------------------------------------------- >
		sc.close();

	}

}

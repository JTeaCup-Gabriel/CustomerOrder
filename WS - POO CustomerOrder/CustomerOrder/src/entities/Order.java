package entities;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {

	private static SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
	private static SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	private static DecimalFormat df = new DecimalFormat("0.00");

	private Date moment = new Date();
	private OrderStatus status;

	private Client client;
	private List<OrderItem> items = new ArrayList<OrderItem>();

	// ------------------------------------------------------------------------ >
	public Order() {
	}

	public Order(OrderStatus status, Client client) {
		this.status = status;
		this.client = client;
	}
	// ------------------------------------------------------------------------ >

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<OrderItem> getItems() {
		return items;
	}
	// ------------------------------------------------------------------------ >

	public void addItem(OrderItem item) {
		items.add(item);
	}

	public void removeItem(OrderItem item) {
		items.remove(item);
	}

	public double total() {

		double sum = 0;

		for (OrderItem o : items) {
			sum += o.subTotal();
		}
		return sum;
	}
	// ------------------------------------------------------------------------ >

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append("ORDER SUMMARY: \n");
		sb.append("Order moment: " + sdf2.format(moment) + "\n");
		sb.append("Order status: " + status + "\n");
		sb.append("Client: " + client.getName() + " (" + sdf1.format(client.getBirthDate()) + ") - " + client.getEmail()
				+ "\n");
		sb.append("Order items: \n");

		for (OrderItem o : items) {

			sb.append(o.getProduct().getName() + ", $" + df.format(o.getProduct().getPrice()) + ", Quantity: "
					+ o.getQuantity() + ", Subtotal: $" + df.format(o.subTotal()) + "\n");

		}
		sb.append("Total price: $" + df.format(total()));

		return sb.toString();

	}

}

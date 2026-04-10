package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    private Date moment;
    
    private OrderStatus status;
    private List<OrderItem> order = new ArrayList<>();
    private Client client;


    public Order(){}

    public Order(Date moment, OrderStatus status, Client client) {
        this.moment = moment;
        this.status = status;
        this.client = client;
    }

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

    public void addItem(OrderItem item){
        order.add(item);
    }
    
    public void removeItem(OrderItem item){
        order.remove(item);
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public double total(){
        double sum = 0.0;
        for (OrderItem o : order){
            sum += o.subTotal(o.getQuantity(), o.getPrice());
        }
        return sum;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Order momment: ");
        sb.append(sdf.format(moment) + "\n");
        sb.append("Order status: " + status + "\n");
        sb.append("Client: " + client.getName()); 
        sb.append(" (" + client.getBirthDate() + ") ");
        sb.append(client.getEmail() + "\n");
        sb.append("Order items: " + "\n");
        for (OrderItem o : order){
            sb.append(o.toString() + "\n");
        }
        sb.append("Total price: $" + this.total());

        return sb.toString();
    }

}

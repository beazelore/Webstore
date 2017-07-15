package model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;

/**
 * Created by Павло on 14.07.2017.
 */
public class Order {
    private int id;
    private int user_id;
    private Map<String, CartItem> cartItems;
    private BigDecimal totalSum;
    private LocalDateTime time;

    public Order() {

    }

    public Order(int id, int user_id, Map<String, CartItem> cartItems, BigDecimal totalSum, LocalDateTime time) {
        this.id = id;
        this.user_id = user_id;
        this.cartItems = cartItems;
        this.totalSum = totalSum;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public Map<String, CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(Map<String, CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public BigDecimal getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(BigDecimal totalSum) {
        this.totalSum = totalSum;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (id != order.id) return false;
        if (user_id != order.user_id) return false;
        if (cartItems != null ? !cartItems.equals(order.cartItems) : order.cartItems != null) return false;
        return (totalSum != null ? !totalSum.equals(order.totalSum) : order.totalSum != null);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + user_id;
        result = 31 * result + (cartItems != null ? cartItems.hashCode() : 0);
        result = 31 * result + (totalSum != null ? totalSum.hashCode() : 0);
        return result;
    }
}

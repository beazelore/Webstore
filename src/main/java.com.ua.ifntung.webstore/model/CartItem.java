package model;

import java.math.BigDecimal;

/**
 * Created by Павло on 14.07.2017.
 */
public class CartItem {
    private Book book;
    private int quantity;
    private BigDecimal totalPrice;

    public CartItem() {
    }

    public CartItem(Book book, int quantity, BigDecimal totalPrice) {
        this.book = book;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
        this.updatePrice();
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        this.updatePrice();
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    private void updatePrice(){
        totalPrice = this.book.getPrice().multiply(new BigDecimal(this.quantity));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CartItem cartItem = (CartItem) o;

        if (quantity != cartItem.quantity) return false;
        if (book != null ? !book.equals(cartItem.book) : cartItem.book != null) return false;
        return totalPrice != null ? totalPrice.equals(cartItem.totalPrice) : cartItem.totalPrice == null;
    }

    @Override
    public int hashCode() {
        int result = book != null ? book.hashCode() : 0;
        result = 31 * result + quantity;
        result = 31 * result + (totalPrice != null ? totalPrice.hashCode() : 0);
        return result;
    }
}

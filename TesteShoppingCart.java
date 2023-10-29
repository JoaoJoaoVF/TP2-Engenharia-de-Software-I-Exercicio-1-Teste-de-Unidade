
/**
* Engenharia de Software Moderna - Testes  (Cap. 8)
* Prof. Marco Tulio Valente
* 
* Exercício simples de teste de unidade (ShoppingCart)
*
*/

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

public class TesteShoppingCart {

  private ShoppingCart shoppingCart;

  @Before
  public void setUp() {
    shoppingCart = new ShoppingCart();
    shoppingCart.addItem(new Item("ESM", 65.0));
    shoppingCart.addItem(new Item("GoF", 120.0));
  }

  @Test
  public void testAddItem() {
    shoppingCart.addItem(new Item("BNV", 95.0));
    int wasAdded = shoppingCart.getItemCount();
    System.out.println("wasAdded: " + wasAdded);
    assertTrue(wasAdded == 3);
  }

  @Test
  public void testRemoveItem() {
    Item itemToRemove = new Item("BNV", 95.0);
    shoppingCart.removeItem(itemToRemove);
    int wasRemoved = shoppingCart.getItemCount();
    System.out.println("wasRemoved: " + wasRemoved);
    assertTrue(wasRemoved == 2);
  }

  @Test
  public void testGetTotalPrice() {
    shoppingCart.addItem(new Item("BNV", 95.0));
    double totalPrice = shoppingCart.getTotalPrice();
    System.out.println("totalPrice: " + totalPrice);
    assertTrue(totalPrice == 280.0);
  }

  @Test
  public void testClearCart() {
    shoppingCart.addItem(new Item("BNV", 95.0));
    shoppingCart.addItem(new Item("DUB", 20.0));
    int sizeCartBefore = shoppingCart.getItemCount();
    System.out.println("sizeCartBefore: " + sizeCartBefore);
    shoppingCart.clearCart();
    int wasCleared = shoppingCart.getItemCount();
    System.out.println("wasCleared: " + wasCleared);
    assertTrue(wasCleared == 0);
  }
}

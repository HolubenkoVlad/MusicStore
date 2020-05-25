package sk.musicstore.services;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import sk.musicstore.models.*;
/**
 * Helper class for working with the session.
 * */
public class SessionUtils {	
	/**Adds a user to the session
	 * @param session - current session
	 * @param loginedUser - user to add
	 * */
    public static void storeLoginedUser(HttpSession session, User loginedUser) {
        session.setAttribute("login", loginedUser);
    }
    /**
     * If the cart is empty when the method is called, a new cart is created and added to the session. 
     * If the cart exists, a copy of the cart is returned.
     * @param session - current session
     * @return cart
     * */
    public static Cart getCart(HttpSession session){
        Cart cart;
        if (session.getAttribute("Cart") == null) {
            cart = new Cart();
            session.setAttribute("Cart", cart);
        } else {
            cart = (Cart)session.getAttribute("Cart");
        }
        return cart;
    }
    /**
     * Saves the cart to the session
     * @param cart - cart to save
     * @param session - current session- 
     * */
    public static void storeCart(Cart cart, HttpSession session){
		session.setAttribute("Cart", cart);
    }
    /**
     * Removing the old cart by replacing the empty one
     * @param session - current session
     * */
    public static void clearCart(HttpSession session){
        session.setAttribute("Cart", new Cart());
    }
}


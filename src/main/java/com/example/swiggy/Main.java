package com.example.swiggy;

import com.example.swiggy.common.Location;
import com.example.swiggy.common.User;
import com.example.swiggy.delivery.DeliveryPartner;
import com.example.swiggy.delivery.DeliveryPartnerService;
import com.example.swiggy.food.AddOn;
import com.example.swiggy.food.Dish;
import com.example.swiggy.food.IFood;
import com.example.swiggy.order.Order;
import com.example.swiggy.order.OrderService;
import com.example.swiggy.restaurant.Menu;
import com.example.swiggy.restaurant.Restaurant;
import com.example.swiggy.restaurant.RestaurantOwner;
import com.example.swiggy.restaurant.RestaurantService;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        RestaurantService restaurantService = RestaurantService.getInstance();
        OrderService orderService = OrderService.getInstance();
        DeliveryPartnerService deliveryPartnerService = DeliveryPartnerService.getInstance();

        User user = new User("1", "Ram", new Location(0,0));
        User user2 = new User("2", "Shyam", new Location(1,1));

        DeliveryPartner partner = new DeliveryPartner("1", "Karan");
        DeliveryPartner partner2 = new DeliveryPartner("2", "Arjun");
        deliveryPartnerService.addDeliveryPartner(partner);
        deliveryPartnerService.addDeliveryPartner(partner2);

        RestaurantOwner owner = new RestaurantOwner("Ramesh");
        Restaurant restaurant = new Restaurant("2", "Burger King", owner, new Location(3,3));
        IFood dish1 = new Dish("Burger", 100);
        IFood dish2 = new Dish("Fries", 50);

        Menu menu = new Menu();
        menu.addDish(dish1);
        menu.addDish(dish2);
        restaurant.addMenu(menu);
        restaurantService.addRestaurant(restaurant);

        // Decorator pattern to add addons to dishes
        dish1 = new AddOn("Coke", 30, dish1);
        dish2 = new AddOn("Sauce", 10, dish2);

        HashMap<IFood, Integer> cart = new HashMap<>();
        cart.put(dish1, 2);
        cart.put(dish2, 1);

        Order order = new Order("order1", user, restaurant, cart);

        orderService.placeOrder(user.getId(), order);

    }
}

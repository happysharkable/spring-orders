package com.geekbrains.geek.market.controllers;

import com.geekbrains.geek.market.entities.Customer;
import com.geekbrains.geek.market.entities.Order;
import com.geekbrains.geek.market.entities.OrderItem;
import com.geekbrains.geek.market.exceptions.ResourceNotFoundException;
import com.geekbrains.geek.market.services.OrderService;
import com.geekbrains.geek.market.services.ProductService;
import com.geekbrains.geek.market.utils.Cart;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/orders")
@AllArgsConstructor
public class OrderController {
    private OrderService orderService;
    private Cart cart;

    @GetMapping
    public String firstRequest(Model model) {
        model.addAttribute("orders", orderService.findAll());
        return "orders";
    }

    @GetMapping("/new")
    public String viewCurrentOrder() {
        return "order";
    }

    @PostMapping("/new")
    public String createNewOrder(@RequestParam(value = "name") String customerName,
                                 @RequestParam(value = "phone") String customerPhone,
                                 @RequestParam(value = "address") String customerAddress) {
        Order o = new Order(customerName, customerPhone, customerAddress, cart.getItems());
        orderService.save(o);
        cart.clear();
        return "redirect:/orders";
    }

    @GetMapping("/{id}")
    public String showOrder(@PathVariable Long id, Model model) {
        Order o = orderService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Unable to find order"));
        model.addAttribute("order", o);
        return "order";
    }
}

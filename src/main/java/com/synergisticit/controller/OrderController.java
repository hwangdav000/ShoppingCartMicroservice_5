package com.synergisticit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import com.synergisticit.domain.OrderRequest;
import com.synergisticit.domain.ProductOrder;
import com.synergisticit.service.OrderService;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/save")
    public void saveOrder(@RequestParam Integer userId, @RequestBody OrderRequest orderRequest) throws Exception {
        orderService.saveOrder(userId, orderRequest);
    }

    @GetMapping("/user/{userId}")
    public List<ProductOrder> getOrdersByUser(@PathVariable Integer userId) {
        return orderService.getOrdersByUser(userId);
    }

    @PutMapping("/update/{id}")
    public ProductOrder updateOrderStatus(@PathVariable Integer id, @RequestParam String status) {
        return orderService.updateOrderStatus(id, status);
    }

    @GetMapping("/all")
    public List<ProductOrder> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{orderId}")
    public ProductOrder getOrdersByOrderId(@PathVariable String orderId) {
        return orderService.getOrdersByOrderId(orderId);
    }

    @GetMapping("/all/pagination")
    public Page<ProductOrder> getAllOrdersPagination(
            @RequestParam Integer pageNo,
            @RequestParam Integer pageSize) {
        return orderService.getAllOrdersPagination(pageNo, pageSize);
    }
}

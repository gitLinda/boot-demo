package ch.juventus.bootdemo.controller;

import ch.juventus.bootdemo.model.Order;
import ch.juventus.bootdemo.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@Tag(name = "Order API")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }


    @GetMapping("/order")
    public ResponseEntity<Set<Order>> readOrders() {
        Set<Order> orders = orderService.readOrders();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @Operation(summary = "Get an order by its id")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Found the order", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Order.class)) }),
        @ApiResponse(responseCode = "404", description = "Order not found", content = @Content) })
    @GetMapping("/order/{id}")
    public ResponseEntity<Order> readOrder(@PathVariable long id) {
        Order order = orderService.readOrder(id);
        if (order == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @PostMapping("/order")
    public ResponseEntity<Long> createOrder(@RequestBody Order newOrder) {
        long newOrderId = orderService.createOrder(newOrder);
        return new ResponseEntity<>(newOrderId, HttpStatus.OK);
    }

    @PutMapping("/order/{id}")
    public ResponseEntity<Long> updateOrder(@PathVariable long id, @RequestBody Order updatedOrder) {
        long updatedOrderId = orderService.updateOrder(id, updatedOrder);
        if (updatedOrderId == -1) {
            return new ResponseEntity<>(id, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedOrderId, HttpStatus.OK);
    }

    @DeleteMapping("/order/{id}")
    public ResponseEntity<Long> deleteOrder(@PathVariable long id) {
        long deletedOrderId = orderService.deleteOrder(id);
        if (deletedOrderId == -1) {
            return new ResponseEntity<>(id, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(deletedOrderId, HttpStatus.OK);
    }

}

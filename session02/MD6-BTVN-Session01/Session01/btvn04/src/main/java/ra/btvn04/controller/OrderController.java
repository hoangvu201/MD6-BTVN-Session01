package ra.btvn04.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ra.btvn04.entity.Order;
import ra.btvn04.entity.Status;

import java.util.ArrayList;
import java.util.List;

@RestController
public class OrderController {

    private List<Order> orders = new ArrayList<>(
            List.of(
                    new Order(1L, "ORD123", Status.Pending),
                    new Order(2L, "ORD124", Status.Shipped),
                    new Order(3L, "ORD125", Status.Delivered)
            )
    );

    @GetMapping("/orders/{id}/status")
    public ResponseEntity<?> getOrderStatus(@PathVariable Long id) {
        for (Order order : orders) {
            if (order.getId().equals(id)) {
                return ResponseEntity.ok(order);
            }
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Order not found");
    }

}

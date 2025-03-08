package ru.ivanov.transactiondemo;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class Controller {
  private final Service service;

  public Controller(Service service) {
    this.service = service;
  }

  @PostMapping("/order")
  public void makeOrder(@RequestBody Purchase purchase) {
    service.createOrder(purchase);
  }

  @PostMapping("/customer")
  public void createCustomer(@RequestBody Customer customer) {

    service.createCustomer(customer);
  }

}

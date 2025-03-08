package ru.ivanov.transactiondemo;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

@org.springframework.stereotype.Service
public class Service {
    private final Dao dao;

    public Service(Dao dao) {
        this.dao = dao;
    }

    public void makeOrder(@RequestBody Purchase purchase) {
        createOrder(purchase);
    }

    public void createCustomer(@RequestBody Customer customer) {
        dao.createCustomer(customer);
    }

    @Transactional
    public void createOrder(Purchase purchase){
        dao.createPurchase(purchase);
      //  method();
        dao.writeOffMoney(purchase);
    }

    //  @SneakyThrows
//  private void method() {
//    Thread.sleep(600);
//  }

    private void method() {
        throw new RuntimeException();
    }
}

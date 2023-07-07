package org.example;

import org.example.entity.Customer;
import org.example.service.CustomerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App
{
    public static void main( String[] args )
    {
        var context = SpringApplication.run(App.class, args);

        CustomerService customerService = context.getBean(CustomerService.class);
        Customer customer = customerService.getById(1L);
        System.out.println(customer);

        System.out.println("-".repeat(50));

        Customer customerById = customerService.getCustomerById(2L);
        System.out.println(customerById);

        System.out.println("-".repeat(50));

        Customer n = customerService.getByLoginStartsWithIgnoreCase("n");
        System.out.println(n);

        System.out.println("-".repeat(50));
        customerService.updateCustomerLoginById(1L, "JavaRush");

        System.out.println("-".repeat(50));

        Customer customer1 = new Customer("fhjsdhfjks", "fsdfsf");

        customerService.saveSomeCustomer(customer1);

    }
}

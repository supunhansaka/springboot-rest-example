package com.projects.springboot.service;

import com.projects.springboot.Customer;
import com.projects.springboot.entity.CustomerModel;
import com.projects.springboot.repository.CustomerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    public Customer createCustomer(final Customer customer) {
        CustomerModel customerModel = new CustomerModel();
        BeanUtils.copyProperties(customer, customerModel);
        customerModel = customerRepository.save(customerModel);
        Customer customerData = new Customer();
        BeanUtils.copyProperties(customerModel, customerData);

        return customerData;
    }

    public List getCustomers() {
        List customers = new ArrayList<>();
        customerRepository.findAll().forEach(customers::add);

        List customerList = new ArrayList<>();
        for (Object customerModel : customers) {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerModel, customer);
            customerList.add(customer);
        }
        return customerList;
    }

    public Customer getCustomer(Long id) {
        Optional customer = customerRepository.findById(id);
        Customer customerData = new Customer();
        BeanUtils.copyProperties(customer.get(), customerData);
        return customerData;
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

}

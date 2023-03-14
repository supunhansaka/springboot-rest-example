package com.projects.springboot.repository;

import com.projects.springboot.entity.CustomerModel;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<CustomerModel, Long> {
}

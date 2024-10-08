package org.chintanu.sdjpa.service;

import org.chintanu.sdjpa.domain.Customer;
import org.chintanu.sdjpa.exceptions.CustomerNotFoundException;
import org.chintanu.sdjpa.exceptions.PageNotFoundException;
import org.chintanu.sdjpa.repository.CustomerRepository;
import org.chintanu.sdjpa.web.mapper.CustomerMapper;
import org.chintanu.sdjpa.web.model.CustomerDto;
import org.chintanu.sdjpa.web.model.CustomerPageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository repository;

    @Autowired
    private CustomerMapper mapper;

    @Override
    public CustomerDto getCustomerById(Long custId) {

        Optional<Customer> customer = repository.findById(custId);

        if (customer.isPresent()) {

            return mapper.convertToCustomerDto(customer.get());
        } else {

            throw new CustomerNotFoundException("Customer Not Available");
        }
    }

    @Override
    public CustomerPageDto getCustomersByPage(int pageNum, int pageSize) {

        Page<Customer> customerPage = repository.findAll(PageRequest.of(pageNum, pageSize));

        if (customerPage.hasContent()) {

            CustomerPageDto pageDto = new CustomerPageDto();
            pageDto.setTotalPages(customerPage.getTotalPages());
            pageDto.setTotalElements(customerPage.getTotalElements());
            pageDto.setCurrentPage(pageNum);
            pageDto.setPageSize(pageSize);
            pageDto.setCustomers(customerPage.getContent()
                                            .stream()
                                            .map(e -> mapper.convertToCustomerDto(e))
                                            .collect(Collectors.toList()));

            return pageDto;
        } else {

            throw new PageNotFoundException("Requested page doesn't contain any records, Please refresh the page");
        }
    }
}

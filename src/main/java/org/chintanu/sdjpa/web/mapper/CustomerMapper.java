package org.chintanu.sdjpa.web.mapper;

import org.chintanu.sdjpa.domain.Customer;
import org.chintanu.sdjpa.web.model.CustomerDto;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {

    public Customer convertToCustomer(CustomerDto customerDto);
    public CustomerDto convertToCustomerDto(Customer customer);
}

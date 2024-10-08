package org.chintanu.sdjpa.service;

import org.chintanu.sdjpa.web.model.CustomerDto;
import org.chintanu.sdjpa.web.model.CustomerPageDto;

import java.util.List;

public interface CustomerService {

    public CustomerDto getCustomerById(Long custId);

    public CustomerPageDto getCustomersByPage(int pageNum, int pageSize);
}

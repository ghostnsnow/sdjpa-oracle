package org.chintanu.sdjpa.web.model;

import lombok.Data;

import java.util.List;

@Data
public class CustomerPageDto {

    private int totalPages;
    private int currentPage;
    private int pageSize;
    private long totalElements;
    private List<CustomerDto> customers;
}

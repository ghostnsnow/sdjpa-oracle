package org.chintanu.sdjpa.web.controller;

import org.chintanu.sdjpa.service.CustomerService;
import org.chintanu.sdjpa.web.model.CustomerDto;
import org.chintanu.sdjpa.web.model.CustomerPageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/{custId}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable("custId") Long custId) {

        CustomerDto dto = customerService.getCustomerById(custId);
        return ResponseEntity.ok(dto);
    }

    /**
     * Get a Page of entities given page number & page size.
     * Slice can also be used in place of Page
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/{pageNum}/{pageSize}")
    public ResponseEntity<CustomerPageDto> getCustomersByPage(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize) {

        CustomerPageDto dto = customerService.getCustomersByPage(pageNum, pageSize);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/countByFirstNm/{firstNm}")
    public ResponseEntity<Integer> countByFirstNm(@PathVariable("firstNm") String firstNm) {

        int count = customerService.countByFirstName(firstNm);
        return ResponseEntity.ok(count);
    }
    /**
     * This following way attaches the Exception handler to the current class only.
     * To have it at the project level, look at CustomerExceptionHandler.class
     */
    /*@ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<ErrorDto> customerNotFound(CustomerNotFoundException ex) {

        ErrorDto dto = new ErrorDto(ex.getMessage(), OffsetDateTime.now());
        return new ResponseEntity<>(dto, HttpStatus.NOT_FOUND);
    }*/
}

package org.chintanu.sdjpa.repository;

import org.assertj.core.api.Assertions;
import org.chintanu.sdjpa.domain.Customer;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@ActiveProfiles("test")
class CustomerRepositoryTest {

    @Autowired
    CustomerRepository repository;

    //TODO : Declared Methods
    @Test
    @DisplayName("Count of the Customer Repository")
    void count() {

        long count = repository.count();
        Assertions.assertThat(count).isEqualTo(983);
    }

    @Test
    @DisplayName("Find Customer where Id = given Id")
    void findById() {

        Customer customer = repository.findById(49671L).get();

        Assertions.assertThat(customer).isNotNull();
        Assertions.assertThat(customer.getCustId()).isEqualTo(49671L);
        Assertions.assertThat(customer.getCustFirstNm()).isEqualTo("Abigail");
        Assertions.assertThat(customer.getCustLastNm()).isEqualTo("Ruddy");
        Assertions.assertThat(customer.getCustMaritalStatus()).isEqualTo("married");
        Assertions.assertThat(customer.getCustGender()).isEqualTo("M");
    }

    //TODO : Derived Methods
    @Test
    @DisplayName("Find Customers where First Name = given First Name")
    void findByFirstNm() {

        List<Customer> customers = repository.findByCustFirstNm("Abigail");

        Assertions.assertThat(customers.size()).isEqualTo(63);
    }

    @Test
    @DisplayName("Count of Customers where First Name = given First Name")
    void countByCustFirstNm() {

        int count = repository.countByCustFirstNm("Abigail");
        Assertions.assertThat(count).isEqualTo(63);
    }

    //TODO : Find by first name = a and last name = b
    @Test
    @DisplayName("Find Customers with AND")
    void findByCustFirstNmAndCustLastNm() {

        List<Customer> customers = repository.findByCustFirstNmAndCustLastNm("Abigail", "Grimes");

        Assertions.assertThat(customers.size()).isEqualTo(16);
    }

    //TODO : Find by first name = a or last name = b
    @Test
    @DisplayName("Find Customers with OR")
    void findByCustFirstNmOrCustLastNm() {

        List<Customer> customers = repository.findByCustFirstNmOrCustLastNm("Anand", "Rudder");

        Assertions.assertThat(customers.size()).isEqualTo(79);
    }

    //TODO : Find by first name = a or b
    @Test
    @DisplayName("Find Customers with IN")
    void findByCustFirstNmIn() {

        List<Customer> customers = repository.findByCustFirstNmIn(List.of("Abigail", "Anand"));
        Assertions.assertThat(customers.size()).isEqualTo(126);
    }

    //TODO : Find by first name like a. Use % as per your need before or after
    @Test
    @DisplayName("Find Customers with LIKE")
    void findByCustFirstNmLike() {

        List<Customer> customers = repository.findByCustFirstNmLike("Ann%");
        Assertions.assertThat(customers.size()).isEqualTo(126);
    }

    //TODO : Find by first name like a or b. This is breaking. Find if possible.
    /*@Test
    void findByCustFirstNmLikeIn() {

        List<Customer> customers = repository.findByCustFirstNmLikeIn(List.of("Absolom%", "Ann%"));
        Assertions.assertThat(customers.size()).isEqualTo(189);
    }*/

    //TODO : Find by first name = a "Ignore case".
    @Test
    @DisplayName("Find Customers with IGNORE CASE")
    void findByCustFirstNmIgnoreCase() {

        List<Customer> customers = repository.findByCustFirstNmIgnoreCase("archibald");
        Assertions.assertThat(customers.size()).isEqualTo(14);
    }

    //TODO : Find by All attribute "Ignore case".
    @Test
    @DisplayName("Find Customers with ALL IGNORE CASE")
    void findByCustFirstNmAndCustLastNmAllIgnoreCase() {

        List<Customer> customers = repository.findByCustFirstNmAndCustLastNmAllIgnoreCase("archibald", "fellows");
        Assertions.assertThat(customers.size()).isEqualTo(14);
    }

    //TODO : Find by first name, order by last name desc.
    @Test
    @DisplayName("Find Customers with ORDER BY")
    void findByCustFirstNmOrderByCustYOBDesc() {

        List<Customer> customers = repository.findByCustFirstNmOrderByCustYOBDesc("Abigail");
        Assertions.assertThat(customers.size()).isEqualTo(63);
        Assertions.assertThat(customers.get(0).getCustYOB()).isEqualTo(1985);
    }

    //TODO : ABC or Dummy - Doesn't matter. Can also be without anything like findDistinctByCustFirstNm
    @Test
    @DisplayName("Find Distinct Customer where first name = given first name")
    void findDistinctByCustFirstNm() {

        List<Customer> customers = repository.findDistinctABCByCustFirstNm("Abigail");
        Assertions.assertThat(customers.size()).isEqualTo(63);
    }

    //TODO : Need to find how this can be done - Find distinct attribute A where attribute B = some value(mostly with @Query as Repository works with Entity & not String)
    @Test
    @Disabled
    void findDistinctCustLastNmByCustFirstNm() {

        List<String> customerLastNms = repository.findDistinctCustLastNmByCustFirstNm("Abigail");
        customerLastNms.stream().forEach(System.out::println);
    }

    //TODO : Find the Page of given size & the page number
    @Test
    @DisplayName("Find Customers with Page")
    void findPageWithPageable() {

        Pageable pageable = PageRequest.of(2, 10);
        Page<Customer> customers = repository.findAll(pageable);
        Assertions.assertThat(customers.getContent().size()).isEqualTo(10);
        Assertions.assertThat(customers.getTotalPages()).isEqualTo(99);
        Assertions.assertThat(customers.getTotalElements()).isEqualTo(983L);
        Assertions.assertThat(customers.getContent().get(1).getCustId()).isEqualTo(2341L);
    }

    //TODO : Unpaged basically means no Paging setup i.e. return all the rows if no limiting/clause is set
    @Test
    @DisplayName("Find Customers with Unpaged")
    void findPageWithPageableUnpaged() {

        //Pageable pageable = PageRequest.of(2, 10);
        Page<Customer> customers = repository.findAll(Pageable.unpaged());
        Assertions.assertThat(customers.getContent().size()).isEqualTo(983);
        Assertions.assertThat(customers.getTotalPages()).isEqualTo(1);
        Assertions.assertThat(customers.getTotalElements()).isEqualTo(983L);
        Assertions.assertThat(customers.getContent().get(2).getCustId()).isEqualTo(1449L);
        Assertions.assertThat(customers.getContent().get(11).getCustId()).isEqualTo(1458L);
    }

    //TODO - Find Page with the provided Sorting
    @Test
    @DisplayName("Find Customers with Sorting")
    void findPageWithSort() {

        Sort sort = Sort.by("custId").descending();
        List<Customer> customers = repository.findAll(sort);
        Assertions.assertThat(customers.size()).isEqualTo(983);
        Assertions.assertThat(customers.get(1).getCustId()).isEqualTo(50575L);
    }

    //TODO - Find Page with Type Safe TypedSort
    @Test
    @DisplayName("Find Customers with TypeSafe Sorting using TypedSort")
    void findPageWithTypedSort() {

        //Sort sort = Sort.by("custId").descending();
        Sort.TypedSort<Customer> typedSort = Sort.sort(Customer.class);
        Sort sort = typedSort.by(Customer::getCustId).descending().and(typedSort.by(Customer::getCustFirstNm));
        List<Customer> customers = repository.findAll(sort);
        Assertions.assertThat(customers.size()).isEqualTo(983);
        Assertions.assertThat(customers.get(1).getCustId()).isEqualTo(50575L);
    }

    //TODO - Find Page with the Unsorted
    //TODO : These 3 are exactly same - repository.findAll(), repository.findAll(Pageable.unpaged()), repository.findAll(Sort.unsorted())
    @Test
    @DisplayName("Find Customers with Unsorted")
    void findPageWithUnsorted() {

        List<Customer> customers = repository.findAll(Sort.unsorted());

        Assertions.assertThat(customers.size()).isEqualTo(983);
        Assertions.assertThat(customers.get(2).getCustId()).isEqualTo(1449L);
        Assertions.assertThat(customers.get(11).getCustId()).isEqualTo(1458L);
    }

    //TODO - Find Top N Customer without any sorting/paging
    @Test
    @DisplayName("Find Top N Customers without any sorting/paging")
    void findTop10By() {

        List<Customer> customers = repository.findTop10By();

        Assertions.assertThat(customers.size()).isEqualTo(10);
        Assertions.assertThat(customers.get(2).getCustId()).isEqualTo(1449L);
        Assertions.assertThat(customers.get(0).getCustId()).isEqualTo(1L);
    }

    //TODO - Find Top 1 Customer with sorting
    @Test
    @DisplayName("Find Top 1 Customer with sorting")
    void findTopByOrderByCustIdDesc() {

        Customer customer = repository.findTopByOrderByCustIdDesc();

        Assertions.assertThat(customer).isNotNull();
        Assertions.assertThat(customer.getCustId()).isEqualTo(50576L);
    }

    //TODO - Find Top N Customer from within a Page : Seems potential bug
    @Test
    @DisplayName("Find Top N Customers from within a Page")
    void findTop5ByOrderByCustIdAsc() {

        Pageable pageable = PageRequest.of(1, 10);

        List<Customer> customers = repository.findTop5ByOrderByCustIdAsc(pageable);

        Assertions.assertThat(customers.size()).isEqualTo(5);
        /*Assertions.assertThat(customers.get(0).getCustId()).isEqualTo(1457L);
        Assertions.assertThat(customers.get(2).getCustId()).isEqualTo(1460L);
        Assertions.assertThat(customers.get(4).getCustId()).isEqualTo(1462L);*/

        customers.stream().forEach(System.out::println);

        List<Customer> customers2 = repository.findTop5ByOrderByCustIdAsc(PageRequest.of(2, 10));
        customers2.stream().forEach(System.out::println);
    }

    //TODO : Find the Page of given size & the page number
    /*@Test
    @DisplayName("Find Customers with Page")
    void findPageWithPageable() {

        Pageable pageable = PageRequest.of(2, 10);
        Page<Customer> customers = repository.findAll(pageable);
        Assertions.assertThat(customers.getContent().size()).isEqualTo(10);
        Assertions.assertThat(customers.getTotalPages()).isEqualTo(99);
        Assertions.assertThat(customers.getTotalElements()).isEqualTo(983L);
        Assertions.assertThat(customers.getContent().get(1).getCustId()).isEqualTo(2341L);
    }*/
}
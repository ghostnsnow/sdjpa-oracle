package org.chintanu.sdjpa.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

@DataJpaTest
@ActiveProfiles("test")
class CustomerRepositoryTest {

    @Autowired
    CustomerRepository repository;

    @Test
    void countByCustFirstNm() {

        int count = repository.countByCustFirstNm("Abigail");
        Assertions.assertThat(count).isEqualTo(63);
    }

    @Test
    void count() {

        long count = repository.count();
        Assertions.assertThat(count).isEqualTo(983);
    }
}
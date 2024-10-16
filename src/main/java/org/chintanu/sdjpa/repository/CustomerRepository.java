package org.chintanu.sdjpa.repository;

import org.chintanu.sdjpa.domain.Customer;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    int countByCustFirstNm(String custFirstNm);

    List<Customer> findByCustFirstNm(String custFirstNm);

    List<Customer> findByCustFirstNmAndCustLastNm(String custFirstNm, String custLastNm);

    List<Customer> findByCustFirstNmOrCustLastNm(String custFirstNm, String custLastNm);

    List<Customer> findByCustFirstNmIn(List<String> custFirstNms);

    List<Customer> findByCustFirstNmLike(String custFirstNm);

    //List<Customer> findByCustFirstNmLikeIn(List<String> custFirstNms);

    List<Customer> findByCustFirstNmIgnoreCase(String custFirstNm);

    List<Customer> findByCustFirstNmAndCustLastNmAllIgnoreCase(String custFirstNm, String custLastNm);

    List<Customer> findByCustFirstNmOrderByCustYOBDesc(String custFirstNm);

    List<Customer> findDistinctABCByCustFirstNm(String custFirstNm);

    List<Customer> findTop10By();

    Customer findTopByOrderByCustIdDesc();

    List<Customer> findTop5ByOrderByCustIdAsc(Pageable pageable);

    List<Customer> findByCountryCountryId(Long countryId);

    List<Customer> findByCountryCountryNm(String countryNm);

    List<String> findDistinctCustLastNmByCustFirstNm(String custFirstNm);


    //TODO - Sort within a group
}

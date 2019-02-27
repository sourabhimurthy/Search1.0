package com.stackroute.pie.repository;

import com.stackroute.pie.domain.Diseases;
import com.stackroute.pie.domain.Policy;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Caching;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import springfox.documentation.annotations.Cacheable;

import java.util.List;
@Repository
public interface SearchRepository extends MongoRepository<Policy, Integer> {

    List<Policy> findByPolicyName(String policyName);

    List<Policy> findByDiseasesListDiseaseName(String diseaseName);

    List<Policy> findByInsurerName(String insurerName);

    List<Policy> findBySumInsured(int sumInsured);

    Policy save(Policy policy);

//    int saveValue(String value,int count);
}



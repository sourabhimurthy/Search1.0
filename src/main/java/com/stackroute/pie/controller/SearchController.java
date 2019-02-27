package com.stackroute.pie.controller;

import com.stackroute.pie.domain.Diseases;
import com.stackroute.pie.domain.Policy;
import com.stackroute.pie.service.SearchServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.Cacheable;

import java.util.List;

@CrossOrigin("*")
@RestController

@RequestMapping("api/v1/")
public class SearchController {
    private SearchServiceImpl searchService;
    @Autowired
    public  SearchController(SearchServiceImpl searchService){
        this.searchService = searchService;
    }

    @PostMapping(value = "policy")
    public ResponseEntity<?> savePolicy(@RequestBody Policy policy)
    {
        ResponseEntity responseEntity;
        Policy policy1 = searchService.savePolicy(policy);
        responseEntity = new ResponseEntity<Policy>(policy1, HttpStatus.CREATED);
        return responseEntity;
    }

    @GetMapping(value = "polici/{value}")
    public ResponseEntity<?> getDiseases(@PathVariable(value = "value") String value)
    {
        List<Policy> allPolicies = searchService.getByDisease(value);

        return new ResponseEntity<List<Policy>>(allPolicies, HttpStatus.OK);
    }

    @GetMapping(value="policies/{value}")
    public ResponseEntity<?> tokeniseString(@PathVariable(value = "value")String value)
    { ResponseEntity responseEntity;
        System.out.println("in controller");
        try {
            List<Policy> alltokens = searchService.tokenString(value);
            responseEntity= new ResponseEntity<List<Policy>>(alltokens, HttpStatus.OK);
        }
        catch(Exception ex){
            responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
        }
        System.out.println("Return responseEntity"+responseEntity);
        return responseEntity;
    }



    @GetMapping(value="polic/{value}")
    public ResponseEntity<?> getString(@PathVariable(value = "value")String value)
    { ResponseEntity responseEntity;
        System.out.println("in controller");
        try {
            List<Policy> alltokens = searchService.getAllPolicies(value);
            responseEntity= new ResponseEntity<List<Policy>>(alltokens, HttpStatus.OK);
        }
        catch(Exception ex){
            responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
        }
        System.out.println("Return responseEntity"+responseEntity);
        return responseEntity;
    }
//    @GetMapping(value = "policys/{value}")
//    public ResponseEntity<?> findPolicy(@PathVariable (value = "value")String value)
//    {
//        ResponseEntity entity;
//            List<Policy> response= searchService.findByDiseaseName(value);
//        entity=new ResponseEntity<List<Policy>>(response,HttpStatus.OK);
//        System.out.println("Hi");
//        return  entity;
//    }



}

package com.stackroute.pie.service;

import com.stackroute.pie.domain.Diseases;
import com.stackroute.pie.domain.Policy;
import com.stackroute.pie.repository.SearchRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

public class SearchServiceImplTest {

    private Optional optional;
    @Mock
    SearchRepository searchRepository;

    @InjectMocks
    SearchServiceImpl searchService;

    Policy policy;
    List<Policy> policy1;
//    List<Policy> addPolicy;
    Diseases disease1,disease2;
    List<Diseases> diseaseList;
    String companyString;
    String policyString;
    String diseaseString;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
         companyString = "MaxBupa,StarHealth,Apollo,Religare";
         policyString = "JeevanSathi , JeevanAnand ,JeevanVima ,HealthSecure ,JeevanHealth";
         diseaseString = "cancer, diabetes, aids, dengue, malaria, tuberculosis, cardiac, heartattack, surgery";

        policy1 = new ArrayList<>();

        diseaseList=new ArrayList<>();
        disease1=new Diseases("cancer");
        disease2=new Diseases("diabetes");
        System.out.println(disease1.getDiseaseName());
        diseaseList.add(disease1);
        diseaseList.add(disease2);
        policy = new Policy(
                 1,
                "JeevanSathi","MaxBupa",
                 "self",diseaseList,

         0,
                 5,
                 400,
               6000,
               4000,
               20,
                 60,
                 null,
              null,
                 null,
                "maxbupa",
             "maxpuba"
    );
        policy1.add(policy);
//        track1.add(new Track("track2","comment2"));
        optional = Optional.of(policy);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getAllPolicies() {
        when(searchRepository.findAll()).thenReturn(policy1);
       List<Policy> actual=searchService.getAllPolicies("cancer");
       assertEquals(policy1,actual);
        verify(searchRepository, Mockito.times(1)).findAll();
//        verifyNoMoreInteractions(trackService);
    }

    @Test
    public void tokenString() throws Exception {
//        if(policyString.contains("JeevanSathi"))
//            when( searchRepository.findByPolicyName("JeevanSathi")).thenReturn(policy1);
//            List<Policy> actual6=searchService.tokenString("JeevanSathi");
//            assertEquals(policy1,actual6);
        int ag=30;
        if(ag<100)
            when( searchRepository.findAll()).thenReturn(policy1);
           List<Policy> list = new ArrayList<>();
            for(Policy p:policy1) {
                if (p.getMinAge() < ag && p.getMaxAge() > ag) {
                    list.add(p);
                }
            }
            List<Policy> actual6=searchService.tokenString("30");
            assertEquals(list,actual6);

        int sum=3000;
        if(sum>3000)
            when( searchRepository.findAll()).thenReturn(policy1);
        List<Policy> list1 = new ArrayList<>();
        for(Policy p:policy1) {
            if (p.sumInsured==sum) {
                list1.add(p);
            }
        }
        List<Policy> actual7=searchService.tokenString("3000");
        assertEquals(list1,actual7);
//
//        if(companyString.contains("MaxBupa"))
//            when( searchRepository.findByInsurerName("MaxBupa")).thenReturn(policy1);
//            List<Policy> actual8=searchService.tokenString("MaxBupa");
//            assertEquals(policy1,actual8);

        if(policyString.contains("JeevanSathi") && diseaseString.contains("cancer"))
        when( searchRepository.findByDiseasesListDiseaseName("cancer")).thenReturn(policy1);
        List<Policy> addPolicy =new ArrayList<>();
        for(Policy p:policy1){
            if(p.getPolicyName().equals("JeevanSathi")){
                addPolicy.add(p);
            }
        }
        List<Policy> actual=searchService.tokenString("cancer JeevanSathi");
        assertEquals(addPolicy,actual);

        if(companyString.contains("MaxBupa") && diseaseString.contains("cancer"))
            when( searchRepository.findByDiseasesListDiseaseName("cancer")).thenReturn(policy1);
        List<Policy> addPolicy1 =new ArrayList<>();
        for(Policy p:policy1){
            if(p.getInsurerName().equals("MaxBupa")){
                addPolicy1.add(p);
            }

        }
        List<Policy> actual1=searchService.tokenString("MaxBupa cancer");
        assertEquals(addPolicy1,actual1);

        if(companyString.contains("MaxBupa"))
            when( searchRepository.findByInsurerName("MaxBupa")).thenReturn(policy1);
        List<Policy> addPolicy2 =new ArrayList<>();
        for(Policy p:policy1){
            if(p.getPolicyName().equals("JeevanSathi")){
                addPolicy2.add(p);
            }
        }
        List<Policy> actual2=searchService.tokenString("MaxBupa JeevanSathi");
        assertEquals(addPolicy2,actual2);

        if(policyString.contains("JeevanSathi"))
            when( searchRepository.findByPolicyName("JeevanSathi")).thenReturn(policy1);
        List<Policy> addPolicy3 =new ArrayList<>();
        for(Policy p:policy1){
            if(p.getInsurerName().equals("MaxBupa")){
                addPolicy3.add(p);
            }
        }
        List<Policy> actual3=searchService.tokenString("MaxBupa JeevanSathi");
        assertEquals(addPolicy3,actual3);

        int num=4000;
        if(policyString.contains("JeevanSathi") && num>1000)
            when( searchRepository.findByPolicyName("JeevanSathi")).thenReturn(policy1);
            List<Policy> addPolicy4 =new ArrayList<>();

        for(Policy p:policy1){
//            System.out.println("amm" + (p.getSumInsured()==num));
            if(p.getSumInsured()==num){
                System.out.println(p.getSumInsured());
                addPolicy4.add(p);
            }
        }
        List<Policy> actual4=searchService.tokenString(" JeevanSathi  4000");
        assertEquals(addPolicy4,actual4);

        int age=30;
        if(policyString.contains("JeevanSathi") && age<100)
            when( searchRepository.findByPolicyName("JeevanSathi")).thenReturn(policy1);
        List<Policy> addPolicy5 =new ArrayList<>();

        for(Policy p:policy1){
//            System.out.println("amm" + (p.getSumInsured()==num));
            if(p.getMinAge()<age && p.getMaxAge()>age){
//                System.out.println(p.getSumInsured());
                addPolicy5.add(p);
            }
        }
        List<Policy> actual5=searchService.tokenString(" JeevanSathi  30");
        assertEquals(addPolicy5,actual5);


    }


//    @Test
//    public void getAllPolicies1() {
//        when(searchRepository.findAll()).thenReturn(policy1);
//        List<Policy> actual=searchService.getAllPolicies("diabetes");
//        assertEquals(policy1,actual);
//        verify(searchRepository, Mockito.times(1)).findAll();
////        verifyNoMoreInteractions(trackService);
//    }

    @Test
    public void savePolicy() {
        when(searchRepository.save(policy)).thenReturn(policy);
        Policy actual = searchService.savePolicy(policy);
        assertEquals(policy, actual);
        verify(searchRepository, times(1)).save(policy);

    }
}
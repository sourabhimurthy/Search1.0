package com.stackroute.pie.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collection = "Policy_")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Policy {
    public int policyId;
    public String policyName;
    public String insurerName;
    public String policyType;
   public List<Diseases> diseasesList;
    public int cashlessHospitals;
    public int waitingPeriod;
    public int monthlyPremium;
    public int yearlyPremium;
    public int sumInsured;
    public int minAge;
    public int maxAge;
    public String location;
    @JsonFormat(pattern="dd-MM-yyyy")
    public Date createdAt;
    @JsonFormat(pattern="dd-MM-yyyy")
    public Date updatedAt;
    public String createdBy;
    public String updatedBy;
}

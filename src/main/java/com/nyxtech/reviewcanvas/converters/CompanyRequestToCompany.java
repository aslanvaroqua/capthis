package com.nyxtech.reviewcanvas.converters;

import com.nyxtech.reviewcanvas.entity.CheckIn;
import com.nyxtech.reviewcanvas.entity.Company;
import com.nyxtech.reviewcanvas.models.CheckInRequest;
import com.nyxtech.reviewcanvas.models.CompanyRequest;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Strings.isNullOrEmpty;

/**
 * Created by varoqua on 12/10/15.
 */
@Component
public class CompanyRequestToCompany implements Converter<CompanyRequest, Company> {

    @Override
    public Company convert(CompanyRequest companyRequest) {
        checkNotNull(companyRequest, "company request cannot be null");
        checkArgument(!isNullOrEmpty(companyRequest.getDescription()), "description cannot be null or empty");
        checkArgument(!isNullOrEmpty(companyRequest.getEmail()), "email cannot be null or empty");
        checkArgument(!isNullOrEmpty(companyRequest.getIndustry()), "industry cannot be null or empty");
        checkArgument(!isNullOrEmpty(companyRequest.getLocation()), "location cannot be null or empty");
        checkArgument(!isNullOrEmpty(companyRequest.getName()), "name cannot be null or empty");
        Company company = new Company();
        company.setDescription(companyRequest.getDescription());
        company.setEmail(companyRequest.getEmail());
        company.setIndustry(companyRequest.getIndustry());
        company.setListOfUserIds(new ArrayList<String>());
        company.setLocation(companyRequest.getLocation());
        company.setName(companyRequest.getName());
        return company;
    }
}

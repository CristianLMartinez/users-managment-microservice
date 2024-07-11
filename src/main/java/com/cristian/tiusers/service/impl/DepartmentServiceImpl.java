package com.cristian.tiusers.service.impl;

import com.cristian.tiusers.dto.CompanyDto;
import com.cristian.tiusers.dto.DepartmentDto;
import com.cristian.tiusers.exception.CompanyNotFound;
import com.cristian.tiusers.mapper.CompanyMapper;
import com.cristian.tiusers.model.Company;
import com.cristian.tiusers.model.Department;
import com.cristian.tiusers.repository.CompanyRepository;
import com.cristian.tiusers.repository.DepartmentRepository;
import com.cristian.tiusers.service.CompanyService;
import com.cristian.tiusers.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {


    private final DepartmentRepository departmentRepository;
    private final CompanyRepository companyRepository;


    @Override
    public void saveDepartment(DepartmentDto department) {
        Company company = companyRepository.findById(department.companyId())
                .orElseThrow(() -> new CompanyNotFound("Company with id: "+department.companyId()+" not found"));
    }

    @Override
    public void updateDepartment(Department department) {

    }
}
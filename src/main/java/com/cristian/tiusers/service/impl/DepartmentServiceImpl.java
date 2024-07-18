package com.cristian.tiusers.service.impl;

import com.cristian.tiusers.aspect.Monitor;
import com.cristian.tiusers.dto.DepartmentDto;
import com.cristian.tiusers.exception.CompanyNotFoundException;
import com.cristian.tiusers.exception.DepartmentNotFoundException;

import com.cristian.tiusers.mapper.DepartmentMapper;
import com.cristian.tiusers.model.Company;
import com.cristian.tiusers.model.Department;
import com.cristian.tiusers.repository.CompanyRepository;
import com.cristian.tiusers.repository.DepartmentRepository;
import com.cristian.tiusers.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;


@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {


    private final DepartmentRepository departmentRepository;
    private final CompanyRepository companyRepository;


    @Override
    @Monitor
    public void saveDepartment(DepartmentDto department) {
        Company company = companyRepository.findById(department.companyId())
                .orElseThrow(() -> new CompanyNotFoundException("Company with id: "+department.companyId()+" not found"));

        Department departmentToSave = DepartmentMapper.dtoToDepartment(department);
        departmentToSave.setCompany(company);

        departmentRepository.save(departmentToSave);

    }

    @Override
    @Monitor
    public void updateDepartment(Long id, DepartmentDto departmentDto) {

        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new DepartmentNotFoundException("Department with id: "+id+" not found"));

        if(Objects.nonNull(departmentDto.name())) {
            department.setName(departmentDto.name());
        }

        if(Objects.nonNull(departmentDto.description())) {
            department.setDescription(departmentDto.description());
        }

        departmentRepository.save(department);

    }

    @Override
    public DepartmentDto getDepartmentById(Long id) {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() ->  new DepartmentNotFoundException("Department with id: "+id+" not found"));
        return DepartmentMapper.departmentToDto(department);
    }


}

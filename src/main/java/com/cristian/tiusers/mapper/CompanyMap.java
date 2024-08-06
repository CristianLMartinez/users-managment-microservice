package com.cristian.tiusers.mapper;

import com.cristian.tiusers.dto.CompanyDto;
import com.cristian.tiusers.model.Company;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CompanyMap {

    CompanyMap INSTANCE = Mappers.getMapper(CompanyMap.class);

    @Mapping(target = "departments", ignore = true)
    @Mapping(target = "users", ignore = true)
    Company dtoToCompany(CompanyDto dto);



}

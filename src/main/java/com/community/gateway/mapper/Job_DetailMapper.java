package com.community.gateway.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.community.gateway.dto.Job_DetailDTO;
import com.community.gateway.model.Job_Detail;
@Mapper(componentModel = "spring")
public interface Job_DetailMapper {
	Job_DetailDTO toJob_DetailDTO(Job_Detail job_detail);

    List<Job_DetailDTO> toJob_DetailDTOs(List<Job_Detail> job_detail);

    Job_Detail toJob_Detail(Job_DetailDTO job_detailDTO);
}

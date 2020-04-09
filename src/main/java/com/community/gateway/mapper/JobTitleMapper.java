package com.community.gateway.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

import com.community.gateway.dto.JobTitleDTO;
import com.community.gateway.model.JobTitle;
@Mapper(componentModel = "spring")
public interface JobTitleMapper {
	JobTitleDTO toJobTitleDTO(JobTitle jobtitle);

    List<JobTitleDTO> toJobTitleDTOs(List<JobTitle> jobtitle);

    JobTitle toJobTitle(JobTitleDTO jobtitleDTO);
}

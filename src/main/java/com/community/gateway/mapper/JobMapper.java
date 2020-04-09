package com.community.gateway.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.community.gateway.dto.JobDTO;
import com.community.gateway.model.Job;
@Mapper(componentModel = "spring")
public interface JobMapper {
	JobDTO toJobDTO(Job job);

    List<JobDTO> toJobDTOs(List<Job> job);

    Job toJob(JobDTO jobDTO);
}

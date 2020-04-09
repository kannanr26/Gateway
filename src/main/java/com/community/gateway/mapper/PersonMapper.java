package com.community.gateway.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.community.gateway.dto.PersonDTO;
import com.community.gateway.model.Person;
@Mapper(componentModel = "spring")
public interface PersonMapper {
	PersonDTO toPersonDTO(Person person);

    List<PersonDTO> toPersonDTOs(List<Person> person);

    Person toPerson(PersonDTO personDTO);
}

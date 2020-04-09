package com.community.gateway.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.community.gateway.dto.KulamDTO;
import com.community.gateway.model.Kulam;
@Mapper(componentModel = "spring")
public interface KulamMapper {
	KulamDTO toKulamDTO(Kulam kulam);

    List<KulamDTO> toKulamDTOs(List<Kulam> kulam);

    Kulam toKulam(KulamDTO kulamDTO);
}

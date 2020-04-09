package com.community.gateway.logical;

import java.util.List;

import javax.validation.Valid;

import com.community.gateway.dto.KulamDTO;
import com.community.gateway.exception.ResourceNotFoundException;

public interface KulamLogical {

	List<KulamDTO> findAll();

	KulamDTO findById(Long kulamId)throws ResourceNotFoundException;

	//KulamDTO save(@Valid Kulam kulamDTO);

	void delete(Long kulamId) throws ResourceNotFoundException;

	KulamDTO save(@Valid KulamDTO kulamDto);

}

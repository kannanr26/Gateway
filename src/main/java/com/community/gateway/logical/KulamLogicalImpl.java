package com.community.gateway.logical;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.community.gateway.dto.KulamDTO;
import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.mapper.KulamMapper;
import com.community.gateway.model.Kulam;
import com.community.gateway.service.KulamService;

@Service
public class KulamLogicalImpl implements KulamLogical {

	@Autowired
	KulamService kulamService;
	
	@Autowired
	KulamMapper kulamMapper;

	@Override
	public List<KulamDTO> findAll() {
		// TODO Auto-generated method stub
		return kulamMapper.toKulamDTOs(kulamService.findAll());
	}

	@Override
	public KulamDTO findById(Long kulamId) throws ResourceNotFoundException {
		return kulamMapper.toKulamDTO(kulamService.findById(kulamId));
	}

	@Override
	public KulamDTO save(@Valid KulamDTO kulamDto) {
		// TODO Auto-generated method stub
		return kulamMapper.toKulamDTO(kulamService.save(kulamMapper.toKulam(kulamDto)));
		
	}

	@Override
	public void delete(Long kulamId)throws ResourceNotFoundException {
		kulamService.delete(kulamId);

	}

}

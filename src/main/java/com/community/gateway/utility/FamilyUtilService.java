package com.community.gateway.utility;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.community.gateway.dto.CasteDTO;
import com.community.gateway.dto.DeityDTO;
import com.community.gateway.dto.GothiramDTO;
import com.community.gateway.dto.KulamDTO;
import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.jwt.response.MessageResponse;
import com.community.gateway.logical.CasteLogical;
import com.community.gateway.logical.DeityLogical;
import com.community.gateway.logical.GothiramLogical;
import com.community.gateway.logical.KulamLogical;
import com.community.gateway.logical.RelationshipNameLogical;

@Service
public class FamilyUtilService {

	private static final List<GothiramDTO> gothirams = new ArrayList<GothiramDTO>();
	private static final List<KulamDTO> kulams = new ArrayList<KulamDTO>();
	private static final List<DeityDTO> deitys = new ArrayList<DeityDTO>();
	private static final List<CasteDTO> castes = new ArrayList<CasteDTO>();

	private final GothiramLogical gothiramLogical;
	private final KulamLogical kulamLogical;
	private final DeityLogical deityLogical;
	private final CasteLogical casteLogical;

	@Autowired
	public FamilyUtilService(GothiramLogical gothiramLogical, KulamLogical kulamLogical, DeityLogical deityLogical,
			CasteLogical casteLogical, RelationshipNameLogical relationShipNameLogical) {

		this.gothiramLogical = gothiramLogical;
		this.kulamLogical = kulamLogical;
		this.deityLogical = deityLogical;
		this.casteLogical = casteLogical;
	}

	public List<GothiramDTO> getGothirams() {
		if (gothirams.isEmpty()) {
			gothirams.addAll(gothiramLogical.findAll());
		}
		System.out.println("Gothiram Size ::"+gothirams.size());
		return gothirams;
	}

	public ResponseEntity<MessageResponse> addGothirams(GothiramDTO gothiramDTO) {
		if (getGothirams().stream()
				.noneMatch(x -> x.getGothiramName().equalsIgnoreCase(gothiramDTO.getGothiramName()))) {
			GothiramDTO gothiramSaved = gothiramLogical.save(gothiramDTO);
			refreshGothirm();
			if(gothiramDTO.getId()==0)
				return ResponseEntity.ok().body(new MessageResponse(gothiramSaved, true, UtilityConstant.SUCCESS));
			else
				return ResponseEntity.ok().body(new MessageResponse( true,UtilityConstant.UPDATED_SUCCESS ));
		}
	return ResponseEntity.badRequest().body(new MessageResponse(false,UtilityConstant.FAILED));

	}

	private void refreshGothirm() {
		// TODO Auto-generated method stub
		gothirams.clear();
		getGothirams();
	}

	public List<KulamDTO> getKulams() {
		if (kulams.isEmpty()) {
			kulams.addAll(kulamLogical.findAll());
		}
		return kulams;
	}

	public ResponseEntity<MessageResponse> addKulams(KulamDTO kulamDTO) {
		try {
			if (getKulams().stream().noneMatch(x -> x.getKulamName().equalsIgnoreCase(kulamDTO.getKulamName()))) {
				KulamDTO kulamDTOSaved = kulamLogical.save(kulamDTO);
				refreshKulam();
				if(kulamDTO.getId()==0)
					return ResponseEntity.ok().body(new MessageResponse(kulamDTOSaved, true, UtilityConstant.SUCCESS));
				else
					return ResponseEntity.ok().body(new MessageResponse( true, UtilityConstant.UPDATED_SUCCESS));
			}
		} catch (Exception e) {

		}
		return ResponseEntity.badRequest().body(new MessageResponse(false,UtilityConstant.FAILED));
	}

	private void refreshKulam() {
		kulams.clear();
		getKulams();
	}

	public List<DeityDTO> getDeitys() {
		if (deitys.isEmpty()) {
			deitys.addAll(deityLogical.findAll());
		}
		return deitys;
	}

	public ResponseEntity<MessageResponse> addDeitys(DeityDTO deityDTO) {

		if (getDeitys().stream().noneMatch(x -> x.getDeityName().equalsIgnoreCase(deityDTO.getDeityName()))) {
			DeityDTO deitySaved = deityLogical.save(deityDTO);
			refreshDeity();
			if(deityDTO.getId()==0)
				return ResponseEntity.ok().body(new MessageResponse(deitySaved,true, UtilityConstant.SUCCESS ));
			else
				return ResponseEntity.ok().body(new MessageResponse(true, UtilityConstant.UPDATED_SUCCESS ));
		}
		return ResponseEntity.badRequest().body(new MessageResponse(false, UtilityConstant.FAILED));
		
	}

	private void refreshDeity() {
		// TODO Auto-generated method stub
		deitys.clear();
		getDeitys();
	}

	public boolean deleteKulams(Long kulamId) {
		try {
			kulamLogical.delete(kulamId);
			refreshKulam();
			return true;
		} catch (ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public List<CasteDTO> getCastes() {
		if (castes.isEmpty()) {
			castes.addAll(casteLogical.findAll());
		}
		return castes;
	}

	public ResponseEntity<MessageResponse> addCaste(CasteDTO casteDTO) {
		if (getCastes().stream().noneMatch(x -> x.getCasteName().equalsIgnoreCase(casteDTO.getCasteName()))) {
			CasteDTO casteSaved = casteLogical.save(casteDTO);
			refreshCaste();
			if(casteDTO.getId()==0)
				return ResponseEntity.ok().body(new MessageResponse(casteSaved,true, UtilityConstant.SUCCESS));
			else
				return ResponseEntity.ok().body(new MessageResponse("",true, UtilityConstant.UPDATED_SUCCESS));
		}
		return ResponseEntity.badRequest().body(new MessageResponse(false, UtilityConstant.FAILED));
	
	}

	private void refreshCaste() {
		// TODO Auto-generated method stub
		castes.clear();
		getCastes();

	}

	public boolean deleteCaste(Long casteId) {
		// TODO Auto-generated method stub
		try {
			casteLogical.delete(casteId);
			refreshCaste();
			return true;
		} catch (ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteGothiram(Long gothiramId) {
		// TODO Auto-generated method stub
		try {
			gothiramLogical.delete(gothiramId);
			refreshGothirm();
			return true;
		} catch (ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteDeity(Long deityId) {
		// TODO Auto-generated method stub
		try {
			deityLogical.delete(deityId);
			refreshDeity();
			return true;
		} catch (ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}

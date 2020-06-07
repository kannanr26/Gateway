package com.community.gateway.utility;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.community.gateway.dto.DeityDTO;
import com.community.gateway.dto.GothiramDTO;
import com.community.gateway.dto.KulamDTO;
import com.community.gateway.exception.ResourceNotFoundException;
import com.community.gateway.logical.DeityLogical;
import com.community.gateway.logical.GothiramLogical;
import com.community.gateway.logical.KulamLogical;

@Service
public class FamilyUtilService {

	private static final List<GothiramDTO> gothirams = new ArrayList<GothiramDTO>();
	private static final List<KulamDTO> kulams = new ArrayList<KulamDTO>();
	private static final List<DeityDTO> deitys = new ArrayList<DeityDTO>();

	private final GothiramLogical gothiramLogical;
	private final KulamLogical kulamLogical;
	private final DeityLogical deityLogical;

	@Autowired
	public FamilyUtilService(GothiramLogical gothiramLogical, KulamLogical kulamLogical, DeityLogical deityLogical) {

		this.gothiramLogical = gothiramLogical;
		this.kulamLogical = kulamLogical;
		this.deityLogical = deityLogical;
	}

	public List<GothiramDTO> getGothirams() {
		if (gothirams.isEmpty()) {
			gothirams.addAll(gothiramLogical.findAll());
		}
		return gothirams;
	}

	public boolean addGothirams(GothiramDTO gothiramDTO) {
		System.out.println("  gothiramDTO" + gothiramDTO.getGothiramName());
		if (getGothirams().stream().noneMatch(x -> x.getGothiramName().equalsIgnoreCase(gothiramDTO.getGothiramName()))) {
				System.out.println(" inside  if gothiramDTO");
			GothiramDTO gothiram = gothiramLogical.save(gothiramDTO);
			gothirams.add(gothiram);
			return true;
		}
		return false;
	}

	public List<KulamDTO> getKulams() {
		if (kulams.isEmpty()) {
			kulams.addAll(kulamLogical.findAll());
		}
		return kulams;
	}

	public boolean addKulams(KulamDTO kulamDTO) {
		if (getKulams().stream().noneMatch(x -> x.getKulamName().equalsIgnoreCase(kulamDTO.getKulamName()))) {
			KulamDTO kulam = kulamLogical.save(kulamDTO);
			kulams.add(kulam);
			return true;
		}
		return false;

	}

	public List<DeityDTO> getDeitys() {
		if (deitys.isEmpty()) {
			deitys.addAll(deityLogical.findAll());
		}
		return deitys;
	}

	public boolean addDeitys(DeityDTO deityDTO) {
		if (getDeitys().stream().noneMatch(x -> x.getCityName().equalsIgnoreCase(deityDTO.getCityName())
				&& x.getDeityName().equalsIgnoreCase(deityDTO.getDeityName()))) { // TODO need to check the logic
			DeityDTO deity = deityLogical.save(deityDTO);
			deitys.add(deity);
			return true;
		}
		return false;
	}

	public boolean deleteKulams(Long kulamId) {
		// TODO Auto-generated method stub
		 try {
			 kulams.remove(kulamLogical.findById(kulamId));
			kulamLogical.delete(kulamId);
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
			 gothirams.remove(gothiramLogical.findById(gothiramId));
			 gothiramLogical.delete(gothiramId);
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

			 deitys.remove(deityLogical.findById(deityId));
			 deityLogical.delete(deityId);
				return true;
			} catch (ResourceNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
	}
}

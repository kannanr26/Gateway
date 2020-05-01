package com.community.gateway.utility;

import com.community.gateway.dto.DeityDTO;
import com.community.gateway.dto.GothiramDTO;
import com.community.gateway.dto.KulamDTO;
import com.community.gateway.jwt.response.MessageResponse;
import com.community.gateway.logical.DeityLogical;
import com.community.gateway.logical.GothiramLogical;
import com.community.gateway.logical.KulamLogical;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;

@Service
public class FamilyService {

	private static final List<GothiramDTO> gothirams = new ArrayList<GothiramDTO>();
	private static final List<KulamDTO> kulams = new ArrayList<KulamDTO>();
	private static final List<DeityDTO> deitys = new ArrayList<DeityDTO>();

	private final GothiramLogical gothiramLocial;
	private final KulamLogical kulamLocial;
	private final DeityLogical deityLocial;

	@Autowired
	public FamilyService(GothiramLogical gothiramLogical, KulamLogical kulamLogical, DeityLogical deityLogical) {

		this.gothiramLocial = gothiramLogical;
		this.kulamLocial = kulamLogical;
		this.deityLocial = deityLogical;
	}

	public List<GothiramDTO> getGothirams() {
		if (gothirams.isEmpty()) {
			gothirams.addAll(gothiramLocial.findAll());
		}
		return gothirams;
	}

	public boolean addGothirams(GothiramDTO gothiramDTO) {
		System.out.println("  gothiramDTO" + gothiramDTO.getGothiramName());
		if (getGothirams().stream().noneMatch(x -> x.getGothiramName().equalsIgnoreCase(gothiramDTO.getGothiramName()))) {
				System.out.println(" inside  if gothiramDTO");
			GothiramDTO gothiram = gothiramLocial.save(gothiramDTO);
			gothirams.add(gothiram);
			return true;
		}
		return false;
	}

	public List<KulamDTO> getKulams() {
		if (kulams.isEmpty()) {
			kulams.addAll(kulamLocial.findAll());
		}
		return kulams;
	}

	public boolean addKulams(KulamDTO kulamDTO) {
		if (getKulams().stream().noneMatch(x -> x.getKulamName().equalsIgnoreCase(kulamDTO.getKulamName()))) {
			KulamDTO kulam = kulamLocial.save(kulamDTO);
			kulams.add(kulam);
			return true;
		}
		return false;

	}

	public List<DeityDTO> getDeitys() {
		if (deitys.isEmpty()) {
			deitys.addAll(deityLocial.findAll());
		}
		return deitys;
	}

	public boolean addDeitys(DeityDTO deityDTO) {
		if (getDeitys().stream().noneMatch(x -> x.getCityName().equalsIgnoreCase(deityDTO.getCityName())
				&& x.getDeityName().equalsIgnoreCase(deityDTO.getDeityName()))) { // TODO need to check the logic
			DeityDTO deity = deityLocial.save(deityDTO);
			deitys.add(deity);
			return true;
		}
		return false;
	}

}

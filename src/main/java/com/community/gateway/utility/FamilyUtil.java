package com.community.gateway.utility;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.community.gateway.dto.CasteDTO;
import com.community.gateway.dto.DeityDTO;
import com.community.gateway.dto.GothiramDTO;
import com.community.gateway.dto.KulamDTO;
import com.community.gateway.logical.DeityLogical;
import com.community.gateway.logical.GothiramLogical;
import com.community.gateway.logical.KulamLogical;

import lombok.Data;

@Data
@Service
public class FamilyUtil {

	public FamilyUtil() {
//		FamilyUtil.gothirams = getGothirams();
//		FamilyUtil.kulams = getKulams();
//		FamilyUtil.deitys = getDeitys();
	}

	@Autowired
	private GothiramLogical gothiramLocial;

	@Autowired
	private KulamLogical kulamLocial;

	@Autowired
	private DeityLogical deityLocial;

	private static List<GothiramDTO> gothirams;
	private static List<KulamDTO> kulams;
	private static List<DeityDTO> deitys;
	//private static List<CasteDTO> caste;
	//private static List<>
	public List<GothiramDTO> getGothirams() {
		if (FamilyUtil.gothirams == null || FamilyUtil.gothirams.isEmpty()) {
			return gothiramLocial.findAll();
		}
		return FamilyUtil.gothirams;
	}

	public void addGothirams(GothiramDTO gothirams) {
		if (!getGothirams().contains(gothirams)) {
			GothiramDTO gothiram = gothiramLocial.save(gothirams);
			FamilyUtil.gothirams.add(gothiram);
		}
	}

	public List<KulamDTO> getKulams() {
		if (FamilyUtil.kulams == null || FamilyUtil.kulams.isEmpty()) {
			return kulamLocial.findAll();
		}
		return FamilyUtil.kulams;
	}

	public void addKulams(KulamDTO kulams) {
		if (!getKulams().contains(kulams)) {
			KulamDTO kulam = kulamLocial.save(kulams);
			FamilyUtil.kulams.add(kulam);
		}

	}

	public List<DeityDTO> getDeitys() {
		if (FamilyUtil.deitys == null || FamilyUtil.deitys.isEmpty()) {
			return deityLocial.findAll();
		}
		return FamilyUtil.deitys;
	}

	public void addDeitys(DeityDTO deitys) {
		if (!getDeitys().contains(deitys)) {
			DeityDTO deity = deityLocial.save(deitys);
			FamilyUtil.deitys.add(deity);
		}
	}

}

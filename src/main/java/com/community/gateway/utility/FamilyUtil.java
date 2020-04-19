package com.community.gateway.utility;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.community.gateway.dto.CasteDTO;
import com.community.gateway.dto.DeityDTO;
import com.community.gateway.dto.GothiramDTO;
import com.community.gateway.dto.KulamDTO;
import com.community.gateway.jwt.response.MessageResponse;
import com.community.gateway.logical.DeityLogical;
import com.community.gateway.logical.GothiramLogical;
import com.community.gateway.logical.KulamLogical;

import lombok.Data;

public class FamilyUtil {

	@Autowired
	private static GothiramLogical gothiramLocial;

	@Autowired
	private static KulamLogical kulamLocial;

	@Autowired
	private static DeityLogical deityLocial;

	private static List<GothiramDTO> gothirams;
	private static List<KulamDTO> kulams;
	private static List<DeityDTO> deitys;
	//private static List<CasteDTO> caste;
	//private static List<>
	public static List<GothiramDTO> getGothirams() {
		if (FamilyUtil.gothirams == null || FamilyUtil.gothirams.isEmpty()) {
			FamilyUtil.gothirams=gothiramLocial.findAll();
		}
		return FamilyUtil.gothirams;
	}

	public static MessageResponse addGothirams(GothiramDTO gothirams) {
		if (!getGothirams().contains(gothirams)) {
			GothiramDTO gothiram = gothiramLocial.save(gothirams);
			FamilyUtil.gothirams.add(gothiram);
			return new MessageResponse(true,"Gothiram added Successfully");
		}
		return new MessageResponse(false,"Gothiram not added");
	}

	public static List<KulamDTO> getKulams() {
		if (FamilyUtil.kulams == null || FamilyUtil.kulams.isEmpty()) {
			FamilyUtil.kulams= kulamLocial.findAll();
		}
		return FamilyUtil.kulams;
	}

	public static MessageResponse addKulams(KulamDTO kulams) {
		if (!getKulams().contains(kulams)) {
			KulamDTO kulam = kulamLocial.save(kulams);
			FamilyUtil.kulams.add(kulam);
			return new MessageResponse(true ,"Kulam added Successfully ");
		}
		return new MessageResponse(false ,"Kulam not added");

	}

	public static List<DeityDTO> getDeitys() {
		if (FamilyUtil.deitys == null || FamilyUtil.deitys.isEmpty()) {
			FamilyUtil.deitys= deityLocial.findAll();
		}
		return FamilyUtil.deitys;
	}

	public static MessageResponse addDeitys(DeityDTO deitys) {
		if (!getDeitys().contains(deitys)) {
			DeityDTO deity = deityLocial.save(deitys);
			FamilyUtil.deitys.add(deity);
			return new MessageResponse(true ,"Deity added Successfully ");
		}
		return new MessageResponse(false ,"Deity not added");
	}

}

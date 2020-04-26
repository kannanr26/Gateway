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

    private static final BiPredicate<GothiramDTO, GothiramDTO> HAS_GOTHIRAM_NAME_MATCH = (inputDTO, gothiramDTO) ->
            gothiramDTO != null && gothiramDTO.getGothiramName() != null &&
                    inputDTO != null && gothiramDTO.getGothiramName().equalsIgnoreCase(inputDTO.getGothiramName());

    private static final List<GothiramDTO> gothirams = new ArrayList<>();
    private static final List<KulamDTO> kulams = new ArrayList<>();
    private static final List<DeityDTO> deitys = new ArrayList<>();

    private final GothiramLogical gothiramLocial;
    private final KulamLogical kulamLocial;
    private final DeityLogical deityLocial;

    @Autowired
    public FamilyService(GothiramLogical gothiramLogical,
                         KulamLogical kulamLogical,
                         DeityLogical deityLogical) {

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

    public MessageResponse addGothirams(GothiramDTO gothiramDTO) {

        if (getGothirams().stream().anyMatch(x -> HAS_GOTHIRAM_NAME_MATCH.test(gothiramDTO, x))) {
            GothiramDTO gothiram = gothiramLocial.save(gothiramDTO);
            gothirams.add(gothiram);
            return new MessageResponse(true, "Gothiram added Successfully");
        }
        return new MessageResponse(false, "Gothiram not added");
    }

    public List<KulamDTO> getKulams() {
        if (kulams.isEmpty()) {
            kulams.addAll(kulamLocial.findAll());
        }
        return kulams;
    }

    public MessageResponse addKulams(KulamDTO kulamDTO) {
        if (getKulams().stream().noneMatch(x -> x.getKulamName().equalsIgnoreCase(kulamDTO.getKulamName()))) {
            KulamDTO kulam = kulamLocial.save(kulamDTO);
            kulams.add(kulam);
            return new MessageResponse(true, "Kulam added Successfully ");
        }
        return new MessageResponse(false, "Kulam not added");

    }

    public List<DeityDTO> getDeitys() {
        if (deitys.isEmpty()) {
            deitys.addAll(deityLocial.findAll());
        }
        return deitys;
    }

    public MessageResponse addDeitys(DeityDTO deityDTO) {
        if (getDeitys().stream().noneMatch(x->x.getCityName().equalsIgnoreCase(deityDTO.getCityName()) &&
                x.getDeityName().equalsIgnoreCase(deityDTO.getDeityName()))) { //TODO need to check the logic
            DeityDTO deity = deityLocial.save(deityDTO);
            deitys.add(deity);
            return new MessageResponse(true, "Deity added Successfully ");
        }
        return new MessageResponse(false, "Deity not added");
    }

}

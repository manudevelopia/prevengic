package info.developia.prevengic.controller;

import info.developia.prevengic.dto.CompoundForm;
import info.developia.prevengic.model.ChemicalProfile;
import info.developia.prevengic.model.Compound;
import info.developia.prevengic.model.Note;
import info.developia.prevengic.model.WarningAdvice;
import info.developia.prevengic.service.CompoundService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/scrapper")
public class ScrapperController {

    private final CompoundService compoundService;

    public ScrapperController(CompoundService compoundService) {
        this.compoundService = compoundService;
    }

    @PostMapping("/compound")
    public ResponseEntity<Compound> createCompound(@RequestBody CompoundForm compoundForm) {

        Set<Note> notes = Optional.ofNullable(compoundForm.getNotes()).orElse(Collections.emptyList())
                .stream()
                .map(advise -> new Note(advise.getCode(), advise.getTitle()))
                .collect(Collectors.toSet());

        Set<WarningAdvice> warningAdvices = Optional.ofNullable(compoundForm.getWarns()).orElse(Collections.emptyList())
                .stream()
                .map(advise -> new WarningAdvice(advise.getCode(), advise.getTitle()))
                .collect(Collectors.toSet());

        ChemicalProfile chemicalProfile = ChemicalProfile.builder()
                .notes(notes)
                .warningAdvices(warningAdvices)
                .vlaEdPpm(compoundForm.getVlaEdPpm())
                .vlaEdMgm(compoundForm.getVlaEdMgm())
                .vlaEcPpm(compoundForm.getVlaEcPpm())
                .vlaEcMgm(compoundForm.getVlaEcMgm())
                .build();

        Compound newCompound = Compound.builder()
                .name(compoundForm.getName())
                .chemicalProfile(chemicalProfile)
                .build();

        Compound compound = compoundService.create(newCompound);

        return ResponseEntity.ok(compound);
    }
}

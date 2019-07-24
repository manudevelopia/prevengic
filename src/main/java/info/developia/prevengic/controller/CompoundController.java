package info.developia.prevengic.controller;

import info.developia.prevengic.dto.CompoundDto;
import info.developia.prevengic.model.Compound;
import info.developia.prevengic.service.CompoundService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/compounds")
public class CompoundController {

    private final CompoundService compoundService;

    public CompoundController(CompoundService compoundService) {
        this.compoundService = compoundService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Compound>> getAll() {
        List<Compound> compounds = compoundService.findAll();

        return ResponseEntity.ok(compounds);
    }

    @GetMapping("/find")
    public ResponseEntity<List<CompoundDto>> findBy(@RequestParam(required = false) String nce,
                                                    @RequestParam(required = false) String ncas,
                                                    @RequestParam(required = false) String name) {
        List<CompoundDto> compounds = compoundService.findBy(nce, ncas, name);

        return ResponseEntity.ok(compounds);
    }

}

package info.developia.prevengic.controller;

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
    ResponseEntity<List<Compound>> getAll() {
        List<Compound> compounds = compoundService.findAll();

        return ResponseEntity.ok(compounds);
    }

    @GetMapping("/find")
    ResponseEntity<List<Compound>> findByName(@RequestParam(required = false) String name,
                                        @RequestParam(required = false) String nce,
                                        @RequestParam(required = false) String cas) {
        List<Compound> compounds = compoundService.findBy(nce, cas, name);
        
        return ResponseEntity.ok(compounds);
    }

}

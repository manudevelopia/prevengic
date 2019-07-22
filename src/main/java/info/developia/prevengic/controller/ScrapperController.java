package info.developia.prevengic.controller;

import info.developia.prevengic.dto.ScrappedCompoundDto;
import info.developia.prevengic.service.ScrapperService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/scrapper")
public class ScrapperController {

    private final ScrapperService scrapperService;

    public ScrapperController(ScrapperService scrapperService) {
        this.scrapperService = scrapperService;
    }

    @PostMapping("/compound")
    public ResponseEntity createCompound(@RequestBody ScrappedCompoundDto scrappedCompoundDto) {

        scrapperService.parse(scrappedCompoundDto);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/compounds")
    public ResponseEntity createCompounds(@RequestBody List<ScrappedCompoundDto> scrappedCompoundDtoList) {

        scrappedCompoundDtoList.stream()
                .filter(c -> c.getParent().isEmpty())
                .forEach(scrapperService::parse);

        scrappedCompoundDtoList.stream()
                .filter(c -> !c.getParent().isEmpty())
                .forEach(scrapperService::parse);

        return ResponseEntity.ok().build();
    }
}

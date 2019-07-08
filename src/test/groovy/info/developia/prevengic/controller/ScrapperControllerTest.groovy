package info.developia.prevengic.controller

import info.developia.prevengic.dto.CompoundForm
import info.developia.prevengic.model.ChemicalProfile
import info.developia.prevengic.model.Compound
import info.developia.prevengic.model.Note
import info.developia.prevengic.model.WarningAdvice
import info.developia.prevengic.service.CompoundService
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.springframework.http.ResponseEntity
import spock.lang.Specification

import static org.mockito.ArgumentMatchers.any
import static org.mockito.Mockito.when

class ScrapperControllerTest extends Specification {

    @Mock
    CompoundService compoundService

    @InjectMocks
    ScrapperController scrapperController

    def setup() {
        MockitoAnnotations.initMocks(this)
    }

    def "test create Compound"() {
        given:
        when(compoundService.create(any())).thenReturn(new Compound("nce", "ncas", "name", new ChemicalProfile(0d, 0d, 0d, 0d, [new WarningAdvice("code", "description")] as Set<WarningAdvice>, [new Note("code", "description")] as Set<Note>)))

        when:
        ResponseEntity<Compound> result = scrapperController.createCompound(
                new CompoundForm(
                        "link", "name",
                        ["vlas"] as String[], 0d, 0d, 0d, 0d,
                        [new CompoundForm.Advise("code", "title")],
                        [new CompoundForm.Advise("code", "title")]))

        then:
        result.statusCode.'2xxSuccessful'
        result.getBody() != null
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme
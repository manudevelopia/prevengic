package info.developia.prevengic.controller

import info.developia.prevengic.model.Compound
import info.developia.prevengic.service.CompoundService
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.springframework.http.ResponseEntity
import spock.lang.Specification

import static org.mockito.Mockito.when

class CompoundControllerTest extends Specification {

    @Mock
    CompoundService compoundService

    @InjectMocks
    CompoundController compoundController

    Compound compound

    def setup() {
        MockitoAnnotations.initMocks(this)

        compound = new Compound(cas: "cas", nce: "nce", name: "Test compound")
    }

    def "test get All"() {
        given:
        when(compoundService.findAll()).thenReturn([compound])

        when:
        ResponseEntity<List<Compound>> result = compoundController.getAll()

        then:
        result.getBody()
    }

    def "test find By Name"() {
        given:
        when(compoundService.findBy(null, null, "Test compound")).thenReturn([compound])

        when:
        ResponseEntity<List<Compound>> result = compoundController.findBy(null, null, "Test compound")

        then:
        !result.getBody()
    }

    def "test find By Nce"() {
        given:
        when(compoundService.findBy("nce", null, null)).thenReturn([compound])

        when:
        ResponseEntity<List<Compound>> result = compoundController.findBy("nce", null, null)

        then:
        !result.getBody()
    }

    def "test find By Cas"() {
        given:
        when(compoundService.findBy(null, "cas", null)).thenReturn([compound])

        when:
        ResponseEntity<List<Compound>> result = compoundController.findBy(null, "cas", null)

        then:
        !result.getBody()
    }

}
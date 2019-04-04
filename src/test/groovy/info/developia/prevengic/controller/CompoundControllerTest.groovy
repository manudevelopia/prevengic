package info.developia.prevengic.controller

import info.developia.prevengic.model.Compound
import info.developia.prevengic.service.CompoundService
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.springframework.http.ResponseEntity
import spock.lang.Specification

import static org.mockito.ArgumentMatchers.anyString
import static org.mockito.Mockito.when

class CompoundControllerTest extends Specification {

    @Mock
    CompoundService compoundService

    @InjectMocks
    CompoundController compoundController

    Compound compound

    def setup() {
        MockitoAnnotations.initMocks(this)
        compound = new Compound(cas: "CAS", nce: "NCE", name: "Test compound1")
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
        when(compoundService.findByName(anyString())).thenReturn([compound])

        when:
        ResponseEntity<List<Compound>> result = compoundController.findByName("name", null, null)

        then:
        !result.getBody().isEmpty()
    }

    def "test find By Nce"() {
        given:
        when(compoundService.findByNce(anyString())).thenReturn([compound])

        when:
        ResponseEntity<List<Compound>> result = compoundController.findByName(null, "nce", null)

        then:
        !result.getBody().isEmpty()
    }

    def "test find By Cas"() {
        given:
        when(compoundService.findByCas(anyString())).thenReturn([compound])

        when:
        ResponseEntity<List<Compound>> result = compoundController.findByName(null, null, "cas")

        then:
        !result.getBody().isEmpty()
    }

}
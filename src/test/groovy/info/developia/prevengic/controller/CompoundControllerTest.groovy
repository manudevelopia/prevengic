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

    def name = "Test compound"
    def cas = "cas"
    def nce = "nce"

    def setup() {
        MockitoAnnotations.initMocks(this)

        compound = new Compound(cas: cas, nce: nce, name: name)
    }

    def "test get All"() {
        given:
        when(compoundService.findAll()).thenReturn([compound])

        when:
        ResponseEntity<List<Compound>> results = compoundController.getAll()

        then:
        def result = results.getBody().get(0)

        result.name == name
        result.cas == cas
        result.nce == nce
    }

    def "test find By Name"() {
        given:
        when(compoundService.findBy(null, null, name)).thenReturn([compound])

        when:
        ResponseEntity<List<Compound>> results = compoundController.findBy(null, null, name)

        then:
        def result = results.getBody().get(0)

        result.name == name
        result.cas == cas
        result.nce == nce
    }

    def "test find By Nce"() {
        given:
        when(compoundService.findBy("nce", null, null)).thenReturn([compound])

        when:
        ResponseEntity<List<Compound>> results = compoundController.findBy(nce, null, null)

        then:
        def result = results.getBody().get(0)

        result.name == name
        result.cas == cas
        result.nce == nce
    }

    def "test find By Cas"() {
        given:
        when(compoundService.findBy(null, "cas", null)).thenReturn([compound])

        when:
        ResponseEntity<List<Compound>> results = compoundController.findBy(null, cas, null)

        then:
        def result = results.getBody().get(0)

        result.name == name
        result.cas == cas
        result.nce == nce
    }

}
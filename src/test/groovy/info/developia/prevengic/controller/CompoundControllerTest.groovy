package info.developia.prevengic.controller

import info.developia.prevengic.model.Compound
import info.developia.prevengic.service.CompoundService
import org.springframework.http.ResponseEntity
import spock.lang.Specification

class CompoundControllerTest extends Specification {

    CompoundService compoundService
    CompoundController compoundController
    Compound compound

    def name = "Test compound"
    def ncas = "ncas"
    def nce = "nce"

    def setup() {
        compoundService = Mock()
        compoundController = new CompoundController(compoundService)

        compound = new Compound(ncas: ncas, nce: nce, name: name)
    }

    def "test get All"() {
        given:
        compoundService.findAll() >> [compound]

        when:
        ResponseEntity<List<Compound>> results = compoundController.getAll()

        then:
        verifyAll(results.getBody().get(0)) {
            name == this.name
            ncas == this.ncas
            nce == this.nce
        }
    }

    def "test find By Name"() {
        given:
        compoundService.findBy(null, null, name) >> [compound]

        when:
        ResponseEntity<List<Compound>> results = compoundController.findBy(null, null, name)

        then:
        verifyAll(results.getBody().get(0)) {
            name == this.name
            ncas == this.ncas
            nce == this.nce
        }
    }

    def "test find By Nce"() {
        given:
        compoundService.findBy(nce, null, null) >> [compound]

        when:
        ResponseEntity<List<Compound>> results = compoundController.findBy(nce, null, null)

        then:
        verifyAll(results.getBody().get(0)) {
            name == this.name
            ncas == this.ncas
            nce == this.nce
        }
    }

    def "test find By NCas"() {
        given:
        compoundService.findBy(null, ncas, null) >> [compound]

        when:
        ResponseEntity<List<Compound>> results = compoundController.findBy(null, ncas, null)

        then:
        verifyAll(results.getBody().get(0)) {
            name == this.name
            this.ncas == this.ncas
            nce == this.nce
        }
    }

}
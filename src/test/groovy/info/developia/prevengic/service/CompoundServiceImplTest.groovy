package info.developia.prevengic.service

import info.developia.prevengic.model.Compound
import info.developia.prevengic.repository.CompoundRepository
import spock.lang.Specification

class CompoundServiceImplTest extends Specification {

    CompoundRepository compoundRepository
    CompoundServiceImpl compoundService

    Compound compound
    info.developia.prevengic.dao.Compound compoundDao

    def setup() {
        compoundRepository = Mock()
        compoundService = new CompoundServiceImpl(compoundRepository)

        compound = new Compound(cas: "CAS", nce: "NCE", name: "Test compound1")
        compoundDao = new info.developia.prevengic.dao.Compound(cas: "CAS", nce: "NCE", name: "Test compound1")
    }

    def "test find All"() {
        given:
        compoundRepository.findAll() >> [compoundDao]

        when:
        List<Compound> result = compoundService.findAll()

        then:
        result == [compound]
    }

    def "test find By Name"() {
        given:
        compoundRepository.findAll(_) >> [compoundDao]

        when:
        List<Compound> result = compoundService.findBy("", "", "compound")

        then:
        result == [compound]
    }

    def "test find By Nce"() {
        given:
        compoundRepository.findAll(_) >> [compoundDao]

        when:
        List<Compound> result = compoundService.findBy(null, "nce", null)

        then:
        result == [compound]
    }

    def "test find By Cas"() {
        given:
        compoundRepository.findAll(_) >> [compoundDao]

        when:
        List<Compound> result = compoundService.findBy("cas", null, null)

        then:
        result == [compound]
    }

}
package info.developia.prevengic.service

import info.developia.prevengic.dao.CompoundDao
import info.developia.prevengic.dto.CompoundDto
import info.developia.prevengic.model.Compound
import info.developia.prevengic.repository.CompoundRepository
import spock.lang.Specification

class CompoundServiceImplTest extends Specification {

    CompoundRepository compoundRepository
    CompoundServiceImpl compoundService

    Compound compound
    CompoundDto compoundDto
    CompoundDao compoundDao

    def setup() {
        compoundRepository = Mock()
        compoundService = new CompoundServiceImpl(compoundRepository)

        compound = new Compound(ncas: "ncas", nce: "nce", name: "Test compound1")
        compoundDto = new CompoundDto(ncas: "ncas", nce: "nce", name: "Test compound1")
        compoundDao = new CompoundDao(ncas: "ncas", nce: "nce", name: "Test compound1")
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
        List<CompoundDto> result = compoundService.findBy("", "", "compound")

        then:
        result == [compoundDto]
    }

    def "test find By Nce"() {
        given:
        compoundRepository.findAll(_) >> [compoundDao]

        when:
        List<CompoundDto> result = compoundService.findBy(null, "nce", null)

        then:
        result == [compoundDto]
    }

    def "test find By NCas"() {
        given:
        compoundRepository.findAll(_) >> [compoundDao]

        when:
        List<CompoundDto> result = compoundService.findBy("ncas", null, null)

        then:
        result == [compoundDto]
    }

}
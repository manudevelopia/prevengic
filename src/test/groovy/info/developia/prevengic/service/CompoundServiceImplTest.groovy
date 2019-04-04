package info.developia.prevengic.service


import info.developia.prevengic.model.Compound
import info.developia.prevengic.repository.CompoundRepository
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import spock.lang.Specification

import static org.mockito.ArgumentMatchers.anyString
import static org.mockito.Mockito.when

class CompoundServiceImplTest extends Specification {
    @Mock
    CompoundRepository compoundRepository

    @InjectMocks
    CompoundServiceImpl compoundServiceImpl

    Compound compound
    info.developia.prevengic.dao.Compound compoundDao

    def setup() {
        MockitoAnnotations.initMocks(this)

        compound = new Compound(cas: "CAS", nce: "NCE", name: "Test compound1")
        compoundDao = new info.developia.prevengic.dao.Compound(cas: "CAS", nce: "NCE", name: "Test compound1")
    }

    def "test find All"() {
        given:
        when(compoundRepository.findAll()).thenReturn([compoundDao])

        when:
        List<Compound> result = compoundServiceImpl.findAll()

        then:
        result == [compound]
    }

    def "test find By Name"() {
        given:
        when(compoundRepository.findByNameIgnoreCaseContaining(anyString())).thenReturn(Optional.of([compoundDao]))

        when:
        List<Compound> result = compoundServiceImpl.findByName("name")

        then:
        result == [compound]
    }

    def "test find By Nce"() {
        given:
        when(compoundRepository.findByNceIgnoreCaseContaining(anyString())).thenReturn(Optional.of([compoundDao]))

        when:
        List<Compound> result = compoundServiceImpl.findByNce("nce")

        then:
        result == [compound]
    }

    def "test find By Cas"() {
        given:
        when(compoundRepository.findByCasIgnoreCaseContaining(anyString())).thenReturn(Optional.of([compoundDao]))

        when:
        List<Compound> result = compoundServiceImpl.findByCas("cas")

        then:
        result == [compound]
    }

}
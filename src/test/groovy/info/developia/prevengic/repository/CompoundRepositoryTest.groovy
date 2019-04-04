package info.developia.prevengic.repository

import info.developia.prevengic.dao.Compound
import info.developia.prevengic.repository.CompoundRepository
import org.junit.Assert
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import spock.lang.Specification

@DataJpaTest
class CompoundRepositoryTest extends Specification {

    @Autowired
    CompoundRepository compoundRepository

    Compound compound

    def setup() {
        compound = new Compound(cas: "CAS", nce: "NCE", name: "Test compound1")

        compoundRepository.save(compound)
    }

    def "testFindByNameIgnoreCaseContaining"() {
        when:
        Compound result = compoundRepository.findByNameIgnoreCaseContaining("Test compound1").get().get(0)

        then:
        Assert.assertTrue(result.name.contains("Test compound1"))
    }

    def "testFindByNceIgnoreCaseContaining"() {
        when:
        Compound result = compoundRepository.findByNceIgnoreCaseContaining("NCE").get().get(0)

        then:
        Assert.assertEquals("NCE", result.nce)
    }

    def "testFindByCasIgnoreCaseContaining"() {
        when:
        Compound result = compoundRepository.findByCasIgnoreCaseContaining("CAS").get().get(0)

        then:
        Assert.assertEquals("CAS", result.cas)
    }

}

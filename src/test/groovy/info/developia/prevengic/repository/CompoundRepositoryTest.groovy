package info.developia.prevengic.repository

import info.developia.prevengic.dao.Compound
import info.developia.prevengic.repository.CompoundRepository
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

    def "find compound by name"() {
        when:
        Compound result = compoundRepository.findByName("Test compound1").get()

        then:
        result.name.contains("Test compound1")
    }

}

package info.developia.prevengic.controller

import info.developia.prevengic.dto.ScrappedCompoundDto
import info.developia.prevengic.service.ScrapperService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import spock.lang.Specification

class ScrapperControllerTest extends Specification {

    ScrapperService scrapperService

    ScrapperController scrapperController

    def setup() {
        scrapperService = Mock()
        scrapperController = new ScrapperController(scrapperService)
    }

    def "test create Compounds"() {
        when:
        ResponseEntity result = scrapperController.createCompounds([new ScrappedCompoundDto("link", "name", "parent", "ncas", "nce", "url", ["vlas"] as String[], 0d, 0d, 0d, 0d, [new ScrappedCompoundDto.Advise("code", "title")], [new ScrappedCompoundDto.Advise("code", "title")])])

        then:
        with(result) {
            statusCode == HttpStatus.OK
            body == null
        }
    }

}

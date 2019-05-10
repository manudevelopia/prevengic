package info.developia.prevengic.controller

import spock.lang.Specification

class HomeControllerTest extends Specification {

    HomeController homeController

    def setup() {
        homeController = new HomeController()
    }

    def "Home controller provides 'index' template"() {
        when:
        def result = homeController.home()

        then:
        result == "index"
    }
}

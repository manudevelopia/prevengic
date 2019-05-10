package info.developia.prevengic.controller

import info.developia.prevengic.exception.UserDoesNotExistException
import info.developia.prevengic.model.User
import info.developia.prevengic.service.UserService
import spock.lang.Specification


class UserControllerTest extends Specification {

    UserController userController
    UserService userService

    def setup() {
        userService = Mock()
        userController = new UserController(userService)
    }

    def "Retrieve User when passing an email"() {
        given:
        def user = new User(email: "johndoe@email.com", name: "John Doe")
        userService.getUserBy(_ as String) >> user

        when:
        def result = userController.getByEmail("johndoe@email.com")

        then:
        verifyAll(result) {
            user.email == "johndoe@email.com"
            user.name == "John Doe"
        }
    }

    def "Exception when passing a non existing email"() {

        given:
        userService.getUserBy(_ as String) >> { throw new UserDoesNotExistException() }

        when:
        userController.getByEmail("non_existing@email.com")

        then:
        thrown(UserDoesNotExistException)
    }

}
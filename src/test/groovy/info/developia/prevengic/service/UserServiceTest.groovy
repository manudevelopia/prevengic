package info.developia.prevengic.service


import info.developia.prevengic.dao.UserDao
import info.developia.prevengic.exception.UserDoesNotExistException
import info.developia.prevengic.repository.UserRepository
import spock.lang.Specification

class UserServiceTest extends Specification {

    UserService userService
    UserRepository userRepository
    UserDao user

    def setup() {
        userRepository = Mock()
        userService = new UserServiceImpl(userRepository)

        user = new UserDao(name: "John Doe", email: "johndoe@email.com")
    }

    def "Obtain User providing email"() {
        given:
        userRepository.findByEmail("johndoe@email.com") >> Optional.of(user)

        when:
        def result = userService.getUserBy("johndoe@email.com")

        then:
        verifyAll(result) {
            name == "John Doe"
            email == "johndoe@email.com"
        }

    }

    def "No user is retieved when providing an invalid email"() {
        given:
        userRepository.findByEmail("nonvalid@email.com") >> { throw new UserDoesNotExistException() }

        when:
        userService.getUserBy("nonvalid@email.com")

        then:
        thrown(UserDoesNotExistException)
    }

}

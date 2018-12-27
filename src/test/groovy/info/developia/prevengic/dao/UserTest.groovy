package info.developia.prevengic.dao


import info.developia.prevengic.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import spock.lang.Specification

import javax.validation.ConstraintViolationException

@DataJpaTest
class UserTest extends Specification {

    @Autowired
    UserRepository repository

    String userEmail
    String userName
    String userPassword

    def setup() {
        userEmail = "user@user.com"
        userName = "John Doe"
        userPassword = "secret"
    }

    def "user can be persisted and recovered"() {
        given:
        User user = new User(email: userEmail, name: userName, password: userPassword)

        when:
        repository.save(user)

        then:
        User result = repository.findByEmail(userEmail).get()

        verifyAll(result) {
            email == userEmail
            name == userName
            password == userPassword
        }
    }

    def "user has to provide a valid email to be persisted"() {
        given:
        userEmail = "invalid @mail"
        User user = new User(email: userEmail)

        when:
        repository.save(user)
        repository.findByEmail(userEmail).get()

        then:
        thrown(ConstraintViolationException)
    }

}

package info.developia.prevengic.dao


import info.developia.prevengic.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import spock.lang.Specification
import spock.lang.Unroll

import javax.validation.ConstraintViolationException

@DataJpaTest
class UserTest extends Specification {

    @Autowired
    UserRepository repository

    String userEmail
    String userName

    def setup() {
        userEmail = "user@user.com"
        userName = "John Doe"
    }

    def "User can be persisted and recovered"() {
        given:
        User user = new User(email: userEmail, name: userName)

        when:
        repository.save(user)

        then:
        User result = repository.findByEmail(userEmail).get()

        verifyAll(result) {
            email == userEmail
            name == userName
        }
    }

    def "User has to provide a valid email and name to be persisted"() {
        given:
        User user = new User(email: e, name: n)

        when:
        repository.save(user)
        repository.findByEmail(e).get()

        then:
        thrown(ConstraintViolationException)

        where:
        e                   | n
        ""                  | ""
        "valid@mail.com"    | ""
        "invalid@mail"      | "Name"
        "invalid @mail"     | "Name"
        "invalid @mail.com" | "Name"
    }

}

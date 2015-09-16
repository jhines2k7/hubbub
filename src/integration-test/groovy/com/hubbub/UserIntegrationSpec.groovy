package com.hubbub

import grails.test.mixin.integration.Integration
import grails.transaction.*
import spock.lang.*

@Integration
@Rollback
class UserIntegrationSpec extends Specification {
    def "Saving our first user to the database"() {
        given: "A brand new user"
        def james = new User(
                loginId: 'james',
                password: 'secret',
                homepage: 'http://www.jamesohines.com'
        )

        when: "the user is saved"
        james.save()

        then: "it saved successfully and can be found in the database"
        james.errors.errorCount == 0
        james.id != null
        User.get(james.id).loginId == james.loginId
    }

}

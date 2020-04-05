package com.acme.example.spock

import org.junit.experimental.categories.Category
import spock.lang.Specification

@Category(UnitTest.class)
class UserDataFactortySpec extends Specification {

    def userDataFactorty = new UserDataFactorty()

    def 'Create User Sample'() {
        expect: 'Should return the correct message'
        userDataFactorty.createSampleUserDefault() != null
    }
}
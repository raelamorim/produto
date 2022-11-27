package br.com.itau.pp8;

//import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;

@MicronautTest
class GrpcexemploTest {

    @Inject
    EmbeddedApplication<?> application;

    @Test
    void testItWorks() {
//        Assertions.assertTrue(application.isRunning());
    }

}

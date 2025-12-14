package com.projeto.notafiscal;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
// Exclui as classes de autoconfiguração do Spring Security para este teste
@AutoConfigureMockMvc
@ActiveProfiles("test") // Opção: usar um profile de teste
@EnableAutoConfiguration(exclude = {SecurityAutoConfiguration.class})
class NotaFiscalApplicationTests {

	@Test
	void contextLoads() {
	}

}

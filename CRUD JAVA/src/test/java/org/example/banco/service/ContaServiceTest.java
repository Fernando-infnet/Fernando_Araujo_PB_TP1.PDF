package org.example.banco.service;

import org.example.banco.entity.Conta;
import org.example.banco.repository.ContaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ContaServiceTest {

    @Autowired
    private ContaService contaService;

    @Autowired
    private ContaRepository contaRepository;

    private Long lpId;
    private Long felipeId;

    @BeforeEach
    void setup() {
        contaRepository.deleteAll();
        Conta lp = contaService.incluirContaDb("LP", 100.0);
        Conta felipe = contaService.incluirContaDb("Felipe", 200.0);
        lpId = lp.getId();
        felipeId = felipe.getId();
    }

    @Test
    void testConsultarContaDb() {
        Conta conta = contaService.consultarContaDb(lpId);
        assertEquals("LP", conta.getNome());
    }

    @Test
    void testAlterarConta() {
        contaService.alterarConta(lpId, 500.0);
        Conta conta = contaService.consultarContaDb(lpId);
        assertEquals(500.0, conta.getSaldo());
    }

    @Test
    void testExcluirConta() {
        contaService.excluirContaDb(felipeId);
        assertThrows(NoSuchElementException.class, () -> contaService.consultarContaDb(felipeId));
    }

    @Test
    void testConsultarContasDb() {
        assertEquals(2, contaService.consultarContasDb().size());
    }
}

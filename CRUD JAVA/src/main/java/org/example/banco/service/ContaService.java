package org.example.banco.service;

import org.example.banco.entity.Conta;
import org.example.banco.repository.ContaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContaService {

    private final ContaRepository contaRepository;

    public ContaService(ContaRepository contaRepository) {
        this.contaRepository = contaRepository;
    }

    public Conta incluirContaDb(String nome, Double saldo) {
        Conta conta = new Conta(null, nome, saldo);
        return contaRepository.save(conta); 
    }

    public Conta consultarContaDb(Long id) {
        Optional<Conta> optionalConta = contaRepository.findById(id);
        if (optionalConta.isEmpty()) {
            throw new java.util.NoSuchElementException("Conta não encontrada com id: " + id);
        }
        return optionalConta.get();
    }

    public List<Conta> consultarContasDb() {
        return contaRepository.findAll();
    }

    public void alterarConta(Long id, Double saldo) {
        Conta conta = consultarContaDb(id); 
        conta.setSaldo(saldo);
        contaRepository.save(conta);
    }

    public void excluirContaDb(Long id) {
        if (!contaRepository.existsById(id)) {
            throw new java.util.NoSuchElementException("Conta não encontrada com id: " + id);
        }
        contaRepository.deleteById(id);
    }
}

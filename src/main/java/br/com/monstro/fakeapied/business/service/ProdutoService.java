package br.com.monstro.fakeapied.business.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.monstro.fakeapied.apiv1.dto.ProductsDTO;
import br.com.monstro.fakeapied.infrastructure.entities.ProdutoEntity;
import br.com.monstro.fakeapied.infrastructure.repositories.ProdutoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository repository;
    
    public ProdutoEntity salvaProduto(ProdutoEntity entity){
        try {
            return repository.save(entity);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar produtos " + e);
        }
    }

    public List<ProdutoEntity> buscaTodosProdutos(){
        try{
            return repository.findAll();
        } catch (Exception e){
            throw new RuntimeException("Erro ao buscar todos os produtos " + e);
        }
    }

public Boolean existPorNome(String nome){
    try{
        return repository.existsByNome(nome);
    } catch (Exception e) {
        throw new RuntimeException(String.format("Erro ao buscar produto por nome ", nome) + e);
    }
}

}

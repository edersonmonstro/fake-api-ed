package br.com.monstro.fakeapied.business.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.monstro.fakeapied.apiv1.dto.ProductsDTO;
import br.com.monstro.fakeapied.business.converter.ProdutoConverter;
import br.com.monstro.fakeapied.infrastructure.entities.ProdutoEntity;
import br.com.monstro.fakeapied.infrastructure.repositories.ProdutoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository repository;
    private final ProdutoConverter converter;
    
    public ProdutoEntity salvaProduto(ProdutoEntity entity){
        try {
            return repository.save(entity);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar produtos " + e);
        }
    }

    public ProductsDTO salvaProdutoDTO(ProductsDTO dto){
        try {
            ProdutoEntity entity = converter.toEntity(dto);
            return converter.toDTO(repository.save(entity));
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar produtos " + e);
        }
    }

    // public List<ProdutoEntity> buscaTodosProdutos(){
    //     try{
    //         return repository.findAll();
    //     } catch (Exception e){
    //         throw new RuntimeException("Erro ao buscar todos os produtos " + e);
    //     }
    // }

     public List<ProductsDTO> buscaTodosProdutos(){
        try{
            return converter.toListDTO(repository.findAll());
        } catch (Exception e){
            throw new RuntimeException("Erro ao buscar todos os produtos " + e);
        }
    }

    public ProductsDTO buscaProdutoPorNome(String nome){
         try{
            return converter.toDTO(repository.findByNome(nome));
        } catch (Exception e) {
            throw new RuntimeException(String.format("Erro ao buscar produto por nome ", nome) + e);
        }
    }

    public void deletaProduto(String nome){
        try{
            repository.deleteByNome(nome);
        } catch (Exception e) {
            throw new RuntimeException(String.format("Erro ao excluir produto por nome ", nome) + e);
        }
    }

public Boolean existPorNome(String nome){
    try{
        return repository.existsByNome(nome);
    } catch (Exception e) {
        throw new RuntimeException(String.format("Erro ao buscar produto por nome ", nome) + e);
    }
}

    public ProductsDTO updateProduto(String id, ProductsDTO dto){
        try {
            ProdutoEntity entity = repository.findById(id).orElseThrow(() -> new RuntimeException("id nao encontrado"));
            salvaProduto(converter.toEntityUpdate(entity, dto, id));
            return converter.toDTO(repository.findByNome(entity.getNome()));
        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar produto" + e);
        }

    }

}

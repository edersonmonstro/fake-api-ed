package br.com.monstro.fakeapied.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.monstro.fakeapied.infrastructure.entities.ProdutoEntity;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoEntity, String> {
    
    Boolean existsByNome(String nome);

}

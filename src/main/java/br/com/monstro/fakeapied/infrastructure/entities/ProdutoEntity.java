package br.com.monstro.fakeapied.infrastructure.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "ProdutoEntity")
@Table(name = "produtos")
@Getter 
@Setter 
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProdutoEntity {
 
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "title", length = 1000)
    private String nome;

    @Column(name = "price")
    private BigDecimal preco;
    
    @Column(name = "category", length = 1000)
    private String categoria;
    
    @Column(name = "description", length = 1000)
    private String descricao;
    
    @Column(name = "image", length = 2000)
    private String imagem;

    @Column(name = "data_inclusao")
    private LocalDateTime dataInclusao;

}

package br.com.monstro.fakeapied.business.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.monstro.fakeapied.apiv1.dto.ProductsDTO;
import br.com.monstro.fakeapied.business.converter.ProdutoConverter;
import br.com.monstro.fakeapied.infrastructure.client.FakeApiClient;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FakeApiService {
    
    private final FakeApiClient cliente;
    private final ProdutoConverter converter;
    private final ProdutoService service;

    public List<ProductsDTO> buscaProdutos(){

        try{

        } catch (Exception e) {
            
        }
        List<ProductsDTO> dto = cliente.buscaListaProdutos();
        dto.forEach(produto -> service.salvaProduto(converter.toEntity(produto))
        
        );
        return converter.toListDTO(service.buscaTodosProdutos());
    }
}

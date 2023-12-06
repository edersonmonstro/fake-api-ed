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
            List<ProductsDTO> dto = cliente.buscaListaProdutos();
            dto.forEach(produto -> {
                Boolean retorno =  service.existPorNome(produto.getNome());
                if(retorno.equals(false)){
                    service.salvaProduto(converter.toEntity(produto));
                }
                //throw new RuntimeException(String.format("Produto já cadastrado no banco de dados", produto.getNome()));
            }
            );
            return service.buscaTodosProdutos();
        } catch(Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao buscar e salvar produtos no banco de dados");
        }
        
    }
}

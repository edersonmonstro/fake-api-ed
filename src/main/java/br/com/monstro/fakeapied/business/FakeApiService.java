package br.com.monstro.fakeapied.business;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.monstro.fakeapied.apiv1.dto.ProductsDTO;
import br.com.monstro.fakeapied.infrastructure.FakeApiClient;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FakeApiService {
    
    private final FakeApiClient cliente;

    public List<ProductsDTO> buscaProdutos(){
        return cliente.buscaListaProdutos();
    }
}

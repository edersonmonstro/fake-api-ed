package br.com.monstro.fakeapied.apiv1;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.monstro.fakeapied.apiv1.dto.ProductsDTO;
import br.com.monstro.fakeapied.business.service.FakeApiService;
import br.com.monstro.fakeapied.business.service.ProdutoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/produtos")
@RequiredArgsConstructor
@Tag(name = "fake-api")
public class FakeApiController {
    private final FakeApiService apiService;
    private final ProdutoService produtoService;

    @Operation(summary = "Busca produtos da API e salvar", method = "POST")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso"),
        @ApiResponse(responseCode = "500", description = "Erro ao realizar busca dos dados"),
    })
    @PostMapping("/api")
    public ResponseEntity<List<ProductsDTO>> salvaProdutosAPI(){
        return ResponseEntity.ok(apiService.buscaProdutos());
    }

    @Operation(summary = "Salvar novos produtos", method = "POST")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Produto salvo com sucesso"),
        @ApiResponse(responseCode = "500", description = "Erro ao salvar o produto"),
    })
    @PostMapping("/")
    public ResponseEntity<ProductsDTO> salvaProduto(@RequestBody ProductsDTO dto ){
        return ResponseEntity.ok(produtoService.salvaProdutoDTO(dto));
    }

    @Operation(summary = "Atualizar produto", method = "PUT")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Produto atualizado com sucesso"),
        @ApiResponse(responseCode = "500", description = "Erro ao atualizar o produto"),
    })
    @PutMapping("/")
    public ResponseEntity<ProductsDTO> atualizaProduto(@RequestParam("Id") String id, @RequestBody ProductsDTO dto){
        return ResponseEntity.ok(produtoService.updateProduto(id, dto));
    }

    @Operation(summary = "Exclui produto", method = "DELETE")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Produto excluído com sucesso"),
        @ApiResponse(responseCode = "500", description = "Erro ao excluir o produto"),
    })
    @DeleteMapping("/")
    public ResponseEntity<Void> excluirProduto(@RequestParam("nome") String nome, @RequestBody ProductsDTO dto){
        produtoService.deletaProduto(nome);
        return ResponseEntity.accepted().build();
    }

    @Operation(summary = "Buscar todos os produtos", method = "GET")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Produto atualizado com sucesso"),
        @ApiResponse(responseCode = "500", description = "Erro ao atualizar o produto"),
    })
    @GetMapping("/")
    public ResponseEntity<List<ProductsDTO>> buscaTodosProdutos(){
        return ResponseEntity.ok(produtoService.buscaTodosProdutos());
    }

    @Operation(summary = "Buscar produtos por nome", method = "GET")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Produto atualizado com sucesso"),
        @ApiResponse(responseCode = "500", description = "Erro ao atualizar o produto"),
    })
    @GetMapping("/{nome}")
    public ResponseEntity<ProductsDTO> buscaProdutoPorNome(@PathVariable("nome") String nome ){
        return ResponseEntity.ok(produtoService.buscaProdutoPorNome(nome));
    }
}

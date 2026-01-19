package br.com.dragos.produtosapi.controller;

import br.com.dragos.produtosapi.model.Produto;
import br.com.dragos.produtosapi.repository.ProdutoRepository;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("produtos")
public class ProdutoController {


    private ProdutoRepository produtoRepository;

    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @PostMapping
    public Produto salvar(@RequestBody Produto produto) {
        System.out.println("Produtos recebidos: " + produto.toString());
        var id = UUID.randomUUID().toString();
        produto.setId(id);
        return produtoRepository.save(produto);
    }

    @GetMapping("{id}")
    public Produto obterPorId(@PathVariable("id") String id) {
        return produtoRepository.findById(id).orElse(null);
    }

    @DeleteMapping("{id}")
    public void deletar(@PathVariable("id") String id) {
        produtoRepository.deleteById(id);
    }

    @PutMapping("{id}")
    public void atualizar(@PathVariable("id") String id, @RequestBody Produto produto) {
        produto.setId(id);
        produtoRepository.save(produto);
    }

    @GetMapping
    public List<Produto> buscar(@RequestParam("nome") String nome) {
        return produtoRepository.findByNome(nome);
    }

}




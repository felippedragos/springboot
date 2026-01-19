package br.com.dragos.produtosapi.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import br.com.dragos.produtosapi.model.Produto;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, String> {

    List<Produto> findByNome(String nome);

}

package br.com.dragos.produtosapi.repository;

import br.com.dragos.produtosapi.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, String> {


}

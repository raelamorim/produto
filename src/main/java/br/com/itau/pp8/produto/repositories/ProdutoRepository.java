package br.com.itau.pp8.produto.repositories;

import br.com.itau.pp8.produto.models.Produto;

public interface ProdutoRepository  {

    Produto findById(int id);
}

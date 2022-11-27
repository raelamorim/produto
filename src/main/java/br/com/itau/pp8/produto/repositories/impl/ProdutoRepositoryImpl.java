package br.com.itau.pp8.produto.repositories.impl;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

import br.com.itau.pp8.produto.models.Produto;
import br.com.itau.pp8.produto.repositories.ProdutoRepository;
import io.micronaut.context.annotation.Primary;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
@Primary
public class ProdutoRepositoryImpl implements ProdutoRepository {

	@Inject
	private DynamoDBMapper dynamoDBMapper;
	
	@Override
	public Produto findById(int id) {
		return dynamoDBMapper.load(Produto.class,id);
	}
}

package br.com.itau.pp8.produto.models;

import java.util.List;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperFieldModel.DynamoDBAttributeType;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTyped;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
@DynamoDBTable(tableName = "produto-table")
public class Produto {

	private int idProduto;
	private String nomeProduto = "";
	private boolean encerrado = false;
	private List<String> segmentos;
	private List<CanalOperacao> canaisOperacoes;
	private int idRisco;

	@DynamoDBHashKey(attributeName = "id_produto") // partition key
	@DynamoDBTyped(DynamoDBAttributeType.N)
	public int getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}

	@DynamoDBAttribute(attributeName = "nome_produto")
	@DynamoDBTyped(DynamoDBAttributeType.S)
	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	@DynamoDBAttribute(attributeName = "encerrado")
	@DynamoDBTyped(DynamoDBAttributeType.BOOL)
	public boolean isEncerrado() {
		return encerrado;
	}

	public void setEncerrado(boolean encerrado) {
		this.encerrado = encerrado;
	}

	@DynamoDBAttribute(attributeName = "segmentos")
	@DynamoDBTyped(DynamoDBAttributeType.L)
	public List<String> getSegmentos() {
		return segmentos;
	}

	public void setSegmentos(List<String> segmentos) {
		this.segmentos = segmentos;
	}

	@DynamoDBAttribute(attributeName = "canais_operacoes")
	@DynamoDBTyped(DynamoDBAttributeType.L)
	public List<CanalOperacao> getCanaisOperacoes() {
		return canaisOperacoes;
	}

	public void setCanaisOperacoes(List<CanalOperacao> canaisOperacoes) {
		this.canaisOperacoes = canaisOperacoes;
	}

	@DynamoDBAttribute(attributeName = "id_risco")
	@DynamoDBTyped(DynamoDBAttributeType.N)
	public int getIdRisco() {
		return idRisco;
	}

	public void setIdRisco(int idRisco) {
		this.idRisco = idRisco;
	}
	
}

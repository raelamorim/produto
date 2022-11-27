package br.com.itau.pp8.produto.models;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperFieldModel.DynamoDBAttributeType;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTyped;

@DynamoDBTyped(DynamoDBAttributeType.M)
public class CanalOperacao {

	private int idCanal;
	private int idOperacao;

	@DynamoDBAttribute(attributeName = "id_canal")
	@DynamoDBTyped(DynamoDBAttributeType.N)
	public int getIdCanal() {
		return idCanal;
	}

	public void setIdCanal(int idCanal) {
		this.idCanal = idCanal;
	}

	@DynamoDBAttribute(attributeName = "id_operacao")
	@DynamoDBTyped(DynamoDBAttributeType.N)
	public int getIdOperacao() {
		return idOperacao;
	}

	public void setIdOperacao(int idOperacao) {
		this.idOperacao = idOperacao;
	}
}

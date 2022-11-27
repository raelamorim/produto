package br.com.itau.pp8.produto.services.mappers;

import java.util.ArrayList;

import br.com.itau.pp8.produto.models.CanalOperacao;
import br.com.itau.pp8.produto.models.Produto;
import br.com.itau.pp8.produto.services.CanalOperacaoReply;
import br.com.itau.pp8.produto.services.FindProdutoByIdReply;

public interface FindProdutoByIdMapper {

	public static FindProdutoByIdReply from(Produto model) {
		var canaisOperacoes = new ArrayList<CanalOperacaoReply>();
		model.getCanaisOperacoes().forEach(c -> canaisOperacoes.add(from(c)));
		
		return FindProdutoByIdReply
			.newBuilder()
			.setNomeProduto(model.getNomeProduto())
			.setEncerrado(model.isEncerrado())
//			.setRisco(RiscoReply.forNumber(model.getIdRisco()))
			.setRisco(model.getIdRisco())
			.addAllSegmentos(model.getSegmentos())
			.addAllCanaisOperacoes(canaisOperacoes)
			.build();
	}
	
	private static CanalOperacaoReply from(CanalOperacao model) {
		return CanalOperacaoReply
			.newBuilder()
			.setIdCanal(model.getIdCanal())
			.setIdOperacao(model.getIdOperacao())
			.build();
	}
}

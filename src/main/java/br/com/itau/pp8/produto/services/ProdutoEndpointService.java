package br.com.itau.pp8.produto.services;

import br.com.itau.pp8.produto.repositories.ProdutoRepository;
import br.com.itau.pp8.produto.services.mappers.FindProdutoByIdMapper;
import io.grpc.stub.StreamObserver;
import io.micronaut.context.annotation.Primary;
import jakarta.inject.Singleton;

@Primary
@Singleton
public class ProdutoEndpointService extends ProdutoServiceGrpc.ProdutoServiceImplBase { 

    private final ProdutoRepository produtoRepository;

    public ProdutoEndpointService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public void send(FindProdutoByIdRequest request, StreamObserver<FindProdutoByIdReply> responseObserver) {
        var produto = produtoRepository.findById(request.getIdProduto());
        responseObserver.onNext(FindProdutoByIdMapper.from(produto));
        responseObserver.onCompleted();
    }
}
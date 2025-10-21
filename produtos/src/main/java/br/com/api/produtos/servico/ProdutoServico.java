package br.com.api.produtos.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import br.com.api.produtos.repositorio.ProdutoRepositorio;

import br.com.api.produtos.modelo.ProdutoModelo;
import br.com.api.produtos.modelo.RespostaModelo;

@Service
public class ProdutoServico {
    @Autowired
    private ProdutoRepositorio produtoRepositorio;

    @Autowired
    private RespostaModelo respostaModelo;

    public Iterable<ProdutoModelo> listarTodos() {
        return produtoRepositorio.findAll();
    }

    public ResponseEntity<?> cadastrarAlterar(ProdutoModelo produtoModelo, String acao) {
        if (produtoModelo.getNome().equals("") || produtoModelo.getNome() == null) {
            respostaModelo.setMensagem("O nome do produto é obrigatório.");
            return ResponseEntity.badRequest().body(respostaModelo);
        } else if (produtoModelo.getMarca() == null) {
            respostaModelo.setMensagem("A marca do produto é obrigatória.");
            return ResponseEntity.badRequest().body(respostaModelo);
        } else {
            if (acao.equals("cadastrar")) {
                return ResponseEntity.ok(produtoRepositorio.save(produtoModelo));
            } else {
                return ResponseEntity.ok(produtoRepositorio.save(produtoModelo));
            }
        }
    }

    public ResponseEntity<?> removerProduto(long codigo){
        produtoRepositorio.deleteById(codigo);
        respostaModelo.setMensagem("Produto removido com sucesso.");
        return ResponseEntity.ok(respostaModelo);
    }

    // public ResponseEntity<?> cadastrar(ProdutoModelo produtoModelo) {
    //     if (produtoModelo.getNome().equals("") || produtoModelo.getNome() == null) {
    //         respostaModelo.setMensagem("O nome do produto é obrigatório.");
    //         return ResponseEntity.badRequest().body(respostaModelo);
    //     } else if (produtoModelo.getMarca() == null) {
    //         respostaModelo.setMensagem("A marca do produto é obrigatória.");
    //         return ResponseEntity.badRequest().body(respostaModelo);
    //     } else {
    //         return ResponseEntity.ok(produtoRepositorio.save(produtoModelo));
    //     }
    // }
}

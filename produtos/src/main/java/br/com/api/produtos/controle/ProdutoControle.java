package br.com.api.produtos.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.api.produtos.modelo.ProdutoModelo;
import br.com.api.produtos.servico.ProdutoServico;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@CrossOrigin(origins = "*")
public class ProdutoControle {
    @Autowired
    private ProdutoServico produtoServico;

    @PostMapping("/cadastrarProduto")
    public ResponseEntity<?> cadastrarAlterar(@RequestBody ProdutoModelo produtoModelo) {
        return produtoServico.cadastrarAlterar(produtoModelo, "cadastrar");
    }

    @PutMapping("/alterarProduto")
    public ResponseEntity<?> alterar(@RequestBody ProdutoModelo produtoModelo) {
        return produtoServico.cadastrarAlterar(produtoModelo, "alterar");
    }

    @GetMapping("/listarProduto")
    public Iterable<ProdutoModelo> listarProdutos() {
        return produtoServico.listarTodos();
    }

    @DeleteMapping("/removerProduto/{codigo}")
    public ResponseEntity<?> removerProduto(@PathVariable long codigo) {
        return produtoServico.removerProduto(codigo);
    }

    @GetMapping("")
    public String rotaInicial() {
        return "API de Produtos funcionando!";
    }
}

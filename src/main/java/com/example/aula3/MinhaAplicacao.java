import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MinhaAplicacao implements CommandLineRunner {

    @Autowired
    private produtos produtoService;

    @Autowired
    private Categorias categoriaService;

    public static void main(String[] args) {
        SpringApplication.run(MinhaAplicacao.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Teste dos métodos

        // Criando uma categoria
        Categoria categoria = new Categoria();
        categoria.setNome("Eletrônicos");
        categoria.setDescricao("Produtos eletrônicos em geral");
        categoriaService.createCategoria(categoria);

        // Criando um produto associado à categoria criada
        Produto produto = new Produto();
        produto.setNome("Smartphone");
        produto.setQuantidade(10);
        produto.setCategoria(categoria);
        produtoService.createProduto(produto);

        // Buscando todos os produtos
        System.out.println("Todos os produtos:");
        produtoService.getAllProdutos().forEach(System.out::println);

        // Buscando um produto por ID
        System.out.println("\nProduto com ID 1:");
        System.out.println(produtoService.getProdutoById(1L));

        // Atualizando um produto
        Produto produtoAtualizado = new Produto();
        produtoAtualizado.setNome("Tablet");
        produtoAtualizado.setQuantidade(5);
        produtoAtualizado.setCategoria(categoria);
        produtoService.updateProduto(1L, produtoAtualizado);

        System.out.println("\nProduto atualizado:");
        System.out.println(produtoService.getProdutoById(1L));

        // Deletando um produto
        produtoService.deleteProduto(1L);
        System.out.println("\nProduto deletado.");

        // Buscando todas as categorias
        System.out.println("\nTodas as categorias:");
        categoriaService.getAllCategorias().forEach(System.out::println);
    }
}

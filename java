package apresentação1;
import java.util.PriorityQueue;
import java.util.Scanner;
	interface Mercado {
	    void adicionarProduto(String produto, double preco);

	    void removerProduto();

	    void exibirProdutos();
	}

	class MercadoImpl implements Mercado {
	    private PriorityQueue<Produto> produtos;

	    public MercadoImpl() {
	        produtos = new PriorityQueue<>();
	    }

	    public void adicionarProduto(String produto, double preco) {
	        Produto novoProduto = new Produto(produto, preco);
	        produtos.add(novoProduto);
	        System.out.println("Produto adicionado com sucesso");
	    }

	    public void removerProduto() {
	        if (!produtos.isEmpty()) {
	            Produto produtoRemovido = produtos.poll();
	            System.out.println("Produto removido: " + produtoRemovido.getNome());
	        } else {
	            System.out.println("O mercado está vazio.");
	        }
	    }

	    public void exibirProdutos() {
	        if (!produtos.isEmpty()) {
	            System.out.println("Produtos disponíveis no mercado:");
	            for (Produto produto : produtos) {
	                System.out.println(produto.getNome() + " - R$" + produto.getPreco());
	            }
	        } else {
	            System.out.println("O mercado está vazio.");
	        }
	    }
	}

	class Produto implements Comparable<Produto> {
	    private String nome;
	    private double preco;

	    public Produto(String nome, double preco) {
	        this.nome = nome;
	        this.preco = preco;
	    }

	    public String getNome() {
	        return nome;
	    }

	    public double getPreco() {
	        return preco;
	    }

	    @Override
	    public int compareTo(Produto outroProduto) {
	        return Double.compare(this.preco, outroProduto.preco);
	    }

	    public static void main(String[] args) {
	        Mercado mercado = new MercadoImpl();
	        Scanner scanner = new Scanner(System.in);
	        System.out.println("Bem vindo(a) ao mercado!");
	        while (true) {
	            System.out.println("\nEscolha uma opção:");
	            System.out.println("1. Adicionar Produto");
	            System.out.println("2. Remover Produto");
	            System.out.println("3. Exibir Produtos");
	            System.out.println("4. Sair");

	            int opcao = scanner.nextInt();
	            switch (opcao) {
	                case 1:
	                    System.out.println("Digite o nome do produto:");
	                    String nomeProduto = scanner.next();
	                    System.out.println("Digite o preço do produto:");
	                    double precoProduto = scanner.nextDouble();
	                    mercado.adicionarProduto(nomeProduto, precoProduto);
	                    break;
	                case 2:
	                    mercado.removerProduto();
	                    break;
	                case 3:
	                    mercado.exibirProdutos();
	                    break;
	                case 4:
	                    System.out.println("Obrigado por utilizar o mercado!");
	                    scanner.close();
	                    System.exit(0);
	                default:
	                    System.out.println("Opção inválida. Tente novamente.");
	            }
	        }
	    }
	}

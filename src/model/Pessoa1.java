package Mercado;

	import java.util.HashSet;
	import java.util.Set;
	import java.time.LocalDate;

	public abstract class Pessoa {
		
	    private String nome;
	    private String cpf;
	    private LocalDate dataNascimento;
	    private Integer codigo;
	    
	    private static Set<String> cpfsCadastrados = new HashSet<>();

	    public Pessoa(String nome, String cpf, LocalDate dataNascimento) {
	        if (cpfsCadastrados.contains(cpf)) {
	            throw new IllegalArgumentException("Já existe uma pessoa cadastrada com o CPF: " + cpf);
	        }
	        cpfsCadastrados.add(cpf);

	        this.nome = nome;
	        this.cpf = cpf;
	        this.dataNascimento = dataNascimento;
	   
	    }

	    public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getCpf() {
			return cpf;
		}


		public void setCpf(String cpf) {
			this.cpf = cpf;
		}


		public LocalDate getDataNascimento() {
			return dataNascimento;
		}


		public Integer getCodigo() {
			return codigo;
		}

		public void setCodigo(Integer codigo) {
			this.codigo = codigo;
		}

		public static Set<String> getCpfsCadastrados() {
			return cpfsCadastrados;
		}

		public static void setCpfsCadastrados(Set<String> cpfsCadastrados) {
			Pessoa.cpfsCadastrados = cpfsCadastrados;
		}

		public void setDataNascimento(LocalDate dataNascimento) {
			this.dataNascimento = dataNascimento;
		}

		public abstract String getDescricao();
		
	    
	    }
	



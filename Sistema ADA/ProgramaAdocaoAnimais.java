package br.ufpb.adocaoanimais;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class ProgramaAdocaoAnimais {
	public static void main(String [] args) {
		SistemaAdocaoAnimais sistema = new SistemaAdocaoAnimaisList();
		boolean sair = false;
		while (!sair) {
			int opcao = Integer.parseInt(JOptionPane.showInputDialog(
					"Digite uma opção:\n1.Cadastrar animal\n"
							+"2.Cadastrar usuário\n"
							+ "3.Pesquisar usuário\n"
							+ "4.Pesquisar usuário pelo nome\n"
							+ "5.Pesquisar animais do tipo"
							+"\n6.Sair\n"));
			switch(opcao) {
			  case 1:
				String nome = JOptionPane.showInputDialog("Qual o nome do animal?");
				String codigo = JOptionPane.showInputDialog("Qual o código do animal?");
				String tipo = JOptionPane.showInputDialog("Qual o tipo do animal?1. Cachorro ou 2.Gato");
				Animal a = null;
				if (tipo.equals("1")) {
					a = new Cachorro();
				} else if (tipo.equals("2")) {
					a = new Gato();
				}
				if (a!=null) {
					a.setNome(nome);
					a.setCodigo(codigo);
					boolean cadastrou = sistema.cadastraAnimal(a);
					if (cadastrou) {
						JOptionPane.showMessageDialog(null, "Animal cadastrado com sucesso");
					} else {
						JOptionPane.showMessageDialog(null, "Animal já estava cadastrado");
					}
				}
				break;
			  case 2:
				String usuario = JOptionPane.showInputDialog(null, "Digite o seu nome: ");
				String cpf = JOptionPane.showInputDialog(null, "Digite o seu cpf: ");
				String dataNascimento = JOptionPane.showInputDialog(null, "Digete sua data de Nacimento: ");
				ArrayList <Requisito> requisitos = new ArrayList <Requisito> ();
				Usuario user = new Usuario(usuario, cpf, dataNascimento, requisitos);

				boolean cadastramento = sistema.cadastraUsuario(user);
				if(cadastramento == true){
					JOptionPane.showMessageDialog(null, "Usuário cadastrado");
				} else{
					JOptionPane.showMessageDialog(null,"Usuário já estava cadastrado");
				}
				
			    break;
			  case 3:
				String cpfPesquisa = JOptionPane.showInputDialog(null, "Digite o seu cpf: ");
				
				try {
					String nomeUsuario = sistema.pesquisaUsuario(cpfPesquisa).getNome();
					JOptionPane.showMessageDialog(null,"O CPF é do Usuário " + nomeUsuario);

					
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null,"CPF não cadastrado");

				}

				
				break;
			  case 4:
				String primeiroNome = JOptionPane.showInputDialog("Digite o prefixo: ");
				List<Usuario> usuarios = sistema.pesquisaUsuariosComNomeComecandoCom(primeiroNome);
				if(usuarios.isEmpty()){
						JOptionPane.showMessageDialog(null,"Não foi encontra usuários com esse prefixo.");
				}for(Usuario i: usuarios){
						JOptionPane.showMessageDialog(null,i.getNome());
					}
				break;
				
			  case 5:
				List<Animal> animais = null;
				String tipoPesq = JOptionPane.showInputDialog("Qual o tipo do animal?1. Cachorro ou 2.Gato");
				if (tipoPesq.equals("1")) {
					animais = sistema.pesquisaAnimaisDoTipo(Cachorro.TIPO_ANIMAL_CACHORRO);
				} else if (tipoPesq.equals("2")) {
					animais = sistema.pesquisaAnimaisDoTipo(Gato.TIPO_ANIMAL_GATO);
				}
				if (animais!=null) {
					for (Animal animal: animais) {
						JOptionPane.showMessageDialog(null, animal.toString());
					}
				} else {
					JOptionPane.showMessageDialog(null, "Não foi encontrado animal do tipo pesquisado");
				}
				break;
			  case 6:
				sair = true;
				break;
			}
				
		}
		JOptionPane.showMessageDialog(null, "FIM DO PROGRAMA");
	}

	public static void gravarDados(SistemaAdocaoAnimais sistema) throws IOException {
		GravadorDeDados gravador = new GravadorDeDados();
		List<Usuario> usuarios = sistema.getUsuarios();
		List<String> linhas = new ArrayList<String>();
		for (Usuario u : usuarios) {
			String linha = u.getNome() + "#" + u.getCpf() + "#";
			linhas.add(linha);
		}
		gravador.gravaTextoEmArquivo(linhas, "usuarios.txt");
	}

	public static void recuperarDados(SistemaAdocaoAnimais sistema) throws IOException {
		GravadorDeDados gravador = new GravadorDeDados();
		List<Usuario> usuarios = new ArrayList<Usuario>();
		List<String> linhas = gravador.recuperaTextoEmArquivo("usuarios.txt");
		for (String linha : linhas) {
			String[] dados = linha.split("#");
			Usuario u = new Usuario(dados[0], dados[1]);
			usuarios.add(u);
		}
		sistema.setUsuarios(usuarios);
	}

	public static void gravarDados(SistemaAdocaoAnimais sistema) throws IOException{
		GravadorDeDados gravador = new GravadorDeDados();
		List<Animal> animais = new ArrayList<Animal>();
		List<String> linhas = new ArrayList<String>();
		for(Animal i:animais){
			
		}
	}

}

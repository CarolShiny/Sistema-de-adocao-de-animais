package br.ufpb.adocaoanimais;
import java.util.ArrayList;
import java.util.List;

public class SistemaAdocaoAnimaisList implements SistemaAdocaoAnimais  {

	private List<Animal> animais;

	private List<Usuario> usuarios;
	
	public SistemaAdocaoAnimaisList() {
		this.animais = new ArrayList<Animal>();
		this.usuarios = new ArrayList<Usuario>();
	}
	
	/**
	 * Pesquisa no sistema o usuário com um dado CPF
	 * 
	 * @param cpf O CPF a pesquisar
	 * @return O usuário do sistema que tem o mesmo CPF
	 * @throws UsuarioNaoExisteException
	 */
	@Override
	public Usuario pesquisaUsuario(String cpf) throws UsuarioNaoExisteException{
		for(Usuario user: this.usuarios){
			if(user.getCpf().equals(cpf)){
				return user;				
			}
		}throw new UsuarioNaoExisteException("Usuario não exite");
	}
	
	/**
	 * Pesquisa os usuários cujo nome começa com um certo prefixo
	 * @param prefixo O prefixo a pesquisar
	 * @return a lista dos usuários cujo nome começa com certo prefixo
	 */
	@Override
	public List<Usuario> pesquisaUsuariosComNomeComecandoCom(String prefixo){
		ArrayList<Usuario> nomes = new ArrayList<Usuario>();
		for(Usuario i: this.usuarios){
			if(i.getNome().startsWith(prefixo)){	
				nomes.add(i);
			}
		}
		return nomes;
	}
	
	/**
	 * Pesquisa os animais do tipo passado como parâmetro
	 * @param tipo O tipo de animal a pesquisar
	 * @return a lista dos animais do tipo pesquisado.
	 */
	@Override
	public List<Animal> pesquisaAnimaisDoTipo(String tipo){
		ArrayList<Animal> nomesAnimais = new ArrayList<Animal>();
		for(Animal i: this.animais){
			if(i.getTipo().equals(tipo)){
				nomesAnimais.add(getNome());				
			}
		}
		return nomesAnimais;
	}

	@Override
	public boolean cadastraUsuario(Usuario user) {
		if (existeUsuario(user)) {
			return false;
		} else {
			this.usuarios.add(user);
			return true;
		}
	}
	
	@Override
	public boolean existeUsuario(Usuario user) {
		for (Usuario u: this.usuarios) {
			if (u.getCpf().equals(user.getCpf())) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public boolean cadastraAnimal(Animal a) {
		if (existeAnimal(a)) {
			return false;
		} else {
			this.animais.add(a);
			return true;
		}
	}
	
	@Override
	public boolean existeAnimal(Animal animal) {
		for (Animal a: this.animais) {
			if (a.getCodigo().equals(animal.getCodigo())) {
				return true;
			}
		}
		return false;
	}

}

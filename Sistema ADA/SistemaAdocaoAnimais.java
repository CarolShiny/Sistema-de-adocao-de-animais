package br.ufpb.adocaoanimais;

import java.util.List;

public interface SistemaAdocaoAnimais {

	/**
	 * Pesquisa no sistema o usuário com um dado CPF
	 * @param cpf O CPF a pesquisar
	 * @return O usuário do sistema que tem o mesmo CPF
	 * @throws UsuarioNaoExisteException
	 */
	public Usuario pesquisaUsuario(String cpf) throws UsuarioNaoExisteException;

	/**
	 * Pesquisa os usuários cujo nome começa com um certo prefixo
	 * @param prefixo O prefixo a pesquisar
	 * @return a lista dos usuários cujo nome começa com certo prefixo
	 */
	public List<Usuario> pesquisaUsuariosComNomeComecandoCom(String prefixo);

	/**
	 * Pesquisa os animais do tipo passado como parâmetro
	 * @param tipo O tipo de animal a pesquisar
	 * @return a lista dos animais do tipo pesquisado.
	 */
	public List<Animal> pesquisaAnimaisDoTipo(String tipo);

	public boolean cadastraUsuario(Usuario user);

	public boolean existeUsuario(Usuario user);

	public boolean cadastraAnimal(Animal a);

	public boolean existeAnimal(Animal animal);

}
package principal;

import conexao.Conexao;
import dao.LivroDao;
import dominio.Livro;

public class Testador {

	public static void main(String[] args) {
		
		Livro l = new Livro("Fire in the valley",
				"prag prog", "Ximbinha", 4, 34.87);
		Livro l2 = new Livro("Harry Potter", "Whatever",
				"J. K. Rowling", 5, 89.90);
		
		Conexao c = new Conexao();
		LivroDao ldao = new LivroDao(c.abreConexao());
		ldao.save(l);
		ldao.save(l2);
		ldao.save(l);
		
		System.out.println(ldao.getOne(1));
		
		Livro atualizado = new Livro("Warlords of Draenor", "Dalaran",
				"Christie Golden", 3, 56.78);
		atualizado.setId(1);
		ldao.update(atualizado);
		
		System.out.println("__________________________________");
		System.out.println(ldao.getOne(1));
		
		ldao.delete(l2);
		
		System.out.println(ldao.list());
		
		c.fechaConexao();

	}

}

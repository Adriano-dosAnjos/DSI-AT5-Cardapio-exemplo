package br.edu.up.sistema;

import java.util.List;

import br.edu.up.dominio.Cardapio;
import br.edu.up.dominio.Item;

/* 1 - incluir listas de itens de opções de pratos, bebidas, vinhos;
 * 2 - o cliente deverá selecionar os itens e adicionar observações;
 * 3 - arquivos disponiveis
 * 4 - armazenar os itens de cada pedido realizado, incluidon preços, vizualizar os pedidos posteriores e total;
 */



public class Programa {

	public static void main(String[] args) {
		
		//C -> Incluir
//		Item picanha = new Item("Picanha", 10.7);
//		Cardapio.incluir(picanha);
//		
//		Item brocolis = new Item("Brocolis", 5.0);
//		Cardapio.incluir(brocolis);
		
		
		//R -> Buscar/ Listar
		
		String query = "ensopado";
		Item itemRetornado = Cardapio.buscarPorNome(query);
		
		System.out.println ("Retornado: " + itemRetornado);
		
//		itemRetornado.setPreco(25.40);
		
		//U -> atualizar
//		brocolis.setPreco(3.0);
//		Cardapio.atualizar(itemRetornado);
		
		
		//D -> Excluir
//		Cardapio.excluir(itemRetornado);
		List<Item> lista = Cardapio.listar();
		System.out.println ("---------------------");
		System.out.println ("Tamanho da lista " + lista.size());
		
		for (Item item : lista) {
			System.out.println (item);
		}
		
	}

}

package br.edu.up.dominio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cardapio {
	
	private static List<Item> listaDePratos;
	private static List<Item> listaDebebidas;
	private static List<Item> listaDeVinhos;
	
	private static String nomeDoArquivo = "C:\\Users\\adfer\\OneDrive\\Documentos\\Universidade Positivo\\2° Semestre\\Desenvolvimento de Software 1\\1° Bimestre\\Workspace\\Aula 15 - CRUDs\\arquivos\\pratos.txt";
	
	static {
		listaDePratos = new ArrayList<Item>();
		listaDePratos = carregarListaDePratos();
		
	}
	
	private static List<Item> carregarListaDePratos() {
		
		List<Item> listaDeRetorno = new ArrayList<>();

		try {
			File arquivo = new File(nomeDoArquivo);
			Scanner leitor = new Scanner(new FileInputStream(arquivo), "UTF-8");
			leitor.nextLine();
			
			while (leitor.hasNext()) {
				String linha = leitor.nextLine();
				String[] partes = linha.split(";");
				Item item = new Item(partes[0], partes[1]);
				listaDeRetorno.add(item);
				
			}			
			
		} catch (FileNotFoundException e) {
			System.out.println ("ocorreu um erro na leitura do arquivo");
			//e.printStackTrace();
		}
	
		return listaDeRetorno;
	}
	
	public static List<Item> listar() {
		return listaDePratos;
	}
	
	
	public static void incluir(Item item) {
		listaDePratos.add(item);
		incluirNoArquivo(item);
	}

	private static void incluirNoArquivo(Item item) {
		try {
			FileWriter arquivo = new FileWriter(nomeDoArquivo, true);
			PrintWriter gravador = new PrintWriter(arquivo);
			gravador.println (item);
			gravador.close();
			arquivo.close();
			
		} catch (IOException e) {
			System.out.println ("Erro do arquivo!");
			//e.printStackTrace();
		}
	}

	public static void excluir(Item item) {
		listaDePratos.remove(item);
		gravarListarAtualizada(listaDePratos);
		
	}

	private static void gravarListarAtualizada(List<Item> listaDeItem) {
		try {
			FileWriter arquivo = new FileWriter(nomeDoArquivo);
			PrintWriter gravador = new PrintWriter(arquivo);
			for (Item item : listaDePratos) {
					gravador.println (item);
			}
			
			gravador.close();
			arquivo.close();
			
		} catch (IOException e) {
			System.out.println ("Erro do arquivo!");
			//e.printStackTrace();
		}
	}

	public static void atualizar(Item item) {
		for (Item itemAtualizar : listaDePratos) {
			if (itemAtualizar.getNome().equals(item.getNome())) {
				itemAtualizar.setNome(item.getNome());
				itemAtualizar.setPreco(item.getPreco());
				break;
			}
		}
		gravarListarAtualizada(listaDePratos);
	}

	public static Item buscarPorNome(String query) {
		Item itemRetornar = null;
		
		for (Item item : listaDePratos) {
			if (item.getNome().contains(query)) {
				itemRetornar = item;
				break;
			}
		}
		
		return itemRetornar;
	}


}

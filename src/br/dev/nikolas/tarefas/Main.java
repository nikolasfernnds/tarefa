package br.dev.nikolas.tarefas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.dev.nikolas.tarefas.dao.FuncionarioDAO;
import br.dev.nikolas.tarefas.model.Funcionario;
import br.dev.nikolas.tarefas.model.Tarefa;

public class Main {
	
	private static String path = "C:\\Users\\25132498\\tarefa\\tarefas.txt";

    public static void main(String[] args) {
    	
    	
    	List<String> frutas 			= new ArrayList<>();
    	List<Funcionario> funcionarios 	= new ArrayList<>();
    	List<Double> numeros 			= new ArrayList<>();
    	
    	
    	frutas.add("abacaxi");
    	frutas.add("banana");
    	frutas.add("goiaba");
    	frutas.add("laranja");
    	
    	numeros.add(4.9);
    	numeros.add(12.78);
    	
    
    	
    
		//Determinando o caminho do arquivo que será lido
    	
    	Funcionario funcionario = new Funcionario();
    	funcionario.setCodigo(4);
    	funcionario.setNome("Murfis Depay");
    	funcionario.setMatricula("9999999");
    	funcionario.setEmail("murfis@gmail.com");
    	
    	Funcionario funcionario2 = new Funcionario();
    	funcionario.setCodigo(7);
    	funcionario.setNome("Teixeira");
    	funcionario.setMatricula("7943741");
    	funcionario.setEmail("teixeira@gmail.com");
    	
    	funcionarios.add(funcionario);
    	funcionarios.add(funcionario2);
    	
    	System.out.println(funcionarios);
    	for (Funcionario f : funcionarios) {
    		System.out.println(f.getEmail());
    		
    	}
    	
    	
//    	
//    	FuncionarioDAO dao = new FuncionarioDAO(funcionario);
//    	dao.gravar();
//    	
//    	System.out.println(funcionario.toString());
    	
    	
//		Funcionario f = new Funcionario();
//    	Tarefa t = new Tarefa();
		
	}

	private static void gravarArquivo() {
		FileWriter file = null;
		BufferedWriter writer = null;
		
		try {
			file = new FileWriter(path, true);
			writer = new BufferedWriter(file);
			
			writer.write("Essa é outra nova linha!!");
			writer.flush();
					
		} catch (Exception erro) {
			System.out.println(erro.getMessage());
		}
	}
	
	private static void lerArquivo() {
		
		//Abrir arquivo para leitura
		
		FileReader file = null;
		BufferedReader buffer = null;
		try {
			file = new FileReader(path);
			buffer = new BufferedReader(file);
			
			String linha = "";
			
			while (linha != null) {
				linha = buffer.readLine();
				if (linha != null) {
					System.out.println(linha);
				}
			}
			
		} catch (FileNotFoundException erro) {
			System.out.println("Arquivo não achado, irmão!");
			System.out.println(erro.getMessage());
		} catch (IOException erro) {
			System.out.println("Você não pode ler o arquivo, patrão!");
			System.out.println(erro.getMessage());
		} catch (Exception erro) {
			System.out.println("Erro genérico");
			System.out.println(erro.getMessage());
		}
	}

}

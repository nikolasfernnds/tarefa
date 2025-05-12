package br.dev.nikolas.tarefas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import br.dev.nikolas.tarefas.model.Tarefa;

public class Main {
	
	private static String path = "C:\\Users\\25132498\\tarefa\\tarefas.txt";

    public static void main(String[] args) {
		
		//Determinando o caminho do arquivo que será lido
		
    	Tarefa t = new Tarefa();
		gravarArquivo();
		lerArquivo();
		
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

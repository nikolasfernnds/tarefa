package br.dev.nikolas.tarefas.ui;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import br.dev.nikolas.tarefas.dao.FuncionarioDAO;
import br.dev.nikolas.tarefas.model.Funcionario;

public class FrameListaFuncionario {

	private JLabel lblTitulo;
	private JTable tblFuncionarios;
	private JScrollPane scrollFuncionarios;
	private JButton btnNovo, btnExcluir, btnAtualizar, btnSair;
	
	private Font fontTitulo = new Font("Arial", Font.BOLD, 26);
	
	public FrameListaFuncionario() {
		criarTela();
	}
	
	public void criarTela() {
		
		JFrame tela = new JFrame();
		tela.setTitle("Cadastro de Funcionários");
		tela.setSize(600, 600);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setResizable(false);
		tela.setLayout(null);
		tela.setLocationRelativeTo(null);
		
		Container painel = tela.getContentPane();
		
		lblTitulo = new JLabel("Cadastro de Funcionários");
		lblTitulo.setBounds(30, 30, 500, 30);
		lblTitulo.setFont(fontTitulo);
		
		
		
		
		//Criação da tabela
		String[] colunas = {"Código", "Nome","E-mail"};
		
		FuncionarioDAO dao = new FuncionarioDAO(null);
		List<Funcionario> funcionarios = dao.showEmployees();
		
		Object[][] dados = new Object[funcionarios.size()][3];
		
		int linha = 0;
		for (Funcionario f : funcionarios) {
			dados[linha][0] = f.getCodigo();
			dados[linha][1] = f.getNome();
			dados[linha][2] = f.getEmail();
			linha++;
			
		}
		
		tblFuncionarios = new JTable(dados, colunas);
		
		scrollFuncionarios = new JScrollPane(tblFuncionarios);
		scrollFuncionarios.setBounds(30, 80, 400, 300);
		
		btnNovo = new JButton("Cadastrar");
		btnNovo.setBounds(30, 390, 150, 40);
		btnNovo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new FrameFuncionario(tela);
//				new FrameListaFuncionario();
			}
		});
		
		
//		bntNovo = new JButton("Novo");
//		bntExcluir = new JButton("Excluir");
//		bntAtualizar = new JButton("Atualizar");
//		bntSair = new JButton("Sair");
				
		painel.add(lblTitulo);
		painel.add(scrollFuncionarios);
		painel.add(btnNovo);
		
		tela.setVisible(true);
		
	}
	
	
}
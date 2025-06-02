package br.dev.nikolas.tarefas.ui;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class FrameTelaInicial {
	private JButton btnFuncionarios;
	private JButton btnTarefas;
	private JLabel lblTitulo;
	
	private Font fontTitulo = new Font("Arial", Font.BOLD, 18);
	
	public FrameTelaInicial () {
		criarTela();
	}
	
	private void criarTela () {
		JFrame tela = new JFrame();
		tela.setLayout(null);
		tela.setSize(500, 300);
		tela.setVisible(true);
		
		btnFuncionarios = new JButton("Funcionários");
		btnFuncionarios.setBounds(80, 100, 150, 60);
		btnFuncionarios.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new FrameListaFuncionario();
				
			}
		});
		
		btnTarefas = new JButton("Tarefas");
		btnTarefas.setBounds(260, 100, 150, 60);
		btnTarefas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new FrameListaTarefa();
				
			}
		});
		
		lblTitulo = new JLabel("Selecione a opção desejada:");
		lblTitulo.setBounds(125, 30, 500, 30);
		lblTitulo.setFont(fontTitulo);
		
		Container painel = tela.getContentPane();
		
		painel.add(btnFuncionarios);
		painel.add(btnTarefas);
		painel.add(lblTitulo);
		
	}
}

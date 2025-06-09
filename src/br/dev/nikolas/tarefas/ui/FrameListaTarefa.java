package br.dev.nikolas.tarefas.ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class FrameListaTarefa {
	
	private JLabel lblCodigo, lblTitulo, lblDescricao, lblDataInicial, lblPrazo, lblResponsavel;
	private JTextField txtCodigo, txtTitulo, txtDescricao, txtResponsavel;
	private JSpinner dataInicial;
	private JButton btnNovaTarefa, btnSair;
	private DefaultTableModel modeloTabela;
	private JTable tabela;
	private Font fontTitulo = new Font("Arial", Font.BOLD, 26);
	
	public FrameListaTarefa () {
		criarTela();
	}
	
	private void criarTela() {
	    JFrame tela = new JFrame();
	    tela.setLayout(null);
	    tela.setSize(600, 600);
	    tela.setResizable(false);
	    tela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    tela.setVisible(true);
	    tela.setLocationRelativeTo(null);
	    
	    Container painel = tela.getContentPane();

	    lblTitulo = new JLabel("Lista de Tarefas");
	    lblTitulo.setBounds(10, 20, 500, 30);
	    lblTitulo.setFont(fontTitulo);

	    btnNovaTarefa = new JButton("Nova Tarefa");
	    btnNovaTarefa.setBounds(140, 500, 150, 40);
	    btnNovaTarefa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new FrameTarefa();
				
			}
		});

	    btnSair = new JButton("Sair");
	    btnSair.setBounds(300, 500, 150, 40);
	    btnSair.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            new FrameTelaInicial();
	            tela.dispose();
	        }
	    });

	 
	    String[] colunas = {"Código", "Nome", "Responsável"};
	    modeloTabela = new DefaultTableModel(colunas, 0);
	    tabela = new JTable(modeloTabela);
	    JScrollPane scrollPane = new JScrollPane(tabela);
	    scrollPane.setBounds(50, 80, 500, 400);

	    painel.add(lblTitulo);
	    painel.add(btnNovaTarefa);
	    painel.add(btnSair);
	    painel.add(scrollPane);
	}
}

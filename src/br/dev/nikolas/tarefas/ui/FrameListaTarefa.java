package br.dev.nikolas.tarefas.ui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;

public class FrameListaTarefa {
	
	private JLabel lblCodigo, lblTitulo, lblDescricao, lblDataInicial, lblPrazo, lblResponsavel;
	private JTextField txtCodigo, txtTitulo, txtDescricao, txtResponsavel;
	private JSpinner dataInicial;
	
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
	}
	
}

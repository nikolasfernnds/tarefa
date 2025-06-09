package br.dev.nikolas.tarefas.ui;

import java.awt.Button;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;

import br.dev.nikolas.tarefas.dao.FuncionarioDAO;
import br.dev.nikolas.tarefas.model.Funcionario;
import br.dev.nikolas.tarefas.utils.Utils;

public class FrameTarefa {

	private JLabel lblCodigo, lblTitulo, lblDescricao, lblDataInicial, lblPrazo, lblResponsavel;
	private JTextField txtCodigo, txtTitulo, txtDescricao, txtResponsavel;
	private JSpinner dataInicial;
	private JButton bntSalvar, bntSair;

	public FrameTarefa(JFrame telaLista) {
		criarTela(telaLista);
	}

	private void criarTela(JFrame telaLista) {

		JDialog tela = new JDialog(telaLista, "Cadastro de Tarefas", true);
		tela.setLayout(null);
		tela.setSize(400, 600);
		tela.setResizable(false);
		tela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		tela.setLocationRelativeTo(telaLista);

		Container painel = tela.getContentPane();

		lblTitulo = new JLabel("Título");
		lblTitulo.setBounds(20, 20, 200, 30);
		txtTitulo = new JTextField();
		txtTitulo.setBounds(20, 50, 200, 30);
		txtTitulo.setEnabled(false);

		lblDescricao= new JLabel("Descrição");
		lblDescricao.setBounds(20, 85, 200, 30);
		txtDescricao = new JTextField();
		txtDescricao.setBounds(20, 115, 345, 50);

		lblDataInicial = new JLabel("Telefone");
		lblDataInicial.setBounds(50, 150, 200, 30);


		bntSalvar = new JButton("Salvar");
		bntSalvar.setBounds(80, 490, 100, 40);

		// Adicionar os ouvintes de ação dos botôes
		bntSalvar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Funcionario funcionario = new Funcionario();
				funcionario.setCodigo(Utils.gerarUUID());
//				funcionario.setNome(txtNome.getText());
//				funcionario.setTelefone(txtTelefone.getText());
//				funcionario.setEmail(txtEmail.getText());

				FuncionarioDAO dao = new FuncionarioDAO(funcionario);
				dao.gravar();

				JOptionPane.showMessageDialog(
						tela,
//						txtNome.getText() + " gravado com sucesso",
//						"Sucesso",
						JOptionPane.INFORMATION_MESSAGE
				);
				
//				limparFormulario();
				
			}
		});

		bntSair = new JButton("Sair");
		bntSair.setBounds(210,490, 100, 40);

		// Ação para poder fechar a tela
		bntSair.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int resposta = JOptionPane.showConfirmDialog(
						tela, 
						"Confima a saída do sistema?", 
						"Sair do Sistema",
						JOptionPane.YES_NO_OPTION
				);
				
				if (resposta == 0) {
					tela.dispose();
				}
			}
		});

		painel.add(lblTitulo);
		painel.add(txtTitulo);
		painel.add(lblDescricao);
		painel.add(txtDescricao);
		painel.add(bntSalvar);
		painel.add(bntSair);
		painel.revalidate();
		painel.repaint();

		tela.setVisible(true);

	}

//	private void limparFormulario() {
//		txtNome.setText(null);
//		txtEmail.setText(null);
//		txtTelefone.setText(null);
//		txtNome.requestFocus();
//	}
	
}
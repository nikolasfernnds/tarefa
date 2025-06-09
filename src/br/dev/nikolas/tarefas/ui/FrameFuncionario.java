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
import javax.swing.JTextField;

import br.dev.nikolas.tarefas.dao.FuncionarioDAO;
import br.dev.nikolas.tarefas.model.Funcionario;
import br.dev.nikolas.tarefas.utils.Utils;

public class FrameFuncionario {

	private JLabel lblCodigo, lblNome, lblTelefone, lblEmail;
	private JTextField txtCodigo, txtNome, txtTelefone, txtEmail;
	private JButton bntSalvar, bntSair;

	public FrameFuncionario(JFrame telaLista) {
		criarTela(telaLista);
	}

	private void criarTela(JFrame telaLista) {

		JDialog tela = new JDialog(telaLista, "Cadastro de Funcionários", true);
		tela.setLayout(null);
		tela.setSize(400, 400);
		tela.setResizable(false);
		tela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		tela.setLocationRelativeTo(telaLista);

		Container painel = tela.getContentPane();

		lblCodigo = new JLabel("Código");
		lblCodigo.setBounds(20, 20, 200, 30);
		txtCodigo = new JTextField();
		txtCodigo.setBounds(20, 50, 200, 30);
		txtCodigo.setEnabled(false);

		lblNome = new JLabel("Nome");
		lblNome.setBounds(20, 85, 200, 30);
		txtNome = new JTextField();
		txtNome.setBounds(20, 115, 345, 30);

		lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(20, 150, 200, 30);
		txtTelefone = new JTextField();
		txtTelefone.setBounds(20, 180, 200, 30);

		lblEmail = new JLabel("Email");
		lblEmail.setBounds(20, 215, 200, 30);
		txtEmail = new JTextField();
		txtEmail.setBounds(20, 245, 300, 30);

		bntSalvar = new JButton("Salvar");
		bntSalvar.setBounds(20, 290, 120, 40);

		// Adicionar os ouvintes de ação dos botôes
		bntSalvar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Funcionario funcionario = new Funcionario();
				funcionario.setCodigo(Utils.gerarUUID());
				funcionario.setNome(txtNome.getText());
				funcionario.setTelefone(txtTelefone.getText());
				funcionario.setEmail(txtEmail.getText());

				FuncionarioDAO dao = new FuncionarioDAO(funcionario);
				dao.gravar();

				JOptionPane.showMessageDialog(
						tela,
						txtNome.getText() + " gravado com sucesso",
						"Sucesso",
						JOptionPane.INFORMATION_MESSAGE
				);
				
				limparFormulario();
				
			}
		});

		bntSair = new JButton("Sair");
		bntSair.setBounds(150, 290, 100, 40);

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

		painel.add(lblCodigo);
		painel.add(txtCodigo);
		painel.add(lblNome);
		painel.add(txtNome);
		painel.add(lblTelefone);
		painel.add(txtTelefone);
		painel.add(lblEmail);
		painel.add(txtEmail);
		painel.add(bntSalvar);
		painel.add(bntSair);
		painel.revalidate();
		painel.repaint();

		tela.setVisible(true);

	}

	private void limparFormulario() {
		txtNome.setText(null);
		txtEmail.setText(null);
		txtTelefone.setText(null);
		txtNome.requestFocus();
	}
	
}
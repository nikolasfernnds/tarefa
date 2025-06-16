package br.dev.nikolas.tarefas.ui;

import java.awt.Button;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JComboBox;

import br.dev.nikolas.tarefas.dao.FuncionarioDAO;
import br.dev.nikolas.tarefas.model.Funcionario;
import br.dev.nikolas.tarefas.utils.Utils;

public class FrameTarefa {

	private JLabel lblCodigo, lblTitulo, lblDescricao, lblFuncionario, lblPrazo, lblResponsavel, lblDataInicial, lblStatus;
	private JTextField txtCodigo, txtTitulo, txtDataInicial, txtPrazo, txtDescricao, txtResponsavel;
	private JButton bntSalvar, bntSair;
	JComboBox<String> boxStatus;
	JComboBox<String> boxFuncionario;

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
		txtDescricao.setBounds(20, 115, 345, 30);

		lblDataInicial = new JLabel("Data Inicial");
		lblDataInicial.setBounds(20, 150, 200, 30);
		txtDataInicial = new JTextField();
		txtDataInicial.setBounds(20, 185, 200, 30);
		
		lblPrazo = new JLabel("Prazo");
		lblPrazo.setBounds(20, 210, 200, 30);
		txtPrazo = new JTextField();
		txtPrazo.setBounds(20, 245, 200, 30);

		lblStatus= new JLabel("Status");
		lblStatus.setBounds(20, 280, 150, 50);
		boxStatus = new JComboBox<String>();
		boxStatus.setBounds(20, 340, 130, 30);
		boxStatus.addItem("NÃO_INICIADA");
		boxStatus.addItem("EM_ANDAMENTO");
		boxStatus.addItem("FINALIZADA");
		boxStatus.addItem("EM_ATRASO");
		
		lblFuncionario = new JLabel("Responsável");
		lblFuncionario.setBounds(20, 380, 150, 50);
		boxFuncionario = new JComboBox<String>();
		boxFuncionario.setBounds(20, 440, 150, 30);
		FuncionarioDAO dao = new FuncionarioDAO(null);
		List<Funcionario> funcionarios = dao.showEmployees();
		for (Funcionario f : funcionarios) {
			boxFuncionario.addItem(f.getNome());
		}
		
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
		painel.add(lblDataInicial);
		painel.add(txtDataInicial);
		painel.add(lblPrazo);
		painel.add(txtPrazo);
		painel.add(lblStatus);
		painel.add(boxStatus);
		painel.add(lblFuncionario);
		painel.add(boxFuncionario);
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
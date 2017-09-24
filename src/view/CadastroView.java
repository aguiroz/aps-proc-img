package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import controller.UsuarioController;
import model.UsuarioModel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JFileChooser;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;
import java.awt.event.ActionEvent;

public class CadastroView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtLogin;
	private JTextField txtBiometria;
		
	private UsuarioController usuarioController;
	private List<UsuarioModel> listaUsuarios;
	private UsuarioModel usuario;
	private JTextField txtNivel;
	
	JButton btnIncluir;
	JButton btnAlterar;
	JButton btnExcluir;
	JButton btnBuscar;
	JButton btnSalvar;
	JButton btnCancelar;
	
	String op = "";
	
	int index = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroView frame = new CadastroView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CadastroView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 912, 532);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 885, 97);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnPrimeiro = new JButton("<<");
		btnPrimeiro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				primeiro();
			}
		});
		btnPrimeiro.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnPrimeiro.setBounds(12, 13, 97, 71);
		panel.add(btnPrimeiro);
		
		JButton btnAnterior = new JButton("<");
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anterior();
			}
		});
		btnAnterior.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAnterior.setBounds(121, 13, 97, 71);
		panel.add(btnAnterior);
		
		JButton btnProximo = new JButton(">");
		btnProximo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				proximo();
			}
		});
		btnProximo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnProximo.setBounds(230, 13, 97, 71);
		panel.add(btnProximo);
		
		JButton btnUltimo = new JButton(">>");
		btnUltimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ultimo();
			}
		});
		btnUltimo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnUltimo.setBounds(339, 13, 97, 71);
		panel.add(btnUltimo);
		
		btnIncluir = new JButton("Incluir");
		btnIncluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				operacaoIncluir();
				//habilitarCampos();
				//incluir();
			}
		});
		btnIncluir.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnIncluir.setBounds(448, 13, 97, 71);
		panel.add(btnIncluir);
		
		btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				operacaoAlterar();
			}
		});
		btnAlterar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAlterar.setBounds(560, 13, 97, 71);
		panel.add(btnAlterar);
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Excluir?") == 1)	
					excluir();
			}
		});
		btnExcluir.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnExcluir.setBounds(669, 13, 97, 71);
		panel.add(btnExcluir);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnSair.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSair.setBounds(778, 13, 97, 71);
		panel.add(btnSair);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(15, 115, 867, 183);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome: ");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNome.setBounds(12, 13, 95, 26);
		panel_1.add(lblNome);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblLogin.setBounds(12, 52, 95, 26);
		panel_1.add(lblLogin);
		
		JLabel lblBiometria = new JLabel("Biometria:");
		lblBiometria.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblBiometria.setBounds(12, 91, 95, 26);
		panel_1.add(lblBiometria);
		
		JLabel lblNivelDeAcesso = new JLabel("Nivel:");
		lblNivelDeAcesso.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNivelDeAcesso.setBounds(12, 130, 95, 26);
		panel_1.add(lblNivelDeAcesso);
		
		txtNome = new JTextField();
		txtNome.setEnabled(false);
		txtNome.setBounds(119, 17, 725, 22);
		panel_1.add(txtNome);
		txtNome.setColumns(10);
		
		txtLogin = new JTextField();
		txtLogin.setEnabled(false);
		txtLogin.setColumns(10);
		txtLogin.setBounds(119, 56, 725, 22);
		panel_1.add(txtLogin);
		
		txtBiometria = new JTextField();
		txtBiometria.setEnabled(false);
		txtBiometria.setColumns(10);
		txtBiometria.setBounds(119, 95, 587, 22);
		panel_1.add(txtBiometria);
		
		btnBuscar = new JButton("Procurar...");
		btnBuscar.setEnabled(false);
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				carregarBiometria();
			}
		});
		btnBuscar.setBounds(718, 94, 126, 25);
		panel_1.add(btnBuscar);
		
		txtNivel = new JTextField();
		txtNivel.setEnabled(false);
		txtNivel.setColumns(10);
		txtNivel.setBounds(119, 134, 449, 22);
		panel_1.add(txtNivel);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				salvar();
			}
		});
		btnSalvar.setEnabled(false);
		btnSalvar.setBounds(718, 133, 126, 25);
		panel_1.add(btnSalvar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelar();
			}
		});
		btnCancelar.setEnabled(false);
		btnCancelar.setBounds(580, 133, 126, 25);
		panel_1.add(btnCancelar);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(12, 311, 159, 163);
		contentPane.add(panel_2);
		
		
		initComponents();
		setUsuario();
	}
	
	private void initComponents() {

		usuarioController = new UsuarioController();
		
		getUsuarios();
		
		if(!listaUsuarios.isEmpty()) {
			usuario = listaUsuarios.get(index);
		}
		
	}
	
	private void getUsuarios(){
		try {
			listaUsuarios = usuarioController.listarUsuarios();
		} catch(Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}
	
	private void setUsuario() {
		if(usuario != null) {
			txtNome.setText(usuario.getNome());
			txtLogin.setText(usuario.getLogin());
			txtBiometria.setText(usuario.getLogin() + ".png");
			txtNivel.setText(String.valueOf(usuario.getNivelAcesso()));
		}
	}
	
	private void proximo() {
		
		index ++;
		
		if(index < listaUsuarios.size()) {
			usuario = listaUsuarios.get(index);
			setUsuario();
		}
		else {
			index = 0;
			usuario = listaUsuarios.get(index);
			setUsuario();
		}
		
	}
	
	private void anterior() {
		
		index --;
		
		if(index < listaUsuarios.size() && index >= 0) {
			usuario = listaUsuarios.get(index);
			setUsuario();
		}
		else {
			index = listaUsuarios.size() - 1;
			usuario = listaUsuarios.get(index);
			setUsuario();
		}
		
	}
	
	private void primeiro() {
		index = 0;
		usuario = listaUsuarios.get(index);
		setUsuario();
	}
	
	private void ultimo() {
		index = listaUsuarios.size() - 1;
		usuario = listaUsuarios.get(index);
		setUsuario();
	}
	
	private void getDados() {
		usuario.setNome(txtNome.getText());
		usuario.setLogin(txtLogin.getText());
		usuario.setNivelAcesso(Integer.parseInt(txtNivel.getText()));
	}
	
	private void incluir() {
		getDados();
		try {
			usuarioController.incluir(usuario, txtBiometria.getText());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
		
		getUsuarios();
		
	}
	
	private void alterar() {
		getDados();
		try {
			usuarioController.alterar(usuario, txtBiometria.getText());
		} catch(Exception e) {
			JOptionPane.showMessageDialog(this,	e.getMessage());
		}
		
		getUsuarios();
	}
	
	private void excluir() {
		getDados();
		try {
			usuarioController.excluir(usuario);
		} catch(Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
		
		getUsuarios();
		primeiro();
	}
	
	private void carregarBiometria(){
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int i = fileChooser.showSaveDialog(null);
		if(i == 1) {
			txtBiometria.setText("");
		} else {
			File file = fileChooser.getSelectedFile();
			txtBiometria.setText(file.getPath());
		}
	}
	
	private void habilitarCampos() {
		txtNome.setEnabled(true);
		txtLogin.setEnabled(true);
		txtBiometria.setEnabled(true);
		txtNivel.setEnabled(true);
	}
	
	private void desabilitarCampos() {
		txtNome.setEnabled(false);
		txtLogin.setEnabled(false);
		txtBiometria.setEnabled(false);
		txtNivel.setEnabled(false);

	}
	
	private void habilitarBotoes() {
		
		btnIncluir.setEnabled(true);
		btnAlterar.setEnabled(true);
		btnExcluir.setEnabled(true);
		
		
	}
	
	private void operacaoIncluir() {
		habilitarCampos();
		btnAlterar.setEnabled(false);
		btnExcluir.setEnabled(false);
		btnSalvar.setEnabled(true);
		btnCancelar.setEnabled(true);
		btnBuscar.setEnabled(true);
		op = "incluir";
		
	}
	
	private void operacaoAlterar() {
		habilitarCampos();
		btnIncluir.setEnabled(false);
		btnExcluir.setEnabled(false);
		btnSalvar.setEnabled(true);
		btnCancelar.setEnabled(true);
		btnBuscar.setEnabled(true);
		op = "alterar";
	}
	
	private void salvar() {
		switch(op) {
		case "incluir":
			
			incluir();
			habilitarCampos();
			habilitarBotoes();
			
			btnSalvar.setEnabled(false);
			btnCancelar.setEnabled(false);
			
			break;
			
		case "alterar":
			
			alterar();
			habilitarCampos();
			habilitarBotoes();
			
			break;
		}
	}
	
	private void cancelar() {
		desabilitarCampos();
		btnSalvar.setEnabled(false);
		btnCancelar.setEnabled(false);
		btnBuscar.setEnabled(false);
		habilitarBotoes();
		
	}
}

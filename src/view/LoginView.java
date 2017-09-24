package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.LoginController;
import model.UsuarioModel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.Serializable;
import java.awt.event.ActionEvent;

public class LoginView extends JFrame implements Serializable {
	

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtLogin;
	private JTextField txtBiometria;
	
	private LoginController loginController;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView frame = new LoginView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public LoginView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 551, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLogin.setBounds(12, 13, 80, 22);
		contentPane.add(lblLogin);
		
		txtLogin = new JTextField();
		txtLogin.setBounds(104, 15, 403, 22);
		contentPane.add(txtLogin);
		txtLogin.setColumns(10);
		
		JLabel lblBiometria = new JLabel("Biometria");
		lblBiometria.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBiometria.setBounds(12, 51, 80, 22);
		contentPane.add(lblBiometria);
		
		txtBiometria = new JTextField();
		txtBiometria.setColumns(10);
		txtBiometria.setBounds(104, 53, 296, 22);
		contentPane.add(txtBiometria);
		
		JButton btnCarregar = new JButton("Carregar...");
		btnCarregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				carregarBiometria();
			}
		});
		btnCarregar.setBounds(412, 52, 95, 25);
		contentPane.add(btnCarregar);
		
		JButton btnAutenticar = new JButton("Autenticar");
		btnAutenticar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login();
			}
		});
		btnAutenticar.setFont(new Font("Tahoma", Font.PLAIN, 26));
		btnAutenticar.setBounds(12, 86, 495, 54);
		contentPane.add(btnAutenticar);
		
		loginController = new LoginController();
		
	}
	
	public void carregarBiometria() {
		
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
	
	private void login() {
		
		String login = txtLogin.getText();
		String biometria = txtBiometria.getText();
		
		try {
			if(loginController.autenticar(login, biometria)) {
				this.setVisible(false);
				UsuarioModel usuario = new UsuarioModel();
				usuario.setLogin("arozaboni");
				usuario.setNivelAcesso(3);
				usuario.setNome("Anderson");
				new AcessoRestritoView(usuario).setVisible(true);
			} else {
				JOptionPane.showMessageDialog(this, "Não foi possivel autenticar");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Não foi possivel fazer a autenticação. " + e.getMessage());
		}
	}
}

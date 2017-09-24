package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.UsuarioModel;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AcessoRestritoView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	
	private JTextField txtRazaoSocial;
	private JTextField txtUF;
	private JTextField txtEndereco;
	private JTextField txtResponsavel;
	private JTextField txtCNPJ;
	private JTextField txtProduto;
	
	JLabel lblInformaoSobrePropriedade;
	JLabel lblImpactosNosLenois;
	JLabel lblRazaoSocial;
	JLabel lblUf;
	JLabel lblEndereo;
	JLabel lblResponsvel;
	JLabel lblCnpj;
	JLabel lblNivelDeAcesso;
	JLabel lblAcesso;
	JLabel lblProdutoUtilizado;
	JLabel lblUsuario;
	
	private UsuarioModel usuario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UsuarioModel user = new UsuarioModel();
					user.setLogin("arozaboni");
					user.setNome("Anderson Guilherme Rozaboni");
					user.setNivelAcesso(3);
					AcessoRestritoView frame = new AcessoRestritoView(user);
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
	public AcessoRestritoView(UsuarioModel usuario) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1037, 653);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 13, 995, 125);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Minist\u00E9rio do Meio Ambiente");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 72));
		lblNewLabel.setBounds(12, 13, 971, 99);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(12, 151, 995, 88);
		contentPane.add(panel_1);
		
		lblInformaoSobrePropriedade = new JLabel("Informa\u00E7\u00F5es estrategicas sobre propriedades ruraris que utilizam agrot\u00F3xicos proibidos por causarem");
		lblInformaoSobrePropriedade.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblInformaoSobrePropriedade.setBounds(61, 13, 804, 20);
		panel_1.add(lblInformaoSobrePropriedade);
		
		lblImpactosNosLenois = new JLabel("impactos nos len\u00E7ois freaticos, rios, mares, etc");
		lblImpactosNosLenois.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblImpactosNosLenois.setBounds(258, 49, 385, 20);
		panel_1.add(lblImpactosNosLenois);
		
		lblRazaoSocial = new JLabel("Raz\u00E3o Social:");
		lblRazaoSocial.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRazaoSocial.setBounds(12, 287, 108, 25);
		contentPane.add(lblRazaoSocial);
		
		lblUf = new JLabel("UF:");
		lblUf.setVisible(false);
		lblUf.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUf.setBounds(12, 325, 90, 25);
		contentPane.add(lblUf);
		
		lblEndereo = new JLabel("Endere\u00E7o:");
		lblEndereo.setVisible(false);
		lblEndereo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEndereo.setBounds(12, 363, 108, 25);
		contentPane.add(lblEndereo);
		
		lblResponsvel = new JLabel("Respons\u00E1vel:");
		lblResponsvel.setVisible(false);
		lblResponsvel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblResponsvel.setBounds(12, 401, 108, 25);
		contentPane.add(lblResponsvel);
		
		lblCnpj = new JLabel("CNPJ:");
		lblCnpj.setVisible(false);
		lblCnpj.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCnpj.setBounds(12, 477, 90, 25);
		contentPane.add(lblCnpj);
		
		lblNivelDeAcesso = new JLabel("Nivel de acesso:");
		lblNivelDeAcesso.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNivelDeAcesso.setBounds(701, 252, 124, 25);
		contentPane.add(lblNivelDeAcesso);
		
		lblAcesso = new JLabel("");
		lblAcesso.setFont(new Font("Tahoma", Font.PLAIN, 87));
		lblAcesso.setBounds(731, 302, 58, 88);
		contentPane.add(lblAcesso);
		
		txtRazaoSocial = new JTextField();
		txtRazaoSocial.setEnabled(false);
		txtRazaoSocial.setText("Fazenda xxx");
		txtRazaoSocial.setBounds(132, 289, 461, 22);
		contentPane.add(txtRazaoSocial);
		txtRazaoSocial.setColumns(10);
		
		txtUF = new JTextField();
		txtUF.setVisible(false);
		txtUF.setEnabled(false);
		txtUF.setText("SP");
		txtUF.setColumns(10);
		txtUF.setBounds(132, 327, 461, 22);
		contentPane.add(txtUF);
		
		txtEndereco = new JTextField();
		txtEndereco.setVisible(false);
		txtEndereco.setEnabled(false);
		txtEndereco.setText("Rua Tambau, 18");
		txtEndereco.setColumns(10);
		txtEndereco.setBounds(132, 365, 461, 22);
		contentPane.add(txtEndereco);
		
		txtResponsavel = new JTextField();
		txtResponsavel.setVisible(false);
		txtResponsavel.setEnabled(false);
		txtResponsavel.setText("Natalicio");
		txtResponsavel.setColumns(10);
		txtResponsavel.setBounds(132, 403, 461, 22);
		contentPane.add(txtResponsavel);
		
		txtCNPJ = new JTextField();
		txtCNPJ.setVisible(false);
		txtCNPJ.setEnabled(false);
		txtCNPJ.setText("11.222.333/0001-60");
		txtCNPJ.setColumns(10);
		txtCNPJ.setBounds(132, 479, 461, 22);
		contentPane.add(txtCNPJ);
		
		JLabel lbl4 = new JLabel("Usuario:");
		lbl4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl4.setBounds(12, 249, 60, 25);
		contentPane.add(lbl4);
		
		lblUsuario = new JLabel("");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUsuario.setBounds(94, 252, 595, 25);
		contentPane.add(lblUsuario);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSair.setBounds(910, 568, 97, 25);
		contentPane.add(btnSair);
		
		lblProdutoUtilizado = new JLabel("Produto:");
		lblProdutoUtilizado.setVisible(false);
		lblProdutoUtilizado.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblProdutoUtilizado.setBounds(12, 439, 90, 25);
		contentPane.add(lblProdutoUtilizado);
		
		txtProduto = new JTextField();
		txtProduto.setVisible(false);
		txtProduto.setText("Thug Life 123");
		txtProduto.setEnabled(false);
		txtProduto.setColumns(10);
		txtProduto.setBounds(132, 441, 461, 22);
		contentPane.add(txtProduto);
		
		this.usuario = usuario;
		setNivelAcesso();
		
	}
	private void setNivelAcesso(){
		switch(usuario.getNivelAcesso()) {
		case 1:
			setNivel1();
			break;
		
		case 2:
			setNivel2();
			break;
			
		case 3:
			setNivel3();
			break;
			
		default:
			setNivel1();
			break;
		
		}
	}
	
	private void setNivel1() {
		lblUsuario.setText(usuario.getNome());
		lblAcesso.setText("1");
	}
	
	private void setNivel2() {
		lblUsuario.setText(usuario.getNome());
		lblAcesso.setText("2");
		
		lblUf.setVisible(true);
		txtUF.setVisible(true);
	}
	
	private void setNivel3() {
		lblUsuario.setText(usuario.getNome());
		lblAcesso.setText("3");
		
		lblUf.setVisible(true);
		txtUF.setVisible(true);
		
		lblEndereo.setVisible(true);
		lblResponsvel.setVisible(true);
		lblProdutoUtilizado.setVisible(true);
		lblCnpj.setVisible(true);
		
		txtEndereco.setVisible(true);
		txtResponsavel.setVisible(true);
		txtProduto.setVisible(true);
		txtCNPJ.setVisible(true);
		
		
		
	}
}

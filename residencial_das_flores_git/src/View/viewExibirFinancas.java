package View;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.ScrollPane;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class viewExibirFinancas extends JFrame {
	private JPanel resultado;
	private JPanel resultado1;
	private JPanel resultado2;
	private JPanel resultado3;
	private JPanel resultado4;
	private JLabel lblespaco;
	private JLabel lblespaco1;
	
	private JRadioButton exibirConta;
	private JRadioButton exibirDespesas;
	private ButtonGroup grupo;
	private JScrollPane scroll;
	private JTextArea exibir;
	private JLabel lblTotalLancadasContas;
	private JLabel lblTotalContasLancadasResultado;
	private JLabel lblTotalContasPagas;
	private JLabel lblTotalContasPagasResultado;
	private JLabel lblTotalContasQuitadas;
	private JLabel lblTotalContasQuitadasResultado;
	
	
	public viewExibirFinancas() {
		super("Exibição de finanças");
		setSize(400,400);
		setLocationRelativeTo(null);
		setLayout(new FlowLayout());
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		
		grupo = new ButtonGroup();
		exibirConta = new JRadioButton("Exibir Contas a Receber");
		exibirDespesas = new JRadioButton("Exibir Despesas");
		grupo.add(exibirConta);
		grupo.add(exibirDespesas);
		
		exibir = new JTextArea("Data lançamento, Data pagamento,Apartamento,Valor e descrição", 10, 30);
		exibir.setEditable(false);
		scroll = new JScrollPane(exibir,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		lblTotalLancadasContas = new JLabel("Total de Contas lançadas");
		lblTotalContasLancadasResultado = new JLabel("R$ 00.00");
		lblTotalContasPagas = new JLabel("Total de Contas pagas");
		lblTotalContasPagasResultado = new JLabel("R$ 00.00");
		lblTotalContasQuitadas = new JLabel("Total de Contas a quitar");
		lblTotalContasQuitadasResultado = new JLabel("R$ 00.00");
		resultado = new JPanel(new FlowLayout());
		resultado1 = new JPanel(new FlowLayout());
		resultado2 = new JPanel(new FlowLayout());
		//resultado1.setBackground(Color.CYAN);
		resultado3 = new JPanel(new FlowLayout());
		//resultado3.setBackground(Color.CYAN);
		lblespaco = new JLabel("                       ");
		lblespaco1 = new JLabel("              ");
		resultado4 = new JPanel(new FlowLayout());
		//resultado4.setBackground(Color.CYAN);
		
		resultado3.add(lblespaco);
		resultado4.add(lblespaco1);
		resultado.setSize(100, 50);
		//resultado.setBackground(Color.RED);
		
		exibirConta.setSelected(true);
		
		add(exibirConta);
		add(exibirDespesas);
		add(scroll);
		add(resultado);
		resultado.add(lblTotalLancadasContas);
		resultado.add(lblTotalContasLancadasResultado);
		resultado1.add(lblTotalContasPagas);
		resultado1.add(lblTotalContasPagasResultado);
		resultado2.add(lblTotalContasQuitadas);
		resultado2.add(lblTotalContasQuitadasResultado);
		add(resultado);
		add(resultado3);
		add(resultado1);
		add(resultado4);
		add(resultado2);
		
		
		
		
	}
	
}

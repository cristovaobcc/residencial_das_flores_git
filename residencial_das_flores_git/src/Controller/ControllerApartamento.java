package Controller;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Observable;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;


import Model.Apartamento;
import Model.BaseDados;
import Model.StatusApartamentos;
import View.TelaMensagem;
import View.viewApartamento;
import View.viewEditarApartamento;

public class ControllerApartamento extends Observable {
	private viewApartamento tela;
	private viewEditarApartamento tela2;
	private controllerLogin tela3;

	public ControllerApartamento(viewApartamento tela, viewEditarApartamento tela2, controllerLogin tela3) {
		super();
		this.tela = tela;
		this.tela2 = tela2;
		this.tela3 = tela3;
		Control();
	}
	private void Control() {
		tela.requestFocus();
		tela.getCadastrar().addActionListener(new Cadastro());
		tela.getLimpar().addActionListener(new Cadastro());
		tela.getCancelar().addActionListener(new Cadastro());
		tela.getBuscaArea().addMouseListener(new ConsultaMouse());
		tela.getSair().addActionListener(new ConsultaMouse());
		tela.getBusca().addActionListener(new BotaoConsulta());
		tela.getBuscaField().addKeyListener(new AreaBusca());
		tela.getExcluir().addActionListener(new ConsultaMouse());
		tela.getEditar().addActionListener(new BotaoEditar());
		tela.getNaptoField().addMouseListener(new Cadastro());
		tela.getQuantidadeField().addMouseListener(new Cadastro());
		tela.getBuscar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				tela.getBusca().doClick();
				
			}
		});
		tela.getCadastrar().addKeyListener(new ClasseBotoes());
		tela.getCancelar().addKeyListener(new ClasseBotoes());
		tela.getNaptoField().addKeyListener(new ClasseBotoes());
		tela.getQuantidadeField().addKeyListener(new ClasseBotoes());
		tela.getTipo().addKeyListener(new ClasseBotoes());
		tela.getBusca().addKeyListener(new ClasseBotoes());
		tela.getBuscaField().addKeyListener(new ClasseBotoes());
		tela.getLimpar().addKeyListener(new ClasseBotoes());
		
		
		tela2.getEditar().addActionListener(new ComandoTelaEditar());
		tela2.getCancelar().addActionListener(new ComandoTelaEditar());
		tela2.getLimpar().addActionListener(new ComandoTelaEditar());
		
		
		
		tela3.viewprincipal.getMenuItemControleApartamentos().addActionListener(new EntrarControleApartamento());
		
	}
	
	private class Cadastro extends MouseAdapter implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == tela.getLimpar()) {
				tela.getNaptoField().setBackground(Color.WHITE);
				tela.getQuantidadeField().setBackground(Color.WHITE);
				tela.getNaptoField().setText("");
				tela.getQuantidadeField().setText("");
				tela.getTipo().setSelectedIndex(0);
				tela.getBuscaField().setText("");
				tela.getBuscaArea().setText("Dados:");
			}
			if (e.getSource() == tela.getCancelar()) {
				if(JOptionPane.showConfirmDialog(null, "Deseja sair do cadastro?","Alerta",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION) {
				tela.dispose();
				}
			}
			
			
			
			if(e.getSource() == tela.getCadastrar()) {
				if(!tela.getNaptoField().getText().equals("") && !tela.getQuantidadeField().getText().equals("")) {
				try{
				String tipo = (String) tela.getTipo().getSelectedItem();
				if(BaseDados.ExisteApartamento(tela.getNaptoField().getText())) {
					
					BaseDados.getApartamentos().add(new Apartamento(tela.getNaptoField().getText(),Integer.parseInt(tela.getQuantidadeField().getText()),tipo));
					
					TelaMensagem.Exibir("Cadastrado com sucesso!");
					tela.getLimpar().doClick();
					setChanged();
					notifyObservers();
				}else {
					TelaMensagem.Exibir("Erro: esse apartamento ja foi cadastrado!");
					tela.getLimpar().doClick();
				}
				
				}catch (Exception e1) {
					
					TelaMensagem.Exibir("Digite apenas numeros");
					tela.getQuantidadeField().setBackground(Color.RED);
				}
				}else {
					TelaMensagem.Exibir("Não pode deixar camos em brancos!");
					if(tela.getNaptoField().getText().equals("")) {
						tela.getNaptoField().setBackground(Color.RED);
					}
					if(tela.getQuantidadeField().getText().equals("")) {
						tela.getQuantidadeField().setBackground(Color.RED);
					}
				}
				
				tela.requestFocus();
			}
			
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			if(e.getSource() == tela.getNaptoField()) {
				tela.getNaptoField().setBackground(Color.WHITE);
				
			}
			if(e.getSource() == tela.getQuantidadeField()) {
				tela.getQuantidadeField().setBackground(Color.WHITE);
			}
			
		}

		

		
		
	}
	private class ConsultaMouse extends MouseAdapter implements ActionListener{
		
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if(SwingUtilities.isRightMouseButton(e)){
				tela.getMenuPop().show(tela.getBuscaArea(), e.getX(), e.getY());

			}

			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == tela.getSair()) {
				tela.dispose();
			}
			
			if(e.getSource()==tela.getBusca()) {
				tela.getBusca().doClick();
			}
			if(e.getSource()==tela.getExcluir()) {
				if(JOptionPane.showConfirmDialog(null, "Deseja excluir o registro ?","Excluir", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
									
				if(BaseDados.ExcluirApartamento(tela.getBuscaField().getText())) {
					
					
					setChanged();
					notifyObservers();
					TelaMensagem.Exibir("Registro excluido com sucesso!");
					tela.getBuscaField().setText("");
					tela.getBusca().doClick();
				}else {
					TelaMensagem.Exibir("Erro: Elemento não encontrado!");
					tela.getBuscaField().setText("");
					tela.getBusca().doClick();
				}
				}
			}
			
			
		}

		
		
		
	}
	private class AreaBusca extends KeyAdapter{
		@Override
		public void keyReleased(KeyEvent e) {
			tela.getBuscaArea().setText(BaseDados.SubString(tela.getBuscaField().getText()));
			
		}
		
		@Override
		public void keyPressed(KeyEvent e) {
			tela.getBuscaArea().setText(BaseDados.SubString(tela.getBuscaField().getText()));
			
		}
	}
	private class BotaoConsulta implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==tela.getBusca()) {
				tela.getBuscaArea().setText(BaseDados.SubString(tela.getBuscaField().getText()));
			}
			
		}
		
		
	}
	
	private class BotaoEditar implements ActionListener{
		
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==tela.getEditar()) {
				if(tela.getBuscaField().getText().equals("") && BaseDados.getApartamentos().size()==1) {
					Apartamento a = BaseDados.getApartamentos().get(0);
					tela2.getNaptoField().setText(a.getNumeroPorta());
					tela2.getQuantidadeField().setText(a.getQuantidadeQuartos()+"");
					int tipo=0;
					if(a.getTipoOcupacao()=="Proprietário") {
						tipo=0;
					}else if(a.getTipoOcupacao()=="Inquilino") {
						tipo=1;
					}else if(a.getTipoOcupacao()=="Vazio") {
						tipo=2;
					}
					tela2.getTipo().setSelectedIndex(tipo);
					tela2.setVisible(true);
				}else if(tela.getBuscaField().getText().equals("") && BaseDados.getApartamentos().size()>1) {
					TelaMensagem.Exibir("Digite o Nº do apartamento desejado!");
					return;
				}else {
				Apartamento a = BaseDados.Buscar(tela.getBuscaField().getText());
				tela2.getNaptoField().setText(a.getNumeroPorta());
				tela2.getQuantidadeField().setText(a.getQuantidadeQuartos()+"");
				int tipo=0;
				if(a.getTipoOcupacao()=="Proprietário") {
					tipo=0;
				}else if(a.getTipoOcupacao()=="Inquilino") {
					tipo=1;
				}else if(a.getTipoOcupacao()=="Vazio") {
					tipo=2;
				}
				tela2.getTipo().setSelectedIndex(tipo);
				tela2.setVisible(true);
			}
				}
			
		}
		
	}
	private class ComandoTelaEditar implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==tela2.getEditar()) {
				
				if (!tela2.getNaptoField().getText().equals("") && !tela2.getQuantidadeField().getText().equals("")) {
					if(BaseDados.ExisteApartamento(tela2.getNaptoField().getText()) || tela2.getNaptoField().getText().equals(tela.getBuscaField().getText())) {
					Apartamento removivel = BaseDados.Buscar(tela.getBuscaField().getText());
					Apartamento novo = new Apartamento(tela2.getNaptoField().getText(), Integer.parseInt(tela2.getQuantidadeField().getText()), (String)tela2.getTipo().getSelectedItem());
					BaseDados.EditarApartamento(removivel, novo);
					
					
					setChanged();
					notifyObservers();
					
					
					tela2.getLimpar().doClick();
					tela2.getCancelar().doClick();
					tela.getBusca().doClick();
					}else {
						TelaMensagem.Exibir("Erro: Esse apartamento ja foi cadastrado!");
					}
				}else {
					TelaMensagem.Exibir("Erro: Nenhum campo pode ficar em branco!");
				}
				
			}
			if(e.getSource()==tela2.getCancelar()) {
				tela2.setVisible(false);
			}
			if(e.getSource()==tela2.getLimpar()) {
				tela2.getNaptoField().setText("");
				tela2.getQuantidadeField().setText("");
				tela2.getTipo().setSelectedIndex(0);
			}
			
		}
		
	}
	private class EntrarControleApartamento implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource()==tela3.viewprincipal.getMenuItemControleApartamentos()) {
				
				tela.setVisible(true);
			}
			
		}}
	private class ClasseBotoes extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
				if(tela.getBusca().hasFocus()) {
					tela.getCancelar().doClick();
				}else if(tela.getCancelar().hasFocus()) {
					tela.getCancelar().doClick();
				}else if(tela.getCadastrar().hasFocus()) {
					tela.getCancelar().doClick();
				}else if(tela.getBuscaField().hasFocus()) {
					tela.getCancelar().doClick();
				}else if(tela.getLimpar().hasFocus()) {
					tela.getCancelar().doClick();
				}else if(tela2.getEditar().hasFocus()) {
					tela.getCancelar().doClick();
				}else if(tela2.getCancelar().hasFocus()) {
					tela.getCancelar().doClick();
				}else if(tela2.getLimpar().hasFocus()) {
					tela.getCancelar().doClick();
				}else {
					tela.getCancelar().doClick();
				}
			}
			if(e.getKeyCode() == KeyEvent.VK_ENTER) {
				if(tela.getBusca().hasFocus()) {
					tela.getBusca().doClick();
				}else if(tela.getCancelar().hasFocus()) {
					tela.getCancelar().doClick();
				}else if(tela.getCadastrar().hasFocus()) {
					tela.getCadastrar().doClick();
				}else if(tela.getBuscaField().hasFocus()) {
					tela.getBusca().doClick();
				}else if(tela.getLimpar().hasFocus()) {
					tela.getLimpar().doClick();
				}else if(tela2.getEditar().hasFocus()) {
					tela2.getEditar().doClick();
				}else if(tela2.getCancelar().hasFocus()) {
					tela2.getCancelar().doClick();
				}else if(tela2.getLimpar().hasFocus()) {
					tela2.getLimpar().doClick();
				}else {
				tela.getCadastrar().doClick();
				}
			}
			
		}
		

		}

	

}

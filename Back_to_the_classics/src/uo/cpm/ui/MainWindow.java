package uo.cpm.ui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.net.URL;

import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpinnerNumberModel;
import javax.swing.TransferHandler;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import uo.cpm.model.Product;
import uo.cpm.model.Ticket;
import uo.cpm.service.Game;

public class MainWindow extends JFrame {

	private JPanel contentPane;
	private JLabel lblTicket;
	private JTextField txtTicket;
	private Game game ;
	private ButtonAction aB;
	private JPanel panelLogo;
	private JLabel lblTitle;
	private JButton btnStart;
	private JButton btnExit;
	private JPanel pnMain;
	private JPanel pn1;
	private JLabel lblLink;
	private JMenuBar menuBar;
	private JMenu mnhelp;
	private JPanel pn2;
	private JPanel pnButton;
	private JScrollPane scrollPane;
	private JButton btnGame;
	private JTextArea txtArea;
	private JPanel pnGame;
	private JPanel pnCaracters;
	private JPanel pnBoard;
	private JPanel pnState;
	private String caracters[]= {"/img/1.jpg","/img/2.png","/img/3.png","/img/4.jpg","/img/5.jpg","/img/6.png","/img/8.png","/img/7.png"};
	private String leader="/img/7.png";

	private Drag pD=new Drag();;
	private ProcessLabel pBT= new ProcessLabel();
	private JButton btnConcede;
	private JPanel pnScore;
	private JPanel pnDouble;
	private JLabel lblScore;
	private JTextField txtScore;
	private JPanel pnLeader;
	private JPanel panel_3;
	private JLabel lblWave;
	private JTextField txtWave;
	private JLabel lblLeader;
	private JLabel lblLeaderIcon;
	private JPanel pnWin;
	private JPanel pnLose;
	private JPanel pnlbl;
	private JLabel lblWIn;
	private JButton btnPrize;
	private JPanel panelLose;
	private JLabel lblLose;
	private JLabel lblNewLabel;
	private JButton btnLeave;
	private JPanel pnPrize;
	private JScrollPane scrArticulos;
	private JPanel pnButtons;
	private JPanel pnCombo;
	private JComboBox<String> comboFilter;
	private JLabel lblSpace;
	private JPanel panel;
	private JTextField txtType;
	private JScrollPane scrOrder;
	private JLabel lblType;
	private JTextField txtName;
	private JTextField txtPoints;
	private JSpinner spUnits;
	private JLabel lblName;
	private JLabel lblDescription;
	private JLabel lblPoints;
	private JLabel lblQuantity;
	private JLabel lblAvailable;
	private JTextField txtAvailable;
	private JPanel pnCommand;
	private JButton btnAdd;
	private JPanel pnFlow;
	private JList AwardList;
	private DefaultListModel awardModel;
	private JButton btnContinue;
	private JButton btnDelete;
	private JTextArea txtDescription;
	private JPanel pnId;
	private JPanel pnConfirm;
	private JLabel lblPlease;
	private JLabel lblId;
	private JTextField txtID;
	private JButton btnConfirm;
	private JButton btnBack;
	private JPanel pnEnd;
	private JPanel pnMessage;
	private JLabel lblCongrats;
	private JLabel lblPick;
	private JButton btnFinish;
	private int debug;
	private int same=(int) (Math.random() * 7);
	private Integer d;
	private JMenuItem mntmAbout;
	private JMenuItem mntmContens;
	private JFileChooser selector=null;
	private JPanel pnDown;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JPanel pnTicket;
	private JLabel lblNewLabel_1;
	private JPanel pnValidate;
	private JTextField textField;
	private JTextField textField_1;
	private JPanel pnText;
	private JTextField textField_2;
	private JPanel panel_1;
	private JPanel panel_2;
	private JLabel lblNewLabel_2;
	/**
	 * Create the frame.
	 */
	public MainWindow(Game game,int debug) {
		setTitle("Back to the classics");
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainWindow.class.getResource("/img/7.png")));
		
		this.game=game;
		this.debug=debug;
		aB = new ButtonAction();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 832, 546);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPanelLogo(), BorderLayout.NORTH);
		contentPane.add(getPnMain(), BorderLayout.CENTER);
		loadHelp();
		
		this.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				associateImagesToButtons();
				//associateImagesToLabels();	
			
			}
		});
		
	}
	
	private void associateImagesToButtons() {
		for (int i = 0; i < pnButtons.getComponents().length; i++) {
			JButton boton = (JButton) (pnButtons.getComponents()[i]);
			adaptImage(boton, game.getMenuProducts().get(i).getImagePath());
		}
	}
	
	private void associateImagesToLabels()
	{
		
		for (int i = 0; i < game.getBoard().getDim(); i++) {
		    for (int j = 0; j < game.getBoard().getDim(); j++) {
		        JLabel label = (JLabel) pnBoard.getComponent(i * game.getBoard().getDim() + j);
		        adaptImage2(label, game.getBoard().getPicture(i, j));
		    }
		}

		
	}
	
	
	
	
	
	private boolean isEmpty() {
		return ( txtTicket.getText().equals("")); 
	}
	private boolean isEmpty2() {
		return ( txtID.getText().equals("")); 
	}
	
	private boolean isIncorrect() {
		Ticket t=game.getTicket(txtTicket.getText());
		if(t==null)
		{
			return true;
		}
		
		if( game.checkTicket(t)==true)
		{
			game.delete(t);
			return false;
		}
		return true;
	}
	
	
	
	
	 private boolean checkExit() {
	    	if( JOptionPane.showConfirmDialog(this, "Are you sure you want to exit the game")== JOptionPane.YES_OPTION)
	    	{
	    		return true;
	    	}
	    	return false;
	    }
	
	private JPanel getPanelLogo() {
		if (panelLogo == null) {
			panelLogo = new JPanel();
			panelLogo.add(getLblTitle());
		}
		return panelLogo;
	}
	private JLabel getLblTitle() {
		if (lblTitle == null) {
			lblTitle = new JLabel("Back to the clssics");
			lblTitle.setForeground(new Color(255, 128, 0));
			lblTitle.setFont(new Font("Tahoma", Font.BOLD, 27));
		}
		return lblTitle;
	}
	private JButton getBtnStart() {
		if (btnStart == null) {
			btnStart = new JButton("Start Game ");
			btnStart.setMnemonic('S');
			btnStart.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					
					if(check())
					{
						game.saveTicket();
						showPn2();
					}
					
				}
			});
			btnStart.setBackground(Color.GREEN);
		}
		return btnStart;
	}
	private JButton getBtnExit() {
		if (btnExit == null) {
			btnExit = new JButton("Exit");
			btnExit.setMnemonic('X');
			btnExit.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					checkExit();
				}
			});
			btnExit.setBackground(Color.RED);
		}
		return btnExit;
	}
	private JPanel getPnMain() {
		if (pnMain == null) {
			pnMain = new JPanel();
			pnMain.setLayout(new CardLayout(0, 0));
			pnMain.add(getPn1(), "pn1");
			pnMain.add(getPn2(), "pn2");
			pnMain.add(getPnGame(), "pnGame");
			pnMain.add(getPnWin(), "pnWin");
			pnMain.add(getPnLose(), "pnLose");
			pnMain.add(getPnPrize(), "pnPrize");
			pnMain.add(getPnId(), "pnId");
			pnMain.add(getPnEnd(), "pnEnd");
		}
		return pnMain;
	}
	private JPanel getPn1() {
		if (pn1 == null) {
			pn1 = new JPanel();
			pn1.setLayout(new BorderLayout(0, 0));
			pn1.add(getPnDown(), BorderLayout.SOUTH);
			pn1.add(getPnTicket(), BorderLayout.CENTER);
			//pn1.add(getLblTicket());
			//pn1.add(getTxtTicket());
			//pn1.add(getLblLink());
			//pn1.add(getBtnStart());
			//pn1.add(getBtnExit());
		}
		return pn1;
	}
	private JLabel getLblLink() {
		if (lblLink == null) {
			lblLink = new JLabel("");
			lblLink.setIcon(new ImageIcon(MainWindow.class.getResource("/img/400px-Link.png")));
		}
		return lblLink;
	}
	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnhelp());
		}
		return menuBar;
	}
	private JMenu getMnhelp() {
		if (mnhelp == null) {
			mnhelp = new JMenu("Help");
			mnhelp.add(getMntmAbout());
			mnhelp.add(getMntmContens());
		}
		return mnhelp;
	}
	
	
	public boolean check() {
		if (isEmpty()) {
			JOptionPane.showMessageDialog(null, "Error: The field cannot be empty");
			return false;
		}
		else
			if (isIncorrect()) {
				JOptionPane.showMessageDialog(null, "Error: The ticket is not valid.The purchase has to be grater than 20 euro and the store needs to be a valid one");
				return false;
			}
		return true;
	 }
	private JPanel getPn2() {
		if (pn2 == null) {
			pn2 = new JPanel();
			pn2.setLayout(new BorderLayout(0, 0));
			pn2.add(getPnButton(), BorderLayout.SOUTH);
			pn2.add(getScrollPane(), BorderLayout.CENTER);
		}
		return pn2;
	}
	private JPanel getPnButton() {
		if (pnButton == null) {
			pnButton = new JPanel();
			pnButton.setLayout(new GridLayout(1, 0, 0, 0));
			pnButton.add(getButton_1());
		}
		return pnButton;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getTxtArea());
		}
		return scrollPane;
	}
	private JButton getButton_1() {
		if (btnGame == null) {
			btnGame = new JButton("Start game ");
			btnGame.setMnemonic('S');
			btnGame.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					showGame();
					StartGame();
				}
			});
			btnGame.setBackground(new Color(0, 255, 0));
			btnGame.setForeground(new Color(0, 0, 0));
		}
		return btnGame;
	}
	private JTextArea getTxtArea() {
		if (txtArea == null) {
			txtArea = new JTextArea();
			txtArea.setText("Tutorial for the game:\n"+"The game takes place on a board with 7 rows and 7 columns. All the squares can be occupied\r\n"
					+ "by a character (or invader) except for the squares in the corners and center of the board, which\r\n"
					+ "will be considered non-accessible positions in the territory.\r\n"
					+ " In the game, eight different types of characters from classic video games will be considered, at\r\n"
					+ "the student's choice. One of them (the one chosen by the student) will be the leader of the\r\n"
					+ "invasion and, therefore, will have an important role in the game, as will be described later.\r\n"
					+ " At the start of a game, 5 randomly generated invaders will have already occupied part of the\r\n"
					+ "territory or game board, in randomly generated positions. The rest will start with their invasion\n"+"The player starts from an initial balance of 0 points. Current score must be always visible and\r\n"
							+ "updated in the interface. This balance will increase in each interaction by 50 points when making\r\n"
							+ "a group of 3 invaders disappear, by 200 if the group is of 4, 1000 if it is of 5, 5000 if it is of 6 and\r\n"
							+ "10000 if it is of 7. If more than one colony is destroyed in the same iteration, the corresponding\r\n"
							+ "points of each of them will be added\n"+"When a colony of 5 or more leader type characters. It is considered that if 5 or more of these\r\n"
									+ "individuals disappear at once, the invasion ends cause a large part of its leaders are eliminated. In\r\n"
									+ "this case, no more invaders will arrive (so we will not reach the 10th turn), the user is the winner and\r\n"
									+ "20000 points are added to their final score.\r\n"
									+ " The last turn (the 10th) is reached and the board has some free space. In this case, the user also\r\n"
									+ "wins since they avoided the total invasion of the territory and ends the game with the accumulated\r\n"
									+ "score.\r\n"
									+ "When all the squares on the board are occupied by an invader and there is no possibility,\r\n"
									+ "therefore, of continuing to place new invaders. In this case, the invader is considered the winner and\r\n"
									+ "the user ends with 0 points.");
		}
		return txtArea;
	}
	private void showPn2() {
		
		((CardLayout)getPnMain().getLayout()).show(pnMain,"pn2");
	}
	
	private void showGame() {
		
		((CardLayout)getPnMain().getLayout()).show(pnMain,"pnGame");
	}
private void showWin() {
		
		((CardLayout)getPnMain().getLayout()).show(pnMain,"pnWin");
	}
private void showLose() {
	
	((CardLayout)getPnMain().getLayout()).show(pnMain,"pnLose");
}
private void showPrize() {
	
	((CardLayout)getPnMain().getLayout()).show(pnMain,"pnPrize");
}
private void showId() {
	
	((CardLayout)getPnMain().getLayout()).show(pnMain,"pnId");
}
private void showEnd() {
	
	((CardLayout)getPnMain().getLayout()).show(pnMain,"pnEnd");
}
private void showFirst() {
	
	((CardLayout)getPnMain().getLayout()).show(pnMain,"pn1");
}
	
	
	private JPanel getPnGame() {
		if (pnGame == null) {
			pnGame = new JPanel();
			pnGame.setLayout(new BorderLayout(0, 0));
			pnGame.add(getPnCaracters(), BorderLayout.NORTH);
			pnGame.add(getPnBoard(), BorderLayout.CENTER);
			pnGame.add(getPnState(), BorderLayout.EAST);
		}
		return pnGame;
	}
	private JPanel getPnCaracters() {
		if (pnCaracters == null) {
			pnCaracters = new JPanel();
			pnCaracters.setBackground(new Color(0, 0, 0));
			pnCaracters.setLayout(new GridLayout(1, 0, 0, 0));
		}
		return pnCaracters;
	}
	
	
	public void fillCaracters() {
		for (int i=0;i<5;i++) {
			getPnCaracters().add(newDissaper(i));
		}
		
		validate();
	}
	
	private JPanel getPnBoard() {
		if (pnBoard == null) {
			pnBoard = new JPanel();
			pnBoard.setBorder(new LineBorder(new Color(0, 128, 192), 3));
			pnBoard.setBackground(new Color(0, 0, 0));
			pnBoard.setLayout(new GridLayout(0,7));
			fillBoard();
		}
		return pnBoard;
	}
	private JPanel getPnState() {
		if (pnState == null) {
			pnState = new JPanel();
			pnState.setBorder(new LineBorder(new Color(0, 128, 192), 4));
			pnState.setLayout(new BorderLayout(0, 0));
			pnState.add(getBtnConcede(), BorderLayout.SOUTH);
			pnState.add(getPnScore(), BorderLayout.NORTH);
			pnState.add(getPnDouble(), BorderLayout.CENTER);
		}
		return pnState;
	}
	
	
	private void fillBoard() {
		
		
		for (int i=0;i<game.getBoard().getDim(); i++)
		{
			for (int j=0;j<game.getBoard().getDim(); j++)
			{
				if((i==0&&j==0)||(i==0&&j==6)||(i==3&&j==3)||(i==6&&j==0)||(i==6&&j==6))
				{
					
					getPnBoard().add(labelfake(i,j) );
					
				}
				else
				{
					if(game.getBoard().getPicture(i, j).equals(""))
					{
						getPnBoard().add(newLabel(i,j) );
					}
					else
					{
						getPnBoard().add(labelInvader(i,j));
					}
					
				}
				
			}
		}
		
		
		
		
		validate();
	}
	
	
	private JLabel labelfake(int i,int j)
	{
		JLabel label = new JLabel("" + i+j);

		label.setIcon(new ImageIcon(MainWindow.class.getResource("/img/white.png")));
		
		return label;
	}
	
	private JLabel labelInvader(int i,int j)
	{
		JLabel label = new JLabel("" + i+j);
		label.setIcon(new ImageIcon(MainWindow.class.getResource(game.getBoard().getPicture(i,j))));
		return label;
	}
	
	private JLabel newLabel (int i,int j) {
		//Creamos y ponemos un texto (número) a cada etiqueta
		JLabel labelBoard = new JLabel("" + i+j);
		//Fondo y texto en negro para que no se vean los números
		labelBoard.setBackground(Color.BLACK);
		labelBoard.setForeground(Color.BLACK);
		labelBoard.setBorder(new LineBorder(new Color(100, 149, 237), 3));
		//PASO 5 DRAG AND DROP
		labelBoard.setTransferHandler(new TransferHandler("icon"));
		
		//PASO 7 DRAG AND DROP
		labelBoard.addPropertyChangeListener(pBT);
		
	
		return labelBoard;
	}
	
	class Drag extends MouseAdapter{
		@Override
		public void mousePressed(MouseEvent e)
		{
			//JComponent c=(JComponent)e.getSource();
			JLabel c=(JLabel)e.getSource();
			d=Integer.parseInt(c.getText());
			TransferHandler handler = c.getTransferHandler();
			handler.exportAsDrag(c, e, TransferHandler.COPY);
		}
	}
	
	
	private JLabel newDissaper(int i) {
		JLabel lbDissapear= new JLabel(""+i);
		lbDissapear.setBorder(new LineBorder(Color.GREEN, 1));
		int invaderPicture = (int) (Math.random() * 8);
		
		if(debug==1)
		{
			invaderPicture = 7;
		}
		
		
		if(debug==2)
		{
			lbDissapear.setIcon(new ImageIcon(MainWindow.class.getResource(caracters[same])));
			lbDissapear.addMouseListener(pD);
			
			//PASO 4 DRAG AND DROP
			lbDissapear.setTransferHandler(new TransferHandler("icon"));
		}
		else
		{
			String s= caracters[invaderPicture];
			
			lbDissapear.setIcon(new ImageIcon(MainWindow.class.getResource(caracters[invaderPicture])));
			//PASO 3 DRAG AND DROP
			lbDissapear.addMouseListener(pD);
			
			//PASO 4 DRAG AND DROP
			lbDissapear.setTransferHandler(new TransferHandler("icon"));
		}
		
		

		
		return lbDissapear;
	}
	
	private void dissapear(int i,int j) {
		game.shoot(i, j);
		representInvaders(i,j);
		
	}
	
	
	private void representInvaders(int i,int j) {
		
		unpaint();
		
		
		
	}
	

	
	private void unpaint() {
		
		int u=getPnCaracters().getComponentCount();
		if(u==0)
		{
			getPnCaracters().remove(0);
		}
		else
		{
			for (int j = 0; j < u ; j++) {

				JLabel c=(JLabel)getPnCaracters().getComponent(j);
				  
				  if(c.getText().equals(d.toString()))
				  {
					  getPnCaracters().remove(c);
					  break;
				  }
				 
			}
		}
		
		
		
		getPnCaracters().repaint();
		validate();
	}
	
	private void wave(int i,int j)
	{
		if(getPnCaracters().getComponents().length==0)
		{
			
			fillCaracters();
			game.updateWave();
			updateGame();
			txtWave.setText(game.getWave().toString());
		}
	}
	
	private void paintSquare(int i,int j) {
		int poz=(i*7)+j;
		Icon imagen = ((JLabel)pnBoard.getComponent(poz)).getIcon();
		String s=imagen.toString().substring(imagen.toString().length()-10);
		//ImageIcon icon = ImageFactory.loadImage(game.getBoard().getPicture(i,j));
		
		game.getBoard().setPicture(i, j, imagen.toString().substring(imagen.toString().length()-10));
		End1();
		
	}
	
	private void End1() {
		if (game.isGameOver()) {
			showLose();			

		}
	}
	private void End2() {
		if (game.win()) {
			showWin();
			

		}
	}
	private void End3() {
		
			showWin();
			

		
	}
	
	public void updateGame()
	{
		Integer delete=0;
		boolean s=game.getBoard().comboLeader(leader.substring(5,6));
		for (int i=0;i<game.getBoard().getDim(); i++)
		{
			for (int j=0;j<game.getBoard().getDim(); j++)
			{
				
				if(game.getBoard().getEliminate(i, j).equals("eliminate"))
				{
					int poz=(i*7)+j;
					((JLabel)pnBoard.getComponent(poz)).setIcon(null);
					((JLabel)pnBoard.getComponent(poz)).setTransferHandler(new TransferHandler("icon"));
					((JLabel)pnBoard.getComponent(poz)).revalidate();
					
					
					
					game.getBoard().setPicture(i, j, "");
					
					delete++;
				}
			}
		}
		
		game.updateScore(s,delete);
		txtScore.setText(game.getScore().toString());
		txtAvailable.setText(game.getScore().toString());
		if(s==true)
		{
			End3();
		}
		End2();
		End1();	
		validate();
		
	}
	
	
	public void check(int i,int j)
	{
		game.getBoard().checkInvader(i,j);
	}

	
	class ProcessLabel implements PropertyChangeListener{
		@Override
		public void propertyChange(PropertyChangeEvent e)
		{
			if(e.getPropertyName().equals("icon")&&(e.getNewValue()!=null))
			{
				JLabel lbPulsada=(JLabel)e.getSource();
				lbPulsada.setTransferHandler(null);
				
				int position1=Integer.parseInt(lbPulsada.getText())%10;
				int position2=Integer.parseInt(lbPulsada.getText())/10;
				
				dissapear(position2,position1);
				paintSquare(position2,position1);
				check(position2,position1);
				wave(position2,position1);
				
				
			}
		}
	}
	
	private void StartGame() {
		 fillCaracters();
		
	}
	private JButton getBtnConcede() {
		if (btnConcede == null) {
			btnConcede = new JButton("Concede");
			btnConcede.setMnemonic('C');
			btnConcede.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if(checkExit()==true)
					{
						finish();
						showFirst();
					}
					else
					{
						
					}
					
				}
			});
			btnConcede.setBackground(new Color(255, 0, 0));
		}
		return btnConcede;
	}
	private JPanel getPnScore() {
		if (pnScore == null) {
			pnScore = new JPanel();
			pnScore.setLayout(new GridLayout(1, 0, 0, 0));
			pnScore.add(getLblScore());
			pnScore.add(getTxtScore());
		}
		return pnScore;
	}
	private JPanel getPnDouble() {
		if (pnDouble == null) {
			pnDouble = new JPanel();
			pnDouble.setLayout(new BorderLayout(0, 0));
			pnDouble.add(getPnLeader(), BorderLayout.NORTH);
			pnDouble.add(getPanel_3(), BorderLayout.CENTER);
		}
		return pnDouble;
	}
	private JLabel getLblScore() {
		if (lblScore == null) {
			lblScore = new JLabel("Score");
		}
		return lblScore;
	}
	private JTextField getTxtScore() {
		if (txtScore == null) {
			txtScore = new JTextField();
			txtScore.setEditable(false);
			txtScore.setColumns(10);
			txtScore.setText(game.getScore().toString());
		}
		return txtScore;
	}
	private JPanel getPnLeader() {
		if (pnLeader == null) {
			pnLeader = new JPanel();
			pnLeader.add(getLblWave());
			pnLeader.add(getTxtWave());
		}
		return pnLeader;
	}
	private JPanel getPanel_3() {
		if (panel_3 == null) {
			panel_3 = new JPanel();
			panel_3.setLayout(null);
			panel_3.add(getLblLeader());
			panel_3.add(getLblLeaderIcon());
		}
		return panel_3;
	}
	private JLabel getLblWave() {
		if (lblWave == null) {
			lblWave = new JLabel("Wave");
		}
		return lblWave;
	}
	private JTextField getTxtWave() {
		if (txtWave == null) {
			txtWave = new JTextField();
			txtWave.setText("1");
			txtWave.setEditable(false);
			txtWave.setColumns(10);
		}
		return txtWave;
	}
	private JLabel getLblLeader() {
		if (lblLeader == null) {
			lblLeader = new JLabel("Leader Type:");
			lblLeader.setBounds(10, 55, 75, 34);
		}
		return lblLeader;
	}
	private JLabel getLblLeaderIcon() {
		if (lblLeaderIcon == null) {
			lblLeaderIcon = new JLabel("");
			lblLeaderIcon.setIcon(new ImageIcon(MainWindow.class.getResource(leader)));
			lblLeaderIcon.setBounds(10, 99, 88, 90);
		}
		return lblLeaderIcon;
	}
	private JPanel getPnWin() {
		if (pnWin == null) {
			pnWin = new JPanel();
			pnWin.setLayout(new BorderLayout(0, 0));
			pnWin.add(getPnlbl(), BorderLayout.CENTER);
			pnWin.add(getBtnPrize(), BorderLayout.SOUTH);
		}
		return pnWin;
	}
	private JPanel getPnLose() {
		if (pnLose == null) {
			pnLose = new JPanel();
			pnLose.setLayout(new BorderLayout(0, 0));
			pnLose.add(getPanelLose(), BorderLayout.CENTER);
			pnLose.add(getBtnLeave(), BorderLayout.SOUTH);
		}
		return pnLose;
	}
	private JPanel getPnlbl() {
		if (pnlbl == null) {
			pnlbl = new JPanel();
			pnlbl.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			pnlbl.add(getLblWIn());
		}
		return pnlbl;
	}
	private JLabel getLblWIn() {
		if (lblWIn == null) {
			lblWIn = new JLabel("YOU Win!!");
			lblWIn.setFont(new Font("Tahoma", Font.PLAIN, 37));
		}
		return lblWIn;
	}
	private JButton getBtnPrize() {
		if (btnPrize == null) {
			btnPrize = new JButton("Choose prize");
			btnPrize.setMnemonic('C');
			btnPrize.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					showPrize();
				}
			});
			btnPrize.setBackground(new Color(0, 255, 0));
		}
		return btnPrize;
	}
	private JPanel getPanelLose() {
		if (panelLose == null) {
			panelLose = new JPanel();
			panelLose.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			panelLose.add(getLblLose());
			panelLose.add(getLblNewLabel());
		}
		return panelLose;
	}
	private JLabel getLblLose() {
		if (lblLose == null) {
			lblLose = new JLabel("Game Over !!");
			lblLose.setFont(new Font("Tahoma", Font.PLAIN, 30));
		}
		return lblLose;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("You Lost!!");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		}
		return lblNewLabel;
	}
	private JButton getBtnLeave() {
		if (btnLeave == null) {
			btnLeave = new JButton("Exit");
			btnLeave.setMnemonic('E');
			btnLeave.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					finish();
					showFirst();
				}
			});
			btnLeave.setBackground(new Color(255, 0, 0));
		}
		return btnLeave;
	}
	private JPanel getPnPrize() {
		if (pnPrize == null) {
			pnPrize = new JPanel();
			pnPrize.setLayout(new BorderLayout(0, 0));
			pnPrize.add(getScrArticulos(), BorderLayout.WEST);
			pnPrize.add(getPnCombo(), BorderLayout.NORTH);
			pnPrize.add(getPanel(), BorderLayout.CENTER);
			pnPrize.add(getScrOrder(), BorderLayout.EAST);
			pnPrize.add(getPnCommand(), BorderLayout.SOUTH);
			
			
		}
		return pnPrize;
	}
	private JScrollPane getScrArticulos() {
		if (scrArticulos == null) {
			scrArticulos = new JScrollPane();
			scrArticulos.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrArticulos.setViewportView(getPnFlow());
		}
		return scrArticulos;
	}
	private JPanel getPnButtons() {
		if (pnButtons == null) {
			pnButtons = new JPanel();
			pnButtons.setLayout(new GridLayout(0, 1, 0, 0));
			
			createProductButtons();
		}
		return pnButtons;
	}
	
	
	private void adaptImage(JButton button, String imagePath) {
		ImageIcon tmpImagen = new ImageIcon(getClass().getResource(imagePath));
		float delta = ((button.getWidth() * 100) / tmpImagen.getIconWidth()) / 100f;
		if (tmpImagen.getIconHeight() > button.getHeight())
			delta = ((button.getHeight() * 100) / tmpImagen.getIconHeight()) / 100f;
		int ancho = (int) (tmpImagen.getIconWidth() * delta);
		int alto = (int) (tmpImagen.getIconHeight() * delta);
		button.setIcon(new ImageIcon(tmpImagen.getImage().getScaledInstance(
				ancho, alto, Image.SCALE_SMOOTH)));
	}
	
	private void adaptImage2(JLabel label, String imagePath) {
		ImageIcon tmpImagen = new ImageIcon(getClass().getResource(imagePath));
		float delta = ((label.getWidth() * 100) / tmpImagen.getIconWidth()) / 100f;
		if (tmpImagen.getIconHeight() > label.getHeight())
			delta = ((label.getHeight() * 100) / tmpImagen.getIconHeight()) / 100f;
		int ancho = (int) (tmpImagen.getIconWidth() * delta);
		int alto = (int) (tmpImagen.getIconHeight() * delta);
		label.setIcon(new ImageIcon(tmpImagen.getImage().getScaledInstance(
				ancho, alto, Image.SCALE_SMOOTH)));
	}

	
	
	private void createProductButtons()
	{
		pnButtons.removeAll();
		
		for(Product p: game.getMenuProducts())
		{
			pnButtons.add(newButton(game.getMenuProducts().indexOf(p),p ));
			
		}
	
	}
	
	
	
	
	private void addToOrder(int position) {
		Product a = game.getMenuProducts().get(position);
		//game.addToOrder(a, 1);
		Float s=game.getScore()-game.getOrderTotal();
		if(s>0)
		{
			getTxtAvailable().setText(s.toString());
		}
		
		getTxtName().setText(a.getName());
		getTxtType().setText(a.getType());
		getTxtDescription().setText(a.getDescription());
		getTxtPoints().setText(String.format("%.2f", a.getPrice()));
		
		
		getBtnAdd().setEnabled(true);

	}
	
	
	private void showInList(Product a) {
		
		Float s=game.getScore()-game.getOrderTotal();
		if(s>0)
		{
			awardModel.removeElement(a);
			awardModel.addElement(a);
		}
		

	}
	
	
	
	class ButtonAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton bt = (JButton) e.getSource();
			addToOrder(Integer.parseInt(bt.getActionCommand()));
		}
	}
	
	
	private JButton newButton(Integer position, Product p) {
		JButton button = new JButton("");
		button.setBackground(Color.white);
		button.setBorder(new LineBorder(Color.LIGHT_GRAY, 2, true));
		button.setToolTipText(p.toString());
		button.setPreferredSize(new Dimension(100, 100));
		button.setActionCommand(position.toString());
		button.addActionListener(aB);
		return button;
	}
	
	
	private JPanel getPnCombo() {
		if (pnCombo == null) {
			pnCombo = new JPanel();
			pnCombo.setLayout(new GridLayout(1, 0, 0, 0));
			pnCombo.add(getComboFilter());
			pnCombo.add(getLblSpace());
		}
		return pnCombo;
	}
	private JComboBox<String> getComboFilter() {
		if (comboFilter == null) {
			comboFilter = new JComboBox();
			comboFilter.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					
					String selectedItem = (String) comboFilter.getSelectedItem();
					filter(selectedItem);
				}
			});
			
		    comboFilter.setModel(new DefaultComboBoxModel<String>(game.getFilter()));
		    

		}
		return comboFilter;
	}
	
	
	public void filter(String f)
	{
		
		for(Component c : pnButtons.getComponents())
		{
			c.setEnabled(true);
		}
		
		for(Component c : pnButtons.getComponents())
		{
			if(check(Integer.parseInt(((JButton) c).getActionCommand()),f)==false)
			{
				c.setEnabled(false);
			}
			
		}
	}
	public boolean check(int position, String c)
	{
		Product a = game.getMenuProducts().get(position);
		Float s=game.getScore()-game.getOrderTotal();
		if(c.equals("Available Products"))
		{
			if(a.getPrice()<s)
			{
				return true;
			}
			
		}
		else if(c.equals("Filter by"))
		{
			return true;
		}
		else if(a.getType().equals(c)) {
			
			return true;
		}
		
		return false;
	}
	
	
	
	private JLabel getLblSpace() {
		if (lblSpace == null) {
			lblSpace = new JLabel("");
		}
		return lblSpace;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(null);
			panel.add(getTxtType());
			panel.add(getLblType());
			panel.add(getTxtName());
			panel.add(getTxtPoints());
			panel.add(getSpUnits());
			panel.add(getLblName());
			panel.add(getLblDescription());
			panel.add(getLblPoints());
			panel.add(getLblQuantity());
			panel.add(getLblAvailable());
			panel.add(getTxtAvailable());
			panel.add(getTxtDescription());
			
			
			
		}
		return panel;
	}
	private JTextField getTxtType() {
		if (txtType == null) {
			txtType = new JTextField();
			txtType.setEditable(false);
			txtType.setBounds(100, 27, 328, 28);
			txtType.setColumns(10);
		}
		return txtType;
	}
	private JScrollPane getScrOrder() {
		if (scrOrder == null) {
			scrOrder = new JScrollPane();
			scrOrder.setViewportView(getAwardList());
		}
		return scrOrder;
	}
	private JLabel getLblType() {
		if (lblType == null) {
			lblType = new JLabel("Type:");
			lblType.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblType.setBounds(31, 30, 83, 16);
		}
		return lblType;
	}
	private JTextField getTxtName() {
		if (txtName == null) {
			txtName = new JTextField();
			txtName.setEditable(false);
			txtName.setBounds(100, 79, 328, 28);
			txtName.setColumns(10);
		}
		return txtName;
	}
	private JTextField getTxtPoints() {
		if (txtPoints == null) {
			txtPoints = new JTextField();
			txtPoints.setEditable(false);
			txtPoints.setBounds(100, 242, 328, 28);
			txtPoints.setColumns(10);
		}
		return txtPoints;
	}
	private JSpinner getSpUnits() {
		if (spUnits == null) {
			spUnits = new JSpinner();
			spUnits.setToolTipText("Units per product");
			spUnits.setModel(new SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
			spUnits.setBounds(120, 282, 53, 20);
		}
		return spUnits;
	}
	private JLabel getLblName() {
		if (lblName == null) {
			lblName = new JLabel("Name:");
			lblName.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblName.setBounds(31, 84, 74, 13);
		}
		return lblName;
	}
	private JLabel getLblDescription() {
		if (lblDescription == null) {
			lblDescription = new JLabel("Description:");
			lblDescription.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblDescription.setBounds(10, 148, 85, 13);
		}
		return lblDescription;
	}
	private JLabel getLblPoints() {
		if (lblPoints == null) {
			lblPoints = new JLabel("Points:");
			lblPoints.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblPoints.setBounds(32, 244, 73, 13);
		}
		return lblPoints;
	}
	private JLabel getLblQuantity() {
		if (lblQuantity == null) {
			lblQuantity = new JLabel("Quantity:");
			lblQuantity.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblQuantity.setBounds(31, 283, 74, 13);
		}
		return lblQuantity;
	}
	private JLabel getLblAvailable() {
		if (lblAvailable == null) {
			lblAvailable = new JLabel("Points Available:");
			lblAvailable.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblAvailable.setBounds(31, 306, 124, 47);
		}
		return lblAvailable;
	}
	private JTextField getTxtAvailable() {
		if (txtAvailable == null) {
			txtAvailable = new JTextField();
			txtAvailable.setEditable(false);
			txtAvailable.setBounds(31, 342, 185, 40);
			txtAvailable.setColumns(10);
		
		}
		return txtAvailable;
	}
	private JPanel getPnCommand() {
		if (pnCommand == null) {
			pnCommand = new JPanel();
			pnCommand.setLayout(new GridLayout(0, 3, 0, 0));
			pnCommand.add(getBtnContinue());
			
			pnCommand.add(getBtnAdd());
			pnCommand.add(getBtnDelete());
			
		}
		return pnCommand;
	}
	private JButton getBtnAdd() {
		if (btnAdd == null) {
			btnAdd = new JButton("Add");
			btnAdd.setEnabled(false);
			btnAdd.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					Product p = game.getProduct(getTxtName().getText());
					 Integer units = (Integer) spUnits.getValue();
					addOrder(p,units);			
					
					 Available();
						 
					
					 
				}
			});
		}
		return btnAdd;
	}
	
	private void addOrder(Product p,Integer units)
	{
		Float s=game.getScore()-(p.getPrice()*units);
		
		if(s<0)
		{
			JOptionPane.showMessageDialog(null, "Error: you don t have enough points");
		}
		else
		{
			game.addToOrder(p, units);
			 showInList(p);
			 getBtnContinue().setEnabled(true);
		}
		
	
	}
	
	private JPanel getPnFlow() {
		if (pnFlow == null) {
			pnFlow = new JPanel();
			pnFlow.add(getPnButtons());
		}
		return pnFlow;
	}
	private JList getAwardList() {
		if (AwardList == null) {
			AwardList = new JList();
			awardModel= new DefaultListModel<Product>();
			AwardList.setModel(awardModel);
		}
		return AwardList;
	}
	private JButton getBtnContinue() {
		if (btnContinue == null) {
			btnContinue = new JButton("Continue");
			btnContinue.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					showId();
				}
			});
			btnContinue.setEnabled(false);
			btnContinue.setBackground(new Color(0, 255, 0));
		}
		return btnContinue;
	}
	private JButton getBtnDelete() {
		if (btnDelete == null) {
			btnDelete = new JButton("Delete");
			btnDelete.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					Product a = (Product) AwardList.getSelectedValue();
					if(a!=null)
					{
						Integer units = a.getUnits();
						 
						 game.deleteOrder(a, units);
						 deleteInList(a);
						 Available();
						
					}
					 
					
					
				}
			});
			btnDelete.setBackground(new Color(255, 0, 0));
		}
		return btnDelete;
	}
	
	private void Available()
	{
		Float s=game.getScore()-game.getOrderTotal();
		
		if(s<0)
		{
			JOptionPane.showMessageDialog(null, "Error: you don t have enough points");

		}
		else
		{
			getTxtAvailable().setText(s.toString());
		}
		
	
	}
	
	private void deleteInList(Product a)
	{
		
		awardModel.removeElement(a);
		
		
	}
	private JTextArea getTxtDescription() {
		if (txtDescription == null) {
			txtDescription = new JTextArea();
			txtDescription.setBounds(100, 144, 328, 63);
		}
		return txtDescription;
	}
	private JPanel getPnId() {
		if (pnId == null) {
			pnId = new JPanel();
			pnId.setLayout(new BorderLayout(0, 0));
			pnId.add(getPnConfirm(), BorderLayout.CENTER);
		}
		return pnId;
	}
	private JPanel getPnConfirm() {
		if (pnConfirm == null) {
			pnConfirm = new JPanel();
			pnConfirm.setLayout(new BorderLayout(0, 0));
			pnConfirm.add(getLblPlease(), BorderLayout.SOUTH);
			pnConfirm.add(getLblId(), BorderLayout.NORTH);
		
			
			pnConfirm.add(getPanel_1(), BorderLayout.SOUTH);
			pnConfirm.add(getPanel_2(), BorderLayout.CENTER);
		}
		return pnConfirm;
	}
	private JLabel getLblPlease() {
		if (lblPlease == null) {
			lblPlease = new JLabel("Please enter ID:");
			lblPlease.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		}
		return lblPlease;
	}
	private JLabel getLblId() {
		if (lblId == null) {
			lblId = new JLabel("ID:");
			lblId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		}
		return lblId;
	}
	private JTextField getTxtID() {
		if (txtID == null) {
			txtID = new JTextField();
			txtID.setColumns(10);
		}
		return txtID;
	}
	private JButton getButton_1_1() {
		if (btnConfirm == null) {
			btnConfirm = new JButton("Confirm");
			btnConfirm.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (isEmpty2()) {
						JOptionPane.showMessageDialog(null, "Error: the field cannot be empty");
					}
					else
					{
						game.setId(getTxtID().getText());
						showEnd();
					}
					
				}
			});
			btnConfirm.setBackground(new Color(0, 255, 0));
		}
		return btnConfirm;
	}
	private JButton getButton_1_2() {
		if (btnBack == null) {
			btnBack = new JButton("Back");
			btnBack.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					showPrize();
				}
			});
			btnBack.setBackground(new Color(255, 0, 0));
		}
		return btnBack;
	}
	private JPanel getPnEnd() {
		if (pnEnd == null) {
			pnEnd = new JPanel();
			pnEnd.setLayout(new BorderLayout(0, 0));
			pnEnd.add(getPnMessage(), BorderLayout.CENTER);
		}
		return pnEnd;
	}
	private JPanel getPnMessage() {
		if (pnMessage == null) {
			pnMessage = new JPanel();
			pnMessage.setLayout(new BorderLayout(0, 0));
			pnMessage.add(getLblCongrats(), BorderLayout.NORTH);
			pnMessage.add(getLblPick());
			pnMessage.add(getButton_1_3(), BorderLayout.SOUTH);
		}
		return pnMessage;
	}
	private JLabel getLblCongrats() {
		if (lblCongrats == null) {
			lblCongrats = new JLabel("Congratulations!!");
			lblCongrats.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		}
		return lblCongrats;
	}
	private JLabel getLblPick() {
		if (lblPick == null) {
			lblPick = new JLabel("You can pick up your prizez at your shop");
			lblPick.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return lblPick;
	}
	private JButton getButton_1_3() {
		if (btnFinish == null) {
			btnFinish = new JButton("Finish");
			btnFinish.setMnemonic('F');
			btnFinish.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					finish();
					showFirst();
				}
			});
			btnFinish.setFont(new Font("Tahoma", Font.PLAIN, 16));
			btnFinish.setBackground(new Color(0, 255, 0));
		}
		return btnFinish;
	}
	
	
	protected void initialize() {
		game.initOrder();
		awardModel.clear();
		pnCaracters.removeAll();
		pnBoard.removeAll();
		game.initialize();
		fillBoard();
		getTxtScore().setText("");
		getTxtTicket().setText("");
		getTxtWave().setText("1");
		btnContinue.setEnabled(false);
		btnAdd.setEnabled(false);
		showFirst();
	}

	
	private void finish() {
		game.saveOrder();
		initialize();
	}
	private JMenuItem getMntmAbout() {
		if (mntmAbout == null) {
			mntmAbout = new JMenuItem("About");
			mntmAbout.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null, "Sebastian Radu-UO297799-5020822260039-PL-I-2");

					
				}
			});
		}
		return mntmAbout;
	}
	private JMenuItem getMntmContens() {
		if (mntmContens == null) {
			mntmContens = new JMenuItem("Contents");
		}
		return mntmContens;
	}
	private void loadHelp(){

		   URL hsURL;
		   HelpSet hs;

		    try {
			    	File fichero = new File("help/Help.hs");
			    	hsURL = fichero.toURI().toURL();
			        hs = new HelpSet(null, hsURL);
			      }

		    catch (Exception e){
		      System.out.println("Help not found!");
		      return;
		   }

		   HelpBroker hb = hs.createHelpBroker();

		   
		   hb.enableHelpOnButton(this.getMntmContens(), "intro", hs);
		   
		 }
	private JFileChooser getSelector()
	{
		if(selector==null)
		{
			selector= new JFileChooser();
			selector.setMultiSelectionEnabled(true);
		}
		return selector;
		
	}
	private JPanel getPnDown() {
		if (pnDown == null) {
			pnDown = new JPanel();
			pnDown.setLayout(new BorderLayout(0, 0));
			pnDown.add(getBtnExit(), BorderLayout.EAST);
			pnDown.add(getBtnStart(), BorderLayout.WEST);
		}
		return pnDown;
	}
	private JButton getButton_1_4() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("New button");
		}
		return btnNewButton;
	}
	private JButton getButton_1_5() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("New button");
			btnNewButton_1.setMaximumSize(new Dimension(100, 21));
		}
		return btnNewButton_1;
	}
	private JPanel getPnTicket() {
		if (pnTicket == null) {
			pnTicket = new JPanel();
			pnTicket.setLayout(new BorderLayout(0, 0));
			pnTicket.add(getLblLink(), BorderLayout.EAST);
			pnTicket.add(getPnValidate(), BorderLayout.CENTER);
		}
		return pnTicket;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("New label");
		}
		return lblNewLabel_1;
	}
	private JPanel getPnValidate() {
		if (pnValidate == null) {
			pnValidate = new JPanel();
			pnValidate.setLayout(new BorderLayout(0, 0));
			
		
			
			
			
			pnValidate.add(getLblTicket(), BorderLayout.NORTH);
			pnValidate.add(getPnText(), BorderLayout.CENTER);
		}
		return pnValidate;
	}
	
	
	private JLabel getLblTicket() { 
		if (lblTicket == null) {
		lblTicket = new
			  JLabel("Enter ticket number:");
			  lblTicket.setFont(new Font("Tahoma", Font.PLAIN, 17)); 
			  } 
	return lblTicket; }
	
	
	 
			 
	
	
	private JPanel getPnText() {
		if (pnText == null) {
			pnText = new JPanel();
			pnText.setLayout(new BorderLayout(0, 0));
			pnText.add(getTxtTicket(), BorderLayout.NORTH);
		}
		return pnText;
	}
	private JTextField  getTxtTicket() {
		if (txtTicket == null) {
			txtTicket = new JTextField();
			txtTicket.setColumns(10);
		}
		return txtTicket;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setLayout(new BorderLayout(0, 0));
			panel_1.add(getButton_1_1(), BorderLayout.EAST);
			panel_1.add(getButton_1_2(), BorderLayout.WEST);
		}
		return panel_1;
	}
	private JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.setLayout(new BorderLayout(0, 0));
			panel_2.add(getTxtID(), BorderLayout.NORTH);
			panel_2.add(getLblNewLabel_2(), BorderLayout.CENTER);
		}
		return panel_2;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("Please enter your ID.");
			lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		}
		return lblNewLabel_2;
	}
}

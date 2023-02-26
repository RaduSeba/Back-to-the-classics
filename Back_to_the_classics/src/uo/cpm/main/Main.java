package uo.cpm.main;

import java.awt.EventQueue;

import javax.swing.UIManager;

import uo.cpm.service.Game;
import uo.cpm.ui.MainWindow;

public class Main {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		final Game game = new Game ();
		int debug=0;
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
					MainWindow frame = new MainWindow(game,debug);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


}

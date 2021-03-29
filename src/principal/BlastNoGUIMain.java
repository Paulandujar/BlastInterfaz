package principal;


import javax.swing.JFrame;

import principal.BlastInterfaz.BlastListener;


public class BlastNoGUIMain {
	
	
	protected static void createAndShowGUI() {

		JFrame frame = new JFrame("Blast Query");
		BlastInterfaz contentPane = new BlastInterfaz();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(contentPane);
		frame.pack();
		frame.setVisible(true);
		
		
	}
	
	public static void main(String args[]){
		
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
}

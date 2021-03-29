package principal;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class BlastInterfaz extends JPanel {
	private JRadioButton proteinButton, nucleotideButton;
	private JComboBox<String> comboOfSequencies;
	private TextField texto;
	private JButton queryButton;
	private JTextArea textarea;
	
	
	
	public TextField getTexto() {
		return texto;
	}

	public void setTexto(TextField texto) {
		this.texto = texto;
	}

	public JRadioButton getProteinButton() {
		return proteinButton;
	}

	public JRadioButton getNucleotideButton() {
		return nucleotideButton;
	}

	public JComboBox<String> getComboOfSequencies() {
		return comboOfSequencies;
	}

	public void setTextarea(String text) {
		textarea.append(text);
	}
	
	public void clearTextarea() {
		textarea.setText("");
	}

	public JTextArea getTextarea() {
		return textarea;
	}

	public BlastInterfaz() {
		BlastListener bl = new BlastListener();
		JPanel contentPane = new JPanel(new BorderLayout());
		// radiobuttons
		JPanel subpanel1 = new JPanel(new BorderLayout());
		JPanel subpanel11 = new JPanel(new BorderLayout());
		JLabel label = new JLabel("Query type: ");
		subpanel11.add(label, BorderLayout.NORTH);
		proteinButton = new JRadioButton("Protein", true);
		nucleotideButton = new JRadioButton("Nucleotide", false);
		ButtonGroup group = new ButtonGroup();
		group.add(proteinButton);
		group.add(nucleotideButton);
		JPanel panelBotones = new JPanel(new GridLayout(1, 0));
		panelBotones.add(nucleotideButton);
		panelBotones.add(proteinButton);
		subpanel11.add(panelBotones, BorderLayout.CENTER);
		subpanel1.add(subpanel11, BorderLayout.NORTH);

		// combobox
		JPanel subpanel12 = new JPanel(new BorderLayout());
		JLabel label1 = new JLabel("Query sequence: ");
		subpanel12.add(label1, BorderLayout.NORTH);
		comboOfSequencies = new JComboBox<String>();
		comboOfSequencies.setEditable(true);
		comboOfSequencies.addActionListener(bl);
		comboOfSequencies.setActionCommand("comboBoxEdited");
		subpanel12.add(comboOfSequencies, BorderLayout.CENTER);
		subpanel1.add(subpanel12, BorderLayout.CENTER);
		contentPane.add(subpanel1, BorderLayout.NORTH);

		// textfield
		JPanel subpanel2 = new JPanel(new BorderLayout());
		JLabel label2 = new JLabel("Query percentage: ");
		subpanel2.add(label2, BorderLayout.NORTH);
		texto = new TextField();
		subpanel2.add(texto, BorderLayout.CENTER);

		// pressToMakeQueryButton
		queryButton = new JButton("Press this button to make the query");
		subpanel2.add(queryButton, BorderLayout.SOUTH);
		contentPane.add(subpanel2, BorderLayout.CENTER);

		// textArea
		JPanel subpanel3 = new JPanel(new BorderLayout());
		JLabel label3 = new JLabel("Result: ");
		subpanel3.add(label3, BorderLayout.NORTH);
		textarea = new JTextArea(10, 30);
		textarea.setVisible(false);
		textarea.setEditable(false);
		JScrollPane scrollpane = new JScrollPane(textarea);
		subpanel3.add(scrollpane, BorderLayout.CENTER);
		contentPane.add(subpanel3, BorderLayout.SOUTH);
		add(contentPane);

		// listener
		queryButton.addActionListener(bl);
		
		
	}
	
	public class BlastListener implements ActionListener{
			BlastGUIMain main = new BlastGUIMain();
		public void actionPerformed(ActionEvent e) {			
			main.event(e, BlastInterfaz.this );
		}
		
		
	}
}

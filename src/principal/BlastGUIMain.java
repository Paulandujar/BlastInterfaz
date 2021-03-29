package principal;

import java.awt.event.ActionEvent;
import blast.BlastController;

public class BlastGUIMain {
	private static final String dataBaseFile = new String("yeast.aa");
	private static final String dataBaseIndexes = new String("yeast.aa.indexs");

	public void event(ActionEvent e, BlastInterfaz contentPane) {
		BlastController bCnt = new BlastController();
		contentPane.getTextarea().setVisible(true);
		contentPane.clearTextarea();
		contentPane.setTexto(contentPane.getTexto());

		if (e.getActionCommand() == "comboBoxEdited") {
			boolean encontrado = false;

			for (int i = 0; i < contentPane.getComboOfSequencies().getItemCount(); i++) {
				if (contentPane.getComboOfSequencies().getSelectedItem() == contentPane.getComboOfSequencies()
						.getItemAt(i)) {
					encontrado = true;
				}
			}
			if (encontrado == false) {
				contentPane.getComboOfSequencies()
						.addItem(contentPane.getComboOfSequencies().getSelectedItem().toString());
			}
		} else {
			try {
				if (contentPane.getProteinButton().isSelected() == true) {
					String result = bCnt.blastQuery('p', dataBaseFile, dataBaseIndexes,
							Float.valueOf(contentPane.getTexto().getText()),
							contentPane.getComboOfSequencies().getSelectedItem().toString());
					contentPane.setTextarea(result);
				} else {
					String result = "Opción no implementada";
					contentPane.setTextarea(result);
				}
			} catch (Exception exc) {
				System.out.println("Error en la llamada: " + exc.toString());
			}
		}

	}
}

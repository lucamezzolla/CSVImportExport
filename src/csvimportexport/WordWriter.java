package csvimportexport;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import javax.swing.JTable;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;

public class WordWriter {

	public static final int MSWORD_TABLE_MAX_COLUMNS = 63;

	private static final Log log = LogFactory.getLog(WordWriter.class);

	public void writeTableToWord(final JTable uiTable, final String outputFileName) {
		if (uiTable != null && uiTable.getModel() != null && uiTable.getModel().getRowCount() != 0 && uiTable.getModel().getColumnCount() != 0) {

			if (uiTable.getModel().getColumnCount() > MSWORD_TABLE_MAX_COLUMNS) {
				log.warn("Numero colonne > 63, export limitato alle prime 63 colonne!");
			}

			// Creazione file docx
			final XWPFDocument doc = new XWPFDocument();
			final XWPFTable table = doc.createTable(uiTable.getModel().getRowCount(), Math.min(uiTable.getModel().getColumnCount(), 63));

			for (int i = 0; i < uiTable.getModel().getRowCount(); i++) {
				for (int j = 0; j < Math.min(uiTable.getModel().getColumnCount(), MSWORD_TABLE_MAX_COLUMNS); j++) {
                                        if(uiTable.getModel().getValueAt(i, j) != null)
                                                table.getRow(i).getCell(j).setText(uiTable.getModel().getValueAt(i, j).toString());
                                        else
                                                table.getRow(i).getCell(j).setText("");
				}   
			}

			// Salvataggio file docx
			BufferedOutputStream out = null;
			try {
				out = new BufferedOutputStream(new FileOutputStream(outputFileName));
				doc.write(out);
			}
			catch (final Exception e) {
				e.printStackTrace();
			}
			finally {
				try {
					out.close();
				}
				catch (final Exception e) {}
				try {
					doc.close();
				}
				catch (final Exception e) {}
			}
		}
	}

}

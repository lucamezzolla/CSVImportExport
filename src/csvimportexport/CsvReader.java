package csvimportexport;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Luca Mezzolla
 */
public class CsvReader {

	public void loadCsvInTable(String csvFileName, String fieldSeparator, JTable table) {
		BufferedReader br = null;
		String line = "";
		try {
			br = new BufferedReader(new FileReader(csvFileName));
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			int rows = 0;
			while ((line = br.readLine()) != null) {
				String[] lineAr = line.split(fieldSeparator);
				if (rows == 0) {
					for (int i = 0; i < lineAr.length; i++) {
						String field = lineAr[i];
						if (field.startsWith("\""))
							field = field.substring(1);
						if (field.endsWith("\""))
							field = field.substring(0, field.length() - 1);
						model.addColumn(field);
					}
				}
				else {
					Vector<String> fields = new Vector<String>();
					for (int i = 0; i < lineAr.length; i++) {
						String field = lineAr[i];
						if (field.startsWith("\""))
							field = field.substring(1);
						if (field.endsWith("\""))
							field = field.substring(0, field.length() - 1);
						fields.add(field);
					}
					model.addRow(fields);
				}
				rows++;
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			if (br != null) {
				try {
					br.close();
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	// public static boolean isElementExists(String[] data, int index){
	// try {
	// String value = data[index];
	// return true;
	// } catch(ArrayIndexOutOfBoundsException e){
	// return false;
	// }
	// }

}
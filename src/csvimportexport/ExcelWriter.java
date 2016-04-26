package csvimportexport;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JTable;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import  org.apache.poi.xssf.usermodel.XSSFSheet;
import  org.apache.poi.xssf.usermodel.XSSFWorkbook;
import  org.apache.poi.xssf.usermodel.XSSFRow;

/**
 * 
 * @author Luca Mezzolla
 */
public class ExcelWriter {
    
    private static final int MSEXCEL_TABLE_MAX_COLUMNS = 63;
    private static final Log log = LogFactory.getLog(WordWriter.class);

	public void writeTableToExcel(final JTable uiTable, final String outputFileName) throws FileNotFoundException, IOException {
            
            if (uiTable != null && uiTable.getModel() != null && uiTable.getModel().getRowCount() != 0 && uiTable.getModel().getColumnCount() != 0) {
                    
                XSSFWorkbook workbook = new XSSFWorkbook();
                XSSFSheet sheet = workbook.createSheet("FirstSheet");  
                
                for (int i = 0; i < uiTable.getModel().getRowCount(); i++) {
                    XSSFRow row = sheet.createRow(i);
                    for (int j = 0; j < Math.min(uiTable.getModel().getColumnCount(), MSEXCEL_TABLE_MAX_COLUMNS); j++) {
                        if(uiTable.getModel().getValueAt(i, j) != null)
                            row.createCell(j).setCellValue(uiTable.getModel().getValueAt(i, j).toString());
                        else
                            row.createCell(j).setCellValue("");
                    }   
                }
                
                FileOutputStream fileOut = new FileOutputStream(outputFileName);
                workbook.write(fileOut);
                fileOut.close();
                
            }
            
        }

}
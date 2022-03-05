/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laaba2;
import laaba2.Calculator;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException; 
import javax.swing.JOptionPane;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/**
 *
 * @author Мария
 */
public class Excel {
    private double[] x;
    private double[] y;
    private double[] z;
    
    
    public  Excel(){
        
    }
    
    public void Read(String str){ 
    try{
    XSSFWorkbook book = new XSSFWorkbook(str);
    XSSFSheet sh = book.getSheetAt(0);
    
    double[] arrx = new double[sh.getLastRowNum()];
    double[] arry = new double[sh.getLastRowNum()];
    double[] arrz = new double[sh.getLastRowNum()];
    
    this.x = arrx;
    this.y = arry;
    this.z = arrz;
    
    for (int i=1; i<=sh.getLastRowNum();i++) {
        arrx[i-1]=sh.getRow(i).getCell(0).getNumericCellValue();
    }
    for (int i=1; i<=sh.getLastRowNum();i++) {
        arry[i-1]=sh.getRow(i).getCell(1).getNumericCellValue();
    }
    for (int i=1; i<=sh.getLastRowNum();i++) {
        arrz[i-1]=sh.getRow(i).getCell(2).getNumericCellValue();
    }
    
    
    book.close();
    }
    catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Файл не найден","Ошибка",JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public double[] getReadx() {
        return this.x;
    }
    public double[] getReady() {
        return this.y;
    }
    public double[] getReadz() {
        return this.z;
    }
   
    public void Write(String str, Calculator c){ 
        try{
            
        XSSFWorkbook book2 = new XSSFWorkbook();
        XSSFSheet sh2 = book2.createSheet("Румнцева");
        XSSFRow r = sh2.createRow(0);
        r.createCell(0).setCellValue("");
        r.createCell(1).setCellValue("X");
        r.createCell(2).setCellValue("Y");
        r.createCell(3).setCellValue("Z");
        
        int i=0;
        for (String s: c.R().keySet()){
            XSSFRow r2 = sh2.createRow(i+1);
            r2.createCell(0).setCellValue(s);
            for (int j=0; j<3;j++){
                r2.createCell(j+1).setCellValue(c.R().get(s)[j]);
            }
            i++;
        }
        
        
        File f = new File(str);
        book2.write(new FileOutputStream(f));
        book2.close();
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Файл не найден","Ошибка",JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    
}

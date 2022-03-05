/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laaba2;
import laaba2.Excel;
import java.util.LinkedHashMap;
import javax.swing.JOptionPane;
import org.apache.commons.math3.distribution.TDistribution;
import org.apache.commons.math3.stat.StatUtils;
import org.apache.commons.math3.stat.correlation.Covariance;
/**
 *
 * @author Мария
 */
public class Calculator {
    private LinkedHashMap<String, Double[]> lhm;
    
    public Calculator(){
        
    }
    
    public void CG(Excel ex){
        lhm.put("Cреднее геометрическое", new Double[] {StatUtils.geometricMean(ex.getReadx()),
            StatUtils.geometricMean(ex.getReady()),
            StatUtils.geometricMean(ex.getReadz())});
    }
    public void CA(Excel ex){
        lhm.put("Cреднее арифметическое", new Double[] {StatUtils.mean(ex.getReadx()),
            StatUtils.mean(ex.getReady()),
            StatUtils.mean(ex.getReadz())});
    }
    public void OCO(Excel ex){
        lhm.put("Оценка стандартного отклонения", new Double[] {Math.sqrt(StatUtils.variance(ex.getReadx())),
            Math.sqrt(StatUtils.variance(ex.getReady())),
            Math.sqrt(StatUtils.variance(ex.getReadz()))});
    }
    public void RV(Excel ex){
        lhm.put("Размах выборки", new Double[] {StatUtils.max(ex.getReadx())-StatUtils.min(ex.getReadx()),
            StatUtils.max(ex.getReady())-StatUtils.min(ex.getReady()),
            StatUtils.max(ex.getReadz())-StatUtils.min(ex.getReadz())});
    }
    public void KK(Excel ex){
        lhm.put("Коэффициент ковариации", new Double[] {new Covariance().covariance(ex.getReadx(),ex.getReady()),
            new Covariance().covariance(ex.getReadx(),ex.getReadz()),
            new Covariance().covariance(ex.getReadz(),ex.getReady())});
    }
    public void CE(Excel ex){
        lhm.put("Количество элементов", new Double[] {Double.valueOf(ex.getReadx().length),
            Double.valueOf(ex.getReady().length),
            Double.valueOf(ex.getReadz().length)});
    }
    public void KV(Excel ex){
        lhm.put("Коэффициент вариации", new Double[] {Math.sqrt(StatUtils.variance(ex.getReadx()))/Math.abs(StatUtils.mean(ex.getReadx())),
            Math.sqrt(StatUtils.variance(ex.getReady()))/Math.abs(StatUtils.mean(ex.getReady())),
            Math.sqrt(StatUtils.variance(ex.getReadz()))/Math.abs(StatUtils.mean(ex.getReadz()))});
    }
    public void DI1(Excel ex){
        lhm.put("-Доверительный интервал", new Double[] {StatUtils.mean(ex.getReadx())-(new TDistribution(ex.getReadx().length-1).inverseCumulativeProbability(0.95)*Math.sqrt(StatUtils.variance(ex.getReadx())))/Math.sqrt(ex.getReadx().length),
            StatUtils.mean(ex.getReady())-(new TDistribution(ex.getReady().length-1).inverseCumulativeProbability(0.95)*Math.sqrt(StatUtils.variance(ex.getReady())))/Math.sqrt(ex.getReady().length),
            StatUtils.mean(ex.getReadz())-(new TDistribution(ex.getReadz().length-1).inverseCumulativeProbability(0.95)*Math.sqrt(StatUtils.variance(ex.getReadz())))/Math.sqrt(ex.getReadz().length)});
    }
    public void DI2(Excel ex){
        lhm.put("+Доверительный интервал", new Double[] {StatUtils.mean(ex.getReadx())+(new TDistribution(ex.getReadx().length-1).inverseCumulativeProbability(0.95)*Math.sqrt(StatUtils.variance(ex.getReadx())))/Math.sqrt(ex.getReadx().length),
            StatUtils.mean(ex.getReady())+(new TDistribution(ex.getReady().length-1).inverseCumulativeProbability(0.95)*Math.sqrt(StatUtils.variance(ex.getReady())))/Math.sqrt(ex.getReady().length),
            StatUtils.mean(ex.getReadz())+(new TDistribution(ex.getReadz().length-1).inverseCumulativeProbability(0.95)*Math.sqrt(StatUtils.variance(ex.getReadz())))/Math.sqrt(ex.getReadz().length)});
    }
    public void OD(Excel ex){
        lhm.put("Оценка дисперсии", new Double[] {StatUtils.variance(ex.getReadx()),
            StatUtils.variance(ex.getReady()),
            StatUtils.variance(ex.getReadz())});
    }
    public void Max(Excel ex){
        lhm.put("Максимум", new Double[] {StatUtils.max(ex.getReadx()),
            StatUtils.max(ex.getReady()),
            StatUtils.max(ex.getReadz())});
    }
    public void Min(Excel ex){
        lhm.put("Минимум", new Double[] {StatUtils.min(ex.getReadx()),
            StatUtils.min(ex.getReady()),
            StatUtils.min(ex.getReadz())});
    }
    
    
    public void calc(Excel ex){
        
        try{
           CG(ex);
           CA(ex);
           OCO(ex);
           RV(ex);
           KK(ex);
           CE(ex);
           KV(ex);
           DI1(ex);
           DI2(ex);
           OD(ex);
           Max(ex);
           Min(ex);
        
        }
        
        catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Данные не записаны","Ошибка",JOptionPane.INFORMATION_MESSAGE);
        }
        
    } 
    
    
    public LinkedHashMap<String, Double[]> R(){
        return this.lhm;
    }
    
}


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Smells;

import CoreClasses.ClassDefinition;
import CoreClasses.SeperateFileContent;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Shane
 */
public class LazyClasses {
    
    public int avgMethCount=0;
    public int avgVariableCount=0;
    
    public DefaultTableModel getLargeClasses( Vector SFCBlocksTemp)
    {
        //int MAX_LINE_COUNT=700; //MAX Class line count
        //int MAX_NO_OF_COMPONENTS = 20;
        int CONSTANT_MULTIPLIER = (2);
        
        Vector columnNames = new Vector();        
        columnNames.add("Class Name");
        columnNames.add("File Name");
        columnNames.add("Method Count");
        columnNames.add("Attribute Count");        
        columnNames.add("Start Line No");    
        
        Vector dataVec = new Vector();
        DefaultTableModel model = new DefaultTableModel(dataVec, columnNames);  
        
         for(int sf=0;sf<SFCBlocksTemp.size();sf++)
        {
            SeperateFileContent SFC = (SeperateFileContent)SFCBlocksTemp.elementAt(sf);
            int cCount=SFC.ClassCodeBlocks.size();
            int mCount=SFC.MethodCodeBlocks.size();
            //System.out.println(SFC.variableList.size());

            int vCount=0;//variable count

             for (int c=0;c<SFC.ClassCodeBlocks.size();c++)
             {
                vCount = vCount + ((ClassDefinition)(SFC.ClassCodeBlocks.elementAt(c))).variableCount;
             } 

             avgMethCount=mCount/cCount;
             avgVariableCount=vCount/cCount;


            for(int c=0;c<SFC.ClassCodeBlocks.size();c++)
            {
                    int curMethCount = Integer.parseInt(String.valueOf(((ClassDefinition)(SFC.ClassCodeBlocks.elementAt(c))).method_names.size()));
                    int curVarCount = Integer.parseInt(String.valueOf(((ClassDefinition)(SFC.ClassCodeBlocks.elementAt(c))).variableCount));
                    String ClassName = ((ClassDefinition)(SFC.ClassCodeBlocks.elementAt(c))).class_name;
                    int StartLineNo = ((ClassDefinition)(SFC.ClassCodeBlocks.elementAt(c))).startLineNo;

                    if(((curMethCount)<=((CONSTANT_MULTIPLIER)*avgMethCount))&((curVarCount)<=((CONSTANT_MULTIPLIER)*avgVariableCount)))
                    {
                        System.out.println(((ClassDefinition)(SFC.ClassCodeBlocks.elementAt(c))).class_name);
                        model.addRow(new Object[] {ClassName.toString(),SFC.fileName.toString(),String.valueOf(curMethCount),String.valueOf(curVarCount),String.valueOf(StartLineNo)});
                    }
                    else
                    {
                        //System.out.println("Not lazy class");
                    }

            }
        }
        return model;
    }
    
    
}

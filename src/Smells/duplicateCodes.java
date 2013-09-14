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
public class duplicateCodes {
    
    public Vector<Object> DuplicateCodeBlocks=new Vector<Object>();
    
    public DefaultTableModel getLargeClasses(SeperateFileContent SFC )
    {
        int MAX_DUPLICATE_LINE=5;
        
        Vector columnNames = new Vector();        
        columnNames.add("Class Name");
        columnNames.add("Method Count");
        columnNames.add("Attribute Count");        
        columnNames.add("Start Line No");    
        
        Vector dataVec = new Vector();
        DefaultTableModel model = new DefaultTableModel(dataVec, columnNames);  
        
        String DuplicateLineContent ="";
        int DuplicateLineContentCount = 0;
        
        for(int l=0;l<SFC.FileContentLineByLineWithoutComments.size();l++)
        {
            String curLine = SFC.FileContentLineByLineWithoutComments.elementAt(l);
            
            DuplicateLineContentCount = 0;
            
            for(int lc=l;lc<SFC.FileContentLineByLineWithoutComments.size();lc++)
            {
                if(curLine.equals(SFC.FileContentLineByLineWithoutComments.elementAt(lc)))
                {
                    int i=0;
                    for(int lcc=lc;lcc<SFC.FileContentLineByLineWithoutComments.size();lcc++)
                    {
                        if(SFC.FileContentLineByLineWithoutComments.elementAt(lc+i).equals(SFC.FileContentLineByLineWithoutComments.elementAt(lcc)))
                        {
                            DuplicateLineContentCount++;
                        }
                        i++;
                         
                        System.out.println(SFC.FileContentLineByLineWithoutComments.elementAt(lcc));
                        
                        
                        
                    }
                }
            }
            
            
        }
        
                    //model.addRow(new Object[] {ClassName.toString(),String.valueOf(curMethCount),String.valueOf(curVarCount),String.valueOf(StartLineNo)});
                
        
        return model;
    }
    
   
}

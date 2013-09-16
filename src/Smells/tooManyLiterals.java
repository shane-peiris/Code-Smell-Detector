/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Smells;

import CoreClasses.ClassDefinition;
import CoreClasses.MethodDefinition;
import CoreClasses.SeperateFileContent;
import static CoreClasses.SeperateFileContent.dataTypes;
import static CoreClasses.SeperateFileContent.dataTypesCount;
import CoreClasses.VariableDefinition;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Shane
 */
public class tooManyLiterals {
    
    
    public int MAX_VAR_COUNT = (1);
    public static String[] dataTypes=new String[]{"int","boolean","char","double","float","byte","short","long","String","Vector"};
    public static int[] dataTypesCount=new int[]{0,0,0,0,0,0,0,0,0,0};
    public DefaultTableModel getTooManyLiterals( Vector SFCBlocksTemp)
    {
        //int MAX_LINE_COUNT=700; //MAX Class line count
        //int MAX_NO_OF_COMPONENTS = 20;
        
        int varCount=0;
        
        Vector columnNames = new Vector();        
        columnNames.add("Class/Method Name");
        columnNames.add("File Name");
        columnNames.add("Class Contain");
        columnNames.add("Type");
        columnNames.add("Primitive Variable Count"); 
        columnNames.add("Parameter Count"); 
        columnNames.add("Start Line No");    
        
        Vector dataVec = new Vector();
        DefaultTableModel model = new DefaultTableModel(dataVec, columnNames);  
        
         for(int sf=0;sf<SFCBlocksTemp.size();sf++)
        {
            SeperateFileContent SFC = (SeperateFileContent)SFCBlocksTemp.elementAt(sf);
            
            for(int c=0;c<SFC.ClassCodeBlocks.size();c++)
            {
                    //int curMethCount = Integer.parseInt(String.valueOf(((ClassDefinition)(SFC.ClassCodeBlocks.elementAt(c))).method_names.size()));
                    //int curVarCount = Integer.parseInt(String.valueOf(((ClassDefinition)(SFC.ClassCodeBlocks.elementAt(c))).variableCount));
                    String ClassName = ((ClassDefinition)(SFC.ClassCodeBlocks.elementAt(c))).class_name;
                    String type = "Class";
                    int StartLineNo = ((ClassDefinition)(SFC.ClassCodeBlocks.elementAt(c))).startLineNo;
                    
                    int primVar = 0;
                    
                    for(int v=0;v<((ClassDefinition)(SFC.ClassCodeBlocks.elementAt(c))).ClassvariableList.size();v++)
                    {                        
                        if(((VariableDefinition)((ClassDefinition)(SFC.ClassCodeBlocks.elementAt(c))).ClassvariableList.elementAt(v)).pos.equals("global"))
                        {
                            if(((VariableDefinition)((ClassDefinition)(SFC.ClassCodeBlocks.elementAt(c))).ClassvariableList.elementAt(v)).containEqual==1)
                                varCount++;
                        }
                    }

                    if(varCount>MAX_VAR_COUNT)
                    {
                        System.out.println(((ClassDefinition)(SFC.ClassCodeBlocks.elementAt(c))).class_name);
                        model.addRow(new Object[] {ClassName.toString(),SFC.fileName.toString(),"-",type.toString(),String.valueOf(primVar),"-",String.valueOf(StartLineNo)});
                    }
                    varCount=0;
            }
            
            for(int m=0;m<SFC.MethodCodeBlocks.size();m++)
            {                
                for(int i=0;i<((MethodDefinition)SFC.MethodCodeBlocks.elementAt(m)).para_Defs.size();i++)
                {
                        if(((VariableDefinition)((MethodDefinition)SFC.MethodCodeBlocks.elementAt(m)).para_Defs.elementAt(i)).containEqual==1)
                        {                           
                                varCount++;
                        }                
                }
                
                
                for(int i=0;i<((MethodDefinition)SFC.MethodCodeBlocks.elementAt(m)).loc_variables.size();i++)
                {
                        if(((VariableDefinition)((MethodDefinition)SFC.MethodCodeBlocks.elementAt(m)).loc_variables.elementAt(i)).containEqual==1)
                        {                           
                                varCount++;
                        }                
                }
                
                
                 if(varCount>MAX_VAR_COUNT)
                 {
                    String MethName = ((MethodDefinition)SFC.MethodCodeBlocks.elementAt(m)).method_name;
                    String type = "Method";
                    //int LineCount = ((MethodDefinition)SFC.MethodCodeBlocks.elementAt(m)).meth_line;
                    int primVar = ((MethodDefinition)(SFC.MethodCodeBlocks.elementAt(m))).loc_variables.size();
                    int paramVar = ((MethodDefinition)(SFC.MethodCodeBlocks.elementAt(m))).para_Defs.size();
                    int StartLineNo = ((MethodDefinition)SFC.MethodCodeBlocks.elementAt(m)).startLineNo;

                    for(int c=0;c<SFC.ClassCodeBlocks.size();c++)
                    {
                        for(int x=0;x<((ClassDefinition)SFC.ClassCodeBlocks.elementAt(c)).method_names.size();x++)
                        {
                            //(ClassDefinition)SFC.ClassCodeBlocks.elementAt(c))
                            //((((MethodDefinition)((ClassDefinition)SFC.ClassCodeBlocks.elementAt(c)).method_names.elementAt(x)).getStartLineNo()).)
                            if((((MethodDefinition)((ClassDefinition)SFC.ClassCodeBlocks.elementAt(c)).method_names.elementAt(x)).getMethodName().equals(MethName))&(((MethodDefinition)((ClassDefinition)SFC.ClassCodeBlocks.elementAt(c)).method_names.elementAt(x)).getStartLineNo()==StartLineNo))
                            {
                                String ClassContain = ((ClassDefinition)SFC.ClassCodeBlocks.elementAt(c)).class_name.toString();
                                model.addRow(new Object[] {MethName.toString(),SFC.fileName.toString(),ClassContain.toString(),type.toString(),String.valueOf(primVar),String.valueOf(paramVar),String.valueOf(StartLineNo)});
                            }
                        }
                    }
                }
                 varCount=0;
            }
            
            
            
            
        }
        return model;
    }
    
    
    
}

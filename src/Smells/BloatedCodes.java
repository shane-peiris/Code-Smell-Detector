/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Smells;

import CoreClasses.ClassDefinition;
import CoreClasses.MethodDefinition;
import CoreClasses.SeperateFileContent;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Shane
 */
public class BloatedCodes {
    
    
    public DefaultTableModel getLongMethods( Vector SFCBlocksTemp)
    {
        int MAX_LONG_METHOD_LINE_COUNT=80;
        
       
        
        Vector columnNames = new Vector();        
        columnNames.add("Method Name");
        columnNames.add("Class Contain In");
        columnNames.add("File Name");
        columnNames.add("Line Count");
        columnNames.add("Start Line No");        
        Vector dataVec = new Vector();
        DefaultTableModel model = new DefaultTableModel(dataVec, columnNames);  
        
        String MethName="";
        String ClassContain="";
        int LineCount=0;
        int StartLineNo=0;
        
        for(int sf=0;sf<SFCBlocksTemp.size();sf++)
        {
            SeperateFileContent SFC = (SeperateFileContent)SFCBlocksTemp.elementAt(sf);
            for(int m=0;m<SFC.MethodCodeBlocks.size();m++)
            {
                if(((MethodDefinition)SFC.MethodCodeBlocks.elementAt(m)).meth_line>MAX_LONG_METHOD_LINE_COUNT)
                {
                    MethName = ((MethodDefinition)SFC.MethodCodeBlocks.elementAt(m)).method_name;
                    LineCount = ((MethodDefinition)SFC.MethodCodeBlocks.elementAt(m)).meth_line;
                    StartLineNo = ((MethodDefinition)SFC.MethodCodeBlocks.elementAt(m)).startLineNo;

                    for(int c=0;c<SFC.ClassCodeBlocks.size();c++)
                    {
                        for(int x=0;x<((ClassDefinition)SFC.ClassCodeBlocks.elementAt(c)).method_names.size();x++)
                        {
                            //(ClassDefinition)SFC.ClassCodeBlocks.elementAt(c))
                            //((((MethodDefinition)((ClassDefinition)SFC.ClassCodeBlocks.elementAt(c)).method_names.elementAt(x)).getStartLineNo()).)
                            if((((MethodDefinition)((ClassDefinition)SFC.ClassCodeBlocks.elementAt(c)).method_names.elementAt(x)).getMethodName().equals(MethName))&(((MethodDefinition)((ClassDefinition)SFC.ClassCodeBlocks.elementAt(c)).method_names.elementAt(x)).getStartLineNo()==StartLineNo))
                            {
                                ClassContain = ((ClassDefinition)SFC.ClassCodeBlocks.elementAt(c)).class_name.toString();
                                model.addRow(new Object[] {MethName.toString(),ClassContain.toString(),SFC.fileName.toString(),String.valueOf(LineCount),String.valueOf(StartLineNo)});
                            }
                        }
                    }
                }
            }
        }
        
        
        
        
        
        
        
        
        
        
        
        
        //model.addRow(new Object[] {"item1","item1info","item1moreinfo","item1closing"});
        return model;
    }
    
    public DefaultTableModel getLargeClasses( Vector SFCBlocksTemp )
    {
        int MAX_LINE_COUNT=700; //MAX Class line count
        int MAX_NO_OF_COMPONENTS = 20;
        
        Vector columnNames = new Vector();        
        columnNames.add("Class Name");
        columnNames.add("File Name");
        columnNames.add("Method Count");
        columnNames.add("Attribute Count");
        columnNames.add("Line Count"); 
        columnNames.add("Start Line No");    
        
        Vector dataVec = new Vector();
        DefaultTableModel model = new DefaultTableModel(dataVec, columnNames);  
        
        
        String ClassName="";
        int MethodCount=0;
        int AttributeCount=0;
        int StartLineNo=0;
        int LineCount=0;
    
        for(int sf=0;sf<SFCBlocksTemp.size();sf++)
        {
            SeperateFileContent SFC = (SeperateFileContent)SFCBlocksTemp.elementAt(sf);
        
            for(int c=0;c<SFC.ClassCodeBlocks.size();c++)
            {
                MethodCount = ((ClassDefinition)SFC.ClassCodeBlocks.elementAt(c)).method_names.size();
                AttributeCount = ((ClassDefinition)SFC.ClassCodeBlocks.elementAt(c)).ClassvariableList.size();
                StartLineNo = ((ClassDefinition)SFC.ClassCodeBlocks.elementAt(c)).startLineNo;
                LineCount = ((ClassDefinition)SFC.ClassCodeBlocks.elementAt(c)).class_line;
                ClassName = ((ClassDefinition)SFC.ClassCodeBlocks.elementAt(c)).class_name;

                if((((MethodCount+AttributeCount)>=MAX_NO_OF_COMPONENTS)&(LineCount >=(MAX_LINE_COUNT/2)))|(LineCount>=MAX_LINE_COUNT))
                {
                    model.addRow(new Object[] {ClassName.toString(),SFC.fileName.toString(),String.valueOf(MethodCount),String.valueOf(AttributeCount),String.valueOf(LineCount),String.valueOf(StartLineNo)});
                }

            }
        }
        
        return model;
    }
    
    public DefaultTableModel getLongParameterLists( Vector SFCBlocksTemp)
    {
        //int MAX_PARAMETER_COUNT=5;
        
        
        
        Vector columnNames = new Vector();        
        columnNames.add("Method Name");
        columnNames.add("Class Contain In");
        columnNames.add("File Name");
        columnNames.add("Parameter Count");
        columnNames.add("Start Line No");        
        Vector dataVec = new Vector();
        DefaultTableModel model = new DefaultTableModel(dataVec, columnNames);  
        
        String MethName="";
        String ClassContain="";
        int ParameterCount=0;
        int StartLineNo=0;
        
        for(int sf=0;sf<SFCBlocksTemp.size();sf++)
        {
            SeperateFileContent SFC = (SeperateFileContent)SFCBlocksTemp.elementAt(sf);
        
            int MethCount = SFC.MethodCodeBlocks.size();
            int curVarCount=0;
            int avgParameters=0;


            for(int m=0;m<SFC.MethodCodeBlocks.size();m++)
            {
                curVarCount = ((MethodDefinition)SFC.MethodCodeBlocks.elementAt(m)).para_Defs.size();

                avgParameters = avgParameters + (curVarCount/MethCount);
            }

            for(int m=0;m<SFC.MethodCodeBlocks.size();m++)
            {

                curVarCount = ((MethodDefinition)SFC.MethodCodeBlocks.elementAt(m)).para_Defs.size();  

                if(((curVarCount>2)&(curVarCount>avgParameters+2))|(curVarCount>10))
                {
                    MethName = ((MethodDefinition)SFC.MethodCodeBlocks.elementAt(m)).method_name;
                    ParameterCount = ((MethodDefinition)SFC.MethodCodeBlocks.elementAt(m)).para_Defs.size();
                    StartLineNo = ((MethodDefinition)SFC.MethodCodeBlocks.elementAt(m)).startLineNo;

                    for(int c=0;c<SFC.ClassCodeBlocks.size();c++)
                    {
                        for(int x=0;x<((ClassDefinition)SFC.ClassCodeBlocks.elementAt(c)).method_names.size();x++)
                        {
                            //(ClassDefinition)SFC.ClassCodeBlocks.elementAt(c))
                            //((((MethodDefinition)((ClassDefinition)SFC.ClassCodeBlocks.elementAt(c)).method_names.elementAt(x)).getStartLineNo()).)
                            if((((MethodDefinition)((ClassDefinition)SFC.ClassCodeBlocks.elementAt(c)).method_names.elementAt(x)).getMethodName().equals(MethName))&(((MethodDefinition)((ClassDefinition)SFC.ClassCodeBlocks.elementAt(c)).method_names.elementAt(x)).getStartLineNo()==StartLineNo))
                            {
                                ClassContain = ((ClassDefinition)SFC.ClassCodeBlocks.elementAt(c)).class_name.toString();
                                model.addRow(new Object[] {MethName.toString(),ClassContain.toString(),SFC.fileName.toString(),String.valueOf(ParameterCount),String.valueOf(StartLineNo)});
                            }
                        }
                    }
                }
            }
        }
        
        
        
        
        
        
        
        
        
        
        
        
        //model.addRow(new Object[] {"item1","item1info","item1moreinfo","item1closing"});
        return model;
    
    }
    
}

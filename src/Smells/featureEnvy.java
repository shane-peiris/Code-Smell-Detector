/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Smells;

import CoreClasses.ClassDefinition;
import CoreClasses.MethodDefinition;
import CoreClasses.SeperateFileContent;
import CoreClasses.VariableDefinition;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Shane
 */
public class featureEnvy {
    
    public DefaultTableModel getFeaturEnvy( Vector SFCBlocksTemp)
    {
        //int MAX_LINE_COUNT=700; //MAX Class line count
        //int MAX_NO_OF_COMPONENTS = 20;
        
        
        Vector columnNames = new Vector();        
        columnNames.add("Method Name");
        columnNames.add("File Name");
        columnNames.add("Class Contain");
        columnNames.add("Start Line No");    
        
        Vector dataVec = new Vector();
        DefaultTableModel model = new DefaultTableModel(dataVec, columnNames);  
        
        Vector<Object> classNameList = new Vector<Object>() ;
        
        for(int sf=0;sf<SFCBlocksTemp.size();sf++)
        {
            SeperateFileContent SFC = (SeperateFileContent)SFCBlocksTemp.elementAt(sf);
            
            for(int c=0;c<SFC.ClassCodeBlocks.size();c++)
            {
                classNameList.add(((ClassDefinition)SFC.ClassCodeBlocks.elementAt(c)).class_name);
            }
            
        }
        
        
        long AttsInCurClass=0;
        long AttsInExtClass=0;
        
        long MethInCurClass=0;
        long MethInExtClass=0;
        String ClassContain="";
        String MethName = "";
        int LineCount=0;
        int StartLineNo= 0;
        String content = "";
        
        for(int sf=0;sf<SFCBlocksTemp.size();sf++)
        {
            SeperateFileContent SFC = (SeperateFileContent)SFCBlocksTemp.elementAt(sf);
            
            for(int m=0;m<SFC.MethodCodeBlocks.size();m++)
            {
                MethName = ((MethodDefinition)SFC.MethodCodeBlocks.elementAt(m)).method_name;
                LineCount = ((MethodDefinition)SFC.MethodCodeBlocks.elementAt(m)).meth_line;
                StartLineNo = ((MethodDefinition)SFC.MethodCodeBlocks.elementAt(m)).startLineNo;
                
                AttsInCurClass=0;
                AttsInExtClass=0;
        
                MethInCurClass=0;
                MethInExtClass=0;
                
                
                //GEtting atts n meths of cur classes
                
                for(int c=0;c<SFC.ClassCodeBlocks.size();c++)
                    {
                        for(int x=0;x<((ClassDefinition)SFC.ClassCodeBlocks.elementAt(c)).method_names.size();x++)
                        {
                            //(ClassDefinition)SFC.ClassCodeBlocks.elementAt(c))
                            //((((MethodDefinition)((ClassDefinition)SFC.ClassCodeBlocks.elementAt(c)).method_names.elementAt(x)).getStartLineNo()).)
                            if((((MethodDefinition)((ClassDefinition)SFC.ClassCodeBlocks.elementAt(c)).method_names.elementAt(x)).getMethodName().equals(MethName))&(((MethodDefinition)((ClassDefinition)SFC.ClassCodeBlocks.elementAt(c)).method_names.elementAt(x)).getStartLineNo()==StartLineNo))
                            {
                                ClassContain = ((ClassDefinition)SFC.ClassCodeBlocks.elementAt(c)).class_name.toString();
                                //model.addRow(new Object[] {MethName.toString(),ClassContain.toString(),SFC.fileName.toString(),String.valueOf(LineCount),String.valueOf(StartLineNo)});
                                
                                content = ((MethodDefinition)((ClassDefinition)SFC.ClassCodeBlocks.elementAt(c)).method_names.elementAt(x)).getContent();
                                
                                Vector<String> MethNameList = new Vector<String>();
                                Vector<String> VarNameList = new Vector<String>();
                                
                                for(int x1=0;x1<((ClassDefinition)SFC.ClassCodeBlocks.elementAt(c)).method_names.size();x1++)
                                {
                                    MethNameList.add(((MethodDefinition)((ClassDefinition)SFC.ClassCodeBlocks.elementAt(c)).method_names.elementAt(x1)).method_name);
                                }
                                
                                for(int x1=0;x1<((ClassDefinition)SFC.ClassCodeBlocks.elementAt(c)).ClassvariableList.size();x1++)
                                {
                                    VarNameList.add(((VariableDefinition)((ClassDefinition)SFC.ClassCodeBlocks.elementAt(c)).ClassvariableList.elementAt(x1)).var_name);
                                }
                                
                                
                                for(int x1=0;x1<MethNameList.size();x1++)
                                {
                                    String s = content;
            
                                    String regex = MethNameList.elementAt(x1);
                                    Pattern p = Pattern.compile(regex);
                                    Matcher m2 = p.matcher(s);
                                    while(m2.find()) {
                                        MethInCurClass++;

                                    }
                                }
                                
                                for(int x1=0;x1<VarNameList.size();x1++)
                                {
                                    String s = content;
            
                                    String regex = VarNameList.elementAt(x1);
                                    Pattern p = Pattern.compile(regex);
                                    Matcher m2 = p.matcher(s);
                                    while(m2.find()) {
                                        AttsInCurClass++;

                                    }
                                }
                                
                                
                            }
                        }
                    }
                
                
                
                //GEtting atts n meths of other classes
                Vector<String> MethNameList2 = new Vector<String>();
                Vector<String> VarNameList2 = new Vector<String>();
                
                for(int sf2=0;sf2<SFCBlocksTemp.size();sf2++)
                {
                    SeperateFileContent SFC2 = (SeperateFileContent)SFCBlocksTemp.elementAt(sf2);
                    
                    for(int c=0;c<SFC2.ClassCodeBlocks.size();c++)
                    {
                        if(!(ClassContain.equals((((ClassDefinition)SFC2.ClassCodeBlocks.elementAt(c)).class_name.toString()))))
                        {
                            
                            
                            for(int x1=0;x1<((ClassDefinition)SFC2.ClassCodeBlocks.elementAt(c)).method_names.size();x1++)
                            {
                                MethNameList2.add(((MethodDefinition)((ClassDefinition)SFC2.ClassCodeBlocks.elementAt(c)).method_names.elementAt(x1)).method_name);
                            }

                            for(int x1=0;x1<((ClassDefinition)SFC2.ClassCodeBlocks.elementAt(c)).ClassvariableList.size();x1++)
                            {
                                VarNameList2.add(((VariableDefinition)((ClassDefinition)SFC2.ClassCodeBlocks.elementAt(c)).ClassvariableList.elementAt(x1)).var_name);
                            }
                            
                            
                        }
                    }
                    
                    
                }
                
                for(int x1=0;x1<MethNameList2.size();x1++)
                {
                    String s = content;

                    String regex = MethNameList2.elementAt(x1);
                    Pattern p = Pattern.compile(regex);
                    Matcher m2 = p.matcher(s);
                    while(m2.find()) {
                        MethInExtClass++;

                    }
                }

                for(int x1=0;x1<VarNameList2.size();x1++)
                {
                    String s = content;

                    String regex = VarNameList2.elementAt(x1);
                    Pattern p = Pattern.compile(regex);
                    Matcher m2 = p.matcher(s);
                    while(m2.find()) {
                        AttsInExtClass++;

                    }
                }
                
                
                //add method to model if IF condition satisfies
                long ATFD = AttsInExtClass + MethInExtClass;
                long LAA = ATFD/(AttsInCurClass+MethInCurClass);
                if((ATFD>3)&(LAA<0.3))
                {
                    model.addRow(new Object[] {MethName.toString(),SFC.fileName.toString(),ClassContain.toString(),String.valueOf(StartLineNo)});
                }
                
                
            }
            
            
            
            
        }
        
        return model;
        
        
    }
    
    
    
}

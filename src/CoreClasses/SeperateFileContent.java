/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CoreClasses;

import java.util.Vector;

/**
 *
 * @author Shane
 */
public class SeperateFileContent {
    
     public Vector<String> FileContentLineByLine=new Vector<String>();
    
    public void addMethodToVector()
    {}
    public void addClassToVector()
    {}
    public void addIfToVector()
    {}
    public void addWhileToVector()
    {}
    public void addRepeatToVector()
    {}
    public void addSwitchToVector()
    {}
    public void addForToVector()
    {}
    public void addVaraibleToVector()
    {}
    
    public void getCodeBlockType(String curLine)
    {
        //Identify Class
            //Then get entire relevant code block
        
        
        //Identify Method
        
        //Identify If
        
        //Identify For Loop
        
        //Identify While Loop
        
        //Identify Repeat Until Loop
        
        //Identify Switch Statement
        
        //Identify Varaible
    
    
    }
    
    public void getEntireCodeBlock()
    {
        //
    }
    
    public void seperateCodeBlocks()
    {}
    
    public String getVectorLineDetails(int pos)
    {
        return FileContentLineByLine.elementAt(pos).toString();
    }
    
    public void ScanContent()
    {
        for(int i=0;i<FileContentLineByLine.size();i++)
        {
            String curLine=getVectorLineDetails(i);
            
            getCodeBlockType(curLine);
            
        }
    }
    
}

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
public class ClassDefinition {
    public Vector interf_names = new Vector<Object>(); 
    public Vector method_names = new Vector<Object>(); 
    public Vector ClassvariableList = new Vector<Object>();
    public String parent_class="";
    public String class_name="";
    public String content="";
    public int class_line=0;
    public int max_class_nest_depth = 0;
    public String accessType="";
    public int variableCount=0;
    
    public String getParentClassName()
    {    
        return parent_class;
    }
    
    public Vector getInterfaceNames()
    {    
        return interf_names;
    }
    public String getContent()
    {    
        return content;
    }
    public String getAccessType()
    {
        return accessType;
    }
    
    public Vector getMethodDefinitions()
    {
        return method_names;
    }
    
    public int getNumberOfLines()
    {
        return class_line;
    }
    
    public int getMaximumNesting()
    {
        return max_class_nest_depth;
    }
    public Vector getVariableList()
    {    
        return ClassvariableList;        
    }
}

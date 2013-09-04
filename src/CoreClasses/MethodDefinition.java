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
public class MethodDefinition {
    public Vector para_Defs = new Vector<Object>();
    public Vector loc_variables = new Vector<Object>();
    public String method_name="";
    public String return_type=""; 
    public String content="";
    public int meth_line=0;
    public int max_meth_nest_depth=0;
    
    public String getMethodName()
    {    
        return method_name;
    }

    public String getReturnType()
    {
        return return_type;
    }
    
    public Vector getParameterDefinitions()
    {    
        return para_Defs;
    }
    public String getContent()
    {    
        return content;
    }
    public Vector getLocalVariables()
    {    
        return loc_variables;        
    }
    
    public int getNumberOfLines()
    {
        return meth_line;
    }
    public int getMaximumNesting()
    {
        return max_meth_nest_depth;
    }
}

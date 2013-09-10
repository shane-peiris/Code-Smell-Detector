/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CoreClasses;

/**
 *
 * @author Shane
 */
public class VariableDefinition {
    public String var_name="";
    public String var_type="";
    public String var_par_or_prim;
    public String pos="";
    public String accessType="";
    public int startLineNo=0;
    
    public String getVariableName()
    {
        return var_name;
    }
    
    public String getVariableType()
    {
        return var_type;
    }
    public String getAccessType()
    {
        return accessType;
    }
    
    public boolean isParameter()
    {
        if(var_par_or_prim.equals("Parameter"))
        {
            return true;
        }
        return false;
    }
    
    public boolean isPrimitive()
    {
        if(var_par_or_prim.equals("Primitive"))
        {
            return true;
        }
        return false;
    }   
    
    public String getVariablePos()
    {
        return pos;
    }
    
    public int getStartLineNo()
    {
        return startLineNo;
    }
    
}

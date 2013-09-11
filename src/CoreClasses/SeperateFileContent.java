/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CoreClasses;

import java.util.StringTokenizer;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Shane
 */
public class SeperateFileContent {
    
    public Vector<String> FileContentLineByLine=new Vector<String>();
    public Vector<String> FileContentLineByLineWithoutComments = new Vector<String>();

    public Vector chk_class_details = new Vector<Object>();
    public Vector chk_method_details = new Vector<Object>();
    public Vector<Object> ClassCodeBlocks=new Vector<Object>();
    public Vector<Object> MethodCodeBlocks=new Vector<Object>();
    public Vector<Object> variableList=new Vector<Object>();
    public Vector<Object> tempVariableListParameter=new Vector<Object>();
    public Vector<Object> tempVariableListPrimitive=new Vector<Object>();

    public String delims = "\t\n,;{}[]().-<>&^%$@!-+\\/*'~\"= ";
    public int fw_flag_c=0;

    public int clzFlag=0;
    public int methodFlag=0;
    public int level=0;
    public int loopFlag=0;
    public int meth=0;
    public int countNum=1;
    public String curClassIn="";
    public int LineCount;
    public int variableCount=0;
    public int FilevariableCount=0;
    public int MethvariableCount=0;
    
    public static String[] dataTypes=new String[]{"int","boolean","char","double","float","byte","short","long","String","Vector"};
    public static int[] dataTypesCount=new int[]{0,0,0,0,0,0,0,0,0,0};
    
    //public int methodLineCount;
    
    public void addMethodToVector(int i)
    {}
    public void addClassToVector(int i) 
    {}
    public void addIfToVector(int i)
    {}
    public void addWhileToVector(int i)
    {}
    public void addRepeatToVector(int i)
    {}
    public void addSwitchToVector(int i)
    {}
    public void addForToVector(int i)
    {}
    public void addVaraibleToVector(int i)
    {}
    
    public ClassDefinition getClassDetails(int i) 
    {
        return (ClassDefinition)ClassCodeBlocks.elementAt(i);
    }
    
    public MethodDefinition getMethodDetails(int i) 
    {
        return (MethodDefinition)MethodCodeBlocks.elementAt(i);
    }
    
    
    public String getCodeBlockType(String curLine)
    {
        String accessType="";
        String methodName="";
        String retType="";
        
        if(curLine.contains("public"))
         {
             accessType = "public";
         }
         else if(curLine.contains("protected"))
         {
             accessType = "protected";
         }
         else if(curLine.contains("private"))
         {
             accessType = "private";
         }
        
        
          curLine = curLine.replaceAll("public ","");
          curLine = curLine.replaceAll("protected ","");
          curLine = curLine.replaceAll("private ","");
          curLine = curLine.replaceAll("static ","");
          curLine = curLine.trim().replace("\\s+","");
          
            //Identify Class
            //Then get entire relevant code block
            try
            {
            //Finds Class Type 1
            if(curLine.matches("class (.*?)"))
            {

                //classLineCount=0;
                clzFlag++;
                try
                {
                    curClassIn= curLine.substring(6,curLine.indexOf(" ", 6));
                }
                catch(Exception ex)
                {
                    curClassIn= curLine.substring(6);
                }
                chk_class_details.add("CN - " + curClassIn);




                if(curLine.matches("class (.*?) extends (.*?)"))
                {
                    if(curLine.matches("class (.*?) extends (.*?) implements (.*?)"))
                    {
                        curLine = curLine.replace("class", "");
                        curLine = curLine.replace(curClassIn, "");

                        chk_class_details.add("PC - " + curLine.substring(curLine.indexOf("extends")+8,curLine.indexOf("implements")));

                        String[] interfaces=curLine.substring(curLine.indexOf("implements")+11).split(",");

                        for (int i=0; i<interfaces.length;i++)
                        {
                            chk_class_details.add("I - " + interfaces[i]);                    
                        }

                        chk_class_details.add("O - " + " ");


                    }
                    else
                    {            
                        curClassIn= curLine.substring(curLine.indexOf("extends")+8);

                        chk_class_details.add("PC - " + curClassIn);
                        chk_class_details.add("I - " + " ");
                        chk_class_details.add("O - " + " ");
                    }
                }
                else if(curLine.matches("class (.*?) implements (.*?)"))
                {
                    curClassIn= curLine.substring(6, curLine.indexOf("implements"));

                    curLine = curLine.replace("class", "");
                    curLine = curLine.replace("implements", "");
                    curLine = curLine.replace(curClassIn, "");
                    curLine = curLine.replace(" ", "");

                    chk_class_details.add("PC - " + " ");

                    String[] interfaces=curLine.split(",");

                    for (int i=0; i<interfaces.length;i++)
                    {
                        chk_class_details.add("I - " + interfaces[i]);
                    }

                    chk_class_details.add("O - " + " ");

                }
                else if(curLine.matches("class (.*?)"))
                {            
                    curClassIn= curLine.substring(6);
                    chk_class_details.add("PC - " + " ");
                    chk_class_details.add("I - " + " ");
                    chk_class_details.add("O - Object");
                }          
                chk_class_details.add(accessType);
                curClassIn = curClassIn.replace("{", "");
                curClassIn = curClassIn.replace(" ", "");
               // System.out.println(curClassIn);


                if((curLine.matches("class (.*?)"))& (curLine.contains("{")))
                {
                    level++;
                    clzFlag++;
                   // System.out.println("------Inside class:------");  

                    return "class";
                }


            } 


            //Find Constructor Type 1
            else if(((curLine.matches(curClassIn+"\\s+\\((.*?)\\)(.*?)"))|(curLine.matches(curClassIn+"\\((.*?)\\)(.*?)"))) & (level==1))
            {
                meth++;  
                //methodLineCount=0; 
                  methodName = curLine.substring(0,curLine.indexOf("("));
                  //System.out.println(methodName);
                  chk_method_details.add(methodName);
                  //chk_method_details.add("");
                  chk_method_details.add(accessType);
                  //md[methodCount+1] = new MethodDefinition();
                 // md[methodCount+1].methodName = methodName;
                 // md[methodCount+1].returnType = "Null";
                  //md[methodCount+1].methodLineCount=methodLineCount;
                  //md[methodCount+1].methodLineCount=methodLineCount;  
                if((curLine.contains("{"))&(meth==1) & (curLine.substring(curLine.length()-1).equals("{")))
                {
                    level++;
                    meth++;
                    //methodCount++;
                    
                    if((curLine.endsWith("}")))
                    {
                        level--;
                        meth--;
                        if(meth==1 & level==1)
                        {
                            try
                            {
                              //md[methodCount].methodLineCount = methodLineCount;
                            }
                            catch(Exception ex){}
                        }
                        if(meth==1)
                        {
                            meth=0;
                        }
                        if(level==0)
                        {
                            meth=0;
                            clzFlag=0;
                            level=0;
                            //cd[classCount-1].classLineCount = classLineCount;
                        } 
                    }    

                    return "method";
                    //System.out.println("***Inside Method***");
                } 
                else
                {
                    //meth--;
                }

                if(meth==2)
                {

                }


            }        

            //Finn Method Type 1
            else if(curLine.matches("(.*?)\\((.*?)\\)(.*?)") & (level==1) )
            {
                meth++; 
                //methodLineCount=0;

                  retType = curLine.substring(0,curLine.indexOf(" "));
                 // System.out.println(retType);
                  curLine = curLine.replace(retType + " ", "");                       

                  methodName = curLine.substring(0,curLine.indexOf("("));
                 // System.out.println(methodName);

                  chk_method_details.add(methodName);
                    chk_method_details.add(accessType);
                  //md[methodCount+1] = new MethodDefinition();
                  //md[methodCount+1].methodName = methodName;
                  chk_method_details.add(retType);
                  
                  //md[methodCount+1].methodLineCount=methodLineCount;

                if((curLine.contains("{"))&(meth==1) & (curLine.substring(curLine.length()-1).equals("{")))
                {
                    level++;
                    meth++;
                   // methodCount++;
                    //cd[classCount-1].methDefs.add(methodName);
                    
                    if((curLine.endsWith("}")))
                    {
                        level--;
                        meth--;
                        if(meth==1 & level==1)
                        {
                            try
                            {
                              //md[methodCount].methodLineCount = methodLineCount;
                            }
                            catch(Exception ex){}
                        }
                        if(meth==1)
                        {
                            meth=0;
                        }
                        if(level==0)
                        {
                            meth=0;
                            clzFlag=0;
                            level=0;
                            //cd[classCount-1].classLineCount = classLineCount;
                        } 
                    }
                    
                    
                    return "method";
                   // System.out.println("***Inside Method:***");
                }   
                else
                {
                    //meth--;
                }

                if(meth==2)                  
                {

                }
            }
            //Finn Method Type 2
            else if((meth==1) & (curLine.contains("{")))
            {
                level++;
                meth++;
                //methodCount++;
                return "method";
                //System.out.println("***Inside Method:***");
            }

            //Find Class Type 2
            else if(clzFlag==1 & curLine.contains("{"))
            {
                level++;
                clzFlag=2;
                return "class";
               // System.out.println("------Inside class:------");              
            }
            else if((curLine.startsWith("{")) | curLine.startsWith("\\s+{"))
            {
                level++;
                meth++;
            }
            else if((curLine.endsWith("}")))
            {
                level--;
                meth--;
                if(meth==1 & level==1)
                {
                    try
                    {
                      //md[methodCount].methodLineCount = methodLineCount;
                    }
                    catch(Exception ex){}
                }
                if(meth==1)
                {
                    meth=0;
                }
                if(level==0)
                {
                    meth=0;
                    clzFlag=0;
                    level=0;
                    //cd[classCount-1].classLineCount = classLineCount;
                }          
            }

            if(meth>=1 & !curLine.equals(""))
            {
                //methodLineCount++;
                //System.out.println("meth lines"+methodLineCount);
            }
            if(clzFlag>=1 & !curLine.equals(""))
            {
              /// classLineCount++;
              // System.out.println("line:"+mLine);
              // System.out.println("/nTotla Number of lines:"+classLineCount);

            }
            
          }
          catch(Exception ex)
          {}
        
            //Identify Method
            
            //Identify If

            //Identify For Loop

            //Identify While Loop

            //Identify Repeat Until Loop

            //Identify Switch Statement

            //Identify Varaible
        
            return "";
         
         
        
    
    
    }
    
    public String removeComments(String curLine)
    {
        curLine = (curLine.replaceAll("(?:/\\*(?:[^*]|(?:\\*+[^*/]))*\\*+/)|(?://.*)",""));
        
        return curLine;
    }
            
    
    public String getEntireCodeBlock(int sPos, String type)
    {
        int x=0;
        int level=0;
        String mLine="";
        String blockDetails="";
        LineCount=0;
        
        variableList.clear();
        tempVariableListPrimitive.removeAllElements();
        tempVariableListParameter.removeAllElements();
       
        for(int i=sPos;i<FileContentLineByLineWithoutComments.size();i++)
        {
          
            mLine= FileContentLineByLineWithoutComments.elementAt(i);
            mLine = mLine.trim().replaceAll("\\s+", " ");
          
          if((x==0)& !(mLine.endsWith("{") | mLine.endsWith("{(.*?)")))
          {
                blockDetails =blockDetails + FileContentLineByLineWithoutComments.elementAt(i).toString() + "\n";  
                
                if(clzFlag==2 & meth==0 & level==1)
                {
                    countVariables("2",FileContentLineByLineWithoutComments.elementAt(i).toString(),"global",i);
                }
                else if(clzFlag==2 & meth==0 & level>1)
                {
                    countVariables("2",FileContentLineByLineWithoutComments.elementAt(i).toString(),"local",i);
                }
              
                if(clzFlag>1 & meth>1)
                {
                    countVariables("2",FileContentLineByLineWithoutComments.elementAt(i).toString(),"local",i);
                }
                else if((FileContentLineByLineWithoutComments.elementAt(i).toString().matches("(.*?)\\((.*?)\\)(.*?)"))& clzFlag>1 & meth>0)
                {
                    countVariables("2",FileContentLineByLineWithoutComments.elementAt(i).toString(),"local",i);
                }
                x++;
                continue;
          }
            
            
          if((mLine.endsWith("{")|mLine.endsWith("\\s+{")) | (mLine.startsWith("{")|mLine.startsWith("\\s+{")) )
          {
              level++;
          }
          else if(mLine.endsWith("}")| mLine.endsWith("(.*?)}"))
          {
              level--;     
          }
          
          blockDetails =blockDetails + FileContentLineByLineWithoutComments.elementAt(i).toString() + "\n";
          
          if(clzFlag==2 & meth==0 & level==1 & mLine.matches("(.*?)\\((.*?)\\)(.*?)"))
            {
                countVariables("2",FileContentLineByLineWithoutComments.elementAt(i).toString(),"local",i);
            }
          else if(clzFlag==2 & meth==0 & level==1)
            {
                countVariables("2",FileContentLineByLineWithoutComments.elementAt(i).toString(),"global",i);
            }
            else if(clzFlag==2 & meth==0 & level>1)
            {
                countVariables("2",FileContentLineByLineWithoutComments.elementAt(i).toString(),"local",i);
            }


            if(clzFlag>1 & meth>1)
            {
                countVariables("2",FileContentLineByLineWithoutComments.elementAt(i).toString(),"local",i);
            }
            else if( (FileContentLineByLineWithoutComments.elementAt(i).toString().matches("(.*?)\\((.*?)\\)(.*?)"))& clzFlag>1 & meth>0 )
            {
                countVariables("2",FileContentLineByLineWithoutComments.elementAt(i).toString(),"local",i);
            }
          
          x++;
          LineCount++;
          
          if((level==0) & !(x==0))
          {
              break;
          }
          
          
        }
        
       
        return blockDetails;
        
    }
    
    public void seperateCodeBlocks()
    {}
    
    public String getVectorLineDetailsOrg(int pos)
    {
        return FileContentLineByLine.elementAt(pos).toString();
    }
    
    public String getVectorLineDetailsWithoutComments(int pos)
    {
        return FileContentLineByLineWithoutComments.elementAt(pos).toString();
    }
    
    public MethodDefinition SeperateMethodDetails(MethodDefinition md_temp)
    {
        md_temp = new MethodDefinition();
        
        md_temp.method_name = chk_method_details.elementAt(0).toString();
        md_temp.accessType = chk_method_details.elementAt(1).toString();
        try
        {
        md_temp.return_type = chk_method_details.elementAt(2).toString();
        md_temp.methType = "Normal";
        
        }
        catch(Exception ex)
        {
        md_temp.return_type="";
        md_temp.methType = "Constructor";
        }
        
        return md_temp;
    }
    
    public ClassDefinition SeperateClassDetails(ClassDefinition cd_temp)
    {
        int ele_id=0;
            if(!(chk_class_details.elementAt(ele_id).toString().substring(5)).equals(" "))
            {
                cd_temp = new ClassDefinition();

                //Show Class Name

                cd_temp.class_name = chk_class_details.elementAt(ele_id).toString().substring(5);
                //System.out.println(file_class_Details.elementAt(ele_id).toString().substring(5) );

                ele_id++;

                //Show Parent Class

                cd_temp.parent_class = chk_class_details.elementAt(ele_id).toString().substring(5);
                //System.out.println(file_class_Details.elementAt(ele_id+1).toString().substring(5));

                ele_id++;

                while((chk_class_details.elementAt(ele_id).toString().contains("I - ")))
                {
                    if(!(chk_class_details.elementAt(ele_id).toString().substring(4).equals(" ")))
                    {
                        //String t = chk_class_details.elementAt(ele_id).toString().substring(4);
                        cd_temp.interf_names.add(chk_class_details.elementAt(ele_id).toString().substring(4));
                        
                    }
                    ele_id++;
                }

                //Show Elements in interfaces

                //System.out.println(cd_temp[cd_count].interf_names.size());



                if((cd_temp.parent_class).equals(""))
                {
                    cd_temp.parent_class = chk_class_details.elementAt(ele_id).toString().substring(4);
                    //System.out.println(cd_temp[cd_count].parent_class );
                }

                if(chk_class_details.elementAt(ele_id+1).toString().equals(""))
                {
                    cd_temp.accessType = "private";
                }
                else
                {
                    cd_temp.accessType = chk_class_details.elementAt(ele_id+1).toString();
                }
                
            }
            return cd_temp;
    }
     
    public void ScanContent()
    {
        int x=0;
        int i=0;
                
        for(i=0;i<FileContentLineByLine.size();i++)
        {
            String curLine=getVectorLineDetailsOrg(i);
            
            //Remove Generic Comments
            curLine = removeComments(curLine);
            //Ignore Complex Comments            
            String lineToProcess = curLine.trim().replaceAll("\\s+", " ");
            StringTokenizer splitter = new StringTokenizer(lineToProcess, delims, true);
            int numTokens = splitter.countTokens();
            String word="";
            
            x=0; 
            
            for(int i2=0;i2<numTokens;i2++)
            {    
                //Read next token in current line
                word = splitter.nextToken();


                        //New Complex Comment Handler END            

                         if ((word.charAt(0)=='/') &(fw_flag_c==0))
                        {
                            fw_flag_c=1;
                            continue;
                        }
                        if ((word.charAt(0)=='*') &(fw_flag_c==1))
                        {
                            fw_flag_c=2;
                            continue;
                        }
                        if ((word.charAt(0)=='*') &(fw_flag_c==2))
                        {
                            fw_flag_c=3;
                            continue;
                        }
                        if ((word.charAt(0)=='/') &(fw_flag_c==3))
                        {
                            fw_flag_c=0;
                            continue;
                        }

                        if ((fw_flag_c==2)|(fw_flag_c==3))
                            continue;

                        //New Complex Comment Handler END
                if(x==0)
                    FileContentLineByLineWithoutComments.add(curLine);
                x++;
                 //getCodeBlockType(curLine); 
            }    
            
           
            
            
        }
        
        int classCount=0;
        for(i=0;i<FileContentLineByLineWithoutComments.size();i++)
        {
            String blockType = getCodeBlockType(FileContentLineByLineWithoutComments.elementAt(i)).toString();
            
            //countVariables("1",FileContentLineByLineWithoutComments.elementAt(i).toString(),"");
                        

            
            switch(blockType) {
                case "class":
                    
                ClassDefinition cd = new ClassDefinition();  
                cd = SeperateClassDetails(cd);
                cd.content = (getEntireCodeBlock(i-1, "class")).toString();
                //cd.class_name=curClassIn.toString();   
                cd.class_line = LineCount;
                cd.startLineNo = i;
                //cd.ClassvariableList = variableList;
                
                for(int v=0;v<variableList.size();v++)
                {
                    cd.ClassvariableList.add(variableList.elementAt(v));
                }
                
                
                cd.variableCount = variableCount;
                ClassCodeBlocks.add(cd);
                
                
                
                chk_class_details.clear();
                classCount++;
                FilevariableCount = FilevariableCount + variableCount;
                variableCount = 0;
                
                break;

                case "method":

                MethodDefinition md = new MethodDefinition();  
                md = SeperateMethodDetails(md);
                md.content = (getEntireCodeBlock(i-1, "method")).toString();
                //cd.class_name=curClassIn.toString();  
                md.startLineNo = i;
                md.meth_line = LineCount;
                
                for(int v=0;v<tempVariableListPrimitive.size();v++)
                {
                    md.loc_variables.add(tempVariableListPrimitive.elementAt(v));
                }
                
                for(int v=0;v<tempVariableListParameter.size();v++)
                {
                    md.para_Defs.add(tempVariableListParameter.elementAt(v));
                }
                
                
                //md.loc_variables.add(tempVariableListPrimitive);
                //md.para_Defs.add(tempVariableListParameter);
                MethvariableCount = variableCount;
                
                md.variableCount = MethvariableCount;
                
                //variableList.removeAllElements();
                //tempVariableListPrimitive.removeAllElements();
                //tempVariableListParameter.removeAllElements();
                
                ClassDefinition cdTemp = (ClassDefinition) ClassCodeBlocks.elementAt(classCount-1);
                
                
                
                cdTemp.method_names.add(md);
                ClassCodeBlocks.removeElementAt(classCount-1);
                ClassCodeBlocks.add(classCount-1, cdTemp);
                MethodCodeBlocks.add(md);
                chk_method_details.clear();
                //FilevariableCount = FilevariableCount + variableCount;
                
                variableCount = 0;
                break;
            }
                    
            
        }
        
        
    }

     public void primitiveDataTYpes(String[] t)
      {
          for(int i=0;i<t.length;i++)
          { 
              for(int j=0;j<dataTypes.length;j++)
              {
                  if(t[i].equals(dataTypes[j]))
                  {
                      dataTypesCount[j] =  dataTypesCount[j] + 1;
                      variableCount++;
                  }              
              }
          }    
      }
      
     public  void countVariables(String val, String line, String pos,int lineNo)
     {
         String accessType="";
      
         String pat="(.*?),"; 
         String pat1="(.*?);";  
         Pattern p = Pattern.compile(pat);
         Pattern p1 = Pattern.compile(pat1);
         
         if(line.contains("public"))
         {
             accessType = "public";
         }
         else if(line.contains("protected"))
         {
             accessType = "protected";
         }
         else if(line.contains("private"))
         {
             accessType = "private";
         }
         
         
        
        String newLine=line;
          newLine = newLine.replaceAll("public ","");
          newLine = newLine.replaceAll("protected ","");
          newLine = newLine.replaceAll("private ","");
          newLine = newLine.replaceAll("static ","");
          
          try
          {
            if(newLine.matches("(.*?)=(.*?)\\((.*?)\\)(.*?)"))  
               newLine = newLine.substring(0,newLine.indexOf("="));
            if(newLine.matches("(.*?)<(.*?)>(.*?)"))
            {
                newLine = newLine.substring(0,newLine.indexOf("<")) + newLine.substring((newLine.indexOf(">"))+1);
                newLine = newLine + ";";
            }
          }
          catch(Exception ex)
          {
          }
          
          Matcher m = p.matcher(newLine);
         Matcher m1 = p1.matcher(newLine);
         // System.out.println(mLine);
          
          //mLine = mLine.trim().replace("\\s+", "");
         
         if(newLine.matches("(.*?)\\((.*?)\\)(.*?)"))
         {
                
                newLine = newLine.replaceAll("\\(", "\\( ");
                
                if(newLine.matches("(.*?)for\\((.*?)\\)(.*?)"))
                {
                    
                    m1 = p1.matcher(newLine);
//                    System.out.println(newLine);  
                    while(m1.find())
                    {
                        //System.out.println(m1.group(1)+ "-------------------------------- Primitive 1");
                        if(val.equals("2"))
                            extractVarDetails(m1.group(1),"Primitive",pos,accessType,lineNo);
                        else
                        {                        
                            String[] tokens=m1.group(1).split("\\s+");   
                            primitiveDataTYpes(tokens);
                        }
                    }
//                    System.out.println(line);  
                }
                else
                {
                   newLine = newLine.replaceAll("\\)", ",\\)");
                    m = p.matcher(newLine);
                    
                    while(m.find())
                    {
                        //System.out.println(newLine); 
                        String[] tokens=m.group(1).split("\\s+");   
                        
                        if(val.equals("2"))
                        {
                            try
                            {
                                if(!(m.group(1).matches("(.*?)\\(\\s+")))
                                {
                                    //System.out.println(m.group(1)+ "-------------------------------- Parameter 2");
                                    extractVarDetails(m.group(1),"Parameter",pos,accessType,lineNo);
                                }
                            }
                            catch(Exception ex)
                            {}
                        }
                        else
                        {     
							if(!(m.group(1).matches("(.*?)\\(\\s+")))
                                {
                            primitiveDataTYpes(tokens);
							}
                        }
                    }
                
                }
                
                
                
         }
         if((newLine.contains(",")))
         {
              while(m1.find())
                {
                 String[] tokens=m1.group(1).split("\\s+"); 
                 
                 
                 
                 //System.out.println(m1.group(1)+ "-------------------------------- Primitive 3");
                if(val.equals("2"))
                {
                    extractVarDetails(m1.group(1),"Primitive",pos,accessType,lineNo);
                }
                else
                {
                 
                    for(int i=0;i<tokens.length;i++)
                    { 
                        for(int j=0;j<dataTypes.length;j++)
                        {
                            if(tokens[i].equals(dataTypes[j]))
                            {

                                while (m.find()) {
                                countNum++;
                               // System.out.println(m.group(0));
                                //System.out.println(""+countNum);   
                                //variableCount++;
                                  } 
                                variableCount = variableCount + countNum;
                                dataTypesCount[j] =  dataTypesCount[j] + countNum; 
                                break;
                            }              
                        }

                    }  
                }
                 countNum=1; 
                
            }
         }
         else
         {
             while(m1.find())
            {
                
                if(val.equals("2"))
                {
                    if(!(m1.group(1).matches("(.*?)\\s+return\\s+(.*?)")))
                    {
                        //System.out.println(m1.group(1)+ "-------------------------------- Primitive 4");
                        extractVarDetails(m1.group(1),"Primitive",pos,accessType,lineNo);
                    }
                }
                else
                {
                    String[] tokens=m1.group(1).split("\\s+");
                    primitiveDataTYpes(tokens);
                }

            }
         }
              
           countNum=1;   
         
     }
    
     public void extractVarDetails(String dataLine, String vType, String pos,String aType,int LineNo)
     {
         String varName="";
         String varType="";
         Vector tempVars = new Vector<String>();
         
         
         
         dataLine = dataLine.trim().replaceAll("(.*?)\\(", "");
         dataLine = dataLine.trim().replaceAll("\\{", "");
         dataLine = dataLine.trim().replaceAll("\\}", "");
         //dataLine = dataLine.trim().replaceAll(" ", "");
         //dataLine = dataLine.trim().replaceAll("return\\s+(.*?)", "");
         //dataLine = dataLine.trim().replace("\\s+", "");
        try
        { 
            for(int j=0;j<dataTypes.length;j++)
            {
                    try
                    {
                    if(dataLine.substring(0,dataLine.indexOf(" ")).equals(dataTypes[j]))
                    {



                        varType = dataLine.substring(0,dataLine.indexOf(" "));

                        dataLine = dataLine.trim().replaceAll(varType+" ", "");

                        //Many Variables in One Line

                        String[] tokens=dataLine.split(",");

                        for(int i=0; i<tokens.length;i++)
                        {
                           // System.out.println(varType + " " + tokens[i] + " " + vType);
                            
                            //VariableDefinition vd = new VariableDefinition();
                            
                            
                            tokens[i] = tokens[i].trim().replaceAll("=.*", "");
                            VariableDefinition vd = new VariableDefinition();
                            vd.var_name = tokens[i];
                            vd.var_type = varType;
                            vd.var_par_or_prim = vType;
                            vd.accessType = aType;
                            vd.pos = pos;
                            vd.startLineNo = LineNo;
                            
                            if(vd.isParameter())
                            {
                                tempVariableListParameter.add(vd);
                                variableCount++;
                                variableList.add(vd);
                                //variableCount++;
                                //System.out.println("Done " + tokens[i] +" " +  md[methodCount+1].getMethodName());
                            }
                            else 
                            {
                                tempVariableListPrimitive.add(vd);
                                variableList.add(vd);
                                variableCount++;
                                //System.out.println("Done " + tokens[i] +" " +  md[methodCount+1].getMethodName());
                            }
                            
                        }

                        
                        
                        //md[methodCount-1].
                        //Varaibles inside brackets

                        //Normal Singular Variables



                        break;
                    }   
                    }
                    catch(Exception ex)
                    {}
                }

            }
        catch(Exception ex)
        {}    
             
            
         
         
         
         
         
     }
     
}


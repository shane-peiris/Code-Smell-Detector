/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CoreClasses;

import java.util.StringTokenizer;
import java.util.Vector;

/**
 *
 * @author Shane
 */
public class SeperateFileContent {
    
    public Vector<String> FileContentLineByLine=new Vector<String>();
    public Vector<String> FileContentLineByLineWithoutComments = new Vector<String>();

    public Vector<Object> ClassCodeBlocks=new Vector<Object>();

    public String delims = "\t\n,;{}[]().-<>&^%$@!-+\\/*'~\"= ";
    public int fw_flag_c=0;

    public int clzFlag=0;
    public int methodFlag=0;
    public int level=0;
    public int loopFlag=0;
    public int meth=0;
    public int countNum=1;
    public String curClassIn="";
    public int classLineCount;
    public int methodLineCount;
    
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
    
    public String getClassList(int i) 
    {
        return ClassCodeBlocks.elementAt(i).toString();
    }
    
    
    public String getCodeBlockType(String curLine)
    {
        
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
                curClassIn = curLine.substring(6,curLine.indexOf("{"));
              }
              catch(Exception ex)
              {
                curClassIn = curLine.substring(6);
              }
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
                //methodName = mLine.substring(0,mLine.indexOf("("));
                //System.out.println(methodName);
                //cd[classCount-1].methDefinition.add(methodName);

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
              
                //retType = mLine.substring(0,mLine.indexOf(" "));
               // System.out.println(retType);
                //curLine = curLine.replace(retType + " ", "");                       

                //methodName = mLine.substring(0,mLine.indexOf("("));
               // System.out.println(methodName);

                //cd[classCount-1].methDefinition.add(methodName);
     
                //md[methodCount+1] = new MethodDefinition();
                //md[methodCount+1].methodName = methodName;
                //md[methodCount+1].returnType = retType;
                //md[methodCount+1].methodLineCount=methodLineCount;
                  
              if((curLine.contains("{"))&(meth==1) & (curLine.substring(curLine.length()-1).equals("{")))
              {
                  level++;
                  meth++;
                 // methodCount++;
                  //cd[classCount-1].methDefs.add(methodName);
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
          else if((curLine.contains("{")))
          {
              level++;
              meth++;
          }
          else if((curLine.contains("}")))
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
                 //classLineCount++;
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
        
       
        
        for(int i=sPos;i<FileContentLineByLineWithoutComments.size();i++)
        {
          
            mLine= FileContentLineByLineWithoutComments.elementAt(i);
            mLine = mLine.trim().replaceAll("\\s+", " ");
          
          if((x==0)& !(mLine.endsWith("{") | mLine.endsWith("{(.*?)")))
          {
              blockDetails =blockDetails + FileContentLineByLineWithoutComments.elementAt(i).toString() + "\n";
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
          
          if((level==0) & !(x==0))
          {
              break;
          }
          
          blockDetails =blockDetails + FileContentLineByLineWithoutComments.elementAt(i).toString() + "\n";
          x++;
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
        
        for(i=0;i<FileContentLineByLineWithoutComments.size();i++)
        {
            String blockType = getCodeBlockType(FileContentLineByLineWithoutComments.elementAt(i)).toString();
            
            switch(blockType) {
                case "class":
                    
                    ClassDefinition cd = new ClassDefinition();                    
                    cd.content = (getEntireCodeBlock(i-1, "class")).toString();
                    cd.class_name=curClassIn.toString();   
                    cd.class_line = classLineCount;
                    ClassCodeBlocks.add(cd);
                    break;
            }
                    
            
        }
        
        
    }
    
}

package uibean;

import java.io.Serializable;  

import javax.faces.bean.ManagedBean; 
import javax.faces.bean.ManagedProperty; 
import javax.faces.bean.RequestScoped;  

@ManagedBean(name = "adBean", eager = true) 
@RequestScoped 
public class adBean implements Serializable {  
   private static final long serialVersionUID = 1L;  
   @ManagedProperty(value = "#{param.pageId}")    
   private String pageId;  
   
   
   public String showPage() { 
       
      if(pageId == null) {          
         return "index";       
      }
      if(pageId.equals("1")) {  
         return "infoPage1";       
      }else if(pageId.equals("2")) {  
         return "infoPage2";       
      }else if(pageId.equals("3")) {
         return "infoPage3";       
      }else {          
         return "index";       
      }    
   }  
   
   public String getPageId() {       
      return pageId;    
   }  
   
   public void setPageId(String pageId) {       
      this.pageId = pageId;   
   } 
} 
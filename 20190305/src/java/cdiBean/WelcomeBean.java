package cdiBean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;

@Named(value = "welcomeBean")
@ManagedBean
@RequestScoped
public class WelcomeBean {
    
    private String name = "123";
    
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String sayHello(){
        name += "*****";
        return "welcome";
    }
    
    public WelcomeBean() {
    }
    
}

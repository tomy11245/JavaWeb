/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uibeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.SelectItem;
import repository.Car;
import repository.CarRepositoryBean;

/**
 *
 * @author hychen39@gm.cyut.edu.tw
 */
@Named(value = "carSelectionBean")
@SessionScoped
public class CarSelectionBean implements Serializable{

    
    // Inject the car repository
    // DO NOT REMOVE THE CODE
    @EJB CarRepositoryBean repository;
    
    private String carMenu;
    
    private List<Car> selectItemList;
    private Car displayCar;
    
    public List<Car> getSelectItemList() {
        return repository.findAll();
    }
    
    
    public String getCarMenu() {
        return this.carMenu;
    }
    
    public void setCarMenu(String carMenu) {
        this.carMenu = carMenu;
    }
    
    /**
     * Action method to redirect to displayInfo facelets page.
     * @return target page name
     */
    
    public String displayInfo(){
        setDisplayCar(Integer.valueOf(this.carMenu));
        return "displayInfo?faces-redirect=true";
    }
    
    public String displayHome(){
        return "index?faces-redirect=true";
    }
    
    public Car getDisplayCar() {
        return this.displayCar;
    }
    
    public void setDisplayCar(int id) {
        this.displayCar = repository.query(id);
    }
}

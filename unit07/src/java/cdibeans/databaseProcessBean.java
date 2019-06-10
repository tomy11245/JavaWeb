/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdibeans;

import ejb.ItemFacade;
import entitys.Item;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author mnba3
 */
@Named(value = "databaseProcessBean")
@SessionScoped
public class databaseProcessBean implements Serializable {

    /**
     * Creates a new instance of databaseProcessBean
     */
    public databaseProcessBean() {
    }

    @EJB
    private ItemFacade itemFacade;

    private Item newItem;
    private Item moditfyItem;

    public Item getNewItem() {
        return newItem;
    }

    public void setNewItem(Item newItem) {
        this.newItem = newItem;
    }

    public Item getModitfyItem() {
        return moditfyItem;
    }

    public void setModitfyItem(Item moditfyItem) {
        this.moditfyItem = moditfyItem;
    }

    public List<Item> findAll() {
        return itemFacade.findAll();
    }

    public String goNewItemPage() {
        this.newItem = new Item();
        return "createItem";
    }

    public String gomoditfyItemPage(long id) {
        this.moditfyItem = itemFacade.find(id);
        return "modifyItem";
    }

    public String addItem() {
        itemFacade.create(newItem);
        return "itemList";
    }

    public String modifyItem() {
        this.itemFacade.edit(this.moditfyItem);
        return "itemList";
    }

    public String RemoveItem(Item item) {
        this.itemFacade.remove(item);
        return "itemList";
    }
}

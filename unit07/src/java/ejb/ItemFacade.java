/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entityControl.AbstractFacade;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import entitys.Item;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author mnba3
 */
@Stateless
@LocalBean
public class ItemFacade extends AbstractFacade<Item> {
    @PersistenceContext(unitName = "unit07PU")
    private EntityManager em;
    
    // default constructor
    public ItemFacade() {
        super(Item.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}

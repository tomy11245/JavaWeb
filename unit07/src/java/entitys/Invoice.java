/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitys;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 *
 * @author mnba3
 */
@Entity
public class Invoice implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    
     @ManyToMany
    //#3
    @JoinTable(name = "ORDER_LINE_SHIPMENT_JOIN", 
                // foreign-key column name in the owning side
               joinColumns = @JoinColumn(name="LINE_FK", referencedColumnName = "ID"), 
               // foeign-key column name in the non-owning side.
               inverseJoinColumns = @JoinColumn(name="SHIP_FK" , referencedColumnName = "ID"))
    // #2
    private Collection<Shipment> shipments;

    public Collection<Shipment> getShipments() {
        return shipments;
    }

    public void setShipments(Collection<Shipment> shipments) {
        this.shipments = shipments;
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Invoice)) {
            return false;
        }
        Invoice other = (Invoice) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitys.Invoice[ id=" + id + " ]";
    }
    
}

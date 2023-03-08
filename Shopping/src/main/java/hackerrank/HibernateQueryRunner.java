package hackerrank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;
import javax.persistence.TypedQuery;
import org.hibernate.HibernateException;
import persistent.Item;

public class HibernateQueryRunner {
    /**
     * @param hql A Hibernate Query Language string.
     * @param namedParameters An optional mapping of named parameters to their respective values for the query.
     * @return An ArrayList of Items
     */
    static ArrayList<Item> getItemsList(String hql, Optional<HashMap<String, Object>> namedParameters) {
        ArrayList<Item> itemsList = null;
        
        try {
            @SuppressWarnings("unchecked")
			TypedQuery<Item> query = HibernateSessionHelper.session.createQuery(hql);
            
            if (namedParameters.isPresent()) {
                namedParameters.get().forEach(query::setParameter);
            }
            
            itemsList = (ArrayList<Item>) query.getResultList();
        } catch (HibernateException e) {
            System.out.println(e.getLocalizedMessage());
            
            throw new ExceptionInInitializerError(e);
        }
        
        return itemsList;
    }
    
    /**
     * @param hql A Hibernate Query Language string.
     * @param namedParameters An optional mapping of named parameters to their respective values for the query.
     * @return item An item.
     */
    static Item getSingleItem(String hql, Optional<HashMap<String, Object>> namedParameters) {
        Item item = null;
        
        try {
            @SuppressWarnings("unchecked")
			TypedQuery<Item> query = HibernateSessionHelper.session.createQuery(hql);
            
            if (namedParameters.isPresent()) {
                namedParameters.get().forEach(query::setParameter);
            }
            
            item = query.getSingleResult();
        } catch (HibernateException e) {
            System.out.println(e.getLocalizedMessage());
            
            throw new ExceptionInInitializerError(e);
        }
        
        return item;
    }
}

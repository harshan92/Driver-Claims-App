/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database.Models;


import Database.Entities.Payments;
import Database.Utils.DBAccessUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author sean
 */
public class PaymentModel {
    
    
     public static enum ATTRIBUTES
    {
        ID("id") // Should be a int
        ,MEMBER_ID("mem_id") // Should be a int 
        ,TYPE_OF_PAYMENT("type_of_payment")// Should be a String 
        ,AMOUNT("amount") // Should be a float
        ,RATIONALE("rationale") // Should be a String  
        ,DATE("date") // Should be a Date in format 1996-01-29
        ,TIME("time");// Should be a time
        
        
        private final String propertyName;
        ATTRIBUTES(String property)
        {
            this.propertyName = property;
        }
        
        public String getValue()
        {
            return this.propertyName;
        }
    }
     
     
    public PaymentModel()
    {
        
    }
    
    
    /**
     * Get all the Payments in the database in a list
     * @return list of all Payments or empty list
     */
    public List<Payments>  getPayments()
    {
        List<Payments> paymentsList = (List<Payments>) new ArrayList<Payments>();
        try 
        {
            DBAccessUtil.getSession().beginTransaction();
            Criteria crit = DBAccessUtil.getSession().createCriteria(Payments.class);         
            paymentsList = crit.list();
         
        } catch (Exception e) {
            e.printStackTrace();
        }finally
        {
             DBAccessUtil.getSession().close();
        }
        return paymentsList;
        
    }
    
    
     /**
     * Get all the Payments in the database in a list with desired attribute
     * @return list of all Payments with desired attribute or empty list
     */
    public List<Payments>  getPayments(ATTRIBUTES property, Object value)
    {
        List<Payments> paymentsList = (List<Payments>) new ArrayList<Payments>();
        try 
        {
            DBAccessUtil.getSession().beginTransaction(); 
            Criteria crit = null;
            
            if(value.getClass().equals(String.class))
            {
                crit = DBAccessUtil.getSession().createCriteria(Payments.class).add(Restrictions.ilike(property.getValue(), (String) value,MatchMode.ANYWHERE));         
            
            }else
            {
                crit = DBAccessUtil.getSession().createCriteria(Payments.class).add(Restrictions.ilike(property.getValue(), value));         
            } 
            paymentsList = crit.list();
         
        } catch (Exception e) {
            e.printStackTrace();
        }finally
        {
             DBAccessUtil.getSession().close();
        }
        return paymentsList;
        
    }
    
    
     /**
     * Get a payment in the database by ID unique 
     * @return  a Payment or null
     */
    public Payments  getPayment( int id)
    {
        Payments payment = null;
        try 
        {
            DBAccessUtil.getSession().beginTransaction(); 
            Query q = DBAccessUtil.getSession().createQuery("from Payments as p where p.id = " +id);
            payment = (Payments) q.uniqueResult();
         
        } catch (Exception e) {
            e.printStackTrace();
        }finally
        {
             DBAccessUtil.getSession().close();
        }
        return payment;
        
    }
    
     /**
     * Used to add or update a Payment
     * @param payment : Payment to be updated or added
     */
    
    public void saveMember(Payments payment)
    {
        try 
        {
           Transaction tx=   DBAccessUtil.getSession().beginTransaction(); 
           DBAccessUtil.getSession().saveOrUpdate(payment);
           tx.commit();
         
        } catch (Exception e) {
            e.printStackTrace();
        }finally
        {
             DBAccessUtil.getSession().close();
        }
    }
    
    
    
}

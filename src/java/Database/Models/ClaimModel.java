/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database.Models;

import Database.Entities.Claims;
import Database.Utils.DBAccessUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author sean
 */
public class ClaimModel {
    
     public static enum ATTRIBUTES
    {
        ID("id") // Should be a int
        ,MEMBER_ID("mem_id") // Should be a String  
        ,DATE("date") // Should be a Date in format 1996-01-29
        ,RATIONALE("rationale") // Should be a String  
        ,STATUS("status") // Should be a String  
        ,AMOUNT("amount"); // Should be a float
        
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
    public  List<Claims>  getMemberClaims(String member_id){
        List<Claims> list = new ArrayList<Claims>();
        Session session = DBAccessUtil.getSession();
        Transaction tx = null;       
        try {
            tx = session.getTransaction();
            tx.begin();
            list = session.createQuery("FROM claims WHERE members_id="+member_id).list();                       
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            
        }
        return list;
    }
     
     public ClaimModel()
     {
         
     }
     
     
     /**
     * Get all the Claims in the database in a list
     * @return list of all Claims or empty list
     */
    public List<Claims>  getClaims()
    {
        List<Claims> claimsList = (List<Claims>) new ArrayList<Claims>();
        try 
        {
            DBAccessUtil.getSession().beginTransaction();
            Criteria crit = DBAccessUtil.getSession().createCriteria(Claims.class);         
            claimsList = crit.list();
         
        } catch (Exception e) {
            e.printStackTrace();
        }finally
        {
             DBAccessUtil.getSession().close();
        }
        return claimsList;
        
    }
    
    /**
     * Get all the Claims in the database in a list with desired attribute
     * @param property
     * @param value
     * @return list of all Claims with desired attribute or empty list
     */
    public List<Claims>  getClaims(ATTRIBUTES property, Object value)
    {
        List<Claims> claimsList = (List<Claims>) new ArrayList<Claims>();
        try 
        {
            DBAccessUtil.getSession().beginTransaction(); 
            Criteria crit = null;
            
            if(value.getClass().equals(String.class))
            {
                crit = DBAccessUtil.getSession().createCriteria(Claims.class).add(Restrictions.ilike(property.getValue(), (String) value,MatchMode.ANYWHERE));         
            
            }else
            {
                crit = DBAccessUtil.getSession().createCriteria(Claims.class).add(Restrictions.ilike(property.getValue(), value));         
            } 
            
            claimsList = crit.list();
         
        } catch (Exception e) {
            e.printStackTrace();
        }finally
        {
             DBAccessUtil.getSession().close();
        }
        return claimsList;
        
    }
    
    /**
     * Get a member in the database by ID unique 
     * @return  a Claim or null
     */
    public Claims  getClaim( int id)
    {
        Claims claim = null;
        try 
        {
            DBAccessUtil.getSession().beginTransaction(); 
            Query q = DBAccessUtil.getSession().createQuery("from Claims as c where c.id = " +id);
            claim = (Claims) q.uniqueResult();
         
        } catch (Exception e) {
            e.printStackTrace();
        }finally
        {
             DBAccessUtil.getSession().close();
        }
        return claim;
        
    }
    
    /**
     * Used to add or update a Claims 
     * @param claim : Claims to be updated or added
     */
    
    public void saveClaim(Claims claim)
    {
        try 
        {
           Transaction tx=   DBAccessUtil.getSession().beginTransaction(); 
           DBAccessUtil.getSession().saveOrUpdate(claim);
           tx.commit();
         
        } catch (Exception e) {
            e.printStackTrace();
        }finally
        {
             DBAccessUtil.getSession().close();
        }
    }
    
    
    
     
    
    
}

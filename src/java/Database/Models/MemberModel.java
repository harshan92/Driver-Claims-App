/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database.Models;

import Database.Entities.Members;
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
public class MemberModel {
    
    
    public static enum ATTRIBUTES
    {
        ID("id") // Should be a int
        ,NAME("name") // Should be a String 
        ,ADDRESS("address") // Should be a String
        ,DOB("dob") // Should be a Date in format 1996-01-29
        ,DOR("dor") // Should be a Date in format 1996-01-29
        ,BALANCE("balance"); // Should be a float
        
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
    
    public MemberModel()
    {
        
    }
   
    /**
     * Get all the members in the database in a list
     * @return list of all members or empty list
     */
    public List<Members>  getMembers()
    {
        List<Members> memebersList = (List<Members>) new ArrayList<Members>();
        try 
        {
            DBAccessUtil.getSession().beginTransaction();
            Criteria crit = DBAccessUtil.getSession().createCriteria(Members.class);         
            memebersList = crit.list();
         
        } catch (Exception e) {
            e.printStackTrace();
        }finally
        {
             DBAccessUtil.getSession().close();
        }
        return memebersList;
        
    }
    
    /**
     * Get all the members in the database in a list with desired attribute
     * @return list of all members with desired attribute or empty list
     */
    public List<Members>  getMembers(ATTRIBUTES property, Object value)
    {
        List<Members> memebersList = (List<Members>) new ArrayList<Members>();
        try 
        {
            DBAccessUtil.getSession().beginTransaction(); 
            Criteria crit = null;
            
            if(value.getClass().equals(String.class))
            {
                crit = DBAccessUtil.getSession().createCriteria(Members.class).add(Restrictions.ilike(property.getValue(), (String) value,MatchMode.ANYWHERE));         
            
            }else
            {
                crit = DBAccessUtil.getSession().createCriteria(Members.class).add(Restrictions.ilike(property.getValue(), value));         
            } 
            memebersList = crit.list();
         
         
        } catch (Exception e) {
            e.printStackTrace();
        }finally
        {
             DBAccessUtil.getSession().close();
        }
        return memebersList;
        
    }
    
    /**
     * Get a member in the database by ID unique 
     * @return  a Member or null
     */
    public Members  getMember( int id)
    {
        Members memeber = null;
        try 
        {
            DBAccessUtil.getSession().beginTransaction(); 
            Query q = DBAccessUtil.getSession().createQuery("from Members as m where m.id = " +id);
            memeber = (Members) q.uniqueResult();
         
        } catch (Exception e) {
            e.printStackTrace();
        }finally
        {
             DBAccessUtil.getSession().close();
        }
        return memeber;
        
    }
    
    /**
     * Used to add or update a member 
     * @param member : member to be updated or added
     */
    
    public void saveMember(Members member)
    {
        try 
        {
           Transaction tx=   DBAccessUtil.getSession().beginTransaction(); 
           DBAccessUtil.getSession().saveOrUpdate(member);
           tx.commit();
         
        } catch (Exception e) {
            e.printStackTrace();
        }finally
        {
             DBAccessUtil.getSession().close();
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}

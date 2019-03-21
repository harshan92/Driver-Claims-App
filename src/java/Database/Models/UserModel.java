/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database.Models;


import Database.Entities.Members;
import Database.Entities.Users;
import Database.Utils.DBAccessUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author sean
 */
public class UserModel {
    
     public static enum ATTRIBUTES
    {
        ID("id") // Should be a int
        ,PASSWORD("password") // Should be a String 
        ,STATUS("status") // Should be a String
        ,USERNAME("username") // Should be a String
        ,MEMBER_ID("members_id") // Should be a int
        ,USER_TYPE("usertype"); // Should be a String
        
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
     
     
     
     public  UserModel()
     {
         
     }
    
    
    
    
    /**
     * Get all the users in the database in a list
     * @return list of all Users or empty list
     */
    public List<Users>  getUsers()
    {
        List<Users> usersList = (List<Users>) new ArrayList<Users>();
        try 
        {
            DBAccessUtil.getSession().beginTransaction();
            Criteria crit = DBAccessUtil.getSession().createCriteria(Users.class);         
            usersList = crit.list();
         
        } catch (Exception e) {
            e.printStackTrace();
        }finally
        {
             DBAccessUtil.getSession().close();
        }
        return usersList;
        
    }
    
    
    /**
     * Get all the Users in the database in a list with desired attribute
     * @return list of all Users with desired attribute or empty list
     */
    public List<Users>  getUsers(ATTRIBUTES property, Object value)
    {
        List<Users> usersList = (List<Users>) new ArrayList<Users>();
        try 
        {
            DBAccessUtil.getSession().beginTransaction(); 
            Criteria crit = null;
            
            if(value.getClass().equals(String.class))
            {
                crit = DBAccessUtil.getSession().createCriteria(Users.class).add(Restrictions.ilike(property.getValue(), (String) value,MatchMode.ANYWHERE));         
            
            }else
            {
                crit = DBAccessUtil.getSession().createCriteria(Users.class).add(Restrictions.ilike(property.getValue(), value));         
            } usersList = crit.list();
            
         
        } catch (Exception e) {
            e.printStackTrace();
        }finally
        {
             DBAccessUtil.getSession().close();
        }
        return usersList;
        
    }
    
    
    /**
     * Get a User in the database by ID unique 
     * @return  a Users or null
     */
    public Users  getUser( int id)
    {
        Users user = null;
        try 
        {
            DBAccessUtil.getSession().beginTransaction(); 
            Query q = DBAccessUtil.getSession().createQuery("from Users as u where u.id = " +id);
            user = (Users) q.uniqueResult();
         
        } catch (Exception e) {
            e.printStackTrace();
        }finally
        {
             DBAccessUtil.getSession().close();
        }
        return user;
        
    }
    
    
    /**
     * Used to add or update a member 
     * @param user : user to be updated or added
     */
    
    public void saveMember(Users user)
    {
        try 
        {
           Transaction tx=   DBAccessUtil.getSession().beginTransaction(); 
           DBAccessUtil.getSession().saveOrUpdate(user);
           tx.commit();
         
        } catch (Exception e) {
            e.printStackTrace();
        }finally
        {
             DBAccessUtil.getSession().close();
        }
    
    }
    
    public void initializeUser(Users user)
    {
        try 
        {
           Transaction tx=   DBAccessUtil.getSession().beginTransaction(); 
           Hibernate.initialize(user);
           
         
        } catch (Exception e) {
            e.printStackTrace();
        }finally
        {
             DBAccessUtil.getSession().close();
        }
        
    }
    
    
}

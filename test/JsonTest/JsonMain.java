/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JsonTest;

import Database.Entities.Members;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sean
 */
public class JsonMain {
    
    
    
    
    
    public static void main(String[] args) {
        
        
        List<Members> members = new ArrayList<Members>();
        for(int i =0; i<5; i++)
        {
            members.add(new Members(100.5f));
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<Members>>(){}.getType();
        String json = gson.toJson(members, type);
        System.out.println(json);
        List<Members> fromJson = gson.fromJson(json, type);

        for (Members task : fromJson) {
            System.out.println(task);
        }

        
        
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.sql.Connection;
import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.*;

/**
 *
 * @author gruselle
 */
public class Connexion
{
    private static DataSource mDataSource;
    
    public static Connection getConnection() throws Exception 
    {
        Hashtable vEnv = new Hashtable();
        vEnv.put("org.omg.CORBA.ORBInitialHost", "127.0.0.1");
        vEnv.put("org.omg.CORBA.ORBInitialPort", "3700");
        Context c = new InitialContext(vEnv);
        
        mDataSource = (DataSource) c.lookup("jdbc/SEBO2014");

        return mDataSource.getConnection();
    }
   
}

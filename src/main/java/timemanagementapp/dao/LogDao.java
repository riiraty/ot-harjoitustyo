
package timemanagementapp.dao;

import timemanagementapp.domain.Log;
import java.sql.*;

public interface LogDao {
    
    Log create(Log log) throws SQLException;
    
    Log delete(int id) throws SQLException;
    
    Log edit(int id) throws SQLException;
    
}

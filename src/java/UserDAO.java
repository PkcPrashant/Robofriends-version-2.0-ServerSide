import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDAO 
{

    public static ArrayList<UserDTO> getUser()throws SQLException
    {
      Connection conn=DBConnection.getConnection();
      ArrayList<UserDTO> users = new ArrayList<>();
      PreparedStatement ps=conn.prepareStatement("select id, name, email from Users");
      ResultSet rs=ps.executeQuery();
      
      while(rs.next())
      {
          int id=Integer.parseInt(rs.getString(1));
          String name=rs.getString(2);
          String email=rs.getString(3);
          users.add(new UserDTO(id, name, email));
      }
      
      return users;
    }
}
    
    
            
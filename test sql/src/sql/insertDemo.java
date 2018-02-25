package sql;

import java.sql.*;  
class insertDemo{  
    public static void main(String[] args) throws SQLException{  
        String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";   
        String dbURL = "jdbc:sqlserver://localhost; DatabaseName=JXGL";   
        String userName = "sa"; //默认用户名  
        String userPwd = "19970521"; //安装sql server 2005时的密码  
         ResultSet rs=null;    //声明数据库结果集      
         PreparedStatement stmt=null; //声明数据库操作  
        Connection conn=null;  
          String aa="8",bb="毛概",cc="12";  int dd=5;  
        try {  
        Class.forName(driverName);  
        conn = DriverManager.getConnection(dbURL, userName, userPwd);  
        System.out.println("Connection Successful!"); //如果连接成功 控制台输出Connection Successful!  
        String sql="insert into Course values (?,?,?,?)";  
        stmt=conn.prepareStatement(sql);//实例化PrepareStatement对象  
        stmt.setString(1, aa);  
        stmt.setString(2, bb);  
        stmt.setString(3, cc);  
        stmt.setInt(4, dd);  
        stmt.executeUpdate();  
        } catch (Exception e) {  
        e.printStackTrace();  
    }finally{  
  
        stmt.close();  
        conn.close();  
    }  
    }  
  
}  
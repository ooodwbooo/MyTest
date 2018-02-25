package sql;

import java.sql.*;  
class deleteDemo{  
    public static void main(String[] args) throws SQLException{  
        String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";   
        String dbURL = "jdbc:sqlserver://localhost; DatabaseName=MyDB";   
        String userName = "root1"; //默认用户名  
        String userPwd = "123456"; //安装sql server 2005时的密码  
         ResultSet rs=null;    //声明数据库结果集      
         PreparedStatement stmt=null; //声明数据库操作  
        Connection conn=null;  
          String aa="8",bb="毛概",cc="12";  int dd=5;  
        try {  
        Class.forName(driverName);  
        conn = DriverManager.getConnection(dbURL, userName, userPwd);  
        System.out.println("Connection Successful!"); //如果连接成功 控制台输出Connection Successful!  
        String sql="delete from Course where Cno=?";  
        stmt=conn.prepareStatement(sql);//实例化PrepareStatement对象  
        stmt.setString(1, "8");  
        stmt.executeUpdate();  
        } catch (Exception e) {  
        e.printStackTrace();  
    }finally{  
  
        stmt.close();  
        conn.close();  
    }  
    }  
  
}  
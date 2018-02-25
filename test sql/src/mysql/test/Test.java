package mysql.test;
import java.sql.*;  
class Test{  
      
    public static void main(String[] args) throws SQLException{  
        String driverName = "com.mysql.jdbc.Driver";   
        String dbURL = "jdbc:mysql://localhost:3306/test?useSSL=true";   
        String userName = "root"; //默认用户名  
        String userPwd = "19970521"; //安装sql server 时的密码  
        String sql="select * from test"; 
        ResultSet rs=null;    //声明数据库结果集     
         PreparedStatement pstmt=null; //声明数据库操作  
         Connection conn=null;  
        try {  
        Class.forName(driverName);  
        conn = DriverManager.getConnection(dbURL, userName, userPwd);  
        System.out.println("连接成功!"); //如果连接成功 控制台输出!  
        pstmt=conn.prepareStatement(sql); //实例化PrepareStatement对象  
         rs=pstmt.executeQuery();  //执行查询操作  
        while(rs.next()){  
            String a=rs.getString(1);  
            String b=rs.getString(2);  

            System.out.println(a+" "+b);  
        }  
        } catch (Exception e) {  
        e.printStackTrace();  
    }finally{  
        rs.close();  
        pstmt.close();  
        conn.close();  
    }  
    }  
  
}  

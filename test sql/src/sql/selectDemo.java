package sql;

import java.sql.*;  
class selectDemo{  
    public static void main(String[] args) throws SQLException{  
        String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";  //com.microsoft.sqlserver.jdbc 
        String dbURL = "jdbc:sqlserver://localhost:1434; DatabaseName=user";   
        String userName = "sa"; //默认用户名  
        String userPwd = "19970521"; //安装sql server 2005时的密码  
         ResultSet rs=null;    //声明数据库结果集      
         PreparedStatement pstmt=null; //声明数据库操作  
         Connection conn=null;  
        try {  
        Class.forName(driverName);  
        conn = DriverManager.getConnection(dbURL, userName, userPwd);  
        System.out.println("Connection Successful!"); //如果连接成功 控制台输出Connection Successful!  
        String sql="select * from us2";  
        pstmt=conn.prepareStatement(sql); //实例化PrepareStatement对象  
         rs=pstmt.executeQuery();  //执行查询操作  
        while(rs.next()){
            String a=rs.getString(1);  
            String b=rs.getString(2);  
            String c=rs.getString(3);  
            int d=rs.getInt(4);  
            System.out.println(a+" "+b+" "+c+" "+d);  
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
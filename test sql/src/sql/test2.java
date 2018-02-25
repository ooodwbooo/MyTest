package sql;
import java.sql.*;

import javax.swing.JOptionPane;  
class test2{  
      
    public static void main(String[] args) throws SQLException{  
    	String [] columnName;  
    	String [][] record; 
        Connection con;
        PreparedStatement sql; 
        ResultSet rs;
        String userName = "sa"; //默认用户名  
        String userPwd = "19970521"; //安装sql server 2005时的密码
        try { 
        	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        	}
        catch (Exception e) {  
            e.printStackTrace();  
        }
        try { 
          String uri="jdbc:sqlserver://localhost:1434; DatabaseName=user"; 
          con=DriverManager.getConnection(uri, userName, userPwd);
          String SQL="select * from us2"; 
          sql=con.prepareStatement(SQL,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
          rs=sql.executeQuery();  
          ResultSetMetaData metaData = rs.getMetaData();
          int columnCount = metaData.getColumnCount();
          columnName=new String[columnCount]; 
          for(int i=1;i<=columnCount;i++){
              columnName[i-1]=metaData.getColumnName(i);
              System.out.printf("%-15S",columnName[i-1]);
          } 
          System.out.print("\n");
          rs.last(); 
          int recordAmount =rs.getRow();//结果集中的记录
          record = new String[recordAmount][columnCount];
          int i=0;
          rs.beforeFirst();
          while(rs.next()) { 
            for(int j=1;j<=columnCount;j++){
               record[i][j-1]=rs.getString(j);
               System.out.printf("%-15S",record[i][j-1]);
            }
            System.out.print("\n");
            i++;
          }
          con.close();
        }
        catch(SQLException e) {
          System.out.println("请输入正确的表名"+e);
          JOptionPane.showMessageDialog
          (null,"输入有误"+e,"消息对话框", JOptionPane.WARNING_MESSAGE);
        }
    }  
  
}  
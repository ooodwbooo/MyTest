package pre;
import java.sql.*;

import javax.swing.JOptionPane;   
public class PreQuery {
   String databaseName="";    	//数据库名
   String SQL;        		//SQL语句
   String [] columnName;  
   String [][] record; 
   int m;   
   public PreQuery() {
      try{  Class.forName("com.mysql.jdbc.Driver");
      System.out.println("驱动加载成功");
      }
      catch(Exception e) {
         System.out.print(e);
      }
   }
   public void setDatabaseName(String s) {  
      databaseName=s.trim();
   }
   public void setSQL(String SQL) {
      this.SQL=SQL.trim();
   }
   public String[] getColumnName() {
       
       return columnName;
   }
   public String[][] getRecord() {
        
       return record;
   }
   public int returnm(){
	   return m;
   }
   public void startQuery() { 
      Connection con;
      PreparedStatement sql; 
      ResultSet rs;
      try { 
    	  String userName = "root"; //默认用户名  
          String userPwd = "19970521"; //安装sql server 2005时的密码
          String uri="jdbc:mysql://localhost:3306/"+databaseName+"?useSSL=true"; 
          System.out.println("连接初始化");
          con=DriverManager.getConnection(uri, userName, userPwd);
          System.out.println("连接成功");
          sql=con.prepareStatement(SQL,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
          rs=sql.executeQuery();  
          ResultSetMetaData metaData = rs.getMetaData();
          int columnCount = metaData.getColumnCount();
          columnName=new String[columnCount]; 
          for(int i=1;i<=columnCount;i++){
              columnName[i-1]=metaData.getColumnName(i);
          } 
          rs.last(); 
          int recordAmount =rs.getRow();//结果集中的记录
          record = new String[recordAmount][columnCount];
          int i=0;
          rs.beforeFirst();
          while(rs.next()) { 
            for(int j=1;j<=columnCount;j++){
               record[i][j-1]=rs.getString(j);
            }
            i++;
          }
          con.close();
          System.out.println("连接断开");
        }
        catch(SQLException e) {
          System.out.println("请输入正确的表名"+e);
          JOptionPane.showMessageDialog
          (null,"输入有误"+e,"消息对话框", JOptionPane.WARNING_MESSAGE);
        }
     }    
  }

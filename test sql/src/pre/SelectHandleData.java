package pre;

import java.awt.event.*;

public class SelectHandleData implements ActionListener {    
   String [][] a;
   PreQuery query;
   int m;
   SelectHandleData() {
      query=new PreQuery();
   }
   public void setArray(String [][] a) {
      this.a =a;
   }
   @Override
public void actionPerformed(ActionEvent e) {  
	 //监听各个按钮
	   String lie="";
	 		if(e.getActionCommand()=="按用户名排序")
	 		{
	 			 lie="username";
	 		}
	 		else if(e.getActionCommand()=="按密码排序"){
	 			lie="password";
	 		}
	 		else if(e.getActionCommand()=="按权限排序"){
	 			lie="power";
	 		}
	 		String table="usertest";
	 		query.setDatabaseName("test");
	 		query.setSQL("SELECT * FROM "+table+" ORDER BY "+lie);
	        query.startQuery();
	        String ziduan[] =query.getColumnName();
	        String [][]record =query.getRecord();
	        DialogOne dialog = new DialogOne(); 
	        dialog.setZiduan(ziduan);
	        dialog.setRecord(record);
	        dialog.init(); 
	        dialog.setVisible(true);
   }
}
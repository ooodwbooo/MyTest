package pre;

import java.sql.SQLException;
import javax.swing.*;

public class SelectView extends JFrame {
   JButton button;
   SelectHandleData handle; 
   SelectView() {
      setLayout(null);
      setBounds(100,30,600,300);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      button = new JButton("按用户名排序");
      JButton button2 = new JButton("按密码排序");
      JButton button3 = new JButton("按权限排序");
 
      add(button);
      add(button2);
      add(button3);
      
      button.setBounds(100,30,120,30);  
      button2.setBounds(250,30,120,30);
      button3.setBounds(400,30,120,30);
      handle = new SelectHandleData();  //数据的处理者
      button.addActionListener(handle);
      button2.addActionListener(handle);
      button3.addActionListener(handle);
   }
}

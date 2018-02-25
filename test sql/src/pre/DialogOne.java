package pre;

import javax.swing.*;

@SuppressWarnings("serial")
public class DialogOne extends JDialog {
   JTable table;
   String ziduan[];
   String record[][];
   DialogOne() {
      setTitle("显示记录");
      setBounds(400,200,600,300);
      setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
   }
   public void setZiduan(String []ziduan){
      this.ziduan=ziduan;
   }
   public void setRecord(String [][]record){
      this.record=record;
   }
   public void init() {
       table = new JTable(record,ziduan);
       add(new JScrollPane(table));
   }
} 
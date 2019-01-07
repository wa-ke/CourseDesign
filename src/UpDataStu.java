import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class UpDataStu extends JDialog {
    public UpDataStu(ActionListener owner, String title) throws SQLException {
        this.setBounds(100,100,600,400);
        setLayout(null);
//        JButton button=new JButton("确认修改");
//        JButton button1=new JButton("取消");
        JPanel jPanel=new JPanel();
        jPanel.setBounds(0,0,this.getWidth(),this.getHeight());
//        jPanel.add(button);
//        jPanel.add(button1);
        add(jPanel);
        DefaultTableModel model=new DefaultTableModel();
        model.setColumnIdentifiers(new Object[6]);
        model.addRow(new Object[]{"学号","姓名","性别","年龄","电话号码","地址"});
        Conn conn=new Conn();
        String sql="select * from stu";
        ResultSet resultSet=conn.select(sql);
        while (resultSet.next()){
            String stunum=resultSet.getString("stunum");
            String stuname=resultSet.getString("stuname");
            String stusex=resultSet.getString("stusex");
            String stuage=resultSet.getString("stuage");
            String stupho=resultSet.getString("stupho");
            String stuadd=resultSet.getString("stuadd");
            model.addRow(new Object[]{stunum,stuname,stusex,stuage,stupho,stuadd});
        }
        JTable jTable=new JTable(model);
        model.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                int row=jTable.getSelectedRow();
                int col=jTable.getSelectedColumn();
                String stuCount="select count(*) from stu";
                ResultSet set=conn.select(stuCount);
                int count=0;
                try {
                    while (set.next()){
                        count=set.getInt(1);
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
//                int[] numArr=new int[count];
//                String pullNum="select stunum from stu";
//                ResultSet set1=conn.select(pullNum);
//                int i=0;
//                try{
//                    while (set1.next()){
//                        numArr[i]=set1.getInt(1);
//                        i++;
//                    }
//                } catch (SQLException e1) {
//                    e1.printStackTrace();
//                }
//                System.out.println(numArr[row-1]);
//                System.out.println(jTable.getValueAt(row,0));
//                System.out.println(jTable.getValueAt(0,col));
//                System.out.println(jTable.getValueAt(row,col));
//                String name=new String();
//
//                System.out.println(name);
                String rowName= (String) jTable.getValueAt(0,col);
                String stuNum= (String) jTable.getValueAt(row,0);
                Map<String,String> map=new HashMap<>();
                map.put("学号","stunum");
                map.put("姓名","stuname");
                map.put("年龄","stuage");
                map.put("性别","stusex");
                map.put("电话号码","stupho");
                map.put("地址","stuadd");
                String colName=map.get(rowName);
                String updateData= (String) jTable.getValueAt(row,col);
//                System.out.println(colName);
//                String sql1="update stu set "+colName+" =  '"+updateData+"'  where 'stunum' = "+stuNum+"";
                String sql1="update stu set "+colName+" = '"+updateData+"' where stunum = '"+stuNum+"'";
                conn.updata(sql1);
//                System.out.println(map.get(na));

            }
        });
        jTable.setPreferredSize(new Dimension(jPanel.getWidth(),jPanel.getHeight()));
        jPanel.add(jTable);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    Pann pann=new Pann();
                    pann.setVisible(true);

                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }

    //    public static void main(String[] args) throws SQLException {
//        JFrame jFrame=new JFrame();
//        jFrame.setBounds(100,100,800,600);
//        UpDataStu upDataStu=new UpDataStu(jFrame,"demo");
//        jFrame.setVisible(true);
//        upDataStu.setVisible(true);
//    }
}

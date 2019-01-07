import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DelStu extends JDialog {
    public DelStu(Frame owner, String title) throws SQLException {
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
        JButton jButton=new JButton("确认删除");
        jPanel.add(jButton,BorderLayout.SOUTH);
        JTable jTable=new JTable(model);
        jTable.setPreferredSize(new Dimension(jPanel.getWidth(),jPanel.getHeight()));
        jPanel.add(jTable);

        jTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
               if (e.getValueIsAdjusting()){
                   int row =jTable.getSelectedRow();
                   String stuNum=(String) jTable.getValueAt(row,0);
//                   System.out.println(row);
//                   System.out.println(jTable.getValueAt(row,0));
                   jButton.addActionListener(new ActionListener() {
                       @Override
                       public void actionPerformed(ActionEvent e) {
                           Conn conn=new Conn();
                           String sql="delete from stu where stunum = '"+stuNum+"'";
                           String sql1="delete from stusocre where stunum = '"+stuNum+"'";
                           conn.updata(sql);
                           conn.updata(sql1);
                           JOptionPane.showMessageDialog(jPanel,"删除成功");
                           model.removeRow(row);
                       }
                   });

               }
            }
        });
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
//        DelStu delStu= new DelStu(jFrame,"demo");
//        jFrame.setVisible(true);
//        delStu.setVisible(true);
//    }
}

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class demo {
    public static void main(String[] args) throws SQLException {
//        JFrame jFrame=new JFrame();
//        jFrame.setBounds(100,100,500,600);
//        jFrame.setBackground(Color.red);
//        jFrame.setLayout(new FlowLayout(FlowLayout.LEFT));
//        JPanel jPanel=new JPanel();
//        jPanel.setSize(200,200);
//        jFrame.add(jPanel,FlowLayout.LEFT);
//        JLabel jLabel=new JLabel("asd");
//        jPanel.add(jLabel);
//        jPanel.setBackground(Color.cyan);
//        jPanel.setLocation(100,100);
//        jFrame.setLayout(null);
//        jFrame.setVisible(true);
//        JFrame jFrame =new JFrame("学生成绩管理系统");
//        JMenu jMenu=new JMenu("学生管理");
//        JMenu jMenu1=new JMenu("成绩管理");
//        JMenu jMenu2=new JMenu("成绩查询");
//        JMenuBar jMenuBar=new JMenuBar();
//        JMenuItem jMenuItem=new JMenuItem("添加学生");
//        JMenuItem jMenuItem1=new JMenuItem("修改学生");
//        JMenuItem jMenuItem2=new JMenuItem("删除学生");
//        JMenuItem jMenuItem3=new JMenuItem("添加成绩");
//        JMenuItem jMenuItem4=new JMenuItem("修改成绩");
//        JMenuItem jMenuItem5=new JMenuItem("删除成绩");
//        JMenuItem jMenuItem6=new JMenuItem("成绩排名");
//        JMenuItem jMenuItem7=new JMenuItem("查询成绩");
//        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        jMenu.add(jMenuItem);
//        jMenu.add(jMenuItem1);
//        jMenu.add(jMenuItem2);
//        jMenu1.add(jMenuItem3);
//        jMenu1.add(jMenuItem4);
//        jMenu1.add(jMenuItem5);
//        jMenu2.add(jMenuItem6);
//        jMenu2.add(jMenuItem7);
//        jMenuBar.add(jMenu);
//        jMenuBar.add(jMenu1);
//        jMenuBar.add(jMenu2);
//        jFrame.setLayout(null);
//        jFrame.setBounds(100,100,800,600);
//        jMenuBar.setSize(jFrame.getWidth(),30);
//        JPanel jPanel=new JPanel();
//        jPanel.setBounds(0,0,jFrame.getWidth(),30);
//        jPanel.setLayout(null);
//        jPanel.add(jMenuBar);
//        jFrame.add(jPanel);
//        JPanel jPanel1=new JPanel();
//        jPanel1.setBounds(0,30,jFrame.getWidth(),30);
//        jPanel1.setBackground(Color.cyan);
//        JLabel jLabel=new JLabel("学生信息");
//        jPanel1.add(jLabel);
//        jFrame.add(jPanel1);
//        JPanel jPanel2=new JPanel();
//        jPanel2.setBounds(0,60,jFrame.getWidth(),jFrame.getHeight()-50);
//        jPanel2.setBackground(Color.orange);
////        String[][] s=new String[20][5];
////        Object[] head = { "姓名", "学号", "科目1", "科目2" };
////        for (int i=0;i<3;i++){
////            s[1][i]="a";
////        }
////        Object[][] data = { { "王鹏", "001", "69", "87" },
////                { "李斯", "002", "69", "87" }, { "全脂", "003", "69", "87" },
////                { "陆远", "004", "69", "87" } };
////        Object[] head = { "姓名", "学号", "科目1", "科目2" };
//        DefaultTableModel model=new DefaultTableModel();
//        model.setColumnIdentifiers(new Object[6]);
//        model.addRow(new Object[]{"学号","姓名","性别","年龄","电话号码","地址"});
//        Conn conn=new Conn();
//        String sql="select * from stu";
//        ResultSet resultSet=conn.select(sql);
//        while (resultSet.next()){
//            String stunum=resultSet.getString("stunum");
//            String stuname=resultSet.getString("stuname");
//            String stusex=resultSet.getString("stusex");
//            String stuage=resultSet.getString("stuage");
//            String stupho=resultSet.getString("stupho");
//            String stuadd=resultSet.getString("stuadd");
//            model.addRow(new Object[]{stunum,stuname,stusex,stuage,stupho,stuadd});
//        }
//        JDialog dialog=new JDialog(jFrame,"asd",true);
//
//        JTable jTable=new JTable(model){
//            @Override
//            public boolean isCellEditable(int row, int column) {
//                return false;
//            }
//        };
//        jTable.setPreferredSize(new Dimension(jPanel2.getWidth(),jPanel2.getHeight()));
//        jPanel2.add(jTable);
//
//        JScrollPane jScrollPane=new JScrollPane(jPanel2);
//        jFrame.add(jPanel2);
//        jFrame.setVisible(true);
////        dialog.setVisible(true);

    }

}

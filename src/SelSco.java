import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelSco extends JDialog {
    public SelSco(Frame owner, String modal) throws SQLException {
        this.setBounds(100,100,600,400);
        setLayout(null);
        JPanel jPanel=new JPanel();
        jPanel.setBounds(0,0,this.getWidth(),this.getHeight());
        add(jPanel);
        DefaultTableModel model=new DefaultTableModel();
        model.setColumnIdentifiers(new Object[8]);
        model.addRow(new Object[]{"学号","姓名","java","php","mfc","专业英语","计算机网络安全","总分"});
        Conn conn=new Conn();
        String sql="select * from stusocre";
        ResultSet resultSet=conn.select(sql);
        while (resultSet.next()){
            String stunum=resultSet.getString("stunum");
            String stuname=resultSet.getString("stuname");
            String java=resultSet.getString("java");
            String php=resultSet.getString("php");
            String mfc=resultSet.getString("mfc");
            String en=resultSet.getString("专业英语");
            String computer=resultSet.getString("计算机网络安全");
//            String count=resultSet.getString("countsocre");
            int count=Integer.parseInt(java)+Integer.parseInt(php)+Integer.parseInt(mfc)+Integer.parseInt(en)+Integer.parseInt(computer);
            String sql2="update stusocre set countsocre ='"+count+"' where stunum ='"+stunum+"'  ";
            conn.updata(sql2);
            model.addRow(new Object[]{stunum,stuname,java,php,mfc,en,computer,count});
        }
        JTable jTable=new JTable(model){
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        jPanel.add(jTable);
        jTable.setPreferredSize(new Dimension(jPanel.getWidth(),jPanel.getHeight()));
    }
//    public static void main(String[] args) throws SQLException {
//        JFrame jFrame=new JFrame();
//        jFrame.setBounds(100,100,800,600);
//      SelSco delStu= new SelSco(jFrame,"demo");
//        jFrame.setVisible(true);
//        delStu.setVisible(true);
//    }
}

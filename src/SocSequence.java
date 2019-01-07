import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SocSequence extends JDialog {
    public SocSequence(Frame owner, String title) throws SQLException {
        this.setBounds(100,100,600,400);
        setLayout(null);
        JPanel jPanel=new JPanel();
        jPanel.setBounds(0,0,this.getWidth(),this.getHeight());
        add(jPanel);
        DefaultTableModel model=new DefaultTableModel();
        model.setColumnIdentifiers(new Object[9]);
        model.addRow(new Object[]{"学号","姓名","java","php","mfc","专业英语","计算机网络安全","总分","排名"});
        Conn conn=new Conn();
        String sql="select * from stusocre order by countsocre desc";
        ResultSet resultSet=conn.select(sql);
        int i=1;
        while (resultSet.next()){

            String stunum=resultSet.getString("stunum");
            String stuname=resultSet.getString("stuname");
            String java=resultSet.getString("java");
            String php=resultSet.getString("php");
            String mfc=resultSet.getString("mfc");
            String en=resultSet.getString("专业英语");
            String computer=resultSet.getString("计算机网络安全");
            int count=Integer.parseInt(java)+Integer.parseInt(php)+Integer.parseInt(mfc)+Integer.parseInt(en)+Integer.parseInt(computer);
            String sql2="update stusocre set countsocre ='"+count+"' where stunum ='"+stunum+"'  ";
            conn.updata(sql2);
            model.addRow(new Object[]{stunum,stuname,java,php,mfc,en,computer,count,i++});
        }
        JTable jTable=new JTable(model){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        jPanel.add(jTable);
        jTable.setPreferredSize(new Dimension(jPanel.getWidth(),jPanel.getHeight()));
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
//        SocSequence delStu= new SocSequence(jFrame,"demo");
//        jFrame.setVisible(true);
//        delStu.setVisible(true);
//    }
}

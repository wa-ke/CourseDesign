import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class UpdateSoc extends JDialog {
    public UpdateSoc() throws SQLException {
        this.setBounds(100,100,600,400);
        setLayout(null);
        JPanel jPanel=new JPanel();
        jPanel.setBounds(0,0,this.getWidth(),this.getHeight());
        add(jPanel);
        DefaultTableModel model=new DefaultTableModel();
        model.setColumnIdentifiers(new Object[7]);
        model.addRow(new Object[]{"学号","姓名","java","php","mfc","专业英语","计算机网络安全"});
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
//            int count=Integer.parseInt(java)+Integer.parseInt(php)+Integer.parseInt(mfc)+Integer.parseInt(en)+Integer.parseInt(computer);
//            String sql2="update stusocre set countsocre ='"+count+"' where stunum ='"+stunum+"'  ";
//            conn.updata(sql2);
            model.addRow(new Object[]{stunum,stuname,java,php,mfc,en,computer});
        }
        JTable jTable=new JTable(model){
            @Override
            public boolean isCellEditable(int row, int column) {
                if (row == 0){
                    return false;
                }else {
                    return true;
                }
            }
        };
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
                String rowName= (String) jTable.getValueAt(0,col);
                String stuNum= (String) jTable.getValueAt(row,0);
                Map<String,String> map=new HashMap<>();
                map.put("学号","stunum");
                map.put("姓名","stuname");
                map.put("java","java");
                map.put("php","php");
                map.put("mfc","mfc");
                map.put("专业英语","专业英语");
                map.put("计算机网络安全","计算机网络安全");
                String colName=map.get(rowName);
                String updateData= (String) jTable.getValueAt(row,col);
                String sql1="update stusocre set "+colName+" = '"+updateData+"' where stunum = '"+stuNum+"'";
                conn.updata(sql1);
            }
        });
        jTable.setPreferredSize(new Dimension(jPanel.getWidth(),jPanel.getHeight()));
        jPanel.add(jTable);
        jTable.setPreferredSize(new Dimension(jPanel.getWidth(),jPanel.getHeight()));
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    Pann pann=new Pann();
                    pann.setVisible(true);
                    SocSequence socSequence=new SocSequence(pann.getjFrame(),"");

                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }
//    public static void main(String[] args) throws SQLException {
//        JFrame jFrame=new JFrame();
//        jFrame.setBounds(100,100,800,600);
//        UpdateSoc delStu= new UpdateSoc();
//        jFrame.setVisible(true);
//        delStu.setVisible(true);
//    }

}

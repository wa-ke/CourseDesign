import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

public class AddStu extends JDialog {
    public AddStu(Frame owner, String title) {
        this.setBounds(100,100,600,400);
        JPanel jPanel=new JPanel();
        jPanel.setBounds(0,0,this.getWidth(),this.getHeight());
        jPanel.setBackground(Color.orange);
        add(jPanel);
        JLabel jLabel=new JLabel("学号：");
        JLabel jLabel1=new JLabel("姓名：");
        JLabel jLabel2=new JLabel("性别：");
        JLabel jLabel3=new JLabel("年龄：");
        JLabel jLabel4=new JLabel("电话：");
        JLabel jLabel5 =new JLabel("地址：");
        JTextField jTextField=new JTextField(45);
        JTextField jTextField1=new JTextField(45);
        JTextField jTextField2=new JTextField(45);
        JTextField jTextField3=new JTextField(45);
        JTextField jTextField4=new JTextField(45);
        JTextField jTextField5=new JTextField(45);
        JButton jButton=new JButton("确认");
        JButton jButton1=new JButton("取消");
        jPanel.add(jLabel);jPanel.add(jTextField);
        jPanel.add(jLabel1);jPanel.add(jTextField1);
        jPanel.add(jLabel2);jPanel.add(jTextField2);
        jPanel.add(jLabel3);jPanel.add(jTextField3);
        jPanel.add(jLabel4);jPanel.add(jTextField4);
        jPanel.add(jLabel5);jPanel.add(jTextField5);
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Conn conn=new Conn();
                String sql="INSERT INTO `stu` (`stunum`, `stuname`, `stusex`, `stuage`, `stupho`, `stuadd`) VALUES ("+jTextField.getText()+", '"+jTextField1.getText()+"', '"+jTextField2.getText()+"', "+jTextField3.getText()+", "+jTextField4.getText()+", '"+jTextField5.getText()+"') ";
                String sql1="INSERT INTO `stusocre` (`stunum`, `stuname`) VALUES ("+jTextField.getText()+", '"+jTextField1.getText()+"')";
                conn.updata(sql);
                conn.updata(sql1);
                JOptionPane.showMessageDialog(jPanel,"添加成功");
            }
        });
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextField.setText("");
                jTextField1.setText("");
                jTextField2.setText("");
                jTextField3.setText("");
                jTextField4.setText("");
                jTextField5.setText("");
            }
        });

        jPanel.add(jButton);
        jPanel.add(jButton1);
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

//        public static void main(String[] args) {
//        JFrame jFrame=new JFrame();
//        jFrame.setBounds(100,100,800,600);
//        AddStu upDataStu=new AddStu(jFrame,"demo");
//        jFrame.setVisible(true);
//        upDataStu.setVisible(true);
//    }
}

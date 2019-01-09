import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login {
    public static void main(String[] args) {
        JFrame jFrame=new JFrame("登录");
        JPanel jPanel=new JPanel();
        jFrame.setLayout(new FlowLayout(FlowLayout.CENTER));
        JPanel jPanel1=new JPanel();
        JPanel jPanel2=new JPanel();
        JLabel jLabel=new JLabel("用户名：");
        JLabel jLabel1=new JLabel("    密码：");
        JTextField jTextField=new JTextField(12);
        JPasswordField jPasswordField=new JPasswordField(12);
        JButton jButton=new JButton("登录");
        JButton jButton1=new JButton("重置");
        jFrame.setBounds(300,300,300,200);
        jPanel.setSize(200,200);
        jPanel1.setSize(200,200);
        jPanel2.setSize(200,200);
        jPanel.add(jLabel);
        jPanel.add(jTextField);
        jPanel1.add(jLabel1);
        jPanel1.add(jPasswordField);
        jPanel2.add(jButton);
        jPanel2.add(jButton1);
        jFrame.add(jPanel);
        jFrame.add(jPanel1);
        jFrame.add(jPanel2);

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
        jButton1.addActionListener(new ActionListener() {
            @Override 
            public void actionPerformed(ActionEvent e) {
                jTextField.setText("");
                jPasswordField.setText("");
            }
        });
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    Conn conn=new Conn();
                    String uname=jTextField.getText();
                    String sql="select upass from user where uname='"+uname+"'";
                    String upass=new String();
                    ResultSet resultSet=conn.select(sql);
                    try {
                        while (resultSet.next()){
                            upass=resultSet.getString(1);
                        }
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                    String pass=new String(jPasswordField.getPassword());
                    if (upass.equals(pass)&&!uname.equals("")&&!upass.equals("")){
                        JOptionPane.showMessageDialog(jFrame,"登录成功");
                        jFrame.dispose();
                        try {
                            new Pann().setVisible(true);
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }
                    }else {
                        JOptionPane.showMessageDialog(jFrame,"登录失败");
                    }

            }
        });


    }
}

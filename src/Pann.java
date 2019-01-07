import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class Pann extends JFrame {
    private JMenuItem jMenuItem;
    private JFrame jFrame;

    public JFrame getjFrame() {
        return jFrame;
    }

    public void setjFrame(JFrame jFrame) {
        this.jFrame = jFrame;
    }

    public JMenuItem getjMenuItem() {
        return jMenuItem;
    }

    public void setjMenuItem(JMenuItem jMenuItem) {
        this.jMenuItem = jMenuItem;
    }

    public Pann() throws SQLException {
        setjFrame(this);
        JMenu jMenu=new JMenu("学生管理");
        JMenu jMenu1=new JMenu("成绩管理");
        JMenu jMenu2=new JMenu("成绩查询");
        JMenuBar jMenuBar=new JMenuBar();
        JMenuItem jMenuItem=new JMenuItem("添加学生");
        JMenuItem jMenuItem1=new JMenuItem("修改学生");
        JMenuItem jMenuItem2=new JMenuItem("删除学生");
        JMenuItem jMenuItem4=new JMenuItem("修改成绩");
        JMenuItem jMenuItem6=new JMenuItem("成绩排名");
        JMenuItem jMenuItem7=new JMenuItem("查询成绩");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jMenu.add(jMenuItem);
        jMenu.add(jMenuItem1);
        jMenu.add(jMenuItem2);
        jMenu1.add(jMenuItem4);
        jMenu2.add(jMenuItem6);
        jMenu2.add(jMenuItem7);
        jMenuBar.add(jMenu);
        jMenuBar.add(jMenu1);
        jMenuBar.add(jMenu2);
        setLayout(null);
        setBounds(100,100,800,600);
        jMenuBar.setSize(getWidth(),30);
        JPanel jPanel=new JPanel();
        jPanel.setBounds(0,0,getWidth(),30);
        jPanel.setLayout(null);
        jPanel.add(jMenuBar);
        add(jPanel);
        JPanel jPanel1=new JPanel();
        jPanel1.setBounds(0,30,getWidth(),30);
        jPanel1.setBackground(Color.cyan);
        JLabel jLabel=new JLabel("学生信息");
        jPanel1.add(jLabel);
        add(jPanel1);
        JPanel jPanel2=new JPanel();
        jPanel2.setBounds(0,60,getWidth(),getHeight()-50);
        jPanel2.setBackground(Color.orange);
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

        JTable jTable=new JTable(model){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        model.fireTableDataChanged();
        jTable.setPreferredSize(new Dimension(jPanel2.getWidth(),jPanel2.getHeight()));
        jPanel2.add(jTable);
        JScrollPane jScrollPane=new JScrollPane(jPanel2);
        add(jPanel2);
        jMenuItem1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UpDataStu upDataStu= null;
                try {
                    upDataStu = new UpDataStu(this,"修改学生信息");
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                upDataStu.setVisible(true);
                upDataStu.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        getjFrame().dispose();
                    }
                });
            }
        });
        jMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddStu addStu=new AddStu(jFrame,"添加学生信息");
                addStu.setVisible(true);
                addStu.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        getjFrame().dispose();
                    }
                });
            }
        });
        jMenuItem2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    DelStu delStu=new DelStu(jFrame,"删除学生");
                    delStu.setVisible(true);
                    delStu.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosing(WindowEvent e) {
                            getjFrame().dispose();
                        }
                    });
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }

            }
        });
        jMenuItem7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    SelSco selSco=new SelSco(jFrame,"成绩查询");
                    selSco.setVisible(true);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
        jMenuItem6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SocSequence upDataStu= null;
                try {
                    upDataStu = new SocSequence(jFrame,"成绩排名");
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                upDataStu.setVisible(true);
                upDataStu.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        getjFrame().dispose();
                    }
                });
            }
        });
        jMenuItem4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UpdateSoc upDataStu= null;
                try {
                    upDataStu = new UpdateSoc();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                upDataStu.setVisible(true);
                upDataStu.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        getjFrame().dispose();
                    }
                });
            }
        });

    }
    public static void main(String[] args) throws SQLException {
        Pann pann=new Pann();
        pann.setVisible(true);
//        JMenuItem jMenuItem=pann.getjMenuItem();
//        jMenuItem.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                UpDataStu upDataStu= null;
//                try {
//                    upDataStu = new UpDataStu(this,"修改学生信息");
//                } catch (SQLException e1) {
//                    e1.printStackTrace();
//                }
//                upDataStu.setVisible(true);
//                upDataStu.addWindowListener(new WindowAdapter() {
//                    @Override
//                    public void windowClosing(WindowEvent e) {
//                        pann.setVisible(false);
//                    }
//                });
//            }
//        });
    }
}

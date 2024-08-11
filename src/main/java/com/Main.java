package com;

import com.sun.javaws.IconUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main extends JFrame {
    private final GridBagLayout gridBagLayout = new GridBagLayout();
    private final JTextArea logs = new JTextArea();
    private final JTextField path = new JTextField(40);
    //扫描 结果文本框
    private final JTextField smResult = new JTextField(40);
    //样品结果文本框
    private final JTextField ypResult = new JTextField();
    private final JTextField ipAddr = new JTextField();
    private final JTextField port = new JTextField();

    void init() {
        this.setTitle("数据采集软件");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(650, 500));
        this.setLocationRelativeTo(null);
        path.setEditable(false);
        smResult.setEditable(false);


        //设置不能最大化
//        this.setResizable(false);
        setLayout(gridBagLayout);
    }

    private boolean testConnect() {
        String net = ipAddr.getText();
        String p = port.getText();
        //TODO http请求
        return true;
    }


    void setPop() {
        //创建菜单栏
        JMenuBar jMenuBar = new JMenuBar();
        //以及菜单
        JMenu jMenu = new JMenu("设置");
        JMenuItem setNetwork = new JMenuItem("网络设置");
        setNetwork.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                JDialog jDialog = new JDialog("线体中控配置",false);

                JButton jButton = new JButton("测试连接");
                jButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (testConnect()) {
                            JOptionPane.showMessageDialog(getContentPane(), "连接成功", "连接测试", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(getContentPane(), "连接失败", "连接测试", JOptionPane.ERROR_MESSAGE);
                        }

                    }
                });

                Object[] message = {
                        "线体中控IP地址：", ipAddr,
                        "端口号：", port,
                        jButton
                };

                int option = JOptionPane.showConfirmDialog(getContentPane(), message, "线体中控网络配置", JOptionPane.OK_CANCEL_OPTION);
                if (option == JOptionPane.OK_OPTION) {
                    String ip = ipAddr.getText() + ":" + port.getText();
//                    JOptionPane.showMessageDialog(null,"ss");

                    String path1 = this.getClass().getClassLoader().getResource("server_config.config").getPath();
                    BufferedWriter bufferedWriter = null;
                    try {
                        bufferedWriter = new BufferedWriter(new FileWriter(path1));
                        String str = "ip=" + ipAddr.getText();
                        String p = "prot=" + port.getText();
                        bufferedWriter.write(str);
                        bufferedWriter.newLine();
                        bufferedWriter.write(p);
                        bufferedWriter.flush();
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    } finally {
                        if (bufferedWriter != null) {
                            try {
                                bufferedWriter.close();
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }

                        }
                    }


                    writeLog("线体中控网络配置:ip:" + ip);


                }
            }
        });

        //添加时间
        JMenuItem processSelect = new JMenuItem("测试项选择");
        //添加事件
        processSelect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object[] select = {"aa", "bb", "cc"};

                Object o = JOptionPane.showInputDialog(getContentPane(), "请选择测试项目", "标题",
                        JOptionPane.INFORMATION_MESSAGE, null, select, null);
                System.out.println(o);
            }
        });

        jMenu.add(setNetwork);
        jMenu.addSeparator();
        jMenu.add(processSelect);


        jMenuBar.add(jMenu);
        setJMenuBar(jMenuBar);
    }


    public Main() {
        //初始化
        init();
        //配置烂设置
        setPop();

        showInfo();
//        pack();
        setVisible(true);


    }

    public String getPath() {
        return path.getText();
    }

    void setPath(JButton jButton) {
        jButton.addActionListener(e -> {
            JFileChooser jFileChooser = new JFileChooser();
            jFileChooser.setCurrentDirectory(new File("/"));
            jFileChooser.setDialogTitle("请选择文件");
            jFileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            if (jFileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                String absolutePath = jFileChooser.getSelectedFile().getAbsolutePath();
                path.setText(absolutePath);

                String msg = "操作员选择目录" + absolutePath;
                writeLog(msg);
                //TODO 写入日志？
                System.out.println(getPath());
            }

        });
    }

    void checkHavePath(JButton button) {
        button.addActionListener(e -> {
            String path1 = getPath();
            if (path1 == null || path1.equals("")) {
                JOptionPane.showMessageDialog(getContentPane(), "请检查配置", "校验失败", JOptionPane.WARNING_MESSAGE);
                String msg = "操作员点击开始测试-校验不通过";

                writeLog(msg);
            } else {
                String msg = "开始监听目标目录是否有新文件生成";
                writeLog(msg);
            }
        });
    }


    void showInfo() {
        JLabel jLabel = new JLabel("扫描结果");
        addContainer(new GBC(1, GridBagConstraints.HORIZONTAL, 0.25), jLabel);

        addContainer(new GBC(GridBagConstraints.REMAINDER, GridBagConstraints.HORIZONTAL, 0.75), smResult);
        JLabel jLabel1 = new JLabel("样品");
        addContainer(new GBC(1, GridBagConstraints.HORIZONTAL, 0.25), jLabel1);

        addContainer(new GBC(GridBagConstraints.REMAINDER, GridBagConstraints.HORIZONTAL, 0.75), ypResult);
        JLabel jLabel2 = new JLabel("请选择目录");
        addContainer(new GBC(1, GridBagConstraints.HORIZONTAL, 0.25), jLabel2);
        //设置目录文本框
        addContainer(new GBC(GridBagConstraints.RELATIVE, GridBagConstraints.HORIZONTAL, 0.5), path);
        JButton jButton = new JButton("浏览");
        setPath(jButton);
        addContainer(new GBC(GridBagConstraints.REMAINDER, GridBagConstraints.NONE, 0.25), jButton);

        JButton jButton1 = new JButton("开始测试");
        addContainer(new GBC(1, GridBagConstraints.NONE, 0.25), jButton1);
        checkHavePath(jButton1);

        JButton jButton2 = new JButton("手动提交");
        addContainer(new GBC(GridBagConstraints.REMAINDER, GridBagConstraints.NONE, 0.25), jButton2);


        //日志

//        jTextArea.setLineWrap(true);//自动换行
        logs.setFont(new Font("楷体", Font.PLAIN, 22));
        logs.setForeground(Color.BLACK);
        logs.setEditable(false);
        //创建滚动板，制定显示组件
        JScrollPane jScrollPane = new JScrollPane(logs,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,//总是显示
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);//从不显示
        addContainer(new GBC(GridBagConstraints.REMAINDER, GridBagConstraints.BOTH, 111), jScrollPane);


    }


    void addContainer(GridBagConstraints gbc, Component component) {
        gridBagLayout.setConstraints(component, gbc);
        add(component);
    }

    //写入日志面板
    public void writeLog(String str) {
        LocalDateTime now = LocalDateTime.now();
        String format = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + ":";
        logs.append(format + str + "\n");
    }

    public static void main(String[] args) {
        Main main = new Main();
    }
}

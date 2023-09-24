package Emp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmpList extends JFrame implements ActionListener {


    public EmpList(String username,String password) throws ClassNotFoundException {
        QueryEmp emp=new QueryEmp();
        emp.Query(username,password);
        Object[][]data=emp.getData();
        // 创建表格模型
        String[] columnNames = {"员工编号", "姓名", "职位", "工资信息"};

        // 创建表格实例
        JTable table = new JTable(data, columnNames);

        // 将表格添加到滚动窗格中
        JScrollPane scrollPane = new JScrollPane(table);

        // 创建窗口实例
        JFrame frame = new JFrame("员工信息");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(scrollPane);
        frame.setSize(300, 150);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}

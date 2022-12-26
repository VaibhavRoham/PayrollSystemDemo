import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Update_salary extends JFrame implements ActionListener,ItemListener{
    JLabel l1,l2;
    JTextField t1,t2;
    JButton b1,b2;
    Choice c2;

    Update_salary(){

        setLayout(null);
        c2 = new Choice();
        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from salary");
            while(rs.next()){
                c2.add(rs.getString("id"));
            }

        }catch(Exception e){ }

        JLabel emp = new JLabel("Select Empno");
        emp.setBounds(20,20,100,20);
        add(emp);

        c2.setBounds(120,20,200,20);
        add(c2);




        l1 = new JLabel("Pf");
        t1 = new JTextField(15);

        l1.setBounds(20,180,100,20);
        t1.setBounds(120,180,200,20);
        add(l1);
        add(t1);

        l2 = new JLabel("basic_salary");
        t2 = new JTextField(15);

        l2.setBounds(20,220,100,20);
        t2.setBounds(120,220,200,20);
        add(l2);
        add(t2);

        b1 =new JButton("Update");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);

        b2 = new JButton("Delete");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);

        b1.setBounds(40,280,100,20);
        b2.setBounds(200,280,100,20);
        add(b1);
        add(b2);

        b1.addActionListener(this);
        b2.addActionListener(this);
        c2.addItemListener(this);

        getContentPane().setBackground(Color.WHITE);

        setVisible(true);
        setSize(400,450);
        setLocation(600,200);
    }

    public void actionPerformed(ActionEvent ae){

        if(ae.getSource()==b1){

            String pf = t1.getText();
            String basic = t2.getText();

            String qry = "update salary set pf="+pf+",basic_salary="+basic+"  where id="+c2.getSelectedItem();

            try{
                conn c1 = new conn();
                c1.s.executeUpdate(qry);
                JOptionPane.showMessageDialog(null,"Salary Updated");
                this.setVisible(false);
            }catch(Exception ee){
                ee.printStackTrace();
            }
        }

        if(ae.getSource()==b2){

            try{
                conn c1 = new conn();
                c1.s.executeUpdate("delete from salary where id="+c2.getSelectedItem());
                JOptionPane.showMessageDialog(null,"Salary Deleted");
                this.setVisible(false);
            }catch(Exception ee){
                ee.printStackTrace();
            }
        }
    }

    public void itemStateChanged(ItemEvent ie)
    {
        try{
            conn c1 = new conn();
            ResultSet rs = c1.s.executeQuery("select * from salary where id="+c2.getSelectedItem());
            if(rs.next()){
                t1.setText(rs.getString("pf"));
                t2.setText(rs.getString("basic_salary"));

            }
        }catch(Exception ee){
            ee.printStackTrace();
        }


    }

    public static void main(String[] args){
        new Update_salary();
    }

}

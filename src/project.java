import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class project extends JFrame implements ActionListener {

    project(){
        setSize(2000,1100);
        getContentPane().setBackground(Color.WHITE);

        JLabel l1 = new JLabel();
        add(l1);

        JMenuBar mb = new JMenuBar();
        setJMenuBar(mb);
        JMenu m1 = new JMenu("Master");
        m1.setForeground(Color.blue);

        JMenuItem t1 = new JMenuItem("New Employee");

        t1.setForeground(Color.blue);
        t1.setFont(new Font("monospaced",Font.PLAIN,12));
        t1.setMnemonic('N');
        t1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));




        JMenuItem t3 = new JMenuItem("Salary");
        t3.setForeground(Color.blue);
        t3.setFont(new Font("monospaced",Font.PLAIN,12));
        t3.setMnemonic('S');
        t3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));


        m1.add(t1);
        m1.add(t3);
        mb.add(m1);

        t1.addActionListener(this);
        t3.addActionListener(this);

        JMenu edit =new JMenu("Update");
        edit.setForeground(Color.RED);

        mb.add(edit);
        JMenuItem s1 = new JMenuItem("Update Salary");
        s1.setForeground(Color.blue);
        s1.setFont(new Font("monospaced",Font.PLAIN,12));
        s1.setMnemonic('U');
        s1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, ActionEvent.CTRL_MASK));

        edit.add(s1);

        JMenuItem s2 = new JMenuItem("Update Employee");

        s2.setForeground(Color.blue);
        s2.setFont(new Font("monospaced",Font.PLAIN,12));
        s2.setMnemonic('p');
        s2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));

        edit.add(s2);

        s1.addActionListener(this);
        s2.addActionListener(this);


        JMenu util =new JMenu("Utilities");
        util.setForeground(Color.red);

        mb.add(util);
        JMenuItem u1 = new JMenuItem("Notepad");



        u1.setForeground(Color.blue);
        u1.setFont(new Font("monospaced",Font.PLAIN,12));
        u1.setMnemonic('o');
        u1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));

        util.add(u1);
        JMenuItem u2 = new JMenuItem("Calculator");

        u2.setForeground(Color.blue);
        u2.setFont(new Font("monospaced",Font.PLAIN,12));
        u2.setMnemonic('C');
        u2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));





        util.add(u2);
        JMenuItem u3 = new JMenuItem("Web Browser");


        u3.setForeground(Color.blue);
        u3.setFont(new Font("monospaced",Font.PLAIN,12));
        u3.setMnemonic('E');
        u3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));

        util.add(u3);

        u1.addActionListener(this);
        u2.addActionListener(this);
        u3.addActionListener(this);



        JMenu m8=new JMenu("Exit");
        m8.setForeground(Color.red);
        mb.add(m8);
        JMenuItem m8i1=new JMenuItem("Exit");
        m8.add(m8i1);
        m8i1.setForeground((Color.blue));
        m8i1.setFont(new Font("monospaced", Font.PLAIN, 14));
        m8i1.setMnemonic('X');
        m8i1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
        m8i1.addActionListener(this);

    }

    public void actionPerformed(ActionEvent ae){
        String msg= ae.getActionCommand();

        if(msg.equals("New Employee"))
            new New_Employee().setVisible(true);

        else if(msg.equals("Update Employee"))
            new Update_employee().setVisible(true);
        else if(msg.equals("Salary"))
            new Salary().setVisible(true);
        else if(msg.equals("Update Salary"))
            new Update_salary().setVisible(true);
        else if(msg.equals("Notepad")){
            try{
                Runtime.getRuntime().exec("notepad.exe");
            }catch(Exception e){ }
        }
        else if(msg.equals("Calculator")){
            try{
                Runtime.getRuntime().exec("calc.exe");
            }catch(Exception e){ }
        }
        else if(msg.equals("Web Browser")){
            try{
                Runtime.getRuntime().exec("C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe");
            }catch(Exception e){ }
        }

        else if(msg.equals("Exit"))
            System.exit(0);

    }

    public static void main(String[] args) throws Exception
    {
        new project().setVisible(true);

    }

}

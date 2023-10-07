import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class GUI extends JFrame implements ActionListener {

    JLabel l1, l2, l3, l4, l5, l6;
    JTextField t1, t2, t3, t4, t5, t6;
    JButton b1;

    public GUI() {
        super("Prime Numbers Generator");

        l1 = new JLabel("N");
        t1 = new JTextField(20);

        l2 = new JLabel("Buffer Size");
        t2 = new JTextField(20);

        l3 = new JLabel("Output File");
        t3 = new JTextField(20);

        l4 = new JLabel("LARGEST PRIME NUMBER");
        t4 = new JTextField(10);

        l5 = new JLabel("NUMBER OF PRIME NUMBERS");
        t5 = new JTextField(10);

        l6 = new JLabel("TIME ELAPSED");
        t6 = new JTextField(10);

        b1 = new JButton("Start Producer");

        setLayout(new FlowLayout(FlowLayout.CENTER, 150, 8));
        getContentPane().setBackground(Color.darkGray);

        l1.setForeground(Color.white);
        add(l1);
        t1.setBackground(Color.lightGray);
        add(t1);

        l2.setForeground(Color.white);
        add(l2);
        t2.setBackground(Color.lightGray);
        add(t2);
        l3.setForeground(Color.white);
        add(l3);
        t3.setBackground(Color.lightGray);
        add(t3);

        b1.setBackground(Color.getHSBColor(30, 30, 100));
        add(b1);

        b1.addActionListener(this);

        l4.setForeground(Color.white);
        add(l4);
        t4.setBackground(Color.lightGray);
        add(t4);

        l5.setForeground(Color.white);
        add(l5);
        t5.setBackground(Color.lightGray);
        add(t5);

        l6.setForeground(Color.white);
        add(l6);
        t6.setBackground(Color.lightGray);
        add(t6);


        setSize(400, 400);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        int num = Integer.parseInt(t1.getText());
        int BufferSize = Integer.parseInt(t2.getText());
        String output = t3.getText();



        Producer p1=new Producer(num, BufferSize,output);
        Thread thread1=new Thread(p1);
        Consumer c1=new Consumer(num, BufferSize, output);
        Thread thread2=new Thread(c1);
        thread1.start();
        try {
            thread1.join();
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }
        thread2.start();

        try {
            thread2.join();
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }

        int l=c1.LargestPrime;
        int c=c1.count;
        long d=c1.duration;


        t4.setText(String.valueOf(l));
        t5.setText(String.valueOf(c));
        t6.setText(String.valueOf(d +" ms"));
    }
}
public class Main {
    public static void main(String[] args) {
        new GUI();
    }
}

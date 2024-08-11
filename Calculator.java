import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class Calculator  implements ActionListener{
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    JLabel label=new JLabel("          Simple Calculator");
    JTextField text = new JTextField();
    JButton[] Numbers= new JButton[10];
    JButton[] Function=new JButton[8];
    double num1,num2,result;
    String operator;

    public Calculator(){
        frame.setSize(450,550);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.CYAN);

        text.setBounds(30,40,275,60);
        text.setFont(new Font(null ,Font.BOLD,40));
        text.setEditable(false);



        Function[0]=new JButton("+");
        Function[1]=new JButton("-");
        Function[2]=new JButton("*");
        Function[3]=new JButton("/");
        Function[4]=new JButton(".");
        Function[5]=new JButton("=");
        Function[6]=new JButton("Delete");
        Function[7]=new JButton("Clear");

        for(int i = 0; i < 8; i++) {
            Function[i].setFont(new Font(null,Font.BOLD,20));
            Function[i].addActionListener(this);
            Function[i].setFocusable(false);
        }

        for(int i = 0; i < 10; i++) {
            Numbers[i] = new JButton(String.valueOf(i));
            Numbers[i].setFont(new Font(null,Font.BOLD,20));
            Numbers[i].addActionListener(this);
            Numbers[i].setFocusable(false);;
        }

        Function[7].setBounds(310,40,90,60);

        label.setBounds(0,0,435,40);
        label.setFont(new Font(null,Font.BOLD,30));
        label.setForeground(Color.RED);

        panel.setBounds(30,110,370,350);
        panel.setLayout(new GridLayout(4,4,10,10));
        panel.setBackground(Color.CYAN);
        panel.add(Numbers[7]);
        panel.add(Numbers[8]);
        panel.add(Numbers[9]);
        panel.add(Function[0]);
        panel.add(Numbers[4]);
        panel.add(Numbers[5]);
        panel.add(Numbers[6]);
        panel.add(Function[1]);
        panel.add(Numbers[1]);
        panel.add(Numbers[2]);
        panel.add(Numbers[3]);
        panel.add(Function[2]);
        panel.add(Numbers[0]);
        panel.add(Function[4]);
        panel.add(Function[5]);
        panel.add(Function[3]);


        frame.add(label);
        frame.add(text);
        frame.add(panel);
        frame.add(Function[7]);
        frame.setVisible(true);
    }

    @Override

    public void actionPerformed(ActionEvent e){
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == Numbers[i]) {
                text.setText(text.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource()==Function[4]){
            text.setText(text.getText().concat("."));
        }
        if(e.getSource()==Function[7]){
            text.setText("");
        }
        if(e.getSource()==Function[0])  {
                num1 = Double.parseDouble(text.getText());
                operator = "+";
                text.setText("");
        }
        if(e.getSource()==Function[1]){
            num1=Double.parseDouble(text.getText());
            operator = "-";
            text.setText("");
        }
        if(e.getSource()==Function[2]){
            num1=Double.parseDouble(text.getText());
            operator = "*";
            text.setText("");
        }
        if(e.getSource()==Function[3]){
            num1=Double.parseDouble(text.getText());
            operator = "/";
            text.setText("");
        }
        if(e.getSource()==Function[5]){
            num2=Double.parseDouble(text.getText());
            switch(operator){
                case "+" -> result = num1+num2;
                case "-" -> result = num1-num2;
                case "*" -> result = num1*num2;
                case "/" -> result = num1/num2;
            }
            text.setText(String.valueOf(result));
        }
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class ViewFrame extends JFrame
{
Container c;
JTextArea txtResult;
JScrollPane spResult;
JButton btnBack;
JPanel p1,p2;

ViewFrame()
{
c=getContentPane();
p1=new JPanel();
p1.setLayout(new FlowLayout());
txtResult=new JTextArea(20,20);
txtResult.setEditable(false);
spResult=new JScrollPane(txtResult);
spResult.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
spResult.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
p1.add(spResult);
c.add(p1);

p2=new JPanel();
p2.setLayout(new FlowLayout());
btnBack=new JButton("Back");
p2.add(btnBack);
c.add("South",p2);


btnBack.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae){
MainFrame a=new MainFrame();
dispose();
}
});

DbHandler db=new DbHandler();
String data=db.getEmployee();
txtResult.setText(data); 


setSize(500,150);
setTitle("View Employee");
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
setLocationRelativeTo(null);
}

public static void main(String args[])
{
ViewFrame a=new ViewFrame();
}
}










import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class DeleteFrame extends JFrame
{
Container c;
JButton btnSave,btnBack;
JLabel id,name;
JTextField idt,namet;
JPanel p1,p2;


DeleteFrame()
{
c=getContentPane();
p1=new JPanel();
p1.setLayout(new FlowLayout());
id=new JLabel("ID");
idt=new JTextField(10);
p1.add(id);
p1.add(idt);
c.add(p1);

p2=new JPanel();
p2.setLayout(new FlowLayout());
btnSave=new JButton("Save");
btnBack=new JButton("Back");
p2.add(btnSave);
p2.add(btnBack);
c.add("South",p2);

btnBack.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae){
MainFrame a=new MainFrame();
dispose();
}
});

btnSave.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae){
String id=idt.getText();

if(id.length()==0)
{
JOptionPane.showMessageDialog(new JDialog(),"ID is empty");
idt.requestFocus();
return;
}


DbHandler db=new DbHandler();
db.getConnect();
db.deleteEmployee(Integer.parseInt(id));
idt.setText("");

}
});


setSize(500,150);
setTitle("Delete Employee");
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
setLocationRelativeTo(null);
}

public static void main(String args[])
{
UpdateFrame a=new UpdateFrame();
}
}
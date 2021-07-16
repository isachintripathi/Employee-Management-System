import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

class MainFrame extends JFrame
{
Container c;
JButton btnAdd,btnUpdate,btnDelete,btnView;
MainFrame()
{
c=getContentPane();
c.setLayout(new FlowLayout());
btnAdd=new JButton("Add");
btnUpdate=new JButton("Update");
btnDelete=new JButton("Delete");
btnView=new JButton("View");

c.add(btnAdd);
c.add(btnUpdate);
c.add(btnDelete);
c.add(btnView);

btnAdd.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae){
AddFrame a=new AddFrame();
dispose();
}
});

btnUpdate.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae){
UpdateFrame a=new UpdateFrame();
dispose();
}
});

btnDelete.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae){
DeleteFrame a=new DeleteFrame();
dispose();
}
});

btnView.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae){
ViewFrame a=new ViewFrame();
dispose();
}
});

setSize(500,150);
setTitle("Employee Management System");
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
setLocationRelativeTo(null);
}

public static void main(String args[])
{
MainFrame m=new MainFrame();
}
}



class DbHandler
{
public static Connection con;
public static void getConnect()
{

try
{
DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","abc123");

}
catch(SQLException e)
{
JOptionPane.showMessageDialog(new JDialog(),"Issue: "+e);
}
finally
{

}
}//end of getConnect

public void addEmployee(int eid,String ename)
{
getConnect();
try
{
String s1="insert into employee values(?,?)";
PreparedStatement p1=con.prepareStatement(s1);
p1.setInt(1,eid);
p1.setString(2,ename);
p1.executeUpdate();
JOptionPane.showMessageDialog(new JDialog()," Row Inserted! ");

}
catch(SQLException e)
{
JOptionPane.showMessageDialog(new JDialog(),"Issue: "+e);
}
finally
{

}
}//End of addEmployee

public String getEmployee()
{
getConnect();
StringBuffer sb=new StringBuffer();
try
{
String s1="select * from employee";
Statement s2=con.createStatement();
ResultSet r1=s2.executeQuery(s1);
while(r1.next())
{
int eid=r1.getInt("eid");
String ename=r1.getString("ename");
sb.append("eid: " +eid+ "\t" +"ename: "+ename+"\n");
}

}
catch(SQLException e)
{
JOptionPane.showMessageDialog(new JDialog(),"Issue: "+e);
}
finally
{

}
return sb.toString();
}//End of getEmployee

public void updateEmployee(int eid,String ename)
{
getConnect();
try
{
String s1="update employee set ename=?"+ "where eid=?";
PreparedStatement p1=con.prepareStatement(s1);
p1.setInt(2,eid);
p1.setString(1,ename);
p1.executeUpdate();
JOptionPane.showMessageDialog(new JDialog()," Row Updated! ");

}
catch(SQLException e)
{
JOptionPane.showMessageDialog(new JDialog(),"Issue: "+e);
}
finally
{

}
}//End of UpdateEmployee


public void deleteEmployee(int eid)
{
getConnect();
try
{
String s1="delete employee where eid=?";
PreparedStatement p1=con.prepareStatement(s1);
p1.setInt(1,eid);
p1.executeUpdate();
JOptionPane.showMessageDialog(new JDialog()," Row Deleted ");

}
catch(SQLException e)
{
JOptionPane.showMessageDialog(new JDialog(),"Issue: "+e);
}
finally
{

}
}//End of deleteEmployee

}//End ofdbhandler










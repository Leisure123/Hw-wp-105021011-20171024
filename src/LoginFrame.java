import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame{
    private JLabel lbID = new JLabel("Account:");
    private JLabel lbPW = new JLabel("Password:");
    private JTextField tfID = new JTextField();
    private JPasswordField pfPW = new JPasswordField();
    private JButton btnLogin = new JButton("Log in");
    private JButton btnExit = new JButton("Exit");
    private Container cp;
    private int fmW = 400, fmH = 150, screenW, screenH;
    private Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

    public LoginFrame(){
        initComp();
    }
    private void initComp(){
        screenW = dim.width;
        screenH = dim.height;
        this.setBounds(screenW/2-fmW/2,screenH/2-100,fmW,fmH);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setTitle("Log in");
        cp = this.getContentPane();
        cp.setLayout(new GridLayout(2,3,3,3));
        lbID.setHorizontalAlignment(JLabel.RIGHT);
        lbPW.setHorizontalAlignment(JLabel.RIGHT);
        cp.add(lbID);
        cp.add(tfID);
        cp.add(btnLogin);
        cp.add(lbPW);
        cp.add(pfPW);
        cp.add(btnExit);

        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(tfID.getText().equals("h304")){
                    if((new String(pfPW.getPassword())).equals("23323456")){
                        MainFrame mfrm = new MainFrame(LoginFrame.this);
                        mfrm.setVisible(true);
                        LoginFrame.this.setVisible(false);
                        tfID.setText("");
                        pfPW.setText("");
                    }else{
                        JOptionPane.showMessageDialog(LoginFrame.this,"Password is wrong!");
                    }
                }else{
                    JOptionPane.showMessageDialog(LoginFrame.this,"Account is wrong!");
                }
            }
        });
    }
}
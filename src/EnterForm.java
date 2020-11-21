import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EnterForm extends JFrame {
    private JPanel enter_panel;
    private JTextField login1;
    private JPasswordField pass1;
    private JButton enter;
    private JLabel mistake;

    EnterForm(){
        setContentPane(enter_panel);
        setPreferredSize(new Dimension(300, 300));
        enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!login1.getText().trim().equals("") && !pass1.getText().trim().equals("")){
                    String login= "Kolya";
                    String pass= "1234";
                    //Pattern p = Pattern.compile("^[0-9a-zA-Z]$");
                    //Matcher m = p.matcher(login1.getText());
                    if(login1.getText().equals(login)){
                        if(pass1.getText().equals(pass)){
                            MainForm  N = new MainForm();
                            N.setVisible(true);
                            N.pack();
                        }
                        else{
                            mistake.setText("Неправильный пароль");
                        }
                    }
                    else{
                        mistake.setText("Неправильный логин");
                    }

                }
                else{
                    mistake.setText("Вы не ввели данные");
                }
            }
        });


    }

    public static void main(String d[]){
        EnterForm F=new EnterForm();
        F.pack();
        F.setVisible(true);
    }
}

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddForm extends JFrame {
    private JPanel add;
    private JTextField firstname;
    private JTextField secondname;
    private JTextField birth_date;
    private JTextField login;
    private JPasswordField pass1;
    private JPasswordField pass2;
    private JButton reg_button;
    private JLabel warning;

    AddForm(){
        setContentPane(add);
        setSize(400,400);
        reg_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!birth_date.getText().trim().equals("")&&!secondname.getText().trim().equals("")&&!login.getText().trim().equals("")&&!firstname.getText().trim().equals("")&&!pass1.getText().trim().equals("")&&!pass2.getText().trim().equals("")){
                    if (pass1.getText().equals(pass2.getText())) {
                        Pattern p = Pattern.compile("^[0-3]\\d\\.[0-1]\\d\\.(19|20)\\d\\d$");
                        Matcher m = p.matcher(birth_date.getText());
                        if((birth_date.getText().length()==10) && m.matches()){
                            String[] s = birth_date.getText().trim().split(".");
                            int day = Integer.parseInt(s[0]);
                            int month = Integer.parseInt(s[1]);
                            int year = Integer.parseInt(s[2]);
                            float ddd;
                            ddd = month%2;
                            if (month>=1 && month <=12 && year >= 1900 && year < 2020) {
                                if ((ddd > 0 && day <= 31) || (ddd == 0 && day <= 30) || (ddd == 0 && month==2)) {

                                }
                            }
                            warning.setText("");
                        }
                        else{
                            warning.setText("Неправильный формат даты");
                        }
                    }
                    else{
                        warning.setText("Пароли не совпадают");
                    }
                }
                else{
                    warning.setText("Вы не ввели данные");
                }
            }
        });
    }
}

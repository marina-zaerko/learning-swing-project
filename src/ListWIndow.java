import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListWIndow extends JFrame {
    private JButton add;
    private JPanel list;

    ListWIndow(){
        setContentPane(list);
        setSize(300,300);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddForm A = new AddForm();
                A.setVisible(true);
                dispose();
            }
        });
    }
}

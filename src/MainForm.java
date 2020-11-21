import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.cert.TrustAnchor;
import java.util.ArrayList;

public class MainForm extends JFrame{
    private JPanel mainpanel;
    private JButton add;
    private JButton edit;
    private JButton show;
    private JList list;
    private JLabel warning;

    MainForm(){
        setContentPane(mainpanel);
        setPreferredSize(new Dimension(400,400));

        ArrayList<UserData> dataList=new ArrayList<>();// создаем массив типа UserData

        DefaultListModel<String> modelList=new DefaultListModel<>();
        list.setModel(modelList); //задаем компоненту list массив данных

        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddSomeForm A = new AddSomeForm(dataList, modelList, list.getSelectedIndex());
                A.pack();
                A.setVisible(true);
            }
        });

        edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(list.getSelectedIndex()==-1){
                    warning.setText("Что-то пошло не так");
                }else{
                    AddSomeForm A=new AddSomeForm(dataList,modelList,list.getSelectedIndex());
                    A.pack();
                    A.setVisible(true);
                }

            }
        });

        show.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ListForm L = new ListForm(dataList);
                L.setVisible(true);
                L.pack();
            }
        });
    }
}

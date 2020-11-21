import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AddSomeForm extends JFrame{
    private JPanel mainpanel;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JButton ok;
    private JButton close;
    private JLabel message;

    AddSomeForm(ArrayList<UserData> dataList, DefaultListModel<String> modelList, int index){
        setContentPane(mainpanel);
        setPreferredSize(new Dimension(300,300));

        if(index>=0){ //для редактирования, в случае выбранного индекса?
            textField1.setText(dataList.get(index).getName());
            textField2.setText(dataList.get(index).getSName());
            textField3.setText(dataList.get(index).getPhone());
            textField4.setText(dataList.get(index).getEmail());
        }

        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] textData = {textField1.getText(), textField2.getText(), textField3.getText(), textField4.getText()};

                for (int i=0; i<textData.length; i++) {
                    if (textData[i].length() == 0) {
                        message.setText("Что-то пошло не так");
                        return;
                    }
                }

                    if (index>=0){
                        dataList.set(index, new UserData(textData[0], textData[1], textData[2], textData[3])); //редактируем данные
                        modelList.set(index, textData[0]);
                    }
                    else{
                        dataList.add(new UserData(textData[0], textData[1], textData[2], textData[3])); //добавляем новые данные
                        modelList.add(dataList.size() - 1, textData[0]);
                    }

                    dispose();



            }
        });

        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

    }
}

import com.sun.xml.internal.ws.api.streaming.XMLStreamWriterFactory;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ListForm extends JFrame{
    private JPanel main_panel;
    private JTable table1;
    private JComboBox comboBox1;

    ListForm(ArrayList<UserData> dataList){
        setContentPane(main_panel);
        setPreferredSize(new Dimension(300, 300));
        setTitle("Таблица");

        DefaultTableModel tablemodel = new DefaultTableModel(); //делаем модель таблицы, с которой работаем, а потом из нее вставляем данные в соответствующий компонент
        tablemodel.addColumn("Name");
        tablemodel.addColumn("SName");
        tablemodel.addColumn("Phone");
        tablemodel.addColumn("Email");

        for(int i=0;i<dataList.size();i++) {
            tablemodel.addRow(dataList.get(i).getAll());
        }

        table1.setModel(tablemodel);

        DefaultComboBoxModel<String> comboModel=new DefaultComboBoxModel<>(); //делаем модель комбобокса, которую потом вставляем в соответствующий компонент
        comboModel.addElement("Only Name"); //добавляем элемент
        comboModel.addElement("Only Phone");
        comboBox1.setModel(comboModel); //устанавливаем модель

        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (comboBox1.getSelectedIndex()){
                    case 0: break;
                    case 1:                                                //в случае, если выбираем телефон, то удаляем все столбцы, кроме телефона
                        table1.removeColumn(table1.getColumn("Name"));
                        table1.removeColumn(table1.getColumn("SName"));
                        table1.removeColumn(table1.getColumn("EMail"));
                        break;
                }
            }
        });

    }
}

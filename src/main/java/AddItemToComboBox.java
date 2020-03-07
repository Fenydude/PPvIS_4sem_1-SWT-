import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.widgets.*;

import java.util.Date;

public class AddItemToComboBox {
    private Button button;
    private Label label;
    private Text text;
    private Label label_combo;
    private Combo combo;
    private String[] items;

    AddItemToComboBox(Display display, Shell shell){
        label = new Label(shell, SWT.NONE);
        label.setText("Your Text: ");

        // Text
        text = new Text(shell, SWT.BORDER);
        RowData layoutData = new RowData();
        layoutData.width = 150;

        text.setLayoutData(layoutData);
        text.setText("");

        button = new Button(shell,SWT.NONE);
        button.setText("Add word");

        label_combo = new Label(shell,SWT.NONE );

        label_combo.setText("Select word:");

        // Create a dropdown Combo
        combo = new Combo(shell, SWT.DROP_DOWN);
        items = new String[] {};

        combo.setItems(items);
        final Label a = new Label(shell, SWT.NONE);
        a.setText("");
        button.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent arg0) {
                boolean check = false;
                for (int i = 0; i<combo.getItemCount();i++){
                    if (combo.getItem(i).equals(text.getText())){
                        check= true;
                    }
                }
                if (check){
                    MessageBox messageBox = new MessageBox(shell,SWT.CANCEL);
                    messageBox.setMessage("Soriamba");
                    messageBox.setText("Soriamba");
                    int response = messageBox.open();
                    display.update();


                }else {
                    combo.add(text.getText());
                    a.setText(text.getText());
                    a.pack();
                    display.update();
                }
            }

        });
    }


}

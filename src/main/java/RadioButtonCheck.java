import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.*;

public class RadioButtonCheck {
    private Button button;
    private Label label;
    private Text text;


    RadioButtonCheck(Display display, Shell shell){
        label = new Label(shell, SWT.NONE);
        label.setText("Your Text: ");

        // Text
        text = new Text(shell, SWT.BORDER);
        RowData layoutData = new RowData();
        layoutData.width = 150;

        text.setLayoutData(layoutData);
        text.setText("");

        button = new Button(shell,SWT.NONE);
        button.setText("Enter sex");

        Group radioButtonGroup = new Group(shell, SWT.NONE);
        radioButtonGroup.setLayout(new RowLayout(SWT.HORIZONTAL));
        radioButtonGroup.setText("Sex");

        Button radioButton1 = new Button(radioButtonGroup, SWT.RADIO);
        radioButton1.setText("Male");

        Button radioButton2 = new Button(radioButtonGroup, SWT.RADIO);
        radioButton2.setText("Female");

        Button radioButton3 = new Button(radioButtonGroup, SWT.RADIO);
        radioButton3.setText("?");




        button.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent arg0) {
                if(text.getText().equals(radioButton1.getText())){
                    radioButton1.setSelection(true);
                    radioButton2.setSelection(false);
                    radioButton3.setSelection(false);
                    display.update();
                }else{
                    if(text.getText().equals(radioButton2.getText())){
                    radioButton1.setSelection(false);
                    radioButton2.setSelection(true);
                    radioButton3.setSelection(false);
                        display.update();
                }else{
                        if(text.getText().equals(radioButton3.getText())){
                            radioButton1.setSelection(false);
                            radioButton2.setSelection(false);
                            radioButton3.setSelection(true);
                            display.update();
                        }else{
                            MessageBox messageBox = new MessageBox(shell,SWT.CANCEL);
                            messageBox.setMessage("Soriamba");
                            messageBox.setText("Soriamba");
                            int response = messageBox.open();
                            display.update();
                        }
                    }}

            }

        });
    }
}

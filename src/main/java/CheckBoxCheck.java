import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.*;

public class CheckBoxCheck {
    private Button button;
    private Label label;
    private Text text;


    CheckBoxCheck(Display display, Shell shell){
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

        Group chezkButtonGroup = new Group(shell, SWT.NONE);
        chezkButtonGroup.setLayout(new RowLayout(SWT.HORIZONTAL));
        chezkButtonGroup.setText("Sex");

        Button checkButton1 = new Button(chezkButtonGroup, SWT.CHECK);
        checkButton1.setText("Male");

        Button checkButton2 = new Button(chezkButtonGroup, SWT.CHECK);
        checkButton2.setText("Female");

        Button checkButton3 = new Button(chezkButtonGroup, SWT.CHECK);
        checkButton3.setText("?");




        button.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent arg0) {
                if(text.getText().equals(checkButton1.getText())){
                    if(checkButton1.getSelection()){
                        checkButton1.setSelection(false);
                        display.update();
                    }else{
                        checkButton1.setSelection(true);
                        display.update();
                    }

                }else{
                    if(text.getText().equals(checkButton2.getText())){
                        if(checkButton2.getSelection()){
                            checkButton2.setSelection(false);
                            display.update();
                        }else{
                            checkButton2.setSelection(true);
                            display.update();
                        }

                    }else{
                        if(text.getText().equals(checkButton3.getText())){

                            if(checkButton3.getSelection()){
                                checkButton3.setSelection(false);
                                display.update();
                            }else{
                                checkButton3.setSelection(true);
                                display.update();
                            }
                        }else{
                            MessageBox messageBox = new MessageBox(shell,SWT.CANCEL);
                            messageBox.setMessage("IdiNah");
                            messageBox.setText("Soriamba");
                            int response = messageBox.open();
                            display.update();
                        }
                    }}

            }

        });
    }
}

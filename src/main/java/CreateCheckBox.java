import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.*;

import java.util.ArrayList;

public class CreateCheckBox {
    private Button button;
    private Button button2;
    private Button button3;
    private Label label;
    private Text text;
    private int time = 500;
    private Runnable timer;
    int first = 0;
    int last;
    boolean a = true;


    CreateCheckBox(Display display, Shell shell) {
        label = new Label(shell, SWT.NONE);
        label.setText("Your Text: ");

        // Text
        text = new Text(shell, SWT.BORDER);
        RowData layoutData = new RowData();
        layoutData.width = 150;

        text.setLayoutData(layoutData);
        text.setText("");

        button = new Button(shell, SWT.NONE);
        button.setText("Enter amount chekbox");

        button2 = new Button(shell, SWT.NONE);
        button2.setText("Start");

        button3 = new Button(shell, SWT.NONE);
        button3.setText("Stop");

        Group checkButtonGroup = new Group(shell, SWT.NONE);
        checkButtonGroup.setLayout(new RowLayout(SWT.HORIZONTAL));
        checkButtonGroup.setText("Check");

        ArrayList<Button> checkButton = new ArrayList<>();





        button.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent arg0) {
                int kol = Integer.parseInt(text.getText());
                if (checkButton.size() == 0) {
                    for (int i = 0; i < kol; i++) {
                        checkButton.add(new Button(checkButtonGroup, SWT.CHECK));
                    }
                    display.update();
                    first = 0;
                    last =checkButton.size()-1;
                } else {
                    for (Button but : checkButton) {
                        but.dispose();
                    }
                    display.update();
                    checkButton.clear();
                    for (int i = 0; i < kol; i++) {
                        checkButton.add(new Button(checkButtonGroup, SWT.CHECK));

                    }
                    first = 0;
                    last = checkButton.size()-1;
                }

                shell.layout();
            }

        });
        button2.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent arg0) {

                timer= new Runnable() {
                    @Override
                    public void run() {
                        if(checkButton.get(first).getSelection()){
                            checkButton.get(first).setSelection(false);
                            checkButton.get(last).setSelection(false);
                        }else{
                            checkButton.get(first).setSelection(true);
                            checkButton.get(last).setSelection(true);
                        }

                        display.update();

                        ++first;
                        --last;

                        if((checkButton.size()%2) == 0 ){
                            if(first >= last) {
                                first = 0;
                                last = checkButton.size() - 1;
                            }
                        }
                        if((checkButton.size()%2) == 1 ){
                            if(first > last) {
                                first = 0;
                                last = checkButton.size() - 1;
                            }
                        }

                        display.timerExec(time,this);
                    }
                };
                display.timerExec(time,timer);

            }


        });
        button3.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent arg0) {
                display.timerExec(-1,timer);
            }

        });
    }
}

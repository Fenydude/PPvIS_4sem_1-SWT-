import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.widgets.*;

public class RenameButton {
    private Button button1;
    private Button button2;
    private Text text;
    RenameButton(Display dysplay, Shell shell){
        button1 = new Button(shell,SWT.NONE);
        button1.setText("SetNameB2");

        button2 = new Button(shell,SWT.NONE);
        button2.setText("Swap");


        text = new Text(shell, SWT.BORDER);
        RowData layoutData = new RowData();
        layoutData.width = 400;

        Scale scale = new Scale(shell, SWT.HORIZONTAL);

        scale.setMaximum(400);
        scale.setMinimum(0);
        scale.setIncrement(1);
        scale.setPageIncrement(5);

        text.setLayoutData(layoutData);
        text.setText("");

        button1.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent arg0) {
                button2.setText(text.getText());

            }

        });

        button2.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent arg0) {
                String temp = new String();
                temp = button1.getText();
                button1.setText(button2.getText());
                button2.setText(temp);
                dysplay.update();
            }

        });

        scale.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                int value = scale.getMaximum() - scale.getSelection() + scale.getMinimum();
                RowData layoutData1 = new RowData();
                layoutData1.width = value;
                text.setLayoutData(layoutData1);
                shell.layout();
                dysplay.update();

            }
        });
    }
}

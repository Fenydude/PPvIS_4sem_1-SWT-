import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.*;

public class Main {

    public static void main(String[] args) {
        Display display = new Display();

        Shell shell = new Shell(display);

        RowLayout rowLayout = new RowLayout();
        rowLayout.marginLeft = 10;
        rowLayout.marginTop = 10;
        rowLayout.spacing = 40;
        shell.setLayout(rowLayout);


        AddItemToComboBox first = new AddItemToComboBox(display,shell);
        display.update();
        RenameButton second = new RenameButton(display,shell);
        display.update();
        RadioButtonCheck third = new RadioButtonCheck(display,shell);
        display.update();
        CheckBoxCheck foth = new CheckBoxCheck(display,shell);
        display.update();
        FillingInTable fifth = new FillingInTable(display,shell);
        display.update();
        CreateCheckBox individualTask = new CreateCheckBox(display, shell);
        display.update();

        //shell.pack();
        shell.open();
        shell.setSize(700,650);
        while (!shell.isDisposed()) {
            if (display.readAndDispatch()) {
                display.sleep();

            }
        }
        display.dispose();
    }

}


/* StackLayout stackLayout = new StackLayout();
        parent.setLayout(stackLayout);




        Button b1 = new Button(parent, SWT.NONE);
        b1.setText("B1");

        Button b2 = new Button(parent, SWT.NONE);
        b2.setText("B2");

        Button button3 = new Button(parent, SWT.NONE);
        button3.setText("Button 3");
        stackLayout.topControl =  button3;*/
// Windows back to natural size.
// shell.pack();
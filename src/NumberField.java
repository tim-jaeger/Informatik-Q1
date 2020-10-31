import javafx.scene.control.TextField;

public class NumberField extends TextField {

    public void setInt(int i) {

        super.setText(Integer.toString(i));
    }
}

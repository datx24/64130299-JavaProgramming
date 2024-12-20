package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class MainController {

    @FXML
    private TextField display;
    
    @FXML
    private Button btnAdd;
    @FXML
    private Button btnSubtract;
    @FXML
    private Button btnMultiply;
    @FXML
    private Button btnDivide;
    @FXML
    private Button btnEquals;

    private StringBuilder currentInput = new StringBuilder();
    private double result = 0;
    private String lastOperator = "=";

    // Phương thức khởi tạo
    @FXML
    private void initialize() {
        // Gán sự kiện cho các nút
    	btnAdd.setOnAction(event -> handleOperator("+"));
    	btnSubtract.setOnAction(event -> handleOperator("-"));
    	btnMultiply.setOnAction(event -> handleOperator("×"));
    	btnDivide.setOnAction(event -> handleOperator("÷"));
    	btnEquals.setOnAction(event -> handleOperator("="));
    }

    // Xử lý sự kiện nhấn trên các nút chứa số
    @FXML
    private void handleButtonClick(ActionEvent event) {
        Button button = (Button) event.getSource();
        String buttonText = button.getText();
        
        if ("0123456789.".contains(buttonText)) {
            currentInput.append(buttonText);
            display.setText(currentInput.toString());
        }
    }
    
    // Xử lý các phép toán cộng, trừ, nhân, chia
    private void handleOperator(String operator) {
        if (!currentInput.toString().isEmpty()) {
            double currentNumber = Double.parseDouble(currentInput.toString());
            switch (lastOperator) {
                case "+":
                    result += currentNumber;
                    break;
                case "-":
                    result -= currentNumber;
                    break;
                case "×":
                    result *= currentNumber;
                    break;
                case "÷":
                    if (currentNumber != 0) {
                        result /= currentNumber;
                    } else {
                        display.setText("Error!");
                        return;
                    }
                    break;
                case "=":
                    result = currentNumber;
                    break;
            }
            display.setText(String.valueOf(result));
            currentInput.setLength(0);
        }
        lastOperator = operator;
    }
    
    //Xử lý các hàm toán học khác
    @FXML
    private void handleMathFunction(ActionEvent event) {
        Button button = (Button) event.getSource();
        String buttonText = button.getText();
        
        double currentNumber = Double.parseDouble(currentInput.toString());

        switch (buttonText) {
            case "√":
                result = Math.sqrt(currentNumber);
                break;
            case "sin":
                result = Math.sin(Math.toRadians(currentNumber));
                break;
            case "cos":
                result = Math.cos(Math.toRadians(currentNumber));
                break;
            case "eˣ":
                result = Math.exp(currentNumber);
                break;
            case "ln":
                result = Math.log(currentNumber);
                break;
            case "π":
                currentInput.setLength(0);
                currentInput.append(Math.PI);
                display.setText(currentInput.toString());
                return;
        }

        display.setText(String.valueOf(result));
        currentInput.setLength(0);
    }
    
    // Xóa display
    @FXML
    private void clear() {
        currentInput.setLength(0);
        display.clear();
        result = 0;
        lastOperator = "=";
    }
    
    @FXML
    public void handlePi(javafx.event.ActionEvent event) {
        display.setText(String.valueOf(Math.PI)); // Hiển thị giá trị của π
    }
}

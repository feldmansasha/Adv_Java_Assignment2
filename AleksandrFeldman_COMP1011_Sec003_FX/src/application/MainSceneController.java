package application;

import java.math.BigInteger;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class MainSceneController {
	int number;
	BigInteger result;
	
	int months;
	double interest;
	int amount;
	double totalPayment;
	
	public BigInteger factorialHavingLargeResult(int n) {
	    BigInteger result = BigInteger.ONE;
	    for (int i = 2; i <= n; i++)
	        result = result.multiply(BigInteger.valueOf(i));
	    return result;
	}
	
	private double carLoanCalculator(int amount, double interest, int months) {
		interest/=1200;
		interest+=1;
		totalPayment=Math.round(amount*Math.pow(interest, months));
		return totalPayment;
	}
	@FXML
    private TextField amountLoan;

    @FXML
    private Button btn1Click;

    @FXML
    private TextField durationInput;

    @FXML
    private TextField inputFactorial;

    @FXML
    private Button interestClick;

    @FXML
    private TextField interestInput;

    @FXML
    private TextField outputFactorial;

    @FXML
    private TextField outputLoan;

    @FXML
    void factorialCount(ActionEvent event) {
    	number=Integer.valueOf(inputFactorial.getText());
    	result=factorialHavingLargeResult(number);
    	outputFactorial.setText(String.valueOf(result));
    }
    @FXML
    void carLoan(ActionEvent event) {
    	months=Integer.valueOf(durationInput.getText());
    	amount=Integer.valueOf(amountLoan.getText());
    	interest=Double.valueOf(interestInput.getText());
    	totalPayment=carLoanCalculator(amount, interest, months);
    	outputLoan.setText(Double.toString(totalPayment-amount));
    }

}
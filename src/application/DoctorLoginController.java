package application;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import application.ControlledScreen;
import application.Main;
import application.ScreensController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class DoctorLoginController implements Initializable, ControlledScreen {
	public DoctorLoginModel loginModal = new DoctorLoginModel();
	ScreensController myController;
	@FXML
	private TextField txtUserName,txtPassword;
	@FXML
	private Label isConnected;
	@FXML
	private Button Login,goBack;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		if(loginModal.isDBConnected()) {
			isConnected.setText("Connected");
		}
		else
		{
			isConnected.setText("Not Connected");
		}
		
	}
	public void login(ActionEvent event) throws Exception {
		try {
			//String password = EncryptDecrypt.encrypt(txtPassword.getText(),"123");
			//System.out.println(password);
			if(loginModal.isLogin(Integer.parseInt(txtUserName.getText()), txtPassword.getText())) {
				isConnected.setText("User name & Password is correct");
				myController.setScreen(Main.screen5ID);
			}
			else {
				isConnected.setText("User name & Password is incorrect");
			}
		} catch (SQLException e) {
			isConnected.setText("User name & Password is incorrect");
			
		}
	}
	
	public void goBack(ActionEvent event) throws IOException  {
		myController.setScreen(Main.screen1ID);
	}
	@Override
	public void setScreenParent(ScreensController screenPage) {
		// TODO Auto-generated method stub
		myController =screenPage;
	}
	

}

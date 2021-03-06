package views.highscores;

import utilities.DBUtility;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.WindowEvent;
import java.awt.Insets;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class HighScoresPromptPanel extends JPanel {
    private static final long serialVersionUID = -5350150586551425338L;
    private JTextField txtName;
    private HighScoreDialogFrame window;

    public HighScoresPromptPanel(HighScoreDialogFrame highScoreDialogFrame, final int score) {

        this.window = highScoreDialogFrame;

        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
        gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        setLayout(gridBagLayout);

        JLabel lblNewLabel = new JLabel("Congratulations, you obtained a high score!!");
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel.gridx = 4;
        gbc_lblNewLabel.gridy = 1;
        add(lblNewLabel, gbc_lblNewLabel);

        JLabel lblPleaseEnterYour = new JLabel("Please enter your name to record your score.");
        GridBagConstraints gbc_lblPleaseEnterYour = new GridBagConstraints();
        gbc_lblPleaseEnterYour.insets = new Insets(0, 0, 5, 5);
        gbc_lblPleaseEnterYour.gridx = 4;
        gbc_lblPleaseEnterYour.gridy = 2;
        add(lblPleaseEnterYour, gbc_lblPleaseEnterYour);

        txtName = new JTextField();
        GridBagConstraints gbc_textField = new GridBagConstraints();
        gbc_textField.insets = new Insets(0, 0, 5, 5);
        gbc_textField.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField.gridx = 4;
        gbc_textField.gridy = 3;
        add(txtName, gbc_textField);
        txtName.setColumns(10);

        JButton btnSubmitHighScore = new JButton("Submit High Score");
        btnSubmitHighScore.addActionListener(e -> {
            SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("MM/dd/yyyy");
            DBUtility.insertNewHighScore(txtName.getText(), DATE_FORMAT.format(Calendar.getInstance().getTime()), score);
            window.dispatchEvent(new WindowEvent(window, WindowEvent.WINDOW_CLOSING));
        });
        GridBagConstraints gbc_btnSubmitHighScore = new GridBagConstraints();
        gbc_btnSubmitHighScore.insets = new Insets(0, 0, 0, 5);
        gbc_btnSubmitHighScore.gridx = 4;
        gbc_btnSubmitHighScore.gridy = 4;
        add(btnSubmitHighScore, gbc_btnSubmitHighScore);

    }
}

package views.directions;

import views.Window;
import views.navbuttons.BackButton;

import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * The panel which contains instructions for the user.
 *
 * @author heshamsalman
 */
public class InstructionPanel extends JPanel {
    private static final long serialVersionUID = 8337054250198837572L;
    Window window;
    private JLabel image;
    private JScrollPane imageView;

    public InstructionPanel(Window window) {
        this.window = window;
        setupGui();
    }

    private void setupGui() {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        image = new JLabel(new ImageIcon(new File("Assets/PNG/Instructions.png").toString()));
        imageView = new JScrollPane();
        imageView.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        imageView.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        imageView.setViewportView(image);
        imageView.setSize(1280, 720);
        imageView.setPreferredSize(new Dimension(1280, 720));
        BackButton back = new BackButton(window);
        add(imageView, BorderLayout.CENTER);
        add(back, BorderLayout.NORTH);
    }
}

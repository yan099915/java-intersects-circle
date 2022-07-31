import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;

import java.awt.geom.*;

public class Main extends JFrame {
    final private Font mainFont = new Font("Segoe print", Font.BOLD, 18);
    // circle 1 information
    private static JLabel xLabel = new JLabel("Center X : ");
    private static JTextField x = new JTextField();
    private static JLabel yLabel = new JLabel("Center Y : ");
    private static JTextField y = new JTextField();
    private static JLabel diameterLabel = new JLabel("Radius : ");
    private static JTextField r = new JTextField();

    // circle 2 information
    private static JLabel xLabel2 = new JLabel("Input X : ");
    private static JTextField x2 = new JTextField();
    private static JLabel yLabel2 = new JLabel("Input Y : ");
    private static JTextField y2 = new JTextField();
    private static JLabel diameterLabel2 = new JLabel("Radius : ");
    private static JTextField r2 = new JTextField();

    private static JLabel intersect = new JLabel("Two Circle Intersect? NO");

    Shape oval = new Ellipse2D.Float(100, 100, 50, 50);
    Shape oval2 = new Ellipse2D.Float(255, 155, 50, 50);;

    JPanel drawPanel = new JPanel() {
        public void paint(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setPaint(Color.blue);
            g2.draw(oval);
            g2.draw(oval2);
        }
    };

    public void initialize() {
        /*************** Form Panel ***************/
        JPanel mainPanel = new JPanel();
        JPanel formPanel = new JPanel();
        JPanel inputForm1 = new JPanel();
        JPanel inputForm2 = new JPanel();
        JPanel buttonsPanel = new JPanel();

        mainPanel.setBackground(Color.red);
        mainPanel.add(formPanel);
        mainPanel.add(buttonsPanel);
        mainPanel.setLayout(new GridLayout(2, 1, 0, 0));

        formPanel.setLayout(new GridLayout(1, 2, 0, 0));
        formPanel.setBackground(Color.red);
        formPanel.add(inputForm1);
        formPanel.add(inputForm2);

        inputForm1.setBackground(Color.blue);
        inputForm1.setLayout(new GridLayout(3, 2, 15, 15));
        inputForm1.add(xLabel);
        inputForm1.add(x);
        inputForm1.add(yLabel);
        inputForm1.add(y);
        inputForm1.add(diameterLabel);
        inputForm1.add(r);
        inputForm1.setPreferredSize(new Dimension(250, 250));

        inputForm2.setBackground(Color.yellow);
        inputForm2.setLayout(new GridLayout(3, 2, 15, 15));
        inputForm2.add(xLabel2);
        inputForm2.add(x2);
        inputForm2.add(yLabel2);
        inputForm2.add(y2);
        inputForm2.add(diameterLabel2);
        inputForm2.add(r2);
        inputForm2.setPreferredSize(new Dimension(250, 250));

        buttonsPanel.setBackground(Color.green);
        buttonsPanel.setLayout(new GridLayout(2, 1, 33, 33));
        JButton btnStart = new JButton("Redraw Circles");
        btnStart.setFont(mainFont);
        buttonsPanel.add(intersect);
        buttonsPanel.add(btnStart);
        buttonsPanel.setPreferredSize(new Dimension(10, 55));

        setLayout(new GridLayout(2, 1, 0, 0));
        setTitle("TK-3 No.3 Yan Septyadi");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(400, 500);
        setMinimumSize(new Dimension(350, 450));
        // setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setVisible(true);
        add(mainPanel);
        add(drawPanel);

        btnStart.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    oval = new Ellipse2D.Float(Float.parseFloat(x.getText()), Float.parseFloat(y.getText()),
                            Float.parseFloat(r.getText()), Float.parseFloat(r.getText()));
                    oval2 = new Ellipse2D.Float(Float.parseFloat(x2.getText()), Float.parseFloat(y2.getText()),
                            Float.parseFloat(r2.getText()), Float.parseFloat(r2.getText()));

                    if (oval.intersects(Float.parseFloat(x2.getText()), Float.parseFloat(y2.getText()),
                            Float.parseFloat(r2.getText()), Float.parseFloat(r2.getText()))) {
                        buttonsPanel.setBackground(Color.red);
                        intersect.setText("Two Circle Intersect? YES");
                        intersect.setForeground(Color.white);
                    } else {
                        buttonsPanel.setBackground(Color.green);
                        intersect.setText("Two Circle Intersect? NO");
                        intersect.setForeground(Color.black);
                    }
                    remove(drawPanel);
                    repaint();
                    invalidate();
                    add(drawPanel);
                    revalidate();

                } catch (Exception ex1) {
                    JOptionPane.showMessageDialog(null, ex1, "Error!", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    }

    public static void main(String[] args) {
        try {

        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }

        Main loginForm = new Main();
        loginForm.initialize();
    }
}

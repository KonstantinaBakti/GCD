import java.awt.event.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;

public class GCD extends JFrame implements ActionListener {

    private JLabel gcdNum, teamGcd, firstNum, secondNum, result, teamNum;
    private JTextField fn, sn, tn;
    private JButton calculate, find;
    private JTextArea area;
    private JScrollPane scroll;
    private static ArrayList<Integer> team = new ArrayList<>();

    public static void main(String[] args) {
        GCD gcd = new GCD();
        gcd.setTitle("Calculate GCD");
        gcd.setSize(500, 360);
        gcd.setVisible(true);
        gcd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gcd.setLocationRelativeTo(null);
    }

    public GCD() {
        gcdNum = new JLabel("Find the GCD between two numbers");
        gcdNum.setFont(new Font("Times New Roman", Font.ITALIC, 16));
        gcdNum.setBounds(20, 10, 300, 30);

        firstNum = new JLabel("First number");
        firstNum.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        firstNum.setBounds(20, 40, 100, 30);

        fn = new JTextField(50);
        fn.setBackground(Color.WHITE);
        fn.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        fn.setBounds(100, 41, 60, 25);

        secondNum = new JLabel("Second number");
        secondNum.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        secondNum.setBounds(180, 40, 100, 30);

        sn = new JTextField(50);
        sn.setBackground(Color.WHITE);
        sn.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        sn.setBounds(280, 41, 60, 25);

        calculate = new JButton("Calculate");
        calculate.setFont(new Font("Times New Roman", Font.BOLD, 16));
        calculate.setBounds(360, 40, 100, 25);
        calculate.addActionListener(this);

        result = new JLabel("");
        result.setFont(new Font("Times New Roman", Font.BOLD, 16));
        result.setBounds(20, 75, 800, 30);

        teamGcd = new JLabel("Find the multiplicative group of Zn (Z*n)");
        teamGcd.setFont(new Font("Times New Roman", Font.ITALIC, 16));
        teamGcd.setBounds(20, 120, 300, 30);

        teamNum = new JLabel("Give n");
        teamNum.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        teamNum.setBounds(20, 160, 40, 30);

        tn = new JTextField(50);
        tn.setBackground(Color.WHITE);
        tn.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        tn.setBounds(65, 161, 60, 25);

        find = new JButton("Find");
        find.setFont(new Font("Times New Roman", Font.BOLD, 16));
        find.setBounds(180, 160, 90, 25);
        find.addActionListener(this);

        area = new JTextArea();
        area.setFont(new Font("Arial", Font.PLAIN, 12));
        area.setLineWrap(true);
        area.setEditable(false);

        scroll = new JScrollPane(area, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setBounds(20, 200, 445, 100);

        Container pane = getContentPane();
        pane.setLayout(null);
        pane.add(gcdNum);
        pane.add(firstNum);
        pane.add(fn);
        pane.add(secondNum);
        pane.add(sn);
        pane.add(calculate);
        pane.add(result);
        pane.add(teamGcd);
        pane.add(teamNum);
        pane.add(tn);
        pane.add(find);
        pane.add(scroll);
        pack();
    }

    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == calculate) {
            int first = Integer.parseInt(fn.getText());
            int second = Integer.parseInt(sn.getText());
            int res = gcd(first, second);
            result.setText("The GCD of those numbers is " + res);
        } else {
            int n = Integer.parseInt(tn.getText());
            findTeam(n);
            area.setText(team.toString());
        }
    }

    public static void findTeam(int n) {
        int x;
        for (int i = 0; i < n; i++) {
            x = gcd(i, n);
            if (x == 1) {
                team.add(i);
            }
        }
    }

    public static int gcd(int x, int y) {
        return (y == 0) ? x : gcd(y, x % y);
    }
}

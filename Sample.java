import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Pert8 extends JFrame implements ActionListener{
    private Image btnBrowse, gambar;
    JButton browse = new JButton();
    JPanel panel1 = new JPanel(new FlowLayout());
    JPanel panel2 = new JPanel(new BorderLayout());
    
    public Pert8() {
        setTitle("Image");
        setSize(900,700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        
        btnBrowse = new ImageIcon("Images/image.jpg").getImage();
        browse.setIcon(new ImageIcon(btnBrowse));
        browse.addActionListener(this);
        
        add(browse);
        
        panel1.add(browse);
        panel2.add(panel1, "First");

        add(panel2);
    }
    
    public void openFile()
    {
        JFileChooser fc = new JFileChooser("D:");
        int result = fc.showOpenDialog(this);
        if(result != JFileChooser.CANCEL_OPTION)
        {
            gambar = new ImageIcon(fc.getSelectedFile().toString()).getImage();
            repaint();
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == browse)
        {
            openFile();
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.
        Graphics2D g2d = (Graphics2D)g;
        g2d.drawImage(gambar, 50, 100, 800, 500, this);
    }
    
    
    public static void main(String[] args) {
        new Pert8();
    }
}
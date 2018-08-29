import java.awt.BorderLayout;
import java.awt.Graphics;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Tugas Besar 2 Pemrograman Berorientasi Objek.
 * @author K03-L
 * @version 1.0
 * @since 1.0
 */
public class DrawPet extends JLabel {

  private JPanel panel;
  private LinkedList<Pet> list;
  private Pet obj;
  private int notFound = -1;
  private ImageIcon leftSnail;
  private ImageIcon rightSnail;

  /**
  * Menggambar pet di swing.
  * @param tempP panel
  * @param tempL listnya
  * @param od objek pet yang di check
  * @param l left image
  * @param r right image
  */
  public DrawPet(JPanel tempP,LinkedList<Pet> tempL,Pet od,ImageIcon l, ImageIcon r) {
    panel = tempP;
    list = tempL;
    obj = od;
    leftSnail = l;
    rightSnail = r;
  }

  /**
   * Menggambar component.
   * @param g gambar graphics
   */
  @Override
  public void paintComponent(Graphics g) {
    int cari = list.find(obj);
    if (cari != notFound) {
      Point p = new Point();
      Pet temp = list.get(cari);
      p.setAbsis(temp.getPosisi().getAbsis());
      p.setOrdinat(temp.getPosisi().getOrdinat());
      this.setLocation(p.getAbsis(),p.getOrdinat());
      if (temp.getFaceRight()) {
        this.setIcon(rightSnail);
      } else {
        this.setIcon(leftSnail);
      }
    } else {
      obj = null;
      list = null;
      panel.remove(this);
      panel = null;
    }
    super.paintComponent(g);
  }
}
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
public class DrawPiranha extends JLabel {

  private JPanel panel;
  private LinkedList<Fish> list;
  private Fish fish;
  private int notFound = -1;
  private ImageIcon leftI;
  private ImageIcon rightI;
  private ImageIcon hungryLeftI;
  private ImageIcon hungryRightI;

  /**
   * gambar piranha object.
   * @param tempP panel gambar
   * @param tempLi listnya
   * @param tempF ikannya
   * @param left gambar kiri
   * @param right gambar kanan
   * @param hleft gambar lapar kiri
   * @param hright gambar lapar kanan
   */
  public DrawPiranha(JPanel tempP,LinkedList<Fish> tempLi,Fish tempF,
                     ImageIcon left,ImageIcon right,ImageIcon hleft,ImageIcon hright) {
    panel = tempP;
    list = tempLi;
    fish = tempF;
    leftI = left;
    rightI = right;
    hungryLeftI = hleft;
    hungryRightI = hright;
  }

  /**
   * penggambar.
   * @param g tempat gambar
   */
  @Override
  public void paintComponent(Graphics g) {
    int cari = list.find(fish);
    if (cari != notFound) {
      Point p = new Point();
      Fish temp = list.get(cari);
      p.setAbsis(temp.getPosisi().getAbsis());
      p.setOrdinat(temp.getPosisi().getOrdinat());
      this.setLocation(p.getAbsis(),p.getOrdinat());
      if (temp.isFaceRight()) {
        if (temp.isStarving()) {
          this.setIcon(hungryRightI);
        } else {
          this.setIcon(rightI);
        }

      } else {
        if (temp.isStarving()) {
          this.setIcon(hungryLeftI);
        } else {
          this.setIcon(leftI);
        }
      }
    } else {
      fish = null;
      list = null;
      panel.remove(this);
      panel = null;
    }
    super.paintComponent(g);
  }
}
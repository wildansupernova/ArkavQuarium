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
public class DrawCoin extends JLabel {
  private JPanel panel;
  private LinkedList<ObjekMati> list;
  private Koin objDead;
  private ImageIcon goldCoin;
  private ImageIcon silverCoin;
  private int notFound = -1;

  /**
   * draw coin.
   * @param tempP jpanel
   * @param tempL listnya
   * @param od objek yang dicek
   * @param g image gold
   * @param s image silver
   */
  public DrawCoin(JPanel tempP,LinkedList<ObjekMati> tempL,ObjekMati od,ImageIcon g, ImageIcon s) {
    panel = tempP;
    list = tempL;
    objDead = (Koin) od;
    goldCoin = g;
    silverCoin = s;
  }

  /**
   * ambil koin.
   * @return ambilkoin
   */
  public Koin getKoin() {
    return objDead;
  }

  /**
   * gambar.
   * @param g yang digambar
   */
  @Override
  public void paintComponent(Graphics g) {
    int cari = list.find(objDead);
    if (cari != notFound) {
      Point p = new Point();
      p.setAbsis(list.get(cari).getPosisi().getAbsis());
      p.setOrdinat(list.get(cari).getPosisi().getOrdinat());
      this.setLocation(p.getAbsis(),p.getOrdinat());

      //
      //Algoritma ganti warna coin taroh sini

      //
    } else {

      objDead = null;
      list = null;
      panel.remove(this);
      panel = null;
    }
    super.paintComponent(g);
  }
}
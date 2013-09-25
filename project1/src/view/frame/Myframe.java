/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.frame;
//sach,baibao,canbo
import view.canbo.Thongtincanbo;
import view.sinhvien.Sinhvien1;
import view.tienthigiangvien.Tienthicuagiangvien;
import view.sach.Sachview;
import view.dangphi.Dangphi;
import view.cacchaunhanqua.Cacchaunhanqua;
import view.bangphicongdoan.CongDoanPhi;
import view.baibao.BaiBaoView;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Calendar;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import model.baibao.IBaiBao;
import view.chamthi.ChamThiV;
import view.giangday.GiangDayV;
import view.nghiencuukhoahoc.NghienCuuKhoaHocV;
import view.sinhvien.Sinhvien2;
import view.sinhvien.Sinhvien3;

public class Myframe extends JFrame {

    private static int test;
    JMenu mthongke;
    JMenu mdichvu;
    JMenu mthongtinsinhvien;
    JMenu mgiupdo;
    JMenuItem mthongtincanbo;
    JMenuItem mkehoachgiangday;
    JMenuItem mchamthi;
    JMenuItem mgiaotrinh;
    JMenuItem mbaibaotapchi;
    JMenuItem mcongdoanphi;
    JMenuItem mdangphi;
    JMenuItem mtienthigiangvien;
    JMenuItem mhuongdansudung;
    JMenuItem mthieunhi;
    JPanel paneltop;
    JPanel panelcenter;
    JPanel panelMain;
    JLabel label;
    CardLayout c;
    JMenuBar menubar;
    JMenuItem msinhvien1;
    JMenuItem msinhvien2;
    JMenuItem msinhvien3;
//    pannelBanner pBanner;
//    pannelMenu pMenu;
    JPanel pBanner;
    JPanel pmenu;
    JButton buton1;
    JButton bgiangday;
    JButton bcanbo;
    JButton bmchamthi;
    JButton bmgiaotrinh;
    JButton bbaibao;
    JButton bmcongdoanphi;
    JButton bmdangphi;
    JButton bmtienthigiangvien;
    JButton bcacchau;
    JButton bhuongdan;
    JButton bexit;
    JButton bsinhvien1;
    JButton bsinhvien2;
    JButton bsinhvien3;
    JMenuItem mnghiencuukhoahoc;
    JButton bmnghiencuukhoahoc;
    JPanel paneltime;
    JLabel labeltime;
    JLabel jl;
    JMenuItem mthoat;

    public Myframe() {

        c = new CardLayout();
        panelMain = new JPanel(c);
        test = 0;
        panelMain.setBackground(Color.YELLOW);

        jl = new JLabel("CHƯƠNG TRÌNH QUẢN LÝ CÁN BỘ");
        jl.setFont(new Font("Serif", Font.PLAIN, 30));

        pBanner = new JPanel();

        pBanner.setPreferredSize(new Dimension(800, 100));
        pBanner.setBackground(Color.GREEN);
        pBanner.add(jl);

        buton1 = new JButton();
        pmenu = new JPanel();
        pmenu.setPreferredSize(new Dimension(150, 700));
        pmenu.setLayout(new FlowLayout());
        pmenu.setBackground(Color.blue);
        paneltime = new JPanel();
        labeltime = new JLabel();


        panelMain.add(buton1);
//        panelcenter = new JPanel();
//        panelcenter.add(new JButton("111111111"));

//        paneltop = new JPanel();

        menubar = new JMenuBar();

        mthongke = new JMenu("Thống Kê");
        mdichvu = new JMenu("Dịch Vụ");
        mthongtinsinhvien = new JMenu("Tác Giả");
        mgiupdo = new JMenu("Giúp Đỡ");
        mthongtincanbo = new JMenuItem("Thông tin cán bộ");
        mkehoachgiangday = new JMenuItem("Giảng Dạy");
        mchamthi = new JMenuItem("Chấm thi");
        mgiaotrinh = new JMenuItem("Giáo Trình");
        mbaibaotapchi = new JMenuItem("Bài báo tạp chí");
        mnghiencuukhoahoc = new JMenuItem("Nghiên Cứu Khoa Học");
        mcongdoanphi = new JMenuItem("Công đoàn phí");
        mdangphi = new JMenuItem("Đảng phí");
        mtienthigiangvien = new JMenuItem("Tiền thi giảng viên");
        mthieunhi = new JMenuItem("Các cháu trong độ tuổi nhận quà");
        msinhvien1 = new JMenuItem("Sinh Viên 1");
        msinhvien2 = new JMenuItem("Sinh Viên 2");
        msinhvien3 = new JMenuItem("Sinh Viên 3");
        mhuongdansudung = new JMenuItem("Hướng dẫn sử dụng");
        mthoat = new JMenuItem("Thoát");
        label = new JLabel("Chương Trình Quản Lý Cán Bộ");
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setSize(new Dimension());
        
        
          ImageIcon icanbo = new ImageIcon("canbo.png");
        ImageIcon igianday = new ImageIcon("giangday.png");
        ImageIcon ichamthi = new ImageIcon("chamthi.png");
        ImageIcon igiaotrinh= new ImageIcon("giaotrinh.png");
        ImageIcon ibaibao = new ImageIcon("baibao.png");
        ImageIcon idangphi = new ImageIcon("dangphi.png");
        ImageIcon idoanphi = new ImageIcon("doanphi.png");
        ImageIcon itienthi = new ImageIcon("tienthi.png");
        ImageIcon icacchau = new ImageIcon("cacchau.png");
        ImageIcon ikhoahoc = new ImageIcon("nghiencuu.png");
        ImageIcon ihuongdan = new ImageIcon("huongdan.png");
        ImageIcon isinhvien1 = new ImageIcon("sinhvien1.png");
        ImageIcon isinhvien2 = new ImageIcon("sinhvien2.png");
        ImageIcon isinhvien3 = new ImageIcon("sinhvien3.png");
        ImageIcon ithoat = new ImageIcon("thoat.png");

        bgiangday = new JButton("Giảng Dạy", igianday);
        bgiangday.setPreferredSize(new Dimension(100, 30));
        bcanbo = new JButton("Cán Bộ",icanbo);
        bcanbo.setPreferredSize(new Dimension(100, 30));
        bmchamthi = new JButton("Chấm Thi",ichamthi);
        bmchamthi.setPreferredSize(new Dimension(100, 30));
        bmgiaotrinh = new JButton("Giáo Trình", igiaotrinh);
        bmgiaotrinh.setPreferredSize(new Dimension(100, 30));
        bbaibao = new JButton("Bài Báo",ibaibao);
        bbaibao.setPreferredSize(new Dimension(100, 30));
        bmcongdoanphi = new JButton("Đoàn Phí",idoanphi);
        bmcongdoanphi.setPreferredSize(new Dimension(100, 30));
        bmdangphi = new JButton("Đảng Phí",idangphi);
        bmdangphi.setPreferredSize(new Dimension(100, 30));
        bmtienthigiangvien = new JButton("Tiền Thi",itienthi);
        bmtienthigiangvien.setPreferredSize(new Dimension(100, 30));
        bcacchau = new JButton("Các Cháu",icacchau);
        bcacchau.setPreferredSize(new Dimension(100, 30));
        bmnghiencuukhoahoc = new JButton("Khoa Học",ikhoahoc);
        bmnghiencuukhoahoc.setPreferredSize(new Dimension(100, 30));
        bhuongdan = new JButton("Hướng Dẫn",ihuongdan);
        bhuongdan.setPreferredSize(new Dimension(100, 30));
        bexit = new JButton("Thoát",ithoat);
        bexit.setPreferredSize(new Dimension(100, 30));
        bsinhvien1 = new JButton("Sinh Viên 1",isinhvien1);
        bsinhvien1.setPreferredSize(new Dimension(100, 30));
        bsinhvien2 = new JButton("Sinh Viên 2",isinhvien2);
        bsinhvien2.setPreferredSize(new Dimension(100, 30));
        bsinhvien3 = new JButton("Sinh Viên 3",isinhvien3);
        bsinhvien3.setPreferredSize(new Dimension(100, 30));
        paneltime.setPreferredSize(new Dimension(120, 20));
        init();
        addView();
        atc();
        runtime();


        setShortcut();

        setVisible(true);
    }//end

    void setShortcut() {
        mkehoachgiangday.setAccelerator(KeyStroke.getKeyStroke('Z', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        mthongtincanbo.setAccelerator(KeyStroke.getKeyStroke('X', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        mchamthi.setAccelerator(KeyStroke.getKeyStroke('C', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        mgiaotrinh.setAccelerator(KeyStroke.getKeyStroke('V', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        mbaibaotapchi.setAccelerator(KeyStroke.getKeyStroke('B', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        mnghiencuukhoahoc.setAccelerator(KeyStroke.getKeyStroke('N', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        mthoat.setAccelerator(KeyStroke.getKeyStroke('E', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        mcongdoanphi.setAccelerator(KeyStroke.getKeyStroke('M', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        mdangphi.setAccelerator(KeyStroke.getKeyStroke('A', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        mtienthigiangvien.setAccelerator(KeyStroke.getKeyStroke('S', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        mthieunhi.setAccelerator(KeyStroke.getKeyStroke('D', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        msinhvien1.setAccelerator(KeyStroke.getKeyStroke('F', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        msinhvien2.setAccelerator(KeyStroke.getKeyStroke('G', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        msinhvien3.setAccelerator(KeyStroke.getKeyStroke('H', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        mhuongdansudung.setAccelerator(KeyStroke.getKeyStroke('J', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));


    }//end

    void init() {
        setTitle("Chương Trình Quản Lý Cán Bộ");
        setSize(800, 710);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
    }

    void atc() {
        mthongtincanbo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                c.show(panelMain, "1");
            }
        });
        bcanbo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                c.show(panelMain, "1");

            }
        });
//        mhuongdansudung = new HuongDanSuDung(this);
        mhuongdansudung.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                c.show(panelMain, "0");

            }
        });
        bhuongdan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                c.show(panelMain, "0");

            }
        });

        mcongdoanphi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                c.show(panelMain, "3");

            }
        });
        bmcongdoanphi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                c.show(panelMain, "3");

            }
        });
        mdangphi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                c.show(panelMain, "4");

            }
        });
        bmdangphi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                c.show(panelMain, "4");

            }
        });
        mtienthigiangvien.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                c.show(panelMain, "5");

            }
        });
        bmtienthigiangvien.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                c.show(panelMain, "5");

            }
        });
        mthieunhi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                c.show(panelMain, "6");

            }
        });
        bcacchau.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                c.show(panelMain, "6");

            }
        });
        mgiaotrinh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                c.show(panelMain, "7");

            }
        });
        bmgiaotrinh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                c.show(panelMain, "7");

            }
        });
        mbaibaotapchi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                c.show(panelMain, "8");

            }
        });
        bbaibao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                c.show(panelMain, "8");

            }
        });
        msinhvien1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                c.show(panelMain, "9");
            }
        });
        bsinhvien1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                c.show(panelMain, "9");
            }
        });
        msinhvien2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                c.show(panelMain, "10");
            }
        });
        bsinhvien2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                c.show(panelMain, "10");
            }
        });
        msinhvien3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                c.show(panelMain, "11");
            }
        });
        bsinhvien3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                c.show(panelMain, "11");
            }
        });
        mchamthi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                c.show(panelMain, "12");
            }
        });
        bmchamthi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                c.show(panelMain, "12");

            }
        });
        mkehoachgiangday.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                c.show(panelMain, "13");
            }
        });
        bgiangday.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                c.show(panelMain, "13");

            }
        });

        mnghiencuukhoahoc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                c.show(panelMain, "14");
            }
        });
        bmnghiencuukhoahoc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                c.show(panelMain, "14");
            }
        });
        mthoat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int i = 0;
                int id = JOptionPane.showConfirmDialog(pmenu, "Ban Co Thuc Su Muon Thoat Khong ", "", i);
                if (id == 0) {
                    System.exit(0);
                }
            }
        });
        bexit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int i = 0;
                int id = JOptionPane.showConfirmDialog(pmenu, "Ban Co Thuc Su Muon Thoat Khong ", "", i);
                if (id == 0) {
                    System.exit(0);
                }
            }
        });
    }
//    void icon(){
//        ImageIcon icanbo = new ImageIcon("canbo.png");
//        ImageIcon igianday = new ImageIcon("giangday.png");
//        ImageIcon ichamthi = new ImageIcon("chamthi.png");
//        ImageIcon igiaotrinh= new ImageIcon("giaotrinh.png");
//        ImageIcon ibaibao = new ImageIcon("baibao.png");
//        ImageIcon idangphi = new ImageIcon("dangphi.png");
//        ImageIcon idoanphi = new ImageIcon("doanphi.png");
//        ImageIcon itienthi = new ImageIcon("tienthi.png");
//        ImageIcon icacchau = new ImageIcon("cacchau.png");
//        ImageIcon ikhoahoc = new ImageIcon("nghiencuu.png");
//        ImageIcon ihuongdan = new ImageIcon("huongdan.png");
//        ImageIcon ithoat = new ImageIcon("thoat.png");
//    }

    void addView() {
        mthongke.add(mthongtincanbo);
        mthongke.add(mkehoachgiangday);
        mthongke.add(mthongtincanbo);
        mthongke.add(mchamthi);
        mthongke.add(mgiaotrinh);
        mthongke.add(mbaibaotapchi);
        mthongke.add(mnghiencuukhoahoc);
        mthongke.add(mthoat);

        mthongtinsinhvien.add(msinhvien1);
        mthongtinsinhvien.add(msinhvien2);
        mthongtinsinhvien.add(msinhvien3);

        mdichvu.add(mcongdoanphi);
        mdichvu.add(mdangphi);
        mdichvu.add(mtienthigiangvien);
        mdichvu.add(mtienthigiangvien);
        mdichvu.add(mthieunhi);
//        mdichvu.add(thanhtichmthieunhi);

        mgiupdo.add(mhuongdansudung);

        menubar.add(mthongke);
        menubar.add(mdichvu);
        menubar.add(mthongtinsinhvien);
        menubar.add(mgiupdo);
        panelMain.add(new Sinhvien1(this), "9");
        panelMain.add(new HuongDanSuDung(this), "0");
        panelMain.add(new Thongtincanbo(this), "1");
        panelMain.add(new CongDoanPhi(this), "3");
        panelMain.add(new Dangphi(this), "4");
        panelMain.add(new Tienthicuagiangvien(this), "5");
        panelMain.add(new Cacchaunhanqua(this), "6");
        panelMain.add(new Sachview(this), "7");
        panelMain.add(new BaiBaoView(this), "8");
        panelMain.add(new Sinhvien2(this), "10");
        panelMain.add(new Sinhvien3(this), "11");
        panelMain.add(new ChamThiV(this), "12");
        panelMain.add(new GiangDayV(this), "13");
        panelMain.add(new NghienCuuKhoaHocV(this), "14");

        paneltime.add(labeltime);

        pmenu.add(bgiangday);
        pmenu.add(bcanbo);
        pmenu.add(bmchamthi);
        pmenu.add(bmgiaotrinh);
        pmenu.add(bbaibao);
        pmenu.add(bmdangphi);
        pmenu.add(bmcongdoanphi);
//        pmenu.add(bmtienthigiangvien);
        pmenu.add(bcacchau);
        pmenu.add(bmnghiencuukhoahoc);
        pmenu.add(bhuongdan);
        pmenu.add(bsinhvien1);
        pmenu.add(bsinhvien2);
        pmenu.add(bsinhvien3);
        pmenu.add(bexit);
        pmenu.add(paneltime);


        add(panelMain, BorderLayout.CENTER);
        add(pBanner, BorderLayout.NORTH);
        add(pmenu, BorderLayout.WEST);
        c.show(panelMain, "0");
        setJMenuBar(menubar);
        setResizable(false);

    }

    void runtime() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    labeltime.setText(timer());
                }
            }
        });
        thread.start();
    }

    String timer() {
        Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR);
        int minus = c.get(Calendar.MINUTE);
        int second = c.get(Calendar.SECOND);
        return "Thời Gian : " + hour + ":" + minus + ":" + second;
    }

    public static void main(String[] args) {
        new Myframe();
    }
}

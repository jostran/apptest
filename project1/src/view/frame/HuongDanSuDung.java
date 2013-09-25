/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.frame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Tran Xuan Truong
 */
public class HuongDanSuDung extends JPanel {

    Myframe m;
    JLabel lbl1;
    JLabel lbl2;
    JLabel lbl3;
    JLabel lbl4;
    JLabel lbl5;
    JLabel lbl6;
    JLabel lbl7;
    JLabel lbl8;
    JLabel lbl9;
    JLabel lbl10;
    JLabel lbl11;


    public HuongDanSuDung(Myframe m) {
        this.m = m;
        setPreferredSize(new Dimension(200, 300));
//        setLayout(new FlowLayout(5, 5, 5));
        setForeground(Color.BLUE);
      
        setBorder(BorderFactory.createBevelBorder(1, Color.yellow, Color.black));

        lbl1 = new JLabel("Hướng Dẫn Sử Dụng");
        lbl2 = new JLabel("Bước 1:Hãy Click vào các nút bên trái hoặc các lựa chọn trong thanh Menu ");
        lbl3 = new JLabel("ở trên cùng bên trái để  mở các mục mà bạn muốn làm việc");
        lbl4 = new JLabel("Bước 2:Hãy Click vào các nút Thêm,Sửa,Xóa để thực hiện các thao tác");
        lbl5 = new JLabel("Bước 3:Sau khi thực hiện các thao tác,hãy nhấn nút Cập Nhật để làm mới");
        lbl7 = new JLabel("danh sách bạn đã thao tác");
        lbl8 = new JLabel("Bước 4:Nếu bạn muốn tìm kiếm gì thì chỉ cần chọn mục xem bạn muốn tìm");
        lbl9 = new JLabel("kiếm theo cái gì là sẽ tự hiện ra danh sách bạn cần tìm");
        lbl10 = new JLabel("Bước 5:Muốn thoát khỏi phần mềm thì bạn hãy Click vào dấu nhấn bên");
        lbl11 = new JLabel("phải trên cùng hoặc nhấn nút Exit");


        Dimension d =  new Dimension(500,40);
        
        lbl1.setPreferredSize(d);
        lbl2.setPreferredSize(d);
        lbl3.setPreferredSize(d);
        lbl4.setPreferredSize(d);
        lbl5.setPreferredSize(d);
//        lbl6.setPreferredSize(d);
        lbl7.setPreferredSize(d);
        lbl8.setPreferredSize(d);
        lbl9.setPreferredSize(d);
        lbl10.setPreferredSize(d);
        lbl11.setPreferredSize(d);
        
        lbl1.setForeground(Color.BLACK);
        lbl2.setForeground(Color.BLUE);
        lbl3.setForeground(Color.BLUE);
        lbl4.setForeground(Color.BLUE);
        lbl5.setForeground(Color.BLUE);
        lbl7.setForeground(Color.BLUE);
        lbl8.setForeground(Color.BLUE);
        lbl9.setForeground(Color.BLUE);
        lbl10.setForeground(Color.BLUE);
        lbl11.setForeground(Color.BLUE);
        lbl1.setFont(new Font("italic", 24, 24));

        
        add(lbl1);
        add(lbl2);
        add(lbl3);
        add(lbl4);
        add(lbl5);
//        add(lbl6);
        add(lbl7);
        add(lbl8);
        add(lbl9);
        add(lbl10);
        add(lbl11);
       
        
        
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package kaweshop;

import MT.userlogin;
import user.enterscreen;
import user.framecode;
import user.userloginx;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author KWHY 
 */
public class Kaweshop {
    private static java.sql.Connection koneksi;
    
    public static java.sql.Connection getkawe(){
        if (koneksi ==null){
            try{
                String url = "jdbc:mysql://localhost:3306/kaweshop";
                String user = "root";
                String password = "";
                DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
                koneksi = DriverManager.getConnection(url,user, password);
                System.out.println("Koneksi Berhasil Dilakukan");   
            }catch (SQLException ex){
                System.out.println("Koneksi Gagal");
            }
        }
        return koneksi;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        getkawe();
        enterscreen screen = new enterscreen();
        userlogin sign = new userlogin();
        screen.setVisible(true);
        try {
            for (int row = 0; row <=100; row++) {
                Thread.sleep(100);
                screen.loadingnumber.setText(Integer.toString(row)+"%");
                screen.loadingprogress.setValue(row);
                if (row == 100) {
                    
                    screen.setVisible(false);
                    sign.setVisible(true);
                }
            }
        } catch (Exception e) {
        }
    }
}
    

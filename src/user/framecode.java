/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package user;




/**
 *
 * @author KWHY
 */
public class framecode {
    public static void main(String[] args) {
        enterscreen screen = new enterscreen();
        userloginx sign = new userloginx();
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

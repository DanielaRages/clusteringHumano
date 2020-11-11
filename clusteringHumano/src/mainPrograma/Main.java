package mainPrograma;

import java.awt.EventQueue;

import Interfaz.principal;

public class Main {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    principal menu = new principal();
                    menu.getFrame().setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

}

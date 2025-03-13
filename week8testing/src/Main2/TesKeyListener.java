package Main2;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner;

public class TesKeyListener implements KeyListener{

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println(e.getKeyChar()+" Typed");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println(e.getKeyChar()+" Pressed");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println(e.getKeyChar()+" Released");
    }
}

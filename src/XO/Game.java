package XO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public class Game extends JComponent {

    public static final int FIELD_EMPTY = 0;
    public static final int FIELD_X = 10;
    public static final int FIELD_0 = 200;
    int[][] field;
    boolean isX;
    int hod = 0;

    public Game(){
        enableEvents(AWTEvent.MOUSE_EVENT_MASK);
        field = new int[3][3];
        initGame();
    }

    public void initGame(){
        for(int i = 0; i<3; i++){
            for(int j = 0; j <3; j++){
                field[i][j] = FIELD_EMPTY;
            }
        }
        isX = true;
        hod = 0;
    }

    @Override
    protected void processMouseEvent(MouseEvent e) {
        super.processMouseEvent(e);
        if(e.getButton() == MouseEvent.BUTTON1){
            int x = e.getX();
            int y = e.getY();

            int i = (int)((float)x/getWidth()*3);
            int j = (int)((float)y/getHeight()*3);
            if(field[i][j] == FIELD_EMPTY){
                field[i][j] = FIELD_X;
                repaint();
                int k = 0;
                if(hod != 4) {
                    while (k == 0) {
                        int a = (int) (Math.random() * 3);
                        int b = (int) (Math.random() * 3);
                        if (field[a][b] == FIELD_EMPTY) {
                            field[a][b] = FIELD_0;
                            k = 1;
                            hod+=1;
                            repaint();
                        }
                    }
                }
                repaint();
                int res = checkState();
                if(res!=0){
                    if(res == FIELD_0*3){
                        JOptionPane.showMessageDialog(this, "Нолики победили!", "Победа!", JOptionPane.INFORMATION_MESSAGE);
                    } else if(res == FIELD_X*3){
                        JOptionPane.showMessageDialog(this, "Крестики победили!", "Победа!", JOptionPane.INFORMATION_MESSAGE);
                    } else{
                        JOptionPane.showMessageDialog(this, "Ничья", "Ничья!", JOptionPane.INFORMATION_MESSAGE);
                    }
                    initGame();
                    repaint();
                }
            }
        }
    }

    public void drawX(int i, int j, Graphics g){
        g.setColor(Color.RED);
        int dw = getWidth()/3;
        int dh = getHeight()/3;
        int x = i*dw;
        int y = j*dh;
        g.drawLine(x, y, x+dw, y+dh);
        g.drawLine(x, y + dh, x+dw, y);
    }

    public void draw0(int i, int j, Graphics g){
        g.setColor(Color.GREEN);
        int dw = getWidth()/3;
        int dh = getHeight()/3;
        int x = i * dw;
        int y = j * dh;
        g.drawOval(x + 5*dw/100, y, dw*9/10, dh);
    }

    public void drawX0(Graphics g){
        for(int i = 0; i <3; i++){
            for(int j = 0; j < 3; j++){
                if(field[i][j]==FIELD_X){
                    drawX(i, j, g);
                } else if (field[i][j] == FIELD_0){
                    draw0(i, j, g);
                }
            }
        }
    }

    public int checkState(){
        int d1 = 0;
        int d2 = 0;
        for(int i = 0; i <3; i++){
            d1+=field[i][i];
            d2+=field[i][2-i];
        }
        if(d1 == 3*FIELD_0 || d1 == FIELD_X*3){
            return d1;
        }
        if(d2 == 3*FIELD_0 || d2 == FIELD_X*3){
            return d2;
        }
        int check_i, check_j;
        boolean hasEmpty = false;

        for (int i = 0; i<3; i++){
            check_i = 0;
            check_j = 0;
            for(int j =0; j<3; j++){
                if(field[i][j]==0){
                    hasEmpty = true;
                }
                check_i +=field[i][j];
                check_j +=field[j][i];
            }

            if(check_i == 3*FIELD_0 || check_i == FIELD_X*3){
                return check_i;
            }
            if(check_j == 3*FIELD_0 || check_j == FIELD_X*3){
                return check_j;
            }
        }
        if(hasEmpty){
            return 0;
        } else{
            return -1;
        }
    }

    public void drawGrid(Graphics g){
        int w = getWidth();
        int h = getHeight();
        int dw = w / 3;
        int dh = h / 3;
        g.setColor(Color.BLACK);
        for(int i = 1; i<3; i++){
            g.drawLine(0, dh*i, w, dh*i);
            g.drawLine(dw*i, 0, dw*i, h);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawGrid(g);
        drawX0(g);
    }
}
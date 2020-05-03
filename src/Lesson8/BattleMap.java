package Lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BattleMap extends JPanel {
    private GameWindow gameWindow;

    public static final int MODE_H_V_A = 0;
    public static final int MODE_H_V_H = 1;

    private int fieldSizeX;
    private int fieldSizeY;
    private int winLength;
    private int turn = 0;
    private int cellHeight;
    private int cellWidth;
    protected static int gameMode;
    private static Image img;
    static int a;
    private boolean isInit = false;


    public BattleMap(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
        setBackground(Color.ORANGE);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                update(e);
            }
        });

    }

    protected void update(MouseEvent e) {
        int cellX = e.getX() / cellWidth;
        int cellY = e.getY() / cellHeight;

        if (!Logic.gameFinished) {
            if (gameMode == 0) {
                Logic.setHumanXY(cellX, cellY, 'X');
            } else {
                if (turn == 0) {
                    Logic.setHumanXY(cellX, cellY, 'X');
                } else {
                    Logic.setHumanXY(cellX, cellY, 'O');
                }
                turn = 1 - turn;
            }
        }
        repaint();

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        render(g);


        if (Logic.gameFinished) {
            drawWinLine(g, Logic.winx, Logic.winy, Logic.wina, Logic.winb);
            repaint();
        }
        if (Logic.gameFinished) {
            drawResult(g, Logic.result);
        }
    }

    private void render(Graphics g) {
        if (!isInit) {
            return;
        }

        int panelWidth = getWidth();
        int panelHeight = getHeight();

        cellHeight = panelHeight / fieldSizeY;
        cellWidth = panelWidth / fieldSizeX;

        for (int i = 0; i < fieldSizeY; i++) {
            int y = i * cellHeight;
            g.drawLine(0, y, panelWidth, y);
        }

        for (int i = 0; i < fieldSizeX; i++) {
            int x = i * cellWidth;
            g.drawLine(x, 0, x, panelHeight);
        }

        for (int i = 0; i < Logic.SIZE; i++) {
            for (int j = 0; j < Logic.SIZE; j++) {
                if (Logic.map[i][j] == Logic.DOT_O) {
                    drawO(g, j, i);
                }
                if (Logic.map[i][j] == Logic.DOT_X) {
                    drawX(g, j, i);
                }
            }
        }
    }

    private void drawO(Graphics g, int cellX, int cellY) {
        Graphics2D g2D = (Graphics2D) g;
        g2D.setStroke(new BasicStroke(5));
        g.setColor(new Color(255, 0, 0));
        g.drawOval(cellX * cellWidth + cellWidth / 4, cellY * cellHeight + cellWidth / 4, cellWidth / 2, cellHeight / 2);

    }

    private void drawX(Graphics g, int cellX, int cellY) {
        Graphics2D g2D = (Graphics2D) g;
        g2D.setStroke(new BasicStroke(5));
        g.setColor(new Color(0, 0, 255));
        g.drawLine(cellX * cellWidth + cellWidth / 4, cellY * cellHeight + cellHeight / 4,
                (cellX + 1) * cellWidth - cellWidth / 4, (cellY + 1) * cellHeight - cellHeight / 4);
        g.drawLine(cellX * cellWidth + cellWidth / 4, (cellY + 1) * cellHeight - cellHeight / 4,
                (cellX + 1) * cellWidth - cellWidth / 4, (cellY) * cellHeight + cellHeight / 4);

    }

    public void drawWinLine(Graphics g, int x1, int y1, int x2, int y2) {
        if (Logic.checkWin('X') || Logic.checkWin('O')) {
            Graphics2D g2D = (Graphics2D) g;
            g2D.setStroke(new BasicStroke(10));
            g.setColor(new Color(0, 255, 0));
            g.drawLine(x1 * cellWidth + cellWidth / 2, (y1) * cellHeight + cellHeight / 2,
                    y2 * cellWidth + cellWidth / 2, x2 * cellHeight + cellHeight / 2);
        }
    }

    public static void drawResult(Graphics g, int result) {
        switch (result) {
            case (1):
                img = new ImageIcon("C:/Java/Java_106042020/src/Lesson8/1.png").getImage();
                break;
            case (2):
                img = new ImageIcon("C:/Java/Java_106042020/src/Lesson8/2.png").getImage();
                break;
            case (3):
                img = new ImageIcon("C:/Java/Java_106042020/src/Lesson8/3.png").getImage();
                break;
        }
            g.drawImage(img, 150, 150, 200, 200, null);
    }

    void startNewGame(int gameMode, int fieldSizeX, int fieldSizeY, int winLength) {
        this.gameMode = gameMode;
        this.fieldSizeX = fieldSizeX;
        this.fieldSizeY = fieldSizeY;
        this.winLength = winLength;
        isInit = true;
        repaint();
    }
}

package Lesson8;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {
    private static final int WIN_HEIGHT = 555;
    private static final int WIN_WIDTH  = 507;
    private static final int WIN_POS_X  = 400;
    private static final int WIN_POS_Y  = 100;

    private StartNewGameWindow startNewGameWindow;
    private BattleMap field;

    public GameWindow(){
        setBounds(WIN_POS_X,WIN_POS_Y,WIN_WIDTH,WIN_HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Крестики-нолики");
        setResizable(false);

        startNewGameWindow = new StartNewGameWindow(this);
        field = new BattleMap(this);
        add(field,BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new GridLayout(1,2));
        JButton btnNewGame = new JButton("Новая игра");
        bottomPanel.add(btnNewGame);

        btnNewGame.addActionListener(e->{
            startNewGameWindow.setVisible(true);
        });

        JButton btnExit = new JButton("Выйти");
        bottomPanel.add(btnExit);

        btnExit.addActionListener(e->{
            System.exit(0);
        });

        add(bottomPanel, BorderLayout.SOUTH);

        setVisible(true);

    }

    void startNewGame(int gameMode, int fieldSizeX, int fieldSizeY, int winLength){
        field.startNewGame(gameMode, fieldSizeX, fieldSizeY, winLength);
    }
}

package Lesson8;

import javax.swing.*;
import java.awt.*;

public class StartNewGameWindow extends JFrame {
    private static final int WIN_HEIGHT = 450;
    private static final int WIN_WIDTH  = 400;
    private static final int WIN_POS_X  = 450;
    private static final int WIN_POS_Y  = 150;
    private static final int MIN_FIELD_SIZE  = 3;
    private static final int MAX_FIELD_SIZE  = 10;
    private static final int MIN_WIN_LENGTH = 3;
    private static final int MAX_DIFFICULT = 4;
    private static final int MIN_DIFFICULT = 1;



    private JRadioButton jrbHumVsAi;
    private JRadioButton jrbHumVsHum;
    private ButtonGroup gameMode;

    private JSlider jsDifficult;
    private JSlider jsFieldSize;
    private JSlider jsWinLength;

    private GameWindow gameWindow;

    public StartNewGameWindow(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
        setBounds(WIN_POS_X,WIN_POS_Y,WIN_WIDTH,WIN_HEIGHT);
        setTitle("Настройки");
        setResizable(false);
        setLayout(new GridLayout(10,1));

        //gameMode
        add(new JLabel("Выберите режим:"));
        jrbHumVsAi = new JRadioButton("Против компьютера",true);
        jrbHumVsHum = new JRadioButton("На двоих");
        gameMode = new ButtonGroup();
        gameMode.add(jrbHumVsAi);
        gameMode.add(jrbHumVsHum);
        add(jrbHumVsAi);
        add(jrbHumVsHum);

        //difficult
        add(new JLabel("Выберите сложность ИИ:"));
        jsDifficult = new JSlider(MIN_DIFFICULT,MAX_DIFFICULT,MAX_DIFFICULT);
        add(jsDifficult);
        jsDifficult.setMajorTickSpacing(1);
        jsDifficult.setPaintLabels(true);
        jsDifficult.setPaintTicks(true);
        jsDifficult.addChangeListener(e->{
            Logic.difficult = jsDifficult.getValue();
        });
        //size
        add(new JLabel("Размер поля:"));
        jsFieldSize = new JSlider(MIN_FIELD_SIZE,MAX_FIELD_SIZE,MIN_FIELD_SIZE);
        add(jsFieldSize);
        jsFieldSize.setMajorTickSpacing(1);
        jsFieldSize.setPaintLabels(true);
        jsFieldSize.setPaintTicks(true);

        jsFieldSize.addChangeListener(e->{
            int fieldSize = jsFieldSize.getValue();
            jsWinLength.setMaximum(fieldSize);
        });
        //dots to win
        add(new JLabel("Длина выигрышной линии:"));
        jsWinLength = new JSlider(MIN_WIN_LENGTH, MIN_FIELD_SIZE, MIN_WIN_LENGTH);
        add(jsWinLength);
        jsWinLength.setMajorTickSpacing(1);
        jsWinLength.setPaintLabels(true);
        jsWinLength.setPaintTicks(true);


        //buttonOk
        JButton btnStartGame = new JButton("Start game");
        add(btnStartGame, BorderLayout.SOUTH);
        btnStartGame.addActionListener(e->{
            btnStartGameClick();
        });

        setVisible(false);
    }

    private void btnStartGameClick(){
        setVisible(false);
        int gameMode;
        if(jrbHumVsAi.isSelected()){
            gameMode = BattleMap.MODE_H_V_A;
        } else {
            gameMode = BattleMap.MODE_H_V_H;
        }
        int fieldSize = jsFieldSize.getValue();
        int winLength = jsWinLength.getValue();

        Logic.SIZE = fieldSize;
        Logic.DOTS_TO_WIN = winLength;
        Logic.createMap();
        Logic.gameFinished = false;

        gameWindow.startNewGame(gameMode, fieldSize,fieldSize,winLength);

    }
}

package com.example.demo;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private Label questionLabel;

    private String pravilnyOtvet = "";
    private int score = 0;

    private final int MAX_VOPROSOV = 10;
    private int nomerVoprosa = 1;

    private final Random random = new Random();
    private final String[] noty = {"C", "D", "E", "F", "G", "A", "B"};

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        questionLabel.setText("Вопрос 1/" + MAX_VOPROSOV + "\nНажмите ноту: " + sgenerirovatVopros());
    }

    @FXML
    protected void onNoteC() { proveritOtvet("C"); }
    @FXML
    protected void onNoteD() { proveritOtvet("D"); }
    @FXML
    protected void onNoteE() { proveritOtvet("E"); }
    @FXML
    protected void onNoteF() { proveritOtvet("F"); }
    @FXML
    protected void onNoteG() { proveritOtvet("G"); }
    @FXML
    protected void onNoteA() { proveritOtvet("A"); }
    @FXML
    protected void onNoteB() { proveritOtvet("B"); }

    private void proveritOtvet(String nazhatayaNota) {
        if (nazhatayaNota.equals(pravilnyOtvet)) {
            score++;
        }

        nomerVoprosa++;

        if (nomerVoprosa > MAX_VOPROSOV) {
            questionLabel.setText("Игра окончена!\nВаш результат: " + score + " из " + MAX_VOPROSOV);
        } else {
            if (nazhatayaNota.equals(pravilnyOtvet)) {
                questionLabel.setText("Верно! Очки: " + score + " из " + MAX_VOPROSOV + "\nВопрос " + nomerVoprosa + "/" + MAX_VOPROSOV + "\nНажмите ноту: " + sgenerirovatVopros());
            } else {
                questionLabel.setText("Ошибка! Это была нота " + pravilnyOtvet + "\nОчки: " + score + " из " + MAX_VOPROSOV + "\nВопрос " + nomerVoprosa + "/" + MAX_VOPROSOV + "\nНажмите ноту: " + sgenerirovatVopros());
            }
        }
    }

    private String sgenerirovatVopros() {
        pravilnyOtvet = noty[random.nextInt(noty.length)];
        return pravilnyOtvet;
    }
}
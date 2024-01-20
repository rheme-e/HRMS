package org.example.hrms.Helper;

import javax.swing.*;
import java.awt.*;

public class Message {
    public static void showMessage(String message){
            String msg;
            switch (message) {
                case "fill":
                    msg = "Tüm alanları doldurunuz!";
                    break;
                case "success":
                    msg = "İşlem başarı ile gerçekleşti!";
                    break;
                case "error":
                    msg = "İşlem gerçekleşemedi";
                    break;
                default:
                    msg = message;
            }
    }
}

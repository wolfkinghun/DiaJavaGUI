package com.example.diagui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileNotFoundException;
import java.security.cert.Extension;
import java.util.ArrayList;
import java.util.Scanner;

public class HelloController {
    public ListView<String>lsList;
    public ComboBox<String> cbList;
    public CheckBox cbfekete;
    public CheckBox cbszines;
    public  Label dbok;
    FileChooser fc = new FileChooser();
    public class Adat{
        String rendezveny;
        Integer ev;
        Integer kocka;
        String szines;

        public Adat(String sor){
            String[]s=sor.split(";");
            rendezveny=s[0];
            ev= Integer.parseInt(s[1]);
            kocka= Integer.parseInt(s[2]);
            szines = s[3];
        }
    }
    ArrayList<Adat> esemenyek=new ArrayList<Adat>();

    ArrayList<String>varosok=new ArrayList<>();
    public void initialize(){
        fc.setInitialDirectory(new File("./"));
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Szövegfájl","*.csv"));
    }
    public void onmegnyit(ActionEvent actionEvent) {
        File fbe= fc.showOpenDialog(lsList.getScene().getWindow());
        Scanner be= null;
        try {
            be= new Scanner(fbe,"utf-8");
            be.nextLine();
            while(be.hasNextLine())esemenyek.add(new Adat(be.nextLine()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            if(be!=null)be.close();
        }
        for(Adat x: esemenyek){
            cbList.getItems().add(String.valueOf(x.ev));
            cbList.getSelectionModel().select(0);
        }
        int hsz = 0;
        for(Adat x: esemenyek){
            if(x.ev.equals(Integer.parseInt(cbList.getSelectionModel().getSelectedItem()))){
                lsList.getItems().add(String.format("%s (%d, %d kocka, %s)",x.rendezveny,x.ev,x.kocka,x.szines.equals("I")? "szines":"fekete-feher"));
                hsz ++;
            }
            dbok.setText(hsz+"-db");
        }
    }
    public void onvalaszt(){
        lsList.getItems().clear();
        int hsz= 0;
        String ev=cbList.getSelectionModel().getSelectedItem();
        for(Adat x:esemenyek){
            if(Integer.parseInt(ev)==x.ev && cbfekete.isSelected() && cbszines.isSelected()){
                lsList.getItems().add(String.format("%s (%d, %d kocka, %s)",x.rendezveny,x.ev,x.kocka,x.szines.equals("I")? "szines":"fekete-feher"));
                hsz ++;
            }
            else if(Integer.parseInt(ev)==x.ev && cbfekete.isSelected() && !cbszines.isSelected() && x.szines.equals("N")){
                lsList.getItems().add(String.format("%s (%d, %d kocka, %s)",x.rendezveny,x.ev,x.kocka,x.szines.equals("I")? "szines":"fekete-feher"));
                hsz ++;
            }
            else if(Integer.parseInt(ev)==x.ev && !cbfekete.isSelected() && cbszines.isSelected() && x.szines.equals("I")){
                lsList.getItems().add(String.format("%s (%d, %d kocka, %s)",x.rendezveny,x.ev,x.kocka,x.szines.equals("I")? "szines":"fekete-feher"));
                hsz ++;
            }
            dbok.setText(hsz+"-db");
        }
    }

    public void onbezar(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void onnevjegy(ActionEvent actionEvent) {
        Alert info= new Alert(Alert.AlertType.INFORMATION);
        info.setHeaderText(null);
        info.setTitle("Névjegy");
        info.setContentText("Dia v1.0.0\n (C) Kandó");
        info.showAndWait();
    }
}
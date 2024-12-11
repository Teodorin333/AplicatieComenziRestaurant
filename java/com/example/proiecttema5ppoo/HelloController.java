package com.example.proiecttema5ppoo;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Clasa ce detine controlul ferestrei principale a aplicatiei
 */
public class HelloController {
    @FXML
    private Button exitButton;

    /**
     * Fisierul de intrare a datelor. Contine comenzile efectuate de restaurant. Poate fi suprascris la inchiderea programului.
     */
    private String dateOut = "C:\\Users\\Test\\IdeaProjects\\ProiectTema5PPOO\\src\\out.txt";
    /**
     * Fisierul de iesire a raportului generat automat.
     */
    private String raportOut = "C:\\Users\\Test\\IdeaProjects\\ProiectTema5PPOO\\src\\raport.txt";


    /**
     * Functie specifica butonului de iesire din aplicatie. Inchide aplicatia complet
     * @param mouseEvent Parametru generic de preluare a input-ului de mouse
     */
    @FXML
    public void onExitButtonClick(javafx.scene.input.MouseEvent mouseEvent) {
        Platform.exit();
    }

    /**
     * Deschide o fereastra noua
     * pentru gestiunea comenzilor
     * @param mouseEvent Parametru generic de preluare a input-ului de mouse
     */
    public void onComNouaButtonClick(MouseEvent mouseEvent) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("comenzi-view.fxml"));
            Scene comandaNoua = new Scene(loader.load());
            Stage scenaComanda = new Stage();
            scenaComanda.setTitle("Comanda noua");
            scenaComanda.setScene(comandaNoua);
            scenaComanda.show();
            CreareComController controller = loader.getController();
            controller.incarcare();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     *Functie specifica butonului de crearea a rapoartelor.
     * Calculeaza automat pe baza fisierului de date numarul de comenzi, de pizza, de paste si profitul total al companiei
     * @param mouseEvent Parametru generic de preluare a input-ului de mouse
     */
    public void onRaportClick(MouseEvent mouseEvent) {
        String rez = "";
        int nrPizza = 0;
        int nrPaste = 0;
        int nrComenzi = 0;
        double profit = 0;
        if(Files.exists(Paths.get(dateOut))){
            try (BufferedReader reader = new BufferedReader(new FileReader(dateOut))) {
                String line;
                while ((line = reader.readLine()) != null) {
                   nrPizza += Integer.valueOf(line.split("pizza", -1).length-1);
                   nrPaste += Integer.valueOf(line.split("Paste", -1).length-1);
                   nrComenzi += 1;
                   String[] cuvinte = line.split(" ");
                   profit += Double.valueOf(cuvinte[cuvinte.length-1]);
                }
                rez += "Restaurantul Bon Appetit a vandut " + nrPizza + " feluri pizza si " + nrPaste + " feluri paste. In total s-au efectuat " + nrComenzi + " comenzi cu un profit de " + profit + "\n";
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(raportOut))) {
                    writer.write(rez);
                    writer.newLine();
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Raport");
                    alert.setContentText("Raport efectuat cu succes");
                    alert.showAndWait();

                } catch (IOException e) {
                    e.printStackTrace();
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setContentText("Nu s-au putut salva datele");
                    alert.showAndWait();
                }
            }

            catch (FileNotFoundException e) {
                e.printStackTrace();
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("Nu s-a gasit fisierul de preluare");
                alert.showAndWait();
            } catch (IOException e) {
                e.printStackTrace();
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("Nu s-au putut citi datele");
                alert.showAndWait();
            }
        }
    }
}
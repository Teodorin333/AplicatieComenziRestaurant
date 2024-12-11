package com.example.proiecttema5ppoo;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Clasa destinata paginii de administrare a comenzilor si a salvarii/incarcarii datelor
 * La deschiderea paginii datele vor fi incarcate, iar la inchidere acestea vor fi salvate
 */
public class CreareComController {

    @FXML
    private ListView<String> listViewProduse;


    /**
     * Fisierul de intrare a datelor. Contine comenzile efectuate de restaurant. Poate fi suprascris la inchiderea programului.
     */
    private final String dateOut = "C:\\Users\\Test\\IdeaProjects\\ProiectTema5PPOO\\src\\out.txt";

    /**
     * La apasarea butonului de adaugarea a unui noi produs, o noua pagina se va deschide pentru a completa aceasta sarcina
     * Vezi "CreareProdusController" pentru detalii
     * @param mouseEvent Parametru generic de preluare a input-ului de mouse
     */
    @FXML
    public void onAddItemClick(javafx.scene.input.MouseEvent mouseEvent) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("produs-view.fxml"));
            Scene produsNou = new Scene(loader.load());
            Stage scenaProdus = new Stage();
            scenaProdus.setTitle("Produs nou");
            scenaProdus.setScene(produsNou);

            CreareProdusController controller = loader.getController();
            controller.setComController(this);

            scenaProdus.show();


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Functia de primire a datelor inapoi de la pagina de creare a produselor
     * @param comenzi lista de Stringuri. Fiecare element reprezinta o serie de produse comandate la o anumita masa
     */
    public void primesteComanda(List<String> comenzi){
        String comanda = "Masa nr. " + comenzi.get(0) + ": ";
        for(int i=1; i<comenzi.size()-1; i++){
            comanda += comenzi.get(i) + " ";
        }
        comanda += " | Cost total: " + comenzi.get(comenzi.size()-1);
        listViewProduse.getItems().add(comanda);
    }

    /**
     * La selectarea unui element din ListView si apasarea butonului de Sterge Comanda, elementul selectat este sters definitiv din lista
     * Pentru restaurarea acelui element poate fi util butonul Incarca Comenzi
     * @param mouseEvent Parametru generic de preluare a input-ului de mouse
     */
    public void stergeComandaSelectata(MouseEvent mouseEvent) {
        String comanda = listViewProduse.getSelectionModel().getSelectedItem();
        if(comanda != null){
            listViewProduse.getItems().remove(comanda);
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("Selectati un item pentru stergere");
            alert.showAndWait();
        }
    }

    /**
     * Functie specifica butonului de salvare. Vezi functia salvare() pentru detalii
     * @param mouseEvent Parametru generic de preluare a input-ului de mouse
     */
    public void salveazaDate(MouseEvent mouseEvent) {
        salvare();
    }

    /**
     * Functie specifica butonului de incarcare a datelor. Vezi functia incarcare() pentru detalii
     * @param mouseEvent Parametru generic de preluare a input-ului de mouse
     */
    public void incarcaDate(MouseEvent mouseEvent) {
        incarcare();
    }

    /**
     * Salveaza toate elementele din interiorul ListView-ului in fisierul dateOut in format text
     */
    public void salvare(){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(dateOut))) {
            for (String comanda : listViewProduse.getItems()) {
                writer.write(comanda);
                writer.newLine();
            }
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Salvare");
            alert.setContentText("Datele au fost salvate cu succes");
            alert.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("Nu s-au putut salva datele");
            alert.showAndWait();
        }
    }

    /**
     * Incarca fiecare element din fisierul dateOut pe cate un item din ListView
     */
    public void incarcare(){
        listViewProduse.getItems().clear();
        if(Files.exists(Paths.get(dateOut))){
            try (BufferedReader reader = new BufferedReader(new FileReader(dateOut))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    listViewProduse.getItems().add(line);
                }
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Incarcare");
                alert.setContentText("Datele au fost incarcate cu succes");
                alert.showAndWait();
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
                alert.setContentText("Nu s-au putut incarca datele");
                alert.showAndWait();
            }
        }
        }

    /**
     * La apasarea butonului de Inchidere, pagina va fi inchisa
     * @param mouseEvent Parametru generic de preluare a input-ului de mouse
     */
    public void inchideFereastra(MouseEvent mouseEvent) {
        salvare();
        Stage stage = (Stage) listViewProduse.getScene().getWindow();
        stage.close();
    }
}


package com.example.proiecttema5ppoo;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Clasa ce administreaza pagina de creare a unui produs si adaugarea lui la o lista de produse.
 * La inchiderea ferestrei, lista de produse este trimisa catre zona de administrare a comenzilor.
 */
public class CreareProdusController implements Initializable {
    @FXML
    private ChoiceBox<TipPizza> cBoxTipPizza;
    @FXML
    private ChoiceBox<TipPaste> cBoxTipPaste;
    @FXML
    private ChoiceBox<TipBautura> cBoxTipBautura;
    @FXML
    private AnchorPane panouPizza;
    @FXML
    private AnchorPane panouPaste;
    @FXML
    private AnchorPane panouBauturi;
    @FXML
    private CheckBox cbMozzarella;
    @FXML
    private CheckBox cbPeperoni;
    @FXML
    private CheckBox cbCeapa;
    @FXML
    private CheckBox cbMasline;
    @FXML
    private CheckBox cbSosP;
    @FXML
    private CheckBox cbSosD;
    @FXML
    private RadioButton rbSimplu;
    @FXML
    private RadioButton rbPufos;
    @FXML
    private RadioButton rbIntegral;
    @FXML
    private CheckBox cbBranza;
    @FXML
    private CheckBox cbBusuioc;
    @FXML
    private Button bttnAdauga;
    @FXML
    private RadioButton rButtonPizza;
    @FXML
    private RadioButton rButtonPaste;
    @FXML
    private RadioButton rButtonBauturi;
    @FXML
    private ToggleGroup tipProdus;
    @FXML
    private ToggleGroup tipBlat;
    @FXML
    private Label counterLabel;
    @FXML
    private TextField tfMasa;

    private CreareComController controller;
    private List<String> comenzi =  new ArrayList<>();

    private ArrayList<Comanda> biletComanda =  new ArrayList<>();

    private int itemCounter = 0;

    private double costTotal = 0;

    /**
     * Functia ce leaga fereastra de creare a produselor cu fereastra de administrare a comenzilor
     * @param controller clasa de administrare a comenzilor
     */
    public void setComController(CreareComController controller){
        this.controller = controller;
    }

    /**
     * Zona de initializare a controalelor aplicatiei. Acestea sunt resetate sau in cazul ChoiceBox-urilor, li se adauga valori
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        comenzi.clear();
        biletComanda.clear();
        tfMasa.clear();
        cBoxTipPizza.getItems().addAll(TipPizza.MARGHERITA, TipPizza.CHEESY, TipPizza.CARNIVORA, TipPizza.DIAVOLA, TipPizza.VEGANA);
        cBoxTipPizza.getSelectionModel().select(0);
        cBoxTipPaste.getItems().addAll(TipPaste.GNOCCHI, TipPaste.CARBONARA, TipPaste.BOLOGNESE, TipPaste.LINGUINI);
        cBoxTipPaste.getSelectionModel().select(0);
        cBoxTipBautura.getItems().addAll(TipBautura.FANTA, TipBautura.APA, TipBautura.COLA, TipBautura.SPRITE, TipBautura.FUZETEA);
        cBoxTipBautura.getSelectionModel().select(0);
    }

    /**
     * In cazul selectarii optiunii de Pizza, meniul special este facut vizibil, iar restul meniurilor devin inivizibile
     * @param mouseEvent Parametru generic de preluare a input-ului de mouse
     */
    public void showPizza(MouseEvent mouseEvent) {
        cBoxTipPizza.getSelectionModel().select(0);
        cbMozzarella.setSelected(false);
        cbPeperoni.setSelected(false);
        cbCeapa.setSelected(false);
        cbSosP.setSelected(false);
        cbSosD.setSelected(false);
        cbMasline.setSelected(false);
        rbSimplu.setSelected(true);
        panouPizza.setVisible(true);
        panouPaste.setVisible(false);
        panouBauturi.setVisible(false);
    }

    /**
     * In cazul selectarii optiunii de Paste, meniul special este facut vizibil, iar restul meniurilor devin inivizibile
     * @param mouseEvent Parametru generic de preluare a input-ului de mouse
     */
    public void showPaste(MouseEvent mouseEvent) {
        cBoxTipPaste.getSelectionModel().select(0);
        cbBusuioc.setSelected(false);
        cbBranza.setSelected(false);
        panouPizza.setVisible(false);
        panouPaste.setVisible(true);
        panouBauturi.setVisible(false);
    }

    /**
     * In cazul selectarii optiunii de Bauturi, meniul special este facut vizibil, iar restul meniurilor devin inivizibile
     * @param mouseEvent Parametru generic de preluare a input-ului de mouse
     */
    public void showBauturi(MouseEvent mouseEvent) {
        cBoxTipBautura.getSelectionModel().select(0);
        panouPizza.setVisible(false);
        panouPaste.setVisible(false);
        panouBauturi.setVisible(true);
    }

    /**
     * La apasarea butonului de adaugare a unui produs, se creaza un obiect de tipul specificat (Pizza, Paste), sau se adauga direct ca String
     * (Bauturi). Rezultatul final este adaugat sub forma de String in lista de produse.
     * Atentie: Necesita un numar de masa pentru a putea fi adaugat produsul in lista. La adaugarea produsului, controalele sunt resetate
     * @param mouseEvent Parametru generic de preluare a input-ului de mouse
     */
    public void adaugaProdus(MouseEvent mouseEvent) {
        if(tfMasa.getText() != null && tfMasa.getText().length() > 0) {
            if (tipProdus.getSelectedToggle().equals(rButtonPizza)) {
                PizzaFactory factory = new PizzaFactory();
                IPizza pizza = null;
                List<Toppings> listaToppinguri = new ArrayList<>();
                if (cbMozzarella.isSelected()) {
                    listaToppinguri.add(Toppings.EXTRA_MOZZARELLA);
                }
                if (cbPeperoni.isSelected()) {
                    listaToppinguri.add(Toppings.PEPERONI);
                }
                if (cbCeapa.isSelected()) {
                    listaToppinguri.add(Toppings.CEAPA);
                }
                if (cbSosP.isSelected()) {
                    listaToppinguri.add(Toppings.SOS_PICANT);
                }
                if (cbSosD.isSelected()) {
                    listaToppinguri.add(Toppings.SOS_DULCE);
                }
                if (cbMasline.isSelected()) {
                    listaToppinguri.add(Toppings.MASLINE);
                }
                Blat blat = Blat.SIMPLU;
                if (tipBlat.getSelectedToggle().equals(rbPufos)) {
                    blat = Blat.PUFOS;
                }
                if (tipBlat.getSelectedToggle().equals(rbIntegral)) {
                    blat = Blat.INTEGRAL;
                }
                if (tipBlat.getSelectedToggle().equals(rbSimplu)) {
                    blat = Blat.SIMPLU;
                }
                TipPizza tipPizza = cBoxTipPizza.getValue();
                try {
                    pizza = factory.createPizza(tipPizza);
                    pizza = new DecoratorBlat(pizza, blat);
                    pizza = new DecoratorTopping(pizza, listaToppinguri);

                    costTotal += pizza.calcPret();
                    comenzi.add(pizza.descriere());
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            } else if (tipProdus.getSelectedToggle().equals(rButtonPaste)) {
                List<TipExtraPaste> extra = new ArrayList<>();
                TipPaste tipPaste = cBoxTipPaste.getValue();
                if (cbBranza.isSelected()) {
                    extra.add(TipExtraPaste.BRANZA);
                }
                if (cbBusuioc.isSelected()) {
                    extra.add(TipExtraPaste.BUSUIOC);
                }
                IPizza paste = null;
                PastaFactory factory = new PastaFactory();
                try {
                    paste = factory.createPasta(tipPaste);
                    paste = new DecoratorPaste(paste, extra);

                    costTotal += paste.calcPret();
                    comenzi.add(paste.descriere());

                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            } else if (tipProdus.getSelectedToggle().equals(rButtonBauturi)) {
                String bautura = cBoxTipBautura.getValue().toString();
                costTotal += 5;
                comenzi.add(bautura);
            }

            itemCounter += 1;
            counterLabel.setText("Produse adaugate: " + Integer.toString(itemCounter));

            cBoxTipPizza.getSelectionModel().select(0);
            cBoxTipPaste.getSelectionModel().select(0);
            cBoxTipBautura.getSelectionModel().select(0);
            cbMozzarella.setSelected(false);
            cbPeperoni.setSelected(false);
            cbCeapa.setSelected(false);
            cbSosP.setSelected(false);
            cbSosD.setSelected(false);
            cbMasline.setSelected(false);
            cbBranza.setSelected(false);
            cbBusuioc.setSelected(false);
            rbSimplu.setSelected(true);
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR, "Introduceti numarul mesei", ButtonType.OK);
            alert.show();
        }
    }

    /**
     * La apasarea butonului de inchidere a ferestrei, lista de produse este trimisa catre pagina de administrare a comenzilor
     * Atentie:Necesita un numar de masa pentru a putea inchide cu succes fereastra
     * @param mouseEvent Parametru generic de preluare a input-ului de mouse
     */
    public void inchidePagina(MouseEvent mouseEvent) {
        if(tfMasa.getText() != null && tfMasa.getText().length() > 0) {
            if (controller != null) {
                comenzi.add(0, tfMasa.getText());
                comenzi.add(Double.toString(costTotal));
                controller.primesteComanda(comenzi);
            }
            Stage stage = (Stage) bttnAdauga.getScene().getWindow();
            stage.close();
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR, "Introduceti numarul mesei", ButtonType.OK);
            alert.show();
        }
    }
}

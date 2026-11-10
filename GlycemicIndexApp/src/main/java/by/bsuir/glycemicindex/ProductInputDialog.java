
package by.bsuir.glycemicindex;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

public class ProductInputDialog {

    public static String show(Window owner, String lastProduct) {
        Stage dialog = new Stage();
        dialog.setTitle("Ввод продукта");
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.initOwner(owner);
        dialog.setResizable(false);

        Label titleLabel = new Label("Введите название продукта:");

        TextField productField = new TextField();
        productField.setPromptText("Например, яблоко");
        productField.setText(lastProduct);

        Button searchButton = new Button("Найти");
        Button cancelButton = new Button("Отмена");

        searchButton.setDefaultButton(true);
        cancelButton.setCancelButton(true);

        final String[] result = {null};

        searchButton.setOnAction(event -> {
            if (!productField.getText().isBlank()) {
                result[0] = productField.getText().trim();
                dialog.close();
            }
        });

        cancelButton.setOnAction(event -> dialog.close());

        VBox layout = new VBox(12);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(
                titleLabel,
                productField,
                searchButton,
                cancelButton
        );

        Scene scene = new Scene(layout, 320, 170);
        dialog.setScene(scene);
        dialog.showAndWait();

        return result[0];
    }
}

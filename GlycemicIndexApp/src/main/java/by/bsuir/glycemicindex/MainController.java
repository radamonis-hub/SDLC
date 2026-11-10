
package by.bsuir.glycemicindex;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainController {

    private final Stage primaryStage;

    private String lastProduct = "";

    private final Label productLabel = new Label("Продукт не выбран");
    private final Label resultLabel = new Label(
            "Введите продукт, чтобы узнать его ГИ"
    );

    public MainController(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void show() {
        Label titleLabel = new Label(
                "Гликемический индекс продуктов"
        );
        titleLabel.setStyle(
                "-fx-font-size: 22px; -fx-font-weight: bold;"
        );

        Label definitionLabel = new Label(
                "Гликемический индекс (ГИ) — показатель, " +
                        "характеризующий скорость повышения уровня " +
                        "глюкозы в крови после употребления продукта " +
                        "по сравнению с употреблением чистой глюкозы."
        );
        definitionLabel.setWrapText(true);
        definitionLabel.setMaxWidth(450);
        definitionLabel.setStyle("-fx-font-size: 14px;");

        Button inputButton = new Button("Ввести продукт");
        inputButton.setPrefWidth(180);
        inputButton.setOnAction(event -> openProductDialog());

        productLabel.setStyle(
                "-fx-font-size: 16px; -fx-font-weight: bold;"
        );
        resultLabel.setStyle("-fx-font-size: 16px;");

        VBox layout = new VBox(
                20,
                titleLabel,
                definitionLabel,
                inputButton,
                productLabel,
                resultLabel
        );

        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(30));
        layout.setStyle("-fx-background-color: #F5F7FA;");

        Scene scene = new Scene(layout, 550, 380);

        primaryStage.setTitle("Гликемический индекс продуктов");
        primaryStage.setScene(scene);
        primaryStage.setMinWidth(500);
        primaryStage.setMinHeight(350);
        primaryStage.show();
    }

    private void openProductDialog() {
        String productName = ProductInputDialog.show(
                primaryStage,
                lastProduct
        );

        if (productName == null) {
            return;
        }

        lastProduct = productName;

        Product product = ProductCatalog.findByName(productName);

        if (product == null) {
            showError(
                    "Продукт не найден",
                    "В каталоге отсутствует продукт «" +
                            productName +
                            "».\nПроверьте название или попробуйте другой продукт."
            );
            return;
        }

        productLabel.setText("Продукт: " + product.getName());

        int glycemicIndex = product.getGlycemicIndex();

        String category;

        if (glycemicIndex <= 55) {
            category = "Низкий ГИ";
        } else if (glycemicIndex <= 69) {
            category = "Средний ГИ";
        } else {
            category = "Высокий ГИ";
        }

        resultLabel.setText(
                "Гликемический индекс: " + glycemicIndex +
                        "\nКатегория: " + category
        );
    }

    private void showError(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(primaryStage);
        alert.showAndWait();
    }
}

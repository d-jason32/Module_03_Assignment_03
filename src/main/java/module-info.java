module edu.farmingdale.module_03_assignment_03 {
    requires javafx.controls;
    requires javafx.fxml;


    opens edu.farmingdale.module_03_assignment_03 to javafx.fxml;
    exports edu.farmingdale.module_03_assignment_03;
}
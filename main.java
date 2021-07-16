/**
 * (C) 7/2021 Teemu
 * Economy-program
 */

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.*;


public class main extends Application {
    public static void main (String [] args) {
        launch(args);
    }

    /**
     * Expense-object
     */
    public class expense {
        private String date = "";
        private String type = "";
        private String info = "";
        private double value;

        expense() {}

        expense(String date, String type, String info, double value) {
            this.date = date;
            this.info = info;
            this.type = type;
            this.value = value;
        }

        public void setDate(String date) {this.date = date;}
        public String getDate() {return this.date;}
        public void setInfo(String info) {this.info = info;}
        public String getInfo() {return this.info;}
        public void setType(String type) {this.type = type;}
        public String getType() {return this.type;}
        public void setValue(double value) {this.value = value;}
        public double getValue() {return this.value;}

    }

    /**
     * Earning-object
     */
    public class earning {
        private String date = "";
        private String type = "";
        private String info = "";
        private double value;

        earning() {}

        earning(String date, String type, String info, double value) {
            this.date = date;
            this.info = info;
            this.type = type;
            this.value = value;
        }

        public void setDate(String date) {this.date = date;}
        public String getDate() {return this.date;}
        public void setInfo(String info) {this.info = info;}
        public String getInfo() {return this.info;}
        public void setType(String type) {this.type = type;}
        public String getType() {return this.type;}
        public void setValue(double value) {this.value = value;}
        public double getValue() {return this.value;}


    }

    /**
     * Earning and expense-object for alltable
     */
    public class allObject {
        private String date = "";
        private String type = "";
        private String info = "";
        private double value;

        allObject() {}

        allObject(String date, String type, String info, double value) {
            this.date = date;
            this.info = info;
            this.type = type;
            this.value = value;
        }

        public void setDate(String date) {this.date = date;}
        public String getDate() {return this.date;}
        public void setInfo(String info) {this.info = info;}
        public String getInfo() {return this.info;}
        public void setType(String type) {this.type = type;}
        public String getType() {return this.type;}
        public void setValue(double value) {this.value = value;}
        public double getValue() {return this.value;}


    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //setting pane and scene
        primaryStage.setTitle("Economy");
        Pane root = new Pane();
        Scene scene = new Scene(root, 890,580);
        //defining Taboane and tabs
        TabPane tPane = new TabPane();
        Tab allTab = new Tab("All");
        Tab earningtab = new Tab("Earnings");
        Tab expensestab = new Tab("Expenses");

        tPane.getTabs().addAll(allTab,earningtab,expensestab);
        tPane.setLayoutY(26);
        tPane.setPrefSize(890,551);

        //Defining pane for tabpane
        Pane allPane = new Pane();
        Pane earningPane = new Pane();
        Pane expensesPane = new Pane();
        //creating menu
        MenuBar menu = new MenuBar();
        Menu menuFile = new Menu("File");
        MenuItem close = new MenuItem("close");

        menuFile.getItems().addAll(close);
        menu.getMenus().addAll(menuFile);
        menu.setPrefSize(890,25);

        //creating buttons
        Button btnAdd = new Button("Add");
        btnAdd.setLayoutX(758);
        btnAdd.setLayoutY(350);

        Button btnDeleteAll = new Button("Delete");
        btnDeleteAll.setLayoutX(600);
        btnDeleteAll.setLayoutY(442);

        Button btnDeleteExp = new Button("Delete");
        btnDeleteExp.setLayoutX(600);
        btnDeleteExp.setLayoutY(442);

        Button btnDeleteEar = new Button("Delete");
        btnDeleteEar.setLayoutX(600);
        btnDeleteEar.setLayoutY(442);

        //creating choicebox
        ChoiceBox typeBox = new ChoiceBox();

        typeBox.getItems().add("Expense");
        typeBox.getItems().add("Earning");

        typeBox.setLayoutY(212);
        typeBox.setLayoutX(710);

        //creating textfields
        TextField valueFieldAll = new TextField();
        valueFieldAll.setEditable(false);
        TextField valueFieldEarnings = new TextField();
        valueFieldEarnings.setEditable(false);
        TextField valueFieldExpenses = new TextField();
        valueFieldExpenses.setEditable(false);
        TextField valueField = new TextField();
        TextField infoField = new TextField();

        valueField.setLayoutY(279);
        valueField.setLayoutX(710);

        infoField.setLayoutY(143);
        infoField.setLayoutX(710);

        valueFieldAll.setLayoutY(427);
        valueFieldAll.setLayoutX(108);
        valueFieldAll.setPrefSize(259,60);

        valueFieldEarnings.setLayoutY(427);
        valueFieldEarnings.setLayoutX(108);
        valueFieldEarnings.setPrefSize(259,60);

        valueFieldExpenses.setLayoutY(427);
        valueFieldExpenses.setLayoutX(108);
        valueFieldExpenses.setPrefSize(259,60);

        //creating datepicker
        DatePicker datePicker = new DatePicker();

        datePicker.setLayoutY(75);
        datePicker.setLayoutX(710);

        //creating texts
        Text txtAll = new Text("Total");
        Text txtEarning = new Text("Total");
        Text txtExpenses = new Text("Total");
        Text txtDate = new Text("Date");
        Text txtInfo = new Text("Info");
        Text txtType = new Text("Type");
        Text txtValue = new Text("Value");

        txtDate.setLayoutY(64);
        txtDate.setLayoutX(759);

        txtInfo.setLayoutY(132);
        txtInfo.setLayoutX(759);

        txtType.setLayoutY(202);
        txtType.setLayoutX(759);

        txtValue.setLayoutY(266);
        txtValue.setLayoutX(759);

        txtAll.setLayoutX(46);
        txtAll.setLayoutY(469);
        txtEarning.setLayoutY(469);
        txtEarning.setLayoutX(46);
        txtExpenses.setLayoutX(46);
        txtExpenses.setLayoutY(469);

        //Creating tableview
        TableView allTable = new TableView();
        TableView earningTable = new TableView();
        TableView expensesTable = new TableView();

        //Creating tablecolumns for tableview
        TableColumn allDateColumn = new TableColumn("Date");
        TableColumn allTypeColumn = new TableColumn("Type");
        TableColumn allValueColumn = new TableColumn("Value");
        TableColumn allInfoColumn = new TableColumn("info");

        TableColumn expDateColumn = new TableColumn("Date");
        TableColumn expTypeColumn = new TableColumn("Type");
        TableColumn expValueColumn = new TableColumn("Value");
        TableColumn expInfoColumn = new TableColumn("info");

        TableColumn earDateColumn = new TableColumn("Date");
        TableColumn earTypeColumn = new TableColumn("Type");
        TableColumn earValueColumn = new TableColumn("Value");
        TableColumn earInfoColumn = new TableColumn("info");

        //setting tableviews and tablecolumns
        allTable.setPrefSize(691,395);
        earningTable.setPrefSize(691,395);
        expensesTable.setPrefSize(691,395);

        allDateColumn.setPrefWidth(90);
        allTypeColumn.setPrefWidth(92);
        allValueColumn.setPrefWidth(114);
        allInfoColumn.setPrefWidth(374);

        expDateColumn.setPrefWidth(90);
        expTypeColumn.setPrefWidth(92);
        expValueColumn.setPrefWidth(114);
        expInfoColumn.setPrefWidth(374);

        earDateColumn.setPrefWidth(90);
        earTypeColumn.setPrefWidth(92);
        earValueColumn.setPrefWidth(114);
        earInfoColumn.setPrefWidth(374);

        //Setting tablecolumns to tableviews
        allTable.getColumns().addAll(allDateColumn,allTypeColumn,allInfoColumn,allValueColumn);
        expensesTable.getColumns().addAll(expDateColumn,expTypeColumn,expInfoColumn,expValueColumn);
        earningTable.getColumns().addAll(earDateColumn,earTypeColumn,earInfoColumn,earValueColumn);

        allTab.setContent(allPane);
        earningtab.setContent(earningPane);
        expensestab.setContent(expensesPane);
        //setting objects to panes
        root.getChildren().addAll(menu,tPane);
        allPane.getChildren().addAll(btnAdd,valueFieldAll,allTable,txtAll,valueField,typeBox,datePicker,infoField,txtDate,txtInfo,txtValue,txtType,btnDeleteAll);
        earningPane.getChildren().addAll(valueFieldEarnings,earningTable,txtEarning,btnDeleteEar);
        expensesPane.getChildren().addAll(valueFieldExpenses,expensesTable,txtExpenses,btnDeleteExp);

        //Creating observablelists for tableview
        ObservableList<earning> earningList = FXCollections.observableArrayList();
        ObservableList<expense> expenseList = FXCollections.observableArrayList();
        ObservableList<Object> allList = FXCollections.observableArrayList();

        /**
         * Setting action for close-button
         */
        close.setOnAction(event -> {
            primaryStage.close();
        });

        /**
         * Setting actions for add-button
         */
        btnAdd.setOnAction(event -> {

            String boxValue = (String) typeBox.getValue();

            String valueMatch = valueField.getText();
            valueMatch = valueMatch.replaceAll("[0-9]+","");
            valueMatch = valueMatch.replaceAll(" ", "");
            System.out.println(valueMatch);
            //checking that all fields has been filled
            if(datePicker.getValue() == null || infoField.getText().isEmpty() || valueField.getText().isEmpty() || boxValue == null || valueMatch.matches("[a-zA-Z ]+$")) {

            } else {
                //if all fields is filled, writing to textfile
                File bankFile = new File("bank.txt");
                if (bankFile.exists()) {
                    try {
                        FileWriter writer = new FileWriter(bankFile,true);
                        BufferedWriter bw = new BufferedWriter(writer);
                        String change = infoField.getText();
                        String doubleValue = valueField.getText();
                        doubleValue = doubleValue.replaceAll(",",".");
                        change = change.replaceAll(" ","__");
                        bw.write(datePicker.getValue()+ " " + boxValue + " " + change + " " + doubleValue);
                        bw.newLine();
                        bw.close();
                        infoField.clear();
                        valueField.clear();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }
            //refreshing all tableviews from textfile
            allList.clear();
            earningList.clear();
            expenseList.clear();
            double allTotal = 0;
            double expenseTotal = 0;
            double earningTotal = 0;

            try {
                String line;

                FileReader bankReader = new FileReader("bank.txt");
                BufferedReader bankBr = new BufferedReader(bankReader);

                while((line = bankBr.readLine()) != null) {
                    String row = line;
                    String[] words = row.split(" ");
                    String date = words[0];
                    String type = words[1];
                    String info = words[2];
                    double value = Double.parseDouble(words[3]);
                    if(type.equals("Earning")) {

                        if (info.contains("_")) {
                            info = info.replaceAll("__", " ");
                        }

                        earningList.add((new earning(date,type,info,value)));
                        allList.add((new allObject(date,type,info,value)));

                        allTotal = allTotal+value;
                        earningTotal = earningTotal + value;
                    } else if (type.equals("Expense")) {
                        if (info.contains("_")) {
                            info = info.replaceAll("__", " ");
                        }

                        expenseList.add((new expense(date,type,info,value)));
                        allList.add((new allObject(date,type,info,value)));

                        allTotal = allTotal - value;
                        expenseTotal = expenseTotal - value;
                    }


                }
                bankBr.close();


            } catch (FileNotFoundException e) {
                e.printStackTrace();

            } catch (IOException e) {
                e.printStackTrace();
            }

            allDateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
            allTypeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
            allInfoColumn.setCellValueFactory(new PropertyValueFactory<>("info"));
            allValueColumn.setCellValueFactory(new PropertyValueFactory<>("value"));

            expDateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
            expTypeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
            expInfoColumn.setCellValueFactory(new PropertyValueFactory<>("info"));
            expValueColumn.setCellValueFactory(new PropertyValueFactory<>("value"));

            earDateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
            earTypeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
            earInfoColumn.setCellValueFactory(new PropertyValueFactory<>("info"));
            earValueColumn.setCellValueFactory(new PropertyValueFactory<>("value"));

            allTable.setItems(allList);
            earningTable.setItems(earningList);
            expensesTable.setItems(expenseList);

            valueFieldAll.setText(String.valueOf(allTotal));
            valueFieldEarnings.setText(String.valueOf(earningTotal));
            valueFieldExpenses.setText(String.valueOf(expenseTotal));


        });
        /**
         * Setting actions to delete-button
         */
        btnDeleteAll.setOnAction(event -> {

            allObject selectedObject = (allObject) allTable.getSelectionModel().getSelectedItem();

            if(selectedObject.getType().equals("Expense")){
                String infoToRemove = selectedObject.getInfo().replaceAll(" ", "__");

                String lineToremove = selectedObject.getDate() + " " + selectedObject.getType() + " " + infoToRemove + " " + selectedObject.getValue();

                File bankListFile = new File("bank.txt");
                File tempBankFile = new File("tempExp.txt");

                try {
                    BufferedReader reader = new BufferedReader(new FileReader(bankListFile));
                    BufferedWriter writer = new BufferedWriter(new FileWriter(tempBankFile));

                    String currentline;
                    while((currentline = reader.readLine()) != null) {
                        String trimmed = currentline.trim();
                        if (trimmed.equals(lineToremove)) {
                            continue;
                        }
                        writer.write(currentline);
                        writer.newLine();
                    }

                    writer.close();
                    reader.close();

                    bankListFile.delete();
                    tempBankFile.renameTo(bankListFile);

                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                } catch (IOException ioException) {
                    ioException.printStackTrace();

                }}

            if(selectedObject.getType().equals("Earning")){

                String infoToRemove = selectedObject.getInfo().replaceAll(" ", "__");

                String lineToremove = selectedObject.getDate() + " " + selectedObject.getType() + " " + infoToRemove + " " + selectedObject.getValue();

                File bankListFile = new File("bank.txt");
                File tempBankFile = new File("tempExp.txt");

                try {
                    BufferedReader reader = new BufferedReader(new FileReader(bankListFile));
                    BufferedWriter writer = new BufferedWriter(new FileWriter(tempBankFile));

                    String currentline;
                    while((currentline = reader.readLine()) != null) {
                        String trimmed = currentline.trim();
                        if (trimmed.equals(lineToremove)) {
                            continue;
                        }
                        writer.write(currentline);
                        writer.newLine();
                    }

                    writer.close();
                    reader.close();

                    bankListFile.delete();
                    tempBankFile.renameTo(bankListFile);

                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                } catch (IOException ioException) {
                    ioException.printStackTrace();

                }}


            allList.clear();
            earningList.clear();
            expenseList.clear();
            double allTotal = 0;
            double expenseTotal = 0;
            double earningTotal = 0;

            try {
                String line;

                FileReader bankReader = new FileReader("bank.txt");
                BufferedReader bankBr = new BufferedReader(bankReader);

                while((line = bankBr.readLine()) != null) {
                    String row = line;
                    String[] words = row.split(" ");
                    String date = words[0];
                    String type = words[1];
                    String info = words[2];
                    double value = Double.parseDouble(words[3]);
                    if(type.equals("Earning")) {
                        if (info.contains("_")) {
                            info = info.replaceAll("__", " ");
                        }
                        earningList.add((new earning(date,type,info,value)));
                        allList.add((new allObject(date,type,info,value)));

                        allTotal = allTotal + value;
                        earningTotal = earningTotal + value;
                    } else if (type.equals("Expense")) {
                        if (info.contains("_")) {
                            info = info.replaceAll("__", " ");
                        }
                        expenseList.add((new expense(date,type,info,value)));
                        allList.add((new allObject(date,type,info,value)));

                        allTotal = allTotal - value;
                        expenseTotal = expenseTotal - value;
                    }


                }
                bankBr.close();


            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {

                e.printStackTrace();
            }

            allDateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
            allTypeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
            allInfoColumn.setCellValueFactory(new PropertyValueFactory<>("info"));
            allValueColumn.setCellValueFactory(new PropertyValueFactory<>("value"));

            expDateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
            expTypeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
            expInfoColumn.setCellValueFactory(new PropertyValueFactory<>("info"));
            expValueColumn.setCellValueFactory(new PropertyValueFactory<>("value"));

            earDateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
            earTypeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
            earInfoColumn.setCellValueFactory(new PropertyValueFactory<>("info"));
            earValueColumn.setCellValueFactory(new PropertyValueFactory<>("value"));

            allTable.setItems(allList);
            earningTable.setItems(earningList);
            expensesTable.setItems(expenseList);

            valueFieldAll.setText(String.valueOf(allTotal));
            valueFieldEarnings.setText(String.valueOf(earningTotal));
            valueFieldExpenses.setText(String.valueOf(expenseTotal));



        });

        /**
         * setting actions to Earning delete-button
         */
        btnDeleteEar.setOnAction(event -> {

            earning selectedEarning = (earning) earningTable.getSelectionModel().getSelectedItem();


            if(selectedEarning.getType().equals("Earning")){

                String infoToRemove = selectedEarning.getInfo().replaceAll(" ", "__");

                String lineToremove = selectedEarning.getDate() + " " + selectedEarning.getType() + " " + infoToRemove + " " + selectedEarning.getValue();

                File bankListFile = new File("bank.txt");
                File tempBankFile = new File("tempExp.txt");

                try {
                    BufferedReader reader = new BufferedReader(new FileReader(bankListFile));
                    BufferedWriter writer = new BufferedWriter(new FileWriter(tempBankFile));

                    String currentline;
                    while((currentline = reader.readLine()) != null) {
                        String trimmed = currentline.trim();
                        if (trimmed.equals(lineToremove)) {
                            continue;
                        }
                        writer.write(currentline);
                        writer.newLine();
                    }

                    writer.close();
                    reader.close();

                    bankListFile.delete();
                    tempBankFile.renameTo(bankListFile);

                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                } catch (IOException ioException) {
                    ioException.printStackTrace();

                }}


            allList.clear();
            earningList.clear();
            expenseList.clear();
            double allTotal = 0;
            double expenseTotal = 0;
            double earningTotal = 0;

            try {
                String line;

                FileReader bankReader = new FileReader("bank.txt");
                BufferedReader bankBr = new BufferedReader(bankReader);

                while((line = bankBr.readLine()) != null) {
                    String row = line;
                    String[] words = row.split(" ");
                    String date = words[0];
                    String type = words[1];
                    String info = words[2];
                    double value = Double.parseDouble(words[3]);
                    if(type.equals("Earning")) {
                        if (info.contains("_")) {
                            info = info.replaceAll("__", " ");
                        }
                        earningList.add((new earning(date,type,info,value)));
                        allList.add((new allObject(date,type,info,value)));

                        allTotal = allTotal + value;
                        earningTotal = earningTotal + value;
                    } else if (type.equals("Expense")) {
                        if (info.contains("_")) {
                            info = info.replaceAll("__", " ");
                        }
                        expenseList.add((new expense(date,type,info,value)));
                        allList.add((new allObject(date,type,info,value)));

                        allTotal = allTotal - value;
                        expenseTotal = expenseTotal - value;
                    }


                }
                bankBr.close();


            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {

                e.printStackTrace();
            }

            allDateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
            allTypeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
            allInfoColumn.setCellValueFactory(new PropertyValueFactory<>("info"));
            allValueColumn.setCellValueFactory(new PropertyValueFactory<>("value"));

            expDateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
            expTypeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
            expInfoColumn.setCellValueFactory(new PropertyValueFactory<>("info"));
            expValueColumn.setCellValueFactory(new PropertyValueFactory<>("value"));

            earDateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
            earTypeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
            earInfoColumn.setCellValueFactory(new PropertyValueFactory<>("info"));
            earValueColumn.setCellValueFactory(new PropertyValueFactory<>("value"));

            allTable.setItems(allList);
            earningTable.setItems(earningList);
            expensesTable.setItems(expenseList);

            valueFieldAll.setText(String.valueOf(allTotal));
            valueFieldEarnings.setText(String.valueOf(earningTotal));
            valueFieldExpenses.setText(String.valueOf(expenseTotal));



        });


        /**
         * Setting actions to expenses delete-button
         */
        btnDeleteExp.setOnAction(event -> {

            expense selectedExpense = (expense) expensesTable.getSelectionModel().getSelectedItem();

            if(selectedExpense.getType().equals("Expense")){
                String infoToRemove = selectedExpense.getInfo().replaceAll(" ", "__");

                String lineToremove = selectedExpense.getDate() + " " + selectedExpense.getType() + " " + infoToRemove + " " + selectedExpense.getValue();

                File bankListFile = new File("bank.txt");
                File tempBankFile = new File("tempExp.txt");

                try {
                    BufferedReader reader = new BufferedReader(new FileReader(bankListFile));
                    BufferedWriter writer = new BufferedWriter(new FileWriter(tempBankFile));

                    String currentline;
                    while((currentline = reader.readLine()) != null) {
                        String trimmed = currentline.trim();
                        if (trimmed.equals(lineToremove)) {
                            continue;
                        }
                        writer.write(currentline);
                        writer.newLine();
                    }

                    writer.close();
                    reader.close();

                    bankListFile.delete();
                    tempBankFile.renameTo(bankListFile);

                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                } catch (IOException ioException) {
                    ioException.printStackTrace();

                }}


            allList.clear();
            earningList.clear();
            expenseList.clear();
            double allTotal = 0;
            double expenseTotal = 0;
            double earningTotal = 0;

            try {
                String line;

                FileReader bankReader = new FileReader("bank.txt");
                BufferedReader bankBr = new BufferedReader(bankReader);

                while((line = bankBr.readLine()) != null) {
                    String row = line;
                    String[] words = row.split(" ");
                    String date = words[0];
                    String type = words[1];
                    String info = words[2];
                    double value = Double.parseDouble(words[3]);
                    if(type.equals("Earning")) {
                        if (info.contains("_")) {
                            info = info.replaceAll("__", " ");
                        }
                        earningList.add((new earning(date,type,info,value)));
                        allList.add((new allObject(date,type,info,value)));

                        allTotal = allTotal + value;
                        earningTotal = earningTotal + value;
                    } else if (type.equals("Expense")) {
                        if (info.contains("_")) {
                            info = info.replaceAll("__", " ");
                        }
                        expenseList.add((new expense(date,type,info,value)));
                        allList.add((new allObject(date,type,info,value)));

                        allTotal = allTotal - value;
                        expenseTotal = expenseTotal - value;
                    }


                }
                bankBr.close();


            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {

                e.printStackTrace();
            }

            allDateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
            allTypeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
            allInfoColumn.setCellValueFactory(new PropertyValueFactory<>("info"));
            allValueColumn.setCellValueFactory(new PropertyValueFactory<>("value"));

            expDateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
            expTypeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
            expInfoColumn.setCellValueFactory(new PropertyValueFactory<>("info"));
            expValueColumn.setCellValueFactory(new PropertyValueFactory<>("value"));

            earDateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
            earTypeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
            earInfoColumn.setCellValueFactory(new PropertyValueFactory<>("info"));
            earValueColumn.setCellValueFactory(new PropertyValueFactory<>("value"));

            allTable.setItems(allList);
            earningTable.setItems(earningList);
            expensesTable.setItems(expenseList);

            valueFieldAll.setText(String.valueOf(allTotal));
            valueFieldEarnings.setText(String.valueOf(earningTotal));
            valueFieldExpenses.setText(String.valueOf(expenseTotal));

        });

        File exFile = new File("bank.txt");

        if(exFile.exists()) {
            System.out.println("Expenses file located");
        } else {
            exFile.createNewFile();
        }


        allList.clear();
        earningList.clear();
        expenseList.clear();
        double allTotal = 0;
        double expenseTotal = 0;
        double earningTotal = 0;

        try {
            String line;

            FileReader bankReader = new FileReader("bank.txt");
            BufferedReader bankBr = new BufferedReader(bankReader);

            while((line = bankBr.readLine()) != null) {
                String row = line;
                String[] words = row.split(" ");
                String date = words[0];
                String type = words[1];
                String info = words[2];
                double value = Double.parseDouble(words[3]);
                if(type.equals("Earning")) {
                    if (info.contains("_")) {
                        info = info.replaceAll("__", " ");
                    }
                    earningList.add((new earning(date,type,info,value)));
                    allList.add((new allObject(date,type,info,value)));

                    allTotal = allTotal+value;
                    earningTotal = earningTotal + value;

                } else if (type.equals("Expense")) {
                    if (info.contains("_")) {
                        info = info.replaceAll("__", " ");
                    }
                    expenseList.add((new expense(date,type,info,value)));
                    allList.add((new allObject(date,type,info,value)));

                    allTotal = allTotal-value;
                    expenseTotal = expenseTotal - value;
                }
            }
            bankBr.close();


        } catch (FileNotFoundException e) {
           e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        allDateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        allTypeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        allInfoColumn.setCellValueFactory(new PropertyValueFactory<>("info"));
        allValueColumn.setCellValueFactory(new PropertyValueFactory<>("value"));

        expDateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        expTypeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        expInfoColumn.setCellValueFactory(new PropertyValueFactory<>("info"));
        expValueColumn.setCellValueFactory(new PropertyValueFactory<>("value"));

        earDateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        earTypeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        earInfoColumn.setCellValueFactory(new PropertyValueFactory<>("info"));
        earValueColumn.setCellValueFactory(new PropertyValueFactory<>("value"));

        allTable.setItems(allList);
        earningTable.setItems(earningList);
        expensesTable.setItems(expenseList);

        valueFieldAll.setText(String.valueOf(allTotal));
        valueFieldEarnings.setText(String.valueOf(earningTotal));
        valueFieldExpenses.setText(String.valueOf(expenseTotal));

        primaryStage.setScene(scene);
        primaryStage.show();

    }


}
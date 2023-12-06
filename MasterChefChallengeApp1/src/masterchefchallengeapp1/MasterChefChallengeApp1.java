/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package masterchefchallengeapp1;

/**
 *
 * @author Administrador
 */
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;


public class MasterChefChallengeApp1 extends JFrame {
    private JTabbedPane tabbedPane;

    public MasterChefChallengeApp1() {
        setTitle("MasterChef Challenge App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        // Configurar panel de inicio de sesión
        JPanel loginPanel = createLoginPanel();
        add(loginPanel);

        setLocationRelativeTo(null); // Centrar la ventana en la pantalla
    }

    private JPanel createLoginPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(173, 216, 230)); // Fondo azul claro

        JPanel innerPanel = new JPanel(new GridLayout(4, 1));
        innerPanel.setOpaque(false); // Hacer el panel interior transparente

        JTextField userField = new JTextField(15);
        JPasswordField passwordField = new JPasswordField(15);

        JButton loginButton = new JButton("Iniciar Sesión");
        JButton creditsButton = new JButton("Créditos");

        // Personalizar la apariencia de los botones
        loginButton.setBackground(Color.RED);
        creditsButton.setBackground(Color.RED);

        // Añadir oyente para el botón de inicio de sesión
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Verificar las credenciales
                String username = userField.getText();
                char[] password = passwordField.getPassword();
                String enteredPassword = new String(password);

                if (username.equals("Master") && enteredPassword.equals("1234")) {
                    // Credenciales válidas, mostrar la aplicación principal
                    remove(panel); // Eliminar el panel de inicio de sesión
                    showMainApplication(); // Mostrar la aplicación principal
                } else {
                    // Credenciales incorrectas, mostrar mensaje de error
                    JOptionPane.showMessageDialog(MasterChefChallengeApp1.this,
                            "Credenciales incorrectas. Inténtalo de nuevo.",
                            "Error de inicio de sesión", JOptionPane.ERROR_MESSAGE);
                    // Limpiar campos de usuario y contraseña
                    userField.setText("");
                    passwordField.setText("");
                }
            }
        });

        // Añadir oyente para el botón de créditos
        creditsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showCredits();
            }
        });

        innerPanel.add(new JLabel("Usuario:"));
        innerPanel.add(userField);
        innerPanel.add(new JLabel("Contraseña:"));
        innerPanel.add(passwordField);
        innerPanel.add(loginButton);
        innerPanel.add(creditsButton);

        panel.add(innerPanel, BorderLayout.CENTER);
        // Mostrar la ventana principal maximizada

        return panel;
    }

    private void showMainApplication() {
        // Crear la interfaz principal con las pestañas y su contenido
        tabbedPane = new JTabbedPane();
        add(tabbedPane);

        addWinnersListTab();
        addTopRestaurantsTab();
        addDessertsTab();
        addJudgesAndHostTab();
        addJuniorWinnerTab();
        addViralFoodSitesTab();
        addFavoriteSeasonAndFoodTab();
        addCreditsTab();
            
        // Establecer el tamaño de la ventana principal antes de hacerla visible
         setSize(800, 600);
        // Mostrar la ventana principal
        setVisible(true);
    }
    

    private void addTopRestaurantsTab() {
        JPanel panel = new JPanel(new BorderLayout());

        // Crear el modelo del árbol
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Restaurantes");

        // Crear nodos para cada restaurante
        DefaultMutableTreeNode homeBurgers = new DefaultMutableTreeNode("Home Burgers");
        DefaultMutableTreeNode vivaLaPizza = new DefaultMutableTreeNode("Viva la Pizza");
        DefaultMutableTreeNode hamburguesasElCorral = new DefaultMutableTreeNode("Hamburguesas El Corral");
        DefaultMutableTreeNode sierraNevada = new DefaultMutableTreeNode("Sierra Nevada Hamburguesas y Malteadas");
        DefaultMutableTreeNode luchaPicante = new DefaultMutableTreeNode("Lucha Picante");
        DefaultMutableTreeNode chopinar = new DefaultMutableTreeNode("Chopinar");
        DefaultMutableTreeNode iLoveChicharron = new DefaultMutableTreeNode("I Love Chicharron");
        DefaultMutableTreeNode javiperros = new DefaultMutableTreeNode("Javiperros");
        DefaultMutableTreeNode sipote71 = new DefaultMutableTreeNode("Sipote 71");
        DefaultMutableTreeNode voodoo = new DefaultMutableTreeNode("Voodoo");

        // Agregar información adicional a cada nodo
        addNodeInfo(homeBurgers, "Carrera 9 81a-19 El Retiro, Bogotá, Colombia", "+57 1 5554390");
        addNodeInfo(vivaLaPizza, "Av. 19 -136 esquina, Bogotá, Colombia", "3611150");
        addNodeInfo(hamburguesasElCorral, "Bogotá, Colombia", "");
        addNodeInfo(sierraNevada, "Calle 26 # 62-49 CC. Gran Estación - Local 3-33, Bogotá, Colombia", "");
        addNodeInfo(luchaPicante, "Carrera 2 numero 12c-39 La Candelaria, Bogotá, Colombia", "+57 315 2290929");
        addNodeInfo(chopinar, "Calle 60 No. 17 - 09, Bogotá, Colombia", "+57 1 3482999");
        addNodeInfo(iLoveChicharron, "Carrera 119 # 13, Bogotá, Colombia", "+57 315 2545558");
        addNodeInfo(javiperros, "Calle 9 #77-07, Bogotá, Colombia", "+57 322 2522902");
        addNodeInfo(sipote71, "Carrera 5 # 71-10, Bogotá, Colombia", "+57 601 6447777");
        addNodeInfo(voodoo, "Cra 10 27 79, Bogotá, Colombia", "110321");

        // Agregar nodos al nodo raíz
        root.add(homeBurgers);
        root.add(vivaLaPizza);
        root.add(hamburguesasElCorral);
        root.add(sierraNevada);
        root.add(luchaPicante);
        root.add(chopinar);
        root.add(iLoveChicharron);
        root.add(javiperros);
        root.add(sipote71);
        root.add(voodoo);

        // Crear el árbol con el modelo
        JTree tree = new JTree(root);

        // Permitir la selección de un solo nodo a la vez
        tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);

        // Agregar un oyente para manejar la selección del nodo
        tree.addTreeSelectionListener(e -> {
            DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
            if (selectedNode != null && selectedNode.isLeaf()) {
                // Obtener la información del nodo seleccionado
                String nodeName = selectedNode.toString();
                String nodeInfo = getNodeInfo(selectedNode);

                // Mostrar la información en un cuadro de diálogo
                JOptionPane.showMessageDialog(this, "Restaurante: " + nodeName + "\n" + nodeInfo,
                        "Información del Restaurante", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // Agregar el árbol al panel
        panel.add(new JScrollPane(tree), BorderLayout.CENTER);

        // Agregar el panel al tabbedPane
        tabbedPane.addTab("Mejores Restaurantes", panel);
    }

    // Métodos auxiliares para agregar información a los nodos
    private void addNodeInfo(DefaultMutableTreeNode node, String address, String phoneNumber) {
        node.setUserObject(node.getUserObject() + " - " + address + " - " + phoneNumber);
    }

    private String getNodeInfo(DefaultMutableTreeNode node) {
        Object userObject = node.getUserObject();
        if (userObject instanceof String) {
            return (String) userObject;
        } else {
            return "";
        }
    }

    // Métodos para otras pestañas

    private void addWinnersListTab() {
        JPanel panel = new JPanel(new BorderLayout());

        // Crear un JComboBox con la lista de ganadores y finalistas
        String[] ganadoresFinalistas = {
                "Piter Albeiro - Ganador 2018 - Finalistas: Estefanía Borge, Variel Sánchez",
                "Adriana Lucía - Ganadora 2019 - Finalistas: Andrea Tovar, Mariana Mesa",
                "Carla Giraldo - Ganadora 2021 - Finalistas: Viña Machado, Liss Pereira",
                "Ramiro Meneses - Ganador 2022 - Finalistas: Carlos Báez, Chicho Arias",
                "Carolina Acevedo - Ganadora 2023 - Finalistas: Marianela González, Adrián Parada"
        };
        JComboBox<String> ganadoresComboBox = new JComboBox<>(ganadoresFinalistas);

        // JTextArea para mostrar detalles del ganador seleccionado
        JTextArea detallesTextArea = new JTextArea();
        detallesTextArea.setEditable(false);

        // Agregar un ActionListener al JComboBox para mostrar detalles
        ganadoresComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String seleccionado = (String) ganadoresComboBox.getSelectedItem();
                detallesTextArea.setText("Detalles del Ganador/Finalistas:\n" + seleccionado);
            }
        });

        // Agregar componentes al panel
        panel.add(new JLabel("Selecciona un Ganador/Finalista:"), BorderLayout.NORTH);
        panel.add(ganadoresComboBox, BorderLayout.CENTER);
        panel.add(new JScrollPane(detallesTextArea), BorderLayout.SOUTH);

        // Agregar el panel al tabbedPane
        tabbedPane.addTab("Ganadores", panel);
    }

    private void addDessertsTab() {
        JPanel panel = new JPanel();
        // ... (Código para la pestaña de postres colombianos)
        tabbedPane.addTab("Postres Colombianos", panel);
    }

    private void addJudgesAndHostTab() {
        JPanel panel = new JPanel();
        // ... (Código para la pestaña de jueces y presentadora)
        tabbedPane.addTab("Jueces y Presentadora", panel);
    }

    private void addJuniorWinnerTab() {
        JPanel panel = new JPanel(new BorderLayout());

        // Crear los datos para el JTable
        Vector<Vector<String>> data = new Vector<>();
        Vector<String> columnNames = new Vector<>();
        columnNames.add("Nombre");
        columnNames.add("Ciudad");
        columnNames.add("Resultado");
        columnNames.add("Edad");

        Vector<String> row1 = new Vector<>();
        row1.add("Yulitza Sarmiento");
        row1.add("Barranquilla");
        row1.add("Ganadora");
        row1.add("11");

        Vector<String> row2 = new Vector<>();
        row2.add("María José Roldán");
        row2.add("Medellín");
        row2.add("Segundo lugar");
        row2.add("13");

        Vector<String> row3 = new Vector<>();
        row3.add("Alan Vagn Knudsen");
        row3.add("Cali");
        row3.add("Semifinalistas");
        row3.add("13");

        Vector<String> row4 = new Vector<>();
        row4.add("Daniel Gómez");
        row4.add("Pasto");
        row4.add("Semifinalista");
        row4.add("11");

        Vector<String> row5 = new Vector<>();
        row5.add("Sara Miranda");
        row5.add("Bogotá");
        row5.add("14.ª eliminada");
        row5.add("11");

        data.add(row1);
        data.add(row2);
        data.add(row3);
        data.add(row4);
        data.add(row5);

        JTable juniorWinnerTable = new JTable(new DefaultTableModel(data, columnNames));

        // Agregar el JTable al panel
        panel.add(new JScrollPane(juniorWinnerTable), BorderLayout.CENTER);

        // Agregar el panel al tabbedPane
        tabbedPane.addTab("Ganador Junior", panel);
    }

    private void addViralFoodSitesTab() {
        JPanel panel = new JPanel();
        // ... (Código para la pestaña de sitios virales de comida)
        tabbedPane.addTab("Sitios Virales", panel);
    }

    private void addFavoriteSeasonAndFoodTab() {
        JPanel panel = new JPanel(new BorderLayout());

        // Crear los datos para el JTable
        Vector<Vector<Object>> data = new Vector<>();
        Vector<String> columnNames = new Vector<>();
        columnNames.add("Temporada");
        columnNames.add("N.º de episodios");
        columnNames.add("Duración");
        columnNames.add("Ganadores");
        columnNames.add("Finalistas");
        columnNames.add("Índice de audiencia");

        // Agregar filas de datos
        Vector<Object> row1 = new Vector<>();
        row1.add("1");
        row1.add(65);
        row1.add("5 de junio de 2018 - 9 de septiembre de 2018");
        row1.add("Piter Albeiro");
        row1.add("Estefanía Borge, Variel Sánchez");
        row1.add(6.6);
        data.add(row1);

        Vector<Object> row2 = new Vector<>();
        row2.add("2");
        row2.add(83);
        row2.add("14 de septiembre de 2019 - 29 de marzo de 2020");
        row2.add("Adriana Lucía");
        row2.add("Andrea Tovar, Mariana Mesa");
        row2.add(5.8);
        data.add(row2);

        Vector<Object> row3 = new Vector<>();
        row3.add("3");
        row3.add(81);
        row3.add("5 de junio de 2021 - 1 de noviembre de 2021");
        row3.add("Carla Giraldo");
        row3.add("Viña Machado, Liss Pereira, Frank Martínez");
        row3.add(9.2);
        data.add(row3);

        Vector<Object> row4 = new Vector<>();
        row4.add("5");
        row4.add(122);
        row4.add("21 de febrero de 2022 - 12 de julio de 2022");
        row4.add("Ramiro Meneses");
        row4.add("Carlos Báez, Chicho Arias, Tatán Mejía");
        row4.add(7.7);
        data.add(row4);

        Vector<Object> row5 = new Vector<>();
        row5.add("6");
        row5.add(122);
        row5.add("29 de mayo de 2023 - 8 de octubre de 2023");
        row5.add("Carolina Acevedo");
        row5.add("Marianela González, Adrián ParadaTapia");
        row5.add(6.3);
        data.add(row5);

        JTable favoriteSeasonTable = new JTable(new DefaultTableModel(data, columnNames));
        JScrollPane tableScrollPane = new JScrollPane(favoriteSeasonTable);

        // Crear JComboBox para seleccionar la temporada favorita
        Vector<String> seasonOptions = new Vector<>();
        for (int i = 0; i < data.size(); i++) {
            seasonOptions.add(data.get(i).get(0).toString()); // Asumiendo que la primera columna es la temporada
        }

        JComboBox<String> seasonComboBox = new JComboBox<>(seasonOptions);
        seasonComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener la temporada seleccionada
                String selectedSeason = (String) seasonComboBox.getSelectedItem();

                // Actualizar la tabla según la temporada seleccionada
                // (puedes implementar esta parte según tus necesidades)
                // Por ejemplo, puedes resaltar la fila correspondiente en la tabla.
            }
        });

        // Agregar componentes al panel
        panel.add(new JLabel("Selecciona tu Temporada Favorita:"), BorderLayout.NORTH);
        panel.add(seasonComboBox, BorderLayout.CENTER);
        panel.add(tableScrollPane, BorderLayout.SOUTH);

        // Agregar el panel al tabbedPane
        tabbedPane.addTab("Temporadas Favoritas", panel);
    }

    private void addCreditsTab() {
        JPanel panel = new JPanel();
        // ... (Código para la pestaña de créditos)
        tabbedPane.addTab("Créditos", panel);
    }

    private void showCredits() {
        JOptionPane.showMessageDialog(this,
                "Arnold Javier Dávila Durán\n" +
                        "POLITECNICO INTERNACIONAL\n" +
                        "DESARROLLO DE SOFTWARE\n" +
                        "arnold.davila@pi.edu.co\n"+
                        "CICLO III",
                "Créditos", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MasterChefChallengeApp1 app = new MasterChefChallengeApp1();
            app.setVisible(true);
        });
    }
}

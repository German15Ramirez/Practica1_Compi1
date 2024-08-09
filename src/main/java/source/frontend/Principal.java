/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

package source.frontend;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author alex
 */
public class Principal extends javax.swing.JFrame {
    
    private Image imagenFondo = new ImageIcon(getClass().getResource("/imagenes/logo.jpg")).getImage();
    private JLabel relojLabel;
    private JPanel contenedorPanel;
    private boolean relojActivo = true;
    private Dimension tamañoPanelFondo;
    private String titulo = "GRAFICADOR DE GEOMETRIA";

    /** Creates new form Principal */
    public Principal() {
        initComponents();
        initUI();
        iniciarReloj();
        
    }
    
    private void initUI() {
        this.setTitle(titulo);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contenedorPanel = new JPanel();
        contenedorPanel.setLayout(new BorderLayout());

        // Obtenemos el tamaño de la pantalla
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Insets insets = Toolkit.getDefaultToolkit().getScreenInsets(GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration());
        screenSize.width -= (insets.left + insets.right);
        screenSize.height -= (insets.top + insets.bottom);
        this.setBounds(0, 0, screenSize.width, screenSize.height);
        tamañoPanelFondo = new Dimension(screenSize.width, screenSize.height);

        setContentPane(new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
            }
        });

        getContentPane().add(contenedorPanel, BorderLayout.CENTER);
        contenedorPanel.removeAll();

        JMenuBar menuPrincipal = new JMenuBar();
        addMenus(menuPrincipal);

        setJMenuBar(menuPrincipal);

        addMessageLabel(menuPrincipal);
        addClockLabel(menuPrincipal);
    }

    private void addMenus(JMenuBar menuPrincipal) {
        JMenu menuLibros = new JMenu("Libros");
        JMenu menuUsuarios = new JMenu("Usuarios");
        JMenu menuRegistros = new JMenu("Registros");
        JMenu menuReportes = new JMenu("Reportes");
        menuPrincipal.add(menuLibros);
        menuPrincipal.add(menuUsuarios);
        menuPrincipal.add(menuRegistros);
        menuPrincipal.add(menuReportes);
        //agregar iconos a cada menu
        ImageIcon iconoAbrirRegistros = new ImageIcon(getClass().getResource("/imagenes/abrir_reportes_icono.png"));
        Image imageAbrirRegistros = iconoAbrirRegistros.getImage();
        Image newImageAbrirRegistros = imageAbrirRegistros.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
        iconoAbrirRegistros = new ImageIcon(newImageAbrirRegistros);
        ImageIcon iconoLibros = new ImageIcon(getClass().getResource("/imagenes/libros_icono.png"));
        Image image = iconoLibros.getImage();
        Image newImage = image.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
        iconoLibros = new ImageIcon(newImage);
        ImageIcon iconoUsuario = new ImageIcon(getClass().getResource("/imagenes/usuarios_icono.png"));
        Image imageUsuarios = iconoUsuario.getImage();
        Image newImageUsuarios = imageUsuarios.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
        iconoUsuario = new ImageIcon(newImageUsuarios);
        ImageIcon iconoUsuarioNuevo = new ImageIcon(getClass().getResource("/imagenes/agregar_usuarios_icono.png"));
        Image imageUsuariosNuevo = iconoUsuarioNuevo.getImage();
        Image newImageUsuariosNuevos = imageUsuariosNuevo.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
        iconoUsuarioNuevo = new ImageIcon(newImageUsuariosNuevos);
        ImageIcon iconoReportes = new ImageIcon(getClass().getResource("/imagenes/reportes_icono.png"));
        Image imageReportes = iconoReportes.getImage();
        Image newImageReportes = imageReportes.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
        iconoReportes = new ImageIcon(newImageReportes);
        ImageIcon iconoListas = new ImageIcon(getClass().getResource("/imagenes/listas_icono.png"));
        Image imageListas = iconoListas.getImage();
        Image newImageListas = imageListas.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
        iconoListas = new ImageIcon(newImageListas);
        ImageIcon iconoErrores = new ImageIcon(getClass().getResource("/imagenes/errores_logo.png"));
        Image imageErrores = iconoErrores.getImage();
        Image newImageErrores = imageErrores.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
        iconoErrores = new ImageIcon(newImageErrores);
        //creacion de items en cada menu
        //items libros
        JMenuItem itemLibros01 = new JMenuItem("Nuevo Libro", iconoLibros);
        JMenuItem itemLibros02 = new JMenuItem("Editar Libro", iconoLibros);
        JMenuItem itemLibros03 = new JMenuItem("Prestar Libro", iconoLibros);
        JMenuItem itemLibros04 = new JMenuItem("Devolver Libro", iconoLibros);
        //items usuarios
        JMenuItem itemNuevoEstudiante = new JMenuItem("Nuevo Estudiante", iconoUsuarioNuevo);
        JMenuItem itemUsuarios02 = new JMenuItem("Editar Estudiante", iconoUsuario);
        //items registros
        JMenuItem itemImportarRegistros = new JMenuItem("Importar Registros", iconoAbrirRegistros);
        JMenuItem itemListaEstudiantes = new JMenuItem("Listado de Estudiantes", iconoListas);
        JMenuItem itemListaLibros = new JMenuItem("Listado de Libros", iconoListas);
        JMenuItem itemListaPrestamos = new JMenuItem("Listado de Prestamos", iconoListas);
        //items reportes
        JMenuItem itemPrestamosMismoDia = new JMenuItem("Prestamos a Devolver Este Día", iconoReportes);
        JMenuItem itemPrestamosMora = new JMenuItem("Prestamos con Mora", iconoReportes);
        JMenuItem itemIngresosIntervalo = new JMenuItem("Ingresos en un Intervalo de Tiempo", iconoReportes);
        JMenuItem itemPrestamosPorEstudiante = new JMenuItem("Prestamos Hechos por Estudiante", iconoReportes);
        JMenuItem itemPrestamosVigentesPorEstudiante = new JMenuItem("Prestamos Vigentes de Cada Estudiante", iconoReportes);
        JMenuItem itemPrestamosPorCarrera = new JMenuItem("Prestamos Realizados por Carrera en un Intervalo de Tiempo", iconoReportes);
        JMenuItem itemDevolucionesConcluidas = new JMenuItem("Devoluciones Concluidas", iconoReportes);
        JMenuItem itemErroresEncontrados = new JMenuItem("Errores Encontrados en la Importación", iconoErrores);

        //agregar al menu
        menuLibros.add(itemLibros01);
        menuLibros.add(itemLibros02);
        menuLibros.add(itemLibros03);
        menuLibros.add(itemLibros04);
        menuUsuarios.add(itemNuevoEstudiante);
        menuUsuarios.add(itemUsuarios02);
        menuRegistros.add(itemImportarRegistros);
        menuRegistros.add(itemListaEstudiantes);
        menuRegistros.add(itemListaLibros);
        menuRegistros.add(itemListaPrestamos);
        menuReportes.add(itemPrestamosMismoDia);
        menuReportes.add(itemPrestamosMora);
        menuReportes.add(itemIngresosIntervalo);
        menuReportes.add(itemPrestamosPorEstudiante);
        menuReportes.add(itemPrestamosVigentesPorEstudiante);
        menuReportes.add(itemPrestamosPorCarrera);
        menuReportes.add(itemDevolucionesConcluidas);
        menuReportes.add(itemErroresEncontrados);
        //ACCIONES
        //Importar registros
        itemImportarRegistros.addActionListener((ActionEvent e) -> {
            JFileChooser chooser = new JFileChooser();
            // Establecer el tamaño del cuadro de diálogo
            chooser.setPreferredSize(new Dimension(800, 600)); // tamaño buscador
            FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos de texto (*.txt)", "txt");
            chooser.setFileFilter(filtro);
            int seleccion = chooser.showOpenDialog(this);

            if (seleccion == JFileChooser.APPROVE_OPTION) {
                String nombreArchivo = chooser.getSelectedFile().getName();
                String extension = nombreArchivo.substring(nombreArchivo.lastIndexOf('.') + 1).toLowerCase();

                if (extension.equals("txt")) {
                    String rutaArchivo = chooser.getSelectedFile().getAbsolutePath();
//                    ImportarDatos importar = new ImportarDatos();
                    int opcion = JOptionPane.showConfirmDialog(this, "Se ha encontrado el archivo \"" + chooser.getSelectedFile().getName() + "\"\n¿Desea importar los datos?", "IMPORTAR DATOS", JOptionPane.YES_NO_OPTION);
                    if (opcion == 0) {
//                        importar.abrirArchivo(rutaArchivo);
//                        FuncionamientoAplicacion.guardarSerializableEstudiantes();
//                        FuncionamientoAplicacion.guardarSerializableLibros();
//                        FuncionamientoAplicacion.guardarSerializablePrestamos();
                        JOptionPane.showMessageDialog(this, "Importación finalizada.\nConsulte los registros para más información");
                    } else {
                        JOptionPane.showMessageDialog(this, "Importación cancelada.");
                    }

                } else {
                    JOptionPane.showMessageDialog(this, "Solo se permiten archivos .txt", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        //personalizar menu
        Font menuFont = new Font("Bitstream Charter", Font.BOLD, 20);
        menuPrincipal.setFont(menuFont);
        for (int i = 0; i < menuPrincipal.getMenuCount(); i++) {
            JMenu menu = menuPrincipal.getMenu(i);
            menu.setFont(menuFont);
            for (int j = 0; j < menu.getItemCount(); j++) {
                JMenuItem menuItem = menu.getItem(j);
                menuItem.setFont(menuFont);
            }
        }

        // Establece el diseño de la barra de menú
        menuPrincipal.setLayout(new BoxLayout(menuPrincipal, BoxLayout.X_AXIS));
        // Establece la barra de menú en el marco
        setJMenuBar(menuPrincipal);
    }

    private void pintarPanel(Component panel) {
        contenedorPanel.removeAll();
        contenedorPanel.setLayout(new BorderLayout());
        contenedorPanel.add(panel, BorderLayout.CENTER);
        if (tamañoPanelFondo != null) {
            panel.setPreferredSize(tamañoPanelFondo);
        }
        // Repintar y validar el contenedor
        contenedorPanel.repaint();
        contenedorPanel.revalidate();
    }

    private void addMessageLabel(JMenuBar menuPrincipal) {
        JLabel mensajeLabel = new JLabel("¿QUÉ TE GUSTARÍA HACER HOY?");
        mensajeLabel.setFont(new Font("Bitstream Charter", Font.BOLD, 25));
        mensajeLabel.setForeground(Color.BLUE);
        mensajeLabel.setBackground(new Color(251, 250, 248));
        menuPrincipal.add(Box.createHorizontalGlue());
        menuPrincipal.add(mensajeLabel);
    }

    private void addClockLabel(JMenuBar menuPrincipal) {
        relojLabel = new JLabel();
        relojLabel.setFont(new Font("Bitstream Charter", Font.BOLD, 20));
        relojLabel.setForeground(Color.BLACK);
        actualizarReloj();
        menuPrincipal.add(Box.createHorizontalGlue());
        menuPrincipal.add(relojLabel);
    }

    private void iniciarReloj() {
        Thread hiloReloj = new Thread(() -> {
            while (true) {
                if (relojActivo) {
                    SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/YYYY");
                    SimpleDateFormat formatoHora = new SimpleDateFormat("hh:mm:ss a");
                    String fecha = formatoFecha.format(new Date());
                    String hora = formatoHora.format(new Date());
                    relojLabel.setText("CUNOC;" + " " + fecha + " " + hora);
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        });
        hiloReloj.start();
    }

    private void actualizarReloj() {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/YYYY");
        SimpleDateFormat formatoHora = new SimpleDateFormat("hh:mm:ss a");
        String fecha = formatoFecha.format(new Date());
        String hora = formatoHora.format(new Date());
        relojLabel.setText("CUNOC;" + " " + fecha + " " + hora);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 650, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 641, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}

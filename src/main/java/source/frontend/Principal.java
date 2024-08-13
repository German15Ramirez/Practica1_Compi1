/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

package source.frontend;

import source.backend.herramientas.NumeracionFilas;
import source.backend.herramientas.OpenFile;
import source.backend.herramientas.SaveFile;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;

import static jdk.jfr.consumer.EventStream.openFile;

/**
 *
 * @author alex
 */
public class Principal extends javax.swing.JFrame {
    JTextPane panelBlanco = new JTextPane();
    private Image imagenFondo = new ImageIcon(getClass().getResource("/imagenes/logo.png")).getImage();
    private JLabel relojLabel;
    private JPanel contenedorPanel;
    private boolean relojActivo = true;
    private Dimension tamañoPanelFondo;
    private String titulo = "GRAFICADOR DE GEOMETRIA";
    private NumeracionFilas numerosFilaC1;
    private JScrollPane jScrollPane1;

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
        int alto = 900;
        int ancho = 1000;
        this.setBounds(0, 0, ancho, alto);
        tamañoPanelFondo = new Dimension(ancho, alto);

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

        // Agregamos el panel de escritura dentro de un JScrollPane
        panelBlanco.setBackground(Color.WHITE);
        panelBlanco.setPreferredSize(new Dimension(900, 800));
        Font fuenteTexto = new Font("SansSerif", Font.PLAIN, 16);
        panelBlanco.setFont(fuenteTexto);

        // Creación del JScrollPane
        jScrollPane1 = new JScrollPane(panelBlanco);

        // Numeración de filas
        numerosFilaC1 = new NumeracionFilas(panelBlanco);
        jScrollPane1.setRowHeaderView(numerosFilaC1);

        // Añadir JScrollPane al contenedor principal
        contenedorPanel.add(jScrollPane1, BorderLayout.CENTER);

        JPanel panelInferior = new JPanel(new BorderLayout());

        // JLabel en la parte inferior
        JLabel labelInferiorIzquierda = new JLabel("Información adicional");
        labelInferiorIzquierda.setFont(new Font("Bitstream Charter", Font.BOLD, 20)); // Texto más grande
        labelInferiorIzquierda.setForeground(new Color(0, 102, 204)); // Color azul oscuro
        panelInferior.add(labelInferiorIzquierda, BorderLayout.WEST);

        // Panel para contener los botones en la parte inferior derecha
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.LEFT));

        // Crear botones
        JButton botonCompilar = new JButton("Compilar");
        JButton botonAnimar = new JButton("Animar");

        // Establecer fuente más grande para los botones
        Font fuenteBotones = new Font("Bitstream Charter", Font.BOLD, 20);
        botonCompilar.setFont(fuenteBotones);
        botonAnimar.setFont(fuenteBotones);

        // Establecer colores de fondo para los botones
        botonCompilar.setBackground(new Color(0, 128, 0)); // Verde
        botonCompilar.setForeground(Color.WHITE); // Texto blanco
        botonAnimar.setBackground(new Color(71, 97, 219)); // Azul suave
        botonAnimar.setForeground(Color.BLACK); // Texto negro

        // Añadir botones al panel de botones
        panelBotones.add(botonCompilar);
        panelBotones.add(botonAnimar);

        // Añadir panel de botones al panel inferior
        panelInferior.add(panelBotones, BorderLayout.EAST);

        // Añadimos el panel inferior al contenido
        getContentPane().add(panelInferior, BorderLayout.SOUTH);
    }


    private void addMenus(JMenuBar menuPrincipal) {
        JMenu menuRegistros = new JMenu("Archivo");
        JMenu menuReportes = new JMenu("Reportes");
        menuPrincipal.add(menuRegistros);
        menuPrincipal.add(menuReportes);
        //agregar iconos a cada menu
        ImageIcon iconoAbrirRegistros = new ImageIcon(getClass().getResource("/imagenes/open_file.png"));
        Image imageAbrirRegistros = iconoAbrirRegistros.getImage();
        Image newImageAbrirRegistros = imageAbrirRegistros.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
        iconoAbrirRegistros = new ImageIcon(newImageAbrirRegistros);
        ImageIcon iconoReportes = new ImageIcon(getClass().getResource("/imagenes/reportes_icono.png"));
        Image imageReportes = iconoReportes.getImage();
        Image newImageReportes = imageReportes.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
        iconoReportes = new ImageIcon(newImageReportes);
        ImageIcon iconoListas = new ImageIcon(getClass().getResource("/imagenes/save_file.png"));
        Image imageListas = iconoListas.getImage();
        Image newImageListas = imageListas.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
        iconoListas = new ImageIcon(newImageListas);
        ImageIcon iconoNuevo = new ImageIcon(getClass().getResource("/imagenes/nuevo_archivo.png"));
        Image imageNuevo = iconoNuevo.getImage();
        Image newImageNuevo = imageNuevo.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
        iconoNuevo = new ImageIcon(newImageNuevo);
        ImageIcon iconoErrores = new ImageIcon(getClass().getResource("/imagenes/errores_logo.png"));
        Image imageErrores = iconoErrores.getImage();
        Image newImageErrores = imageErrores.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
        iconoErrores = new ImageIcon(newImageErrores);
        //creacion de items en cada menu
        //items registros
        JMenuItem itemImportarRegistros = new JMenuItem("Cargar Archivo", iconoAbrirRegistros);
        // Añadir ActionListener para abrir archivo
        itemImportarRegistros.addActionListener(e -> OpenFile.openFileAndSetText(panelBlanco));
        JMenuItem itemGuardarArchivos = new JMenuItem("Guardar Archivo", iconoListas);
        itemGuardarArchivos.addActionListener(e -> SaveFile.saveTextToFile(panelBlanco));
        JMenuItem itemListaLibros = new JMenuItem("Nuevo Archivo", iconoNuevo);
        //items reportes
        JMenuItem itemPrestamosMismoDia = new JMenuItem("Ocurrencias de Operadores Matemáticos", iconoReportes);
        JMenuItem itemPrestamosMora = new JMenuItem("Colores Usados", iconoReportes);
        JMenuItem itemIngresosIntervalo = new JMenuItem("Objetos Usados", iconoReportes);
        JMenuItem itemPrestamosPorEstudiante = new JMenuItem("Animaciones Usadas", iconoReportes);
        JMenuItem itemPrestamosVigentesPorEstudiante = new JMenuItem("Errores de Compilación", iconoErrores);
        //añadir al menu
        menuRegistros.add(itemImportarRegistros);
        menuRegistros.add(itemGuardarArchivos);
        menuRegistros.add(itemListaLibros);
        menuReportes.add(itemPrestamosMismoDia);
        menuReportes.add(itemPrestamosMora);
        menuReportes.add(itemIngresosIntervalo);
        menuReportes.add(itemPrestamosPorEstudiante);
        menuReportes.add(itemPrestamosVigentesPorEstudiante);

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
        JLabel mensajeLabel = new JLabel("GRAFICADOR DE GEOMETRIA");
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

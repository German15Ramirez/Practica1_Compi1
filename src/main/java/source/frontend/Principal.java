/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

package source.frontend;

import java_cup.runtime.*;
import source.Lexer;
import source.backend.herramientas.*;
import source.parser;
import source.sym;
import java.awt.*;
import java.io.StringReader;
import java.text.*;
import java.util.*;
import javax.swing.*;


/**
 *
 * @author alex
 */
public class Principal extends javax.swing.JFrame {
    private JTextPane panelBlanco;
    private Image imagenFondo = new ImageIcon(getClass().getResource("/imagenes/logo.png")).getImage();
    private JLabel relojLabel;
    private JPanel contenedorPanel;
    private boolean relojActivo = true;
    private Dimension tamañoPanelFondo;
    private String titulo = "GRAFICADOR DE GEOMETRIA";
    private NumeracionFilas numerosFilaC1;
    private JScrollPane jScrollPane1;
    private Numeracion numeracion;
    private JLabel infoLabel;
    private JLabel labelInferiorIzquierda;

    /** Creates new form Principal */
    public Principal() {
        initComponents();
        initUI();
        iniciarReloj();
    }

    private void initUI() {
        setTitle(titulo);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contenedorPanel = new JPanel(new BorderLayout());

        int alto = 900;
        int ancho = 1000;
        setBounds(0, 0, ancho, alto);
        tamañoPanelFondo = new Dimension(ancho, alto);

        setContentPane(new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
            }
        });

        getContentPane().add(contenedorPanel, BorderLayout.CENTER);

        JMenuBar menuPrincipal = new JMenuBar();
        addMenus(menuPrincipal);
        setJMenuBar(menuPrincipal);

        addMessageLabel(menuPrincipal);
        addClockLabel(menuPrincipal);

        panelBlanco = new JTextPane();
        panelBlanco.setBackground(Color.WHITE);
        panelBlanco.setPreferredSize(new Dimension(900, 800));
        panelBlanco.setFont(new Font("SansSerif", Font.PLAIN, 16));

        jScrollPane1 = new JScrollPane(panelBlanco);
        numerosFilaC1 = new NumeracionFilas(panelBlanco);
        jScrollPane1.setRowHeaderView(numerosFilaC1);
        contenedorPanel.add(jScrollPane1, BorderLayout.CENTER);

        JPanel panelInferior = new JPanel(new BorderLayout());

        // JLabel a la izquierda
        labelInferiorIzquierda = new JLabel("");
        labelInferiorIzquierda.setFont(new Font("Bitstream Charter", Font.BOLD, 20));
        labelInferiorIzquierda.setForeground(new Color(0, 102, 204));
        panelInferior.add(labelInferiorIzquierda, BorderLayout.WEST);

        // Panel para los botones
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton botonCompilar = new JButton("Compilar");
        botonCompilar.addActionListener(e -> {
            String textoIngresado = panelBlanco.getText();
            StringReader reader = new StringReader(textoIngresado);
            Lexer lexer = new Lexer(reader);
            Symbol simbolo;
            try {
                // Leer tokens hasta encontrar EOF
                while ((simbolo = lexer.next_token()).sym != sym.EOF) {
                    // Mostrar información detallada del token
                    System.out.println("Token: " + simbolo.sym);
                    System.out.println("Valor: " + simbolo.value);
                    System.out.println("Línea: " + simbolo.left + ", Columna: " + simbolo.right);
                    System.out.println("--------------");
                }
            } catch (Exception ex) {
                System.err.println("Error durante el análisis:");
                ex.printStackTrace();
            }
            parser parser = new parser(lexer);

            try {
                parser.parse();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }

            // Si todo va bien
            System.out.println("Análisis completado exitosamente.");

        });
        JButton botonAnimar = new JButton("Animar");
        Font fuenteBotones = new Font("Bitstream Charter", Font.BOLD, 20);
        botonCompilar.setFont(fuenteBotones);
        botonAnimar.setFont(fuenteBotones);
        botonCompilar.setBackground(new Color(0, 128, 0));
        botonCompilar.setForeground(Color.WHITE);
        botonAnimar.setBackground(new Color(71, 97, 219));
        botonAnimar.setForeground(Color.BLACK);
        panelBotones.add(botonCompilar);
        panelBotones.add(botonAnimar);

        panelInferior.add(panelBotones, BorderLayout.EAST);

        infoLabel = new JLabel("Columna No.: 0 Fila No.: 0");
        infoLabel.setFont(new Font("Bitstream Charter", Font.BOLD, 20));
        infoLabel.setForeground(new Color(0, 102, 204));
        numeracion = new Numeracion(panelBlanco, infoLabel);
        panelInferior.add(infoLabel, BorderLayout.CENTER);

        getContentPane().add(panelInferior, BorderLayout.SOUTH);
    }

    private void addMenus(JMenuBar menuPrincipal) {
        JMenu menuRegistros = new JMenu("Archivo");
        JMenu menuReportes = new JMenu("Reportes");
        menuPrincipal.add(menuRegistros);
        menuPrincipal.add(menuReportes);

        // Crear iconos menu
        ImageIcon iconoAbrirArchivo = createScaledIcon("/imagenes/open_file.png", 30, 30);
        ImageIcon iconoGuardar = createScaledIcon("/imagenes/save_file.png", 30, 30);
        ImageIcon iconoNuevo = createScaledIcon("/imagenes/nuevo_archivo.png", 30, 30);
        ImageIcon iconoReportes = createScaledIcon("/imagenes/reportes_icono.png", 30, 30);
        ImageIcon iconoErrores = createScaledIcon("/imagenes/errores_logo.png", 30, 30);

        JMenuItem itemAbrirAchivo = new JMenuItem("Cargar Archivo", iconoAbrirArchivo);
        itemAbrirAchivo.addActionListener(e -> OpenFile.openFileAndSetText(panelBlanco));

        JMenuItem itemGuardarArchivos = new JMenuItem("Guardar Archivo", iconoGuardar);
        itemGuardarArchivos.addActionListener(e -> SaveFile.saveTextToFile(panelBlanco));

        JMenuItem itemNuevoArchivo = new JMenuItem("Nuevo Archivo", iconoNuevo);
        itemNuevoArchivo.addActionListener(e -> {
            panelBlanco.setText(""); // Limpiar el JTextPane
            JOptionPane.showMessageDialog(this, "Ya puedes escribir en tu nuevo archivo :)", "Nuevo Archivo", JOptionPane.INFORMATION_MESSAGE);
        });

        JMenuItem itemOCOpMatematicos = new JMenuItem("Ocurrencias de Operadores Matemáticos", iconoReportes);
        JMenuItem itemColoresUsados = new JMenuItem("Colores Usados", iconoReportes);
        JMenuItem itemObjetosUsados = new JMenuItem("Objetos Usados", iconoReportes);
        JMenuItem itemAnimacionesUsadas = new JMenuItem("Animaciones Usadas", iconoReportes);
        JMenuItem itemErroresDeCompilacion = new JMenuItem("Errores de Compilación", iconoErrores);

        menuRegistros.add(itemAbrirAchivo);
        menuRegistros.add(itemGuardarArchivos);
        menuRegistros.add(itemNuevoArchivo);
        menuReportes.add(itemOCOpMatematicos);
        menuReportes.add(itemColoresUsados);
        menuReportes.add(itemObjetosUsados);
        menuReportes.add(itemAnimacionesUsadas);
        menuReportes.add(itemErroresDeCompilacion);

        // Personalizar fuente de menú
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
        menuPrincipal.setLayout(new BoxLayout(menuPrincipal, BoxLayout.X_AXIS));
    }

    private ImageIcon createScaledIcon(String path, int width, int height) {
        ImageIcon icon = new ImageIcon(getClass().getResource(path));
        Image image = icon.getImage();
        Image scaledImage = image.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImage);
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

    public void actualizarInfoLabel(int fila, int columna) {
        infoLabel.setText("Columna No.: " + columna + " Fila No.: " + fila);
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

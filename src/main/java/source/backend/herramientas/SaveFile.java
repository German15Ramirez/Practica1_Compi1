package source.backend.herramientas;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class SaveFile {

    public static void saveTextToFile(JTextPane jTextPane) {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivo de Texto (.txt)", "txt");
        fileChooser.setFileFilter(filter);

        int result = fileChooser.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            // Si el usuario no especifica la extensión, agregar .txt por defecto
            if (!selectedFile.getName().endsWith(".txt")) {
                selectedFile = new File(selectedFile.getAbsolutePath() + ".txt");
            }
            try {
                saveTextToFile(selectedFile, jTextPane.getText());
            } catch (IOException e) {
                handleFileSaveError(e);
            }
        }
    }

    private static void saveTextToFile(File file, String text) throws IOException {
        try (FileWriter fileWriter = new FileWriter(file, StandardCharsets.UTF_8);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            bufferedWriter.write(text);
        }
    }

    private static void handleFileSaveError(Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error al guardar el archivo: " + e.getMessage(), "Error inesperado", JOptionPane.ERROR_MESSAGE);
    }
}


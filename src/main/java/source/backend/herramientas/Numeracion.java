package source.backend.herramientas;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Numeracion extends JPanel
        implements CaretListener, DocumentListener {
    private JTextPane jTextPane;
    private JLabel jLabel;
    private int lineNumber;
    private int columnNumber;

    public Numeracion(JTextPane jTextPane, JLabel jLabel) {
        this.jTextPane = jTextPane;
        this.jLabel = jLabel;

        if (this.jLabel == null) {
            throw new IllegalArgumentException("jLabel cannot be null");
        }

        jTextPane.getDocument().addDocumentListener(this);
        jTextPane.addCaretListener(this);
        updateColumnNumbers();
    }

    private void updateColumnNumbers() {
        if (jLabel == null) {
            return; // No se puede actualizar si jLabel es null
        }

        int caretPosition = jTextPane.getCaretPosition();
        int caretLine = jTextPane.getDocument().getDefaultRootElement().getElementIndex(caretPosition);
        int startOffset = jTextPane.getDocument().getDefaultRootElement().getElement(caretLine).getStartOffset();
        caretLine++;
        lineNumber = caretLine;
        columnNumber = caretPosition - startOffset;

        jLabel.setText("Columna No.: " + columnNumber + " Fila No.: " + lineNumber);
    }

    @Override
    public void caretUpdate(CaretEvent e) {
        updateColumnNumbers();
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        updateColumnNumbers();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        updateColumnNumbers();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        updateColumnNumbers();
    }
}
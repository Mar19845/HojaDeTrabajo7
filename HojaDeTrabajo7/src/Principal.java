
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Juan Marroquin
 */
public class Principal extends javax.swing.JFrame {

    private final JFileChooser openFile;
    private final JFileChooser openFile1;
    private BufferedReader lector;
    private BufferedReader lector2;
    String FileName;
    public String lineas;
    BinaryTree<String> binaryTree = new BinaryTree<>();
    Diccionario<String, String> dictionaryMap = new Diccionario<>();

    public Principal() {
        initComponents();
        initComponents();
        openFile = new JFileChooser();
        openFile.setCurrentDirectory(new File("c:\\temp"));
        openFile.setFileFilter(new FileNameExtensionFilter("Txt files", "txt"));
        openFile1 = new JFileChooser();
        openFile1.setCurrentDirectory(new File("c:\\temp"));
        openFile1.setFileFilter(new FileNameExtensionFilter("Txt files", "txt"));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        boton_buscar = new javax.swing.JButton();
        label_archivo = new javax.swing.JLabel();
        boton_orden = new javax.swing.JButton();
        boton_traducir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        boton_buscar.setText("Buscar");
        boton_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_buscarActionPerformed(evt);
            }
        });

        label_archivo.setText(".....");

        boton_orden.setText("Orden del Diccionario");
        boton_orden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_ordenActionPerformed(evt);
            }
        });

        boton_traducir.setText("Traducir algo");
        boton_traducir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_traducirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(boton_traducir)
                    .addComponent(boton_orden)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(boton_buscar)
                        .addGap(29, 29, 29)
                        .addComponent(label_archivo, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(104, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boton_buscar)
                    .addComponent(label_archivo))
                .addGap(18, 18, 18)
                .addComponent(boton_orden)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(boton_traducir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boton_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_buscarActionPerformed
        int returnValue = openFile.showOpenDialog(this);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            try {
                //lector = FileReader.read(openFile.getSelectedFile());
                lector = new BufferedReader(new FileReader(openFile.getSelectedFile()));
                FileName = openFile.getName(openFile.getSelectedFile());
                //labelNombreArchivo.setText(FileName);
                label_archivo.setText(FileName);
                while (lector.ready()) {
                    lineas = lector.readLine();
                    //System.out.println(lineas);
                    binaryTree.add(lineas);
                    lineas = lineas.replace("(", "");
                    lineas = lineas.replace(")", "");
                    //System.out.println(lineas);
                    String[] splitLine = lineas.split(",");
                    splitLine[1] = splitLine[1].replace(" ", "");
                    dictionaryMap.addEntry(splitLine[0], splitLine[1]);
                    //System.out.println(dictionaryMap.toString());
                }

            } catch (IOException io) {
                label_archivo.setText("Fallo la carga del archivo");
            }
        } else {
            label_archivo.setText("No se escogio ningun archivo");
        }

    }//GEN-LAST:event_boton_buscarActionPerformed

    private void boton_ordenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_ordenActionPerformed
        System.out.println("The binary tree in order is: ");
        binaryTree.inOrder(binaryTree.getRoot());
        System.out.println();
    }//GEN-LAST:event_boton_ordenActionPerformed

    private void boton_traducirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_traducirActionPerformed
        int returnValue1 = openFile1.showOpenDialog(this);

        if (returnValue1 == JFileChooser.APPROVE_OPTION) {
            try {
                //lector = FileReader.read(openFile.getSelectedFile());
                lector2 = new BufferedReader(new FileReader(openFile1.getSelectedFile()));
                while (lector2.ready()) {
                    String line = lector2.readLine();
                    String translatedLine = "";
                    // Initializes an array in case the line is empty
                    String[] wordsToTranslate = new String[0];
                    // The array contains the words in the line
                    if (line.length() > 0) {
                        wordsToTranslate = line.split(" ");
                    }
                    for (int i = 0; i < wordsToTranslate.length; i++) {

                        // Last character in the current word
                        char lastCharacter = wordsToTranslate[i].charAt(wordsToTranslate[i].length() - 1);
                        // Assumes the wors is lowercase and has no punctuation in the end
                        boolean punctuation = false;
                        boolean uppercase = false;

                        // If the word contains punctuation
                        if (lastCharacter == '.' || lastCharacter == ';' || lastCharacter == ':' || lastCharacter == ','
                                || lastCharacter == '!' || lastCharacter == '?') {
                            //Removes the punctuation mark and the punctuation flag is set to true
                            wordsToTranslate[i] = wordsToTranslate[i].replace("" + lastCharacter, "");
                            punctuation = true;
                        }

                        // Saves the original word to translate
                        String originalWord = wordsToTranslate[i];

                        // If it's capitalized, the corresponding flag is set
                        if (Character.isUpperCase(wordsToTranslate[i].charAt(0))) {
                            uppercase = true;
                        }

                        // Converts the word to lowercase
                        wordsToTranslate[i] = wordsToTranslate[i].toLowerCase();

                        // If the word is in the dictionary, it is translated
                        if (dictionaryMap.containsWord(wordsToTranslate[i])) {
                            String translatedWord = dictionaryMap.getSpanishWord(wordsToTranslate[i]);
                            // If the original word was in uppercase, the translated one is too
                            if (uppercase) {
                                translatedWord = translatedWord.replace(translatedWord.charAt(0) + "",
                                        (translatedWord.charAt(0) + "").toUpperCase());
                            }
                            // Adds the word to the translated line
                            translatedLine = translatedLine + " " + translatedWord;
                            // If it's not in the dictionary, the word is surrounded by asterisks
                        } else {
                            translatedLine = translatedLine + " *" + originalWord + "*";
                        }

                        // If the word had a punctuation mark, it is once again added after the translation
                        if (punctuation) {
                            translatedLine += lastCharacter + "";
                        }
                    }
                    System.out.println(translatedLine);
                }
            } catch (IOException io) {
                System.err.println("Hubo un error");
            }
        } else {
            System.out.println("No se escogio ningun archivo");
        }
    }//GEN-LAST:event_boton_traducirActionPerformed

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
    private javax.swing.JButton boton_buscar;
    private javax.swing.JButton boton_orden;
    private javax.swing.JButton boton_traducir;
    private javax.swing.JLabel label_archivo;
    // End of variables declaration//GEN-END:variables
}

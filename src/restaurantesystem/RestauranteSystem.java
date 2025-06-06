/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package restaurantesystem;

/**
 *
 * @author alunocmc
 */
public class RestauranteSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        frmPrincipal frmPrin = new frmPrincipal();
        frmPrin.setVisible(true);
        frmPrin.setLocationRelativeTo(null);
        // Adiciona menu para abrir cadastro de cliente
        javax.swing.JMenuBar menuBar = new javax.swing.JMenuBar();
        javax.swing.JMenu menu = new javax.swing.JMenu("Cadastros");
        javax.swing.JMenuItem itemCliente = new javax.swing.JMenuItem("Cliente");
        itemCliente.addActionListener(e -> {
            new frmClienteCadastro().setVisible(true);
        });
        menu.add(itemCliente);
        menuBar.add(menu);
        frmPrin.setJMenuBar(menuBar);
    }
    
}

package restaurantesystem;

import javax.swing.*;

public class frmClienteCadastro extends javax.swing.JFrame {
    public frmClienteCadastro() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Cadastro de Cliente");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(350, 200);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(20, 20, 80, 25);
        add(lblNome);
        JTextField txtNome = new JTextField();
        txtNome.setBounds(100, 20, 200, 25);
        add(txtNome);

        JLabel lblTelefone = new JLabel("Telefone:");
        lblTelefone.setBounds(20, 60, 80, 25);
        add(lblTelefone);
        JTextField txtTelefone = new JTextField();
        txtTelefone.setBounds(100, 60, 200, 25);
        add(txtTelefone);

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(100, 110, 100, 30);
        add(btnSalvar);

        btnSalvar.addActionListener(e -> {
            String nome = txtNome.getText().trim();
            String telefone = txtTelefone.getText().trim();
            if (nome.isEmpty() || telefone.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Preencha todos os campos.");
                return;
            }
            try {
                Cliente cliente = new Cliente(0, nome, telefone);
                ClienteDAO dao = new ClienteDAO();
                dao.inserir(cliente);
                JOptionPane.showMessageDialog(this, "Cliente cadastrado com sucesso!");
                dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro ao cadastrar cliente: " + ex.getMessage());
            }
        });
    }
}

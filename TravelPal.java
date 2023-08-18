import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TravelPal {

    private JFrame frame;
    private JTextField txtNombre, txtEmail, txtTelefono;
    private JTextArea txtIntereses;
    private JComboBox<String> comboRangoPrecio;

    public TravelPal() {
        frame = new JFrame("Travel pal");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Panel superior para el título
        JPanel panelTitulo = new JPanel();
        JLabel lblTitulo = new JLabel("Travel pal");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 24));
        panelTitulo.add(lblTitulo);
        frame.add(panelTitulo, BorderLayout.NORTH);

        // Panel central para ingreso de datos
        JPanel panelDatos = new JPanel();
        panelDatos.setLayout(new GridLayout(8, 2));

        // Datos de contacto
        panelDatos.add(new JLabel("Nombre:"));
        txtNombre = new JTextField(15);
        panelDatos.add(txtNombre);

        panelDatos.add(new JLabel("Email:"));
        txtEmail = new JTextField(15);
        panelDatos.add(txtEmail);

        panelDatos.add(new JLabel("Teléfono:"));
        txtTelefono = new JTextField(10);
        panelDatos.add(txtTelefono);

        // Intereses
        panelDatos.add(new JLabel("Intereses de viaje:"));
        txtIntereses = new JTextArea(4, 15);
        JScrollPane scrollIntereses = new JScrollPane(txtIntereses);
        panelDatos.add(scrollIntereses);

        // Rango de precio
        panelDatos.add(new JLabel("Rango de precio:"));
        String[] rangos = {"$0 - $500", "$501 - $1000", "$1001 - $5000", "Más de $5000"};
        comboRangoPrecio = new JComboBox<>(rangos);
        panelDatos.add(comboRangoPrecio);

        frame.add(panelDatos, BorderLayout.CENTER);

        // Botón de envío
        JButton btnEnviar = new JButton("Enviar");
        btnEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enviarDatos();
            }
        });
        frame.add(btnEnviar, BorderLayout.SOUTH);

        frame.pack();
        frame.setVisible(true);
    }

    private void enviarDatos() {
        String nombre = txtNombre.getText().trim();
        String email = txtEmail.getText().trim();
        String telefono = txtTelefono.getText().trim();

        // Validación
        if (nombre.isEmpty() || email.isEmpty() || telefono.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Por favor, rellena todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!email.contains("@")) {
            JOptionPane.showMessageDialog(frame, "Por favor, introduce un email válido", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Aquí puedes agregar la lógica para procesar los datos, como guardarlos en una base de datos o enviarlos a un servidor.
        JOptionPane.showMessageDialog(frame, "Datos enviados con éxito!", "Información", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        new TravelPal();
    }
}

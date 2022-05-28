/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ArrayPersonas {

    public ArrayList lPersonas;
    MetodosPersonas Mispersonas;

    public ArrayPersonas() {
        lPersonas = new ArrayList();
        Mispersonas = new MetodosPersonas();
    }

    public int getBuscarDni(String Dni) {
        int i;
        MetodosPersonas temp = null;
        for (i = 0; i < lPersonas.size(); i++) {
            temp = (MetodosPersonas) lPersonas.get(i);
            if (temp.getDni().equals(Dni)) {
                return i;
            }
        }
        return -1;
    }

    public void setAddPersona(
            JTextField jtfNom,
            JTextField jtfEdad,
            JComboBox jcbSexo,
            JTextField jtfPeso,
            String DNI,
            JTextField jtfAlt
    ) {

        int posB = getBuscarDni(DNI);
        if (posB != -1) {
            JOptionPane.showMessageDialog(null,
                    "El idEmpleado ya esta registrado. "
                    + "Intente nuevamente!");
        } else {
            MetodosPersonas info = new MetodosPersonas(
                    jtfNom.getText(),
                    Integer.parseInt(jtfEdad.getText()),
                    DNI,
                    jcbSexo.getSelectedItem().toString().charAt(0),
                    Float.parseFloat(jtfPeso.getText()),
                    Float.parseFloat(jtfAlt.getText())
            );
            lPersonas.add(info);
            JOptionPane.showMessageDialog(null,
                    "¡Nueva Persona registrada!");
            jtfNom.setText("");
            jtfEdad.setText("");
            jcbSexo.setSelectedIndex(0);
            jtfPeso.setText("");
            jtfAlt.setText("");
            jtfNom.requestFocus();
        }
    }

    public void setPersona(
            String idEmp
    ) {
        int posB = getBuscarDni(idEmp);
        if (posB == -1) {
            JOptionPane.showMessageDialog(null,
                    "¡La persona a eliminar no esta registrada!");
        } else {
            lPersonas.remove(posB);
            JOptionPane.showMessageDialog(null,
                    "Persona eliminada de la posición: " + posB);
        }
    }

    public void setModificarEmpleado(
            String DNI, String nombre, int edad, char sexo, float peso, float altura
    ) {
        int posB = getBuscarDni(DNI);
        if (posB == -1) {
            JOptionPane.showMessageDialog(null,
                    "El Dato no se encuetra");
        } else {
            MetodosPersonas info = new MetodosPersonas(
                    nombre, edad, DNI, sexo, peso, altura
            );
            lPersonas.set(posB, info);
            JOptionPane.showMessageDialog(null,
                    "Datos de empleado modificado!");
        }
    }

    public void setRegistrarFilaJTable(DefaultTableModel miModelo,
            int Fila, int indiceArray) {

        MetodosPersonas temp = (MetodosPersonas) lPersonas.get(indiceArray);
        miModelo.setValueAt(temp.getNombre(), Fila, 0);
        miModelo.setValueAt(temp.getEdad(), Fila, 1);
        miModelo.setValueAt(temp.getSexo(), Fila, 2);
        miModelo.setValueAt(temp.getPeso(), Fila, 3);
        miModelo.setValueAt(temp.getAltura(), Fila, 4);
        miModelo.setValueAt(temp.getCalcularImc(), Fila, 5);
        miModelo.setValueAt(temp.getMayorDeEdad(), Fila, 6);
        miModelo.setValueAt(temp.getDni(), Fila, 7);
    }

    public void setLlenarJTable(JTable tab) {
        int indice = 0;
        int i = 0;
        DefaultTableModel miModelo = new DefaultTableModel();
        miModelo.addColumn("Nombre");
        miModelo.addColumn("Edad");
        miModelo.addColumn("Sexo");
        miModelo.addColumn("Peso");
        miModelo.addColumn("Altura");
        miModelo.addColumn("IMC");
        miModelo.addColumn("Mayor de edad");
        miModelo.addColumn("DNI");
        while (indice < lPersonas.size()) {
            miModelo.addRow(new Object[]{"", "", "", "", "", "", "", ""});
            setRegistrarFilaJTable(miModelo, i, indice);
            i++;
            indice++;
        }
        tab.setModel(miModelo);
    }

}

package actividad_m3;

import javax.swing.JOptionPane;

public class ListaP {

    Producto cab;

    ListaP() {

        cab = null;

    }

    Producto getUltimo() {
        if (cab == null) {
            return null;
        } else {
            Producto aux = cab;
            while (aux.sig != cab) {
                aux = aux.sig;
            }
            return aux;
        }
    }

    public boolean getIsEmpty() {
        return cab == null ? true : false;

    }

    Producto getReferencia(String id) {
        if (cab == null) {
            return null;
        } else {
            Producto p = cab;
            do {
                if ((p.idProducto).equalsIgnoreCase(id)) {
                    return p;
                } else {
                    p = p.sig;
                }
            } while (p != cab);
            return null;
        }
    }

    int getLongLista() {
        int cont = 0;
        if (cab == null) {
            return cont;
        } else {
            Producto p = cab;
            do {
                cont++;
                p = p.sig;
            } while (p != cab);
            return cont;
        }
    }

    void setAddInicio(Producto q) {
        if (cab == null) {
            cab = q;
            cab.sig = cab;
            JOptionPane.showMessageDialog(null,
                    "Producto agregado al inicio...");
        } else {
            Producto p = getReferencia(q.idProducto);
            if (p != null) {
                JOptionPane.showMessageDialog(null,
                        "La referencia existe!!!");
            } else {
                p = getUltimo();
                q.sig = cab;
                p.sig = q;
                cab = q;
                q = p = null;
                JOptionPane.showMessageDialog(null,
                        "Producto agregado al inicio...");
            }
        }
    }

    void setAddFinal(Producto q) {
        Producto p, aux;
        if (cab == null) {
            cab = q;
            cab.sig = cab;
            JOptionPane.showMessageDialog(null, "Agregado al final...");
        } else {
            aux = getReferencia(q.idProducto);
            if (aux == null) {
                p = getUltimo();
                p.sig = q;
                q.sig = cab;
                JOptionPane.showMessageDialog(null,
                        "Agregado al final...");
            } else {
                JOptionPane.showMessageDialog(null,
                        "Elemento existe...");
            }
        }
    }

}

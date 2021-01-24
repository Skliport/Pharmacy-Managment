
package Entidades;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encriptador {
   
    public String Encriptar(String entrada) {
        String salida = null;
        try {
            if (entrada != null) {

                MessageDigest algoritmo = MessageDigest.getInstance("SHA-256");
                algoritmo.reset();
                algoritmo.update(entrada.getBytes());
                byte bytes[] = algoritmo.digest();
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < bytes.length; i++) {
                    String hex = Integer.toHexString(0xff & bytes[i]);
                    if (hex.length() == 1) {
                        sb.append('0');
                    }
                    sb.append(hex);
                }

                salida = sb.toString();
            }
        } catch (NoSuchAlgorithmException e) {
        }

        return salida;
    }
}
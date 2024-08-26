import javax.swing.*;

public class DocumentoDeVisao {

    private int[] numbers = new int[8];

    public static void main(String[] args) {
        DocumentoDeVisao sorter = new DocumentoDeVisao();
        sorter.entradaNumeros();
        sorter.bubbleSort();
        sorter.procuraNumero();
    }

    
    private void entradaNumeros() {
        JPanel panel = new JPanel();
        JTextField[] fields = new JTextField[8];
        for (int i = 0; i < 8; i++) {
            fields[i] = new JTextField(5);
            panel.add(new JLabel("Número " + (i + 1) + ":"));
            panel.add(fields[i]);
        }
        int result = JOptionPane.showConfirmDialog(null, panel, "Insira 8 números inteiros", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            for (int i = 0; i < 8; i++) {
                try {
                    numbers[i] = Integer.parseInt(fields[i].getText());
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Por favor, insira apenas números inteiros.");
                    i--; 
                }
            }
        } else {
            System.exit(0);
        }
    }

    
    private void bubbleSort() {
        boolean b;
        for (int i = 0; i < numbers.length - 1; i++) {
            b = false;
            for (int j = 0; j < numbers.length - i - 1; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                    b = true;
                }
            }
            if (!b) break;
        }
    }


    private void procuraNumero() {
        String input = JOptionPane.showInputDialog("Insira um número inteiro para buscar:");
        try {
            int key = Integer.parseInt(input);
            int index = buscaBinaria(key);

            mostraResultado(key, index);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Por favor, insira apenas números inteiros.");
            procuraNumero(); 
        }
    }

    
    private int buscaBinaria(int key) {
        int left = 0;
        int right = numbers.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (numbers[mid] == key) {
                return mid; 
            }

            if (numbers[mid] < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1; 
    }

    
    private void mostraResultado(int key, int index) {
        String message;
        if (index != -1) {
            message = "Chave " + key + " encontrada na posição " + (index + 1) + ".";
        } else {
            message = "Chave " + key + " não encontrada.";
        }
        JOptionPane.showMessageDialog(null, message, "Resultado da Busca", JOptionPane.INFORMATION_MESSAGE);
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SortingApp {
    public static void main(String[] args) {
        // Membuat JFrame
        JFrame frame = new JFrame("Sorting Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Label untuk input
        JLabel inputLabel = new JLabel("Masukkan angka");
        inputLabel.setFont(new Font("Arial", Font.BOLD, 14));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 10, 5, 10);
        frame.add(inputLabel, gbc);

        // TextField untuk input
        JTextField inputField = new JTextField(25);
        inputField.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(5, 10, 10, 10);
        frame.add(inputField, gbc);

        // Tombol Bubble Sort
        JButton bubbleSortButton = new JButton("Bubble Sort");
        bubbleSortButton.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(5, 10, 5, 5);
        frame.add(bubbleSortButton, gbc);

        // Tombol Selection Sort
        JButton selectionSortButton = new JButton("Selection Sort");
        selectionSortButton.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.insets = new Insets(5, 5, 5, 10);
        frame.add(selectionSortButton, gbc);

        // TextArea untuk hasil
        JTextArea resultArea = new JTextArea(10, 30);
        resultArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 10, 10, 10);
        frame.add(scrollPane, gbc);

        // Fungsi Bubble Sort
        bubbleSortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputField.getText();
                try {
                    int[] arr = parseInput(input);
                    bubbleSort(arr);
                    resultArea.setText("Hasil Bubble Sort:\n" + arrayToString(arr));
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Input tidak valid. Masukkan angka yang dipisahkan dengan koma.");
                }
            }
        });

        // Fungsi Selection Sort
        selectionSortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputField.getText();
                try {
                    int[] arr = parseInput(input);
                    selectionSort(arr);
                    resultArea.setText("Hasil Selection Sort:\n" + arrayToString(arr));
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Input tidak valid. Masukkan angka yang dipisahkan dengan koma.");
                }
            }
        });

        // Menampilkan frame
        frame.setVisible(true);
    }

    // Fungsi untuk parsing input dari String ke array of integers
    private static int[] parseInput(String input) {
        String[] parts = input.split(",");
        int[] arr = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            arr[i] = Integer.parseInt(parts[i].trim());
        }
        return arr;
    }

    // Fungsi Bubble Sort
    private static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Fungsi Selection Sort
    private static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // Swap
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    // Fungsi untuk mengubah array menjadi String
    private static String arrayToString(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int num : arr) {
            sb.append(num).append(" ");
        }
        return sb.toString().trim();
    }
}

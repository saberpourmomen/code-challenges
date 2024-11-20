import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class Main {

    public static int[][] sudokuQuadrantChecker(int[][] sudoku) {
        long zero_column = Arrays.stream(sudoku).flatMapToInt(Arrays::stream).filter(n->n==0).count();
        while (zero_column>0) {
            for (int i = 0; i < sudoku.length; i++) {

                for (int j = 0; j < sudoku[i].length; j++) {
                    List<Integer> validValues = new ArrayList<>(IntStream.range(1, 10).boxed().toList());
                    if (sudoku[i][j] == 0) {
                        validValues=checkRow(sudoku[i], validValues);
                        validValues=checkColumn(sudoku, j, validValues);
                        validValues=checkSubgrid(sudoku, i, j, validValues);
                        if (validValues.size() == 1) {
                            sudoku[i][j] = validValues.get(0);
                            zero_column--;
                        }

                    }
                }
            }
        }
        return sudoku;
    }

    private static List<Integer> checkRow(int[] row, List<Integer> validValues) {
        return validValues.stream().filter(n-> !Arrays.stream(row).boxed().toList().contains(n)).toList();
    }

    private static List<Integer> checkColumn(int[][] sudoku, int index, List<Integer> validValues) {
        for (int[] row : sudoku) {
            if (row[index] != 0) {
                validValues=validValues.stream().filter(n-> row[index] != n ).toList();
            }
        }
        return validValues;
    }

    private static List<Integer> checkSubgrid(int[][] sudoku, int row, int column, List<Integer> validValues) {
        column = column / 3;
        row = row / 3;
        for (int i = 3 * row; i < 3 + (3 * row); i++) {
            for (int j = 3 * column; j < 3 + (3 * column); j++) {
                if (sudoku[i][j] != 0) {
                    int value=sudoku[i][j];
                    validValues=validValues.stream().filter(n-> value != n ).toList();
                }
            }

        }
        return validValues;
    }

    public static void printSudoku(int[][] sudoku) {
        IntStream.range(0, 9).forEach(i -> {
            if (i > 0 && i < 9 && i % 3 == 0) {
                System.out.println("---------------------------");
            }
            IntStream.range(0, 9).forEach(j -> {
                System.out.print(sudoku[i][j]);
                if (j == 2 || j == 5) {
                    System.out.print(" | ");
                } else {
                    System.out.print("  ");
                }
            });
            System.out.println();
        });
        System.out.println("---------------------------------------------------------------------------------");
    }

    public static int[][] getSudokuArray() throws FileNotFoundException {
        int[][] sudoku = new int[9][9];
        ClassLoader classLoader = Main.class.getClassLoader();
        String filePath = Objects.requireNonNull(classLoader.getResource("testValue.txt")).getPath();
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new DataInputStream(new FileInputStream(Paths.get("").toAbsolutePath().toString() + "\\sudoku-quadrant-checker\\src\\testValue.txt"))))) {
            int row = 0;
            String line = bufferedReader.readLine();
            while (Objects.nonNull(line) && !line.isBlank()) {
                sudoku[row] = Arrays.stream(line.split(",")).mapToInt(Integer::valueOf).toArray();
                row++;
                line = bufferedReader.readLine();
            }
            printSudoku(sudoku);
            return sudoku;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws FileNotFoundException {

        printSudoku(sudokuQuadrantChecker(getSudokuArray()));
    }
}
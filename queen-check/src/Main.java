import classes.Piece;

import java.io.*;
import java.nio.file.Paths;
import java.util.Objects;

public class Main {



    private static String queenCheck (String[] strArray){
        Piece queen=new Piece(Integer.parseInt(strArray[0]),Integer.parseInt(strArray[1]));
        Piece king=new Piece(Integer.parseInt(strArray[2]),Integer.parseInt(strArray[3]));

        if(!king.isCheckedBy(queen)){
            return "-1";
        }
        int safeMove=0;

        int[][] directions={{0,1},{0,-1},{1,0},{-1,0},{1,-1},{1,1},{-1,-1},{-1,1}};
        for (int[] direction : directions){
            Piece newKing=new Piece(king.getX()-direction[0],king.getY()-direction[1]);
            if (!newKing.validMove()){
                continue;
            }
            if(!newKing.isCheckedBy(queen)){
                safeMove++;
            }
        }

        return String.valueOf(safeMove);
    }

    private static String[] convertInputStringToStringArray(String str){
        return str.replaceAll("[()]","").split(",");
    }

    public static void main(String[] args) throws IOException {
        ClassLoader classLoader = Main.class.getClassLoader();
        String filePath=classLoader.getResource("testValue.txt").getPath();
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new DataInputStream(new FileInputStream(Paths.get("").toAbsolutePath().toString()+"\\queen-check\\src\\testValue.txt"))))){
            String line = bufferedReader.readLine();
            while (Objects.nonNull(line) && !line.isBlank()) {
                System.out.println(queenCheck(convertInputStringToStringArray(line)));
                line = bufferedReader.readLine();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
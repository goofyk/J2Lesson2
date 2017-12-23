/**
 * @author Anton Gil
 * @version 0.1.1 dated Dec 23, 2017
 * @link https://github.com/goofyk/J2Lesson2Gil
 */

import java.io.FileReader;
import java.util.Scanner;
import java.io.*;

class StringHandle{

    public String[][] getArrStringFromFile(String pathToFile, int sizeArr) throws Exception {

        String[][] arrOfVal = new String[0][];
        String[] arrFromStr;
        int arrWidth = 0;
        int arrHeight = 0;
        Scanner scan;

        try (FileReader fr = new FileReader(pathToFile)) {

            scan = new Scanner(fr);

            while (scan.hasNextLine()) {

                arrHeight += 1;
                arrWidth = Math.max(getArrStringFromLine(scan.nextLine(), "\t").length, arrWidth);

                if( arrWidth !=  sizeArr){
                    throw new ArrayIndexOutOfBoundsException("Size of array from file is not correct");
                }
            }

            if( arrHeight !=  sizeArr){
                throw new ArrayIndexOutOfBoundsException("Size of array from file is not correct");
            }

            arrOfVal = new String[sizeArr][sizeArr];

            scan.close();
        
        }catch (IOException ex) {
            ex.printStackTrace();
        }

        fillArrStringFromLine(pathToFile, arrOfVal);

        return arrOfVal;
    }

    public String[] getArrStringFromLine(String parseLine, String splitSymbol) {
        return parseLine.split(splitSymbol);
    }

    public void fillArrStringFromLine(String pathToFile, String[][] arrOfVal) {

        Scanner scan;
        String[] arrFromStr;
        
        try (FileReader fr = new FileReader(pathToFile)) {

            scan = new Scanner(fr);

            int i = 0;

            while (scan.hasNextLine()) {

                arrFromStr = getArrStringFromLine(scan.nextLine(), "\t");

                for(int j = 0; j < arrOfVal.length; j++){

                    arrOfVal[i][j] = new String(arrFromStr[j]);

                }

                i++;
            }

        }catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
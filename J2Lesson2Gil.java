/**
 * @author Anton Gil
 * @version 0.1.1 dated Dec 23, 2017
 * @link https://github.com/goofyk/J2Lesson2Gil
 */

// 1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4,
// при подаче массива другого размера необходимо бросить исключение ArrayIndexOutOfBoundsException.
// 2. Далее метод должен пройтись по всем элементам массива, преобразовать в int, и просуммировать.
// Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или
// текст вместо числа), должно быть брошено исключение NumberFormatException, с детализацией в какой
// именно ячейке лежат неверные данные.
// 3. В методе main() вызвать полученный метод, обработать возможные исключения ArrayIndexOutOfBoundsException
// и NumberFormatException, и вывести результат расчета.
// 4. *** Прочитать двухмерный строковый массив из текстового файла.

class J2Lesson2Gil{

    public static void main(String[] args) throws Exception {

        final int sizeArr = 4;
        String[][] arrOfVal;

        // Static array for test
        //String[][] arrOfVal = {{"1","2","3","4"},{"6","7","8","9"},{"11","12","13","14"},{"16","17","18","19"}};

        try{
             // Reading array from file
             StringHandle strHandle = new StringHandle();
             arrOfVal = strHandle.getArrStringFromFile("C:\\ULTRA\\WORK\\GEEKBRAINS\\JAVA2\\J2Lesson2\\src\\test.txt", sizeArr);

             System.out.println(countValOfArray(arrOfVal));

         }catch(ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
         }catch(NumberFormatException e){
            e.printStackTrace();
         }

    }

    public static int countValOfArray(String[][] arrOfVal) throws ArrayIndexOutOfBoundsException, NumberFormatException {

        // System.out.println(checkArrSize(arrOfVal, 0));
        // System.out.println(arrOfVal[0].length);

        if (!checkArrSize(arrOfVal, -1)){
            throw new ArrayIndexOutOfBoundsException("Size of array is different");
        }

        return sumValOfArray(arrOfVal);

    }

    public static boolean checkArrSize(String[][] arrCheck, int checkableArrSize){

        int allowArrSize 	= checkableArrSize == -1 ? 4 : checkableArrSize;
        boolean arrAllowed 	= true;

        if(arrCheck.length != allowArrSize){
            arrAllowed = false;
        }

        if (arrAllowed) {
            for(int i = 0; i < arrCheck.length; i++){
                if(arrCheck[i].length != allowArrSize){
                    arrAllowed = false;
                    break;
                }
            }
        }

        return arrAllowed;

    }

    public static int sumValOfArray(String[][] arrOfVal) {

        int sum = 0;

        for(int i = 0; i < arrOfVal.length; i++){
            for(int j = 0; j < arrOfVal[i].length; j++){
                try{
//                    sum += Integer.parseInt(arrOfVal[i][j]);
                    sum += Integer.valueOf(arrOfVal[i][j]);
                }catch(NumberFormatException e){
                    throw new NumberFormatException("Error parseInt in cell [" + i + "][" + j + "] = " + arrOfVal[i][j]);
                }
            }
        }
        return sum;

    }

}
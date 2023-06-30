import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class HomeTask2 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws SecurityException, IOException {
        String dirPath = System.getProperty("user.dir");
        // task1(dirPath);
        task2(dirPath);
    }
    // 1) Напишите метод, который определит тип (расширение) файлов из текущей папки и выведет в консоль результат вида
    // 1 Расширение файла: txt
    // 2 Расширение файла: pdf
    // 3 Расширение файла:
    // 4 Расширение файла: jpg
    static void task1(String dirPath) {
        File currentDir = new File(dirPath);
        String[] currentList = currentDir.list();
        for (int i = 0; i < currentList.length; i++) {
            currentList[i] = currentList[i].substring(currentList[i].lastIndexOf("."));
            System.out.printf("Extension of %d file : %s", i+1, currentList[i]);
            System.out.println();
        }
    }

    // 2) Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.
    static void task2(String pathFile) throws SecurityException, IOException {
        System.out.print("Input length: ");
        int length = getNum();
        int[] arr = new int[length];
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("Input %d value: ", i+1);
            arr[i] = getNum();
        }

        Logger logger = Logger.getLogger(HomeTask2.class.getName());
        FileHandler fh = new FileHandler("task2(log).txt");

        logger.addHandler(fh);

        SimpleFormatter simple = new SimpleFormatter();
        fh.setFormatter(simple);

        for (int i = 0; i < arr.length; i++) {
            
            for (int j = 0; j < arr.length - i - 1; j++) {
                String res = "";
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    
                    for (int k = 0; k < arr.length; k++) {
                        res += arr[k] + " ";
                    }
                   
                    logger.info(res);
                }

            }
        
        }

    }

    static int getNum() {
        int num;
        if (sc.hasNextInt()) num = sc.nextInt();
        else {
            System.out.println("Error! Try again.");
            sc.next();
            num = getNum();
        }
        return num;
    }
    
}

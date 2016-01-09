package Revesre;

import java.util.Scanner;

public class SmartReverse {
	static final String WORD_BREAKER = " ";//Слова разделяются символом "пробел".
	
    static void reverseParth(char[] array, int startPos, int endPos) {
    	/*Метод принимает такие параметры: отрезок из букв и символов,
    	 * индекс первого элемента отрезка,
    	 * индекс последнего элемента отрезка.
    	 */
    	
    	while ( startPos < endPos ) {
    		//Проходимся циклом по открезку и меняем расположение символов как нам надо.
    		
            if ( ! Character.isLetter(array[startPos]) )
                ++startPos;
            else if ( ! Character.isLetter(array[endPos]) )
                --endPos;
            else {
                char tmp = array[startPos];
                array[startPos] = array[endPos];
                array[endPos] = tmp;
                ++startPos;
                --endPos;
            }
        }
    }
    
    static String smartReverse(String s) {
    	//Метод принимает введенную пользователем строку.
        char[] arr = s.toCharArray();
        //Разбитую на массив символов строку присваиваем объявленному масиву.
        int head = 0;
        
        while ( head < arr.length ) {
        	/*Проходимся циклом по массиву,
        	 * исходя из того, какой у нас символ разделитель
        	 * -выделяем отрезок по которому мы
        	 * будем проходится вложенным циклом
        	 */
            if ( WORD_BREAKER.indexOf(arr[head]) >= 0 )
                ++head;
            else {
                int tail = head + 1;
                while ( ( tail < arr.length ) && ( WORD_BREAKER.indexOf(arr[tail]) == -1 ) )
                    ++tail;
                reverseParth(arr, head, tail - 1); 
                /*Юзаем наш метод "reverseParth" для обработки отрезка 
                 * передавая ему параметры */
                head = tail + 1;
            }
        }
        
        return new String(arr);
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while ( true ) {
            System.out.print("String: ");
            String s = scanner.nextLine();
            if ( "".equals(s) )
                break;
            System.out.println("Result: " + smartReverse(s));
        }
    }
}


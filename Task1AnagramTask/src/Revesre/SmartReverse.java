package Revesre;

import java.util.Scanner;

public class SmartReverse {
	static final String WORD_BREAKER = " ";//����� ����������� �������� "������".
	
    static void reverseParth(char[] array, int startPos, int endPos) {
    	/*����� ��������� ����� ���������: ������� �� ���� � ��������,
    	 * ������ ������� �������� �������,
    	 * ������ ���������� �������� �������.
    	 */
    	
    	while ( startPos < endPos ) {
    		//���������� ������ �� �������� � ������ ������������ �������� ��� ��� ����.
    		
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
    	//����� ��������� ��������� ������������� ������.
        char[] arr = s.toCharArray();
        //�������� �� ������ �������� ������ ����������� ������������ ������.
        int head = 0;
        
        while ( head < arr.length ) {
        	/*���������� ������ �� �������,
        	 * ������ �� ����, ����� � ��� ������ �����������
        	 * -�������� ������� �� �������� ��
        	 * ����� ���������� ��������� ������
        	 */
            if ( WORD_BREAKER.indexOf(arr[head]) >= 0 )
                ++head;
            else {
                int tail = head + 1;
                while ( ( tail < arr.length ) && ( WORD_BREAKER.indexOf(arr[tail]) == -1 ) )
                    ++tail;
                reverseParth(arr, head, tail - 1); 
                /*����� ��� ����� "reverseParth" ��� ��������� ������� 
                 * ��������� ��� ��������� */
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


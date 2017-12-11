
import java.util.Arrays;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Boogster
 */
public class Table {
    private  String [] Table;
    private  int mySize;
    private int collisions = 0;
    
    public Table(int size)
    {
        mySize = size;
        Table = new String[size];
    }
    
    public boolean addToHash(String input)
    {
        //return false if collision
        boolean answer = true;
        int hashValue = Math.abs(input.hashCode());
        int finalPos = hashValue % mySize;
        if (Table[finalPos] == null || input.compareTo(Table[finalPos]) == 0)
            Table[finalPos] = input;
        else 
        {
            answer = false;
            collisions ++;
        }
        return answer;
        
    }
    
    public String printOut()
    {
        int totalWords = 0;
        String answer = "<html>";
        for (int i = 0;i < Table.length ;i++)
        {
            if (Table[i] != null)
            {
                answer += "hash: " + i + "  Word: " + Table[i] + "<br>";
                totalWords ++;
            }
        }
        return answer + "<br><br>Unique Words: " + totalWords;
    }
    
    public int findWord(String input)
    {
        int answer = -1;
        int hashValue = Math.abs(input.hashCode());
        int finalPos = hashValue % mySize;
        if (Table[finalPos] != null)
            if (input.compareTo(Table[finalPos]) == 0)
                answer = finalPos;
        
        return answer;
    }
}
   


package ge;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class GETest {


    public static class LinkedListNode{
        int val;
        LinkedListNode next;
    
        LinkedListNode(int node_value) {
            val = node_value;
            next = null;
        }
    };
    
    public static LinkedListNode _insert_node_into_singlylinkedlist(LinkedListNode head, LinkedListNode tail, int val){
        if(head == null) {
            head = new LinkedListNode(val);
            tail = head;
        }
        else {
            tail.next = new LinkedListNode(val);
            tail = tail.next;
        }
        return tail;
    }
    
    
    public static void main(String[] args) throws IOException{

        LinkedListNode res;
        
        int _list_size = 0;
        _list_size = 11;
        int _list_i;
        int _list_item;
        LinkedListNode _list = null;
        LinkedListNode _list_tail = null;
        for(_list_i = 1; _list_i < _list_size; _list_i++) { 
            _list_item = _list_i;
            if(_list_i == 1) {
        	_list = _insert_node_into_singlylinkedlist(_list, _list_tail, _list_item);
        	_list_tail = _list;
        }
        else {
        	_list_tail = _insert_node_into_singlylinkedlist(_list, _list_tail, _list_item);
        }
        }
        
        res = deleteEven(_list);
        while(res != null){
        	System.out.print(res.val + ", ");
        	res = res.next;
        }
    }

    static LinkedListNode deleteEven(LinkedListNode list) {

    	if(list == null) return null;
    	
    	while((list.val % 2) != 0){
    		list = list.next;
            if(list == null)
                return null;
    	}
    	
    	LinkedListNode prev =  list;
    	LinkedListNode curr =  list.next;
    	
    	while(curr != null){
    		if(curr.val % 2 != 0){
    			prev.next = curr.next;
    		};
    		prev = curr;
    		curr = curr.next;
    		
    	}
    	return list;
    }
}

    
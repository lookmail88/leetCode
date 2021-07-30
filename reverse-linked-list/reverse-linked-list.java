/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
         if(head == null ) return null;
        Stack<Integer> stack = new Stack<Integer>();
        ListNode list = head;
        while(list != null){
            stack.push(list.val);
            list = list.next;
        }
        ListNode start = new ListNode(stack.pop());
       ListNode rst = start;
        while(!stack.isEmpty()){
           start.next = new ListNode(stack.pop());
            start = start.next;
        }
        start  = null;
        return rst;
    }
}
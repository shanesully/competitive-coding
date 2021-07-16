import java.math.BigInteger;

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        if (l1.val == 0 && l1.next == null && l2.val == 0 && l2.next == null) {
            return new ListNode(0);
        }
        
        List<Integer> l1Num = extractNumFromListNode(l1);
        List<Integer> l2Num = extractNumFromListNode(l2);
        
        Collections.reverse(l1Num);
        Collections.reverse(l2Num);
        
        String l1Int = String.join("", l1Num.stream().map(Object::toString).collect(Collectors.toList()));
        String l2Int = String.join("", l2Num.stream().map(Object::toString).collect(Collectors.toList()));
        
        BigInteger sum;
        BigInteger bi1 = new BigInteger(l1Int);
        BigInteger bi2 = new BigInteger(l2Int);
        
        sum = bi1.add(bi2);
        
        return convertNumberToListNodeSequence(sum.toString());
    }
    
    private List extractNumFromListNode(ListNode l) {
        List<Integer> num = new ArrayList<>();
        
        num.add(l.val);
        
        while (l.next != null) {
            l = l.next;
            num.add(l.val);
        }
        
        return num;
    }
    
    private ListNode convertNumberToListNodeSequence(String numStr) {
        String[] digits = numStr.split("(?<=.)");
        
        int i = digits.length - 1;
        ListNode head = new ListNode();
        ListNode curr = head;
        
        while (i >= 0) {
            curr.val = Integer.parseInt(digits[i]);
            
            if (i != 0) {
                curr.next = new ListNode();
                curr = curr.next;
            }
            i = i - 1;
        }
        
        return head;
    }
}
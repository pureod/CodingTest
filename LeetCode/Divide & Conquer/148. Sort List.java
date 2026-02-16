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
    public ListNode sortList(ListNode head) {
        if (head == null) return head;

        List<ListNode> list = new ArrayList<>();
        ListNode cur = head;

        while (cur != null) {
            list.add(cur);
            cur = cur.next;
        }

        Collections.sort(list, (o1,o2) -> Integer.compare(o1.val, o2.val));

        for (int i = 0; i < list.size()-1; i++) {
            list.get(i).next = list.get(i+1);
        }

        list.get(list.size() - 1).next = null;

        return list.get(0);
    }
}
package hackerrank;

public class Test8 {

	static class LinkedListNode {
		String val;
		LinkedListNode next;
	};

	static LinkedListNode create(int[] vals) {
		LinkedListNode head = null;
		LinkedListNode end = null;
		for (int i = 0; i < vals.length; i++) {
			end = new LinkedListNode();
			end.val = String.valueOf(vals[i]);
			if (head == null) {
				head = end;
			} else {
				LinkedListNode start = head;
				while (start.next != null) {
					start = start.next;
				}
				start.next = end;
			}
		}
		return head;
	}

	public int find(LinkedListNode list, LinkedListNode sublist) {
		int index = 0;
		LinkedListNode start = list;
		while (start.next != null) {
			if (compare(start, sublist)) {
				return index;
			}
			index++;
			start = start.next;
		}
		return -1;
	}

	private boolean compare(LinkedListNode list, LinkedListNode sublist) {
		while (list.next != null && sublist.next != null) {
			return compare(list.next, sublist.next);
		}
		return list.val.equals(sublist.val);
	}
}

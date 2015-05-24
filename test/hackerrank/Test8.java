package hackerrank;

public class Test8 {

	static class LinkedListNode {
		String val;
		LinkedListNode next;
	};

	static int find(LinkedListNode list, LinkedListNode sublist) {
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

	private static boolean compare(LinkedListNode list, LinkedListNode sublist) {
		while (list.next != null && sublist.next != null) {
			return compare(list.next, sublist.next);
		}
		System.out.println("main.val" + list.val);
		System.out.println("sub.val" + sublist.val);
		return list.val.equals(sublist.val);
	}
}

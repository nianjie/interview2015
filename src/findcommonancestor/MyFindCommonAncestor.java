/**
 *
 */
package findcommonancestor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @author Jack Xu
 *
 */
public class MyFindCommonAncestor implements FindCommonAncestor {

	@Override
	public String findCommmonAncestor(String[] commitHashes,
			String[][] parentHashes, String commitHash1, String commitHash2) {
		// use set to hold all ancestors for a specified commit.
		Set<String> hash1Ancestors = new HashSet<String>(Arrays.asList(commitHash1));
		Set<String> hash2Ancestors = new HashSet<String>(Arrays.asList(commitHash2));

		for (int i = 0; i < commitHashes.length; i++) {
			if (parentHashes[i] != null ) {
				// if a commit at index i can be found,
				// then commits held in parentHases at the same index should
				// be the corresponding ancestors immediately or not immediately
				if (hash1Ancestors.contains(commitHashes[i])) {
					hash1Ancestors.addAll(Arrays.asList(parentHashes[i]));
				}
				if (hash2Ancestors.contains(commitHashes[i])) {
					hash2Ancestors.addAll(Arrays.asList(parentHashes[i]));
				}
			}
		}
		//remove given commits selves
		hash1Ancestors.remove(commitHash1);
		hash2Ancestors.remove(commitHash2);
		//by performing intersection common ancestors can be found.
		if (hash1Ancestors.retainAll(hash2Ancestors)) {
			return mostRecentAncestor(commitHashes, hash1Ancestors);
		}

		return null;
	}

	private String mostRecentAncestor(String[] commitHashes,
			Set<String> hash1Ancestors) {
		List<Integer> index = new ArrayList<Integer>(hash1Ancestors.size());
		for (Iterator<String> iterator = hash1Ancestors.iterator(); iterator.hasNext();) {
			index.add(getCommitIndex(commitHashes, iterator.next()));
		}
		java.util.Collections.sort(index);

		return commitHashes[index.get(0)];
	}

	private int getCommitIndex(String[] commitHashes, String commitHash) {
		for (int i = 0; i < commitHashes.length; i++) {
			if (commitHash.equals(commitHashes[i])) {
				return i;
			}
		}
		return -1;
	}

}

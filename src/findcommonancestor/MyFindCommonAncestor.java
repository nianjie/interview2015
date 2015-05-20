/**
 *
 */
package findcommonancestor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Jack Xu
 *
 */
public class MyFindCommonAncestor implements FindCommonAncestor {

	@Override
	public String findCommmonAncestor(String[] commitHashes,
			String[][] parentHashes, String commitHash1, String commitHash2) {
		//
		int hash1Index = getCommitIndex(commitHashes, commitHash1);
		int hash2Index = getCommitIndex(commitHashes, commitHash2);

		//
		List<String> hash1Ancestors = collectAncestors(commitHashes,parentHashes, hash1Index);
		List<String> hash2Ancestors = collectAncestors(commitHashes,parentHashes, hash2Index);

		//
		if (hash1Ancestors.retainAll(hash2Ancestors)) {
			return hash1Ancestors.get(0);
		}

		return null;
	}

	private int getCommitIndex(String[] commitHashes, String commitHash) {
		for (int i = 0; i < commitHashes.length; i++) {
			if (commitHash.equals(commitHashes[i])) {
				return i;
			}
		}
		return -1;
	}

	private List<String> collectAncestors(String[] commitHashes, 
			String[][] parentHashes, int index) {
		List<String> ances = new ArrayList<String>();
		// 
		if (parentHashes[index] != null) {
			ances.addAll(Arrays.asList(parentHashes[index]));
		}
		
		for (int i = index+1; i < parentHashes.length; i++) {
			String[] parents = parentHashes[i];
			if (parents != null && ances.contains(commitHashes[i])) {
				ances.addAll(Arrays.asList(parents));
			}
		}
		return ances;
	}

}

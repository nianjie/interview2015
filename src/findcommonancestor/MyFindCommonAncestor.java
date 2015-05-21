/**
 *
 */
package findcommonancestor;

import java.util.Arrays;
import java.util.HashSet;
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
				// remove given commits selves
				if (commitHash1.equals(commitHashes[i])) {
					hash1Ancestors.remove(commitHash1);
				}
				if (commitHash2.equals(commitHashes[i])) {
					hash1Ancestors.remove(commitHash2);
				}
			}
			//find the most recent common ancestors between given commits.
			if (hash1Ancestors.contains(commitHashes[i]) && hash2Ancestors.contains(commitHashes[i])) {
				return commitHashes[i];
			}
		}

		return null;
	}

}

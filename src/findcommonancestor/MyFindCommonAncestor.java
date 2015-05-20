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

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

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
		Set<String> hash1Ancestors = collectAncestors(commitHashes,parentHashes, hash1Index);
		Set<String> hash2Ancestors = collectAncestors(commitHashes,parentHashes, hash2Index);

		//
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

	private Set<String> collectAncestors(String[] commitHashes, 
			String[][] parentHashes, int index) {
		Set<String> ances = new HashSet<String>();
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

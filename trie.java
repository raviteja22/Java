package com.assignments.trie;

import java.util.ArrayList;

public class Trie {

	TrieNode insert(TrieNode root, String word) {
		
		if (root == null) {
			root = new TrieNode();
			if (word.length() != 0) {
				if (root.isleaf)
					root.isleaf = false;
				root.childNodes[word.charAt(0) - 'a'] = insert(
						root.childNodes[word.charAt(0) - 'a'],
						word.substring(1));
			} else {
				root.isleaf = true;
				root.isword = true;
			}

		} else {
			if (word.length() != 0) {
				if (root.isleaf)
					root.isleaf = false;
				root.childNodes[word.charAt(0) - 'a'] = insert(
						root.childNodes[word.charAt(0) - 'a'],
						word.substring(1));
			} else
				root.isword = true;

		}
		return root;

	}

	private TrieNode find(TrieNode root, String word) {
		if (root == null)
			return null;
		//length 0 means word pattern exists in the trie
		if (word.length() == 0)
			return root;
		return find(root.childNodes[word.charAt(0) - 'a'], word.substring(1));

	}

	boolean isContains(TrieNode root, String word) {
		if (root == null)
			return false;
		
		if (word.length()==0 && root.isword)
			return true;

		return isContains(root.childNodes[word.charAt(0) - 'a'],
				word.substring(1));

	}

	void prefixSearch(TrieNode root, String prefix) {
		TrieNode prefixNode = find(root, prefix);
		if (prefix == null) {
			System.out.println("there are no words which are starting with :"
					+ prefix);
			return;
		} else {
			System.out.println("words that are starting with " + prefix
					+ " are ");
			ArrayList<Character> prefixList = new ArrayList<Character>();
			for (int i = 0; i < prefix.length(); i++)
				prefixList.add(prefix.charAt(i));
			printTrie(prefixNode, prefixList);
		}

	}

	void printTrie(TrieNode root, ArrayList<Character> s) {
		if (root == null)
			return;
		if (root.isword)
			print(s);

		for (int i = 0; i < 26; i++) {
			if (root.childNodes[i] != null) {
				int index = s.size();
				s.add(index, (char) ('a' + i));
				printTrie(root.childNodes[i], s);
				s.remove(index);
			}

		}

	}

	private void print(ArrayList<Character> s) {

		for (int i = 0; i < s.size(); i++)
			System.out.print(s.get(i));
		System.out.println();

	}

	TrieNode remove(TrieNode root, String word) {
		if (root == null)
			return root;

		if (word.length() != 0) {
				root.childNodes[word.charAt(0) - 'a'] = remove(
						root.childNodes[word.charAt(0) - 'a'], word.substring(1));
				if (root.isword )
					return root;
				for (int i = 0; i < 26; i++) {
						if (root.childNodes[i] != null) {
							return root;
					}
				}
				return null;
		} else {

				if (root.isleaf)
					return null;
				else {
					for (int i = 0; i < 26; i++) {
						if (root.childNodes[i] != null) {
							root.isword = false;
							return root;
						}
					}
					return null;
	
				}

		}

	}

	
}

class TrieNode {
	boolean isleaf;
	boolean isword;
	TrieNode childNodes[];
	int wordCount;

	TrieNode() {
		isleaf = false;
		isword = false;
		childNodes = new TrieNode[26];
	}

}

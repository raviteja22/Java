package com.assignments.trie;

import java.util.ArrayList;

public class TestTrie {
	public static void main(String[] args) {
		Trie t = new Trie();
		TrieNode root = t.insert(null, "algorithmica");
		root = t.insert(root, "tries");
		root = t.insert(root, "retrievals");
		root = t.insert(root, "queues");
		root = t.insert(root, "stacks");
		root = t.insert(root, "suffixtrees");
		root=t.insert(root, "suffix");
		System.out.println("all the elements that are present in trie are: ");
		t.printTrie(root, new ArrayList<Character>());
		System.out.println("elements after removal of \"tries\" are" );
		root=t.remove(root, "tries");
		t.printTrie(root, new ArrayList<Character>());
		System.out.println("findin whether the word \"suffix\" is present or not ");
		t.isContains(root, "suffix");
		t.prefixSearch(root, "suffix");
		
	}

}

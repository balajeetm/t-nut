/*
 * Copyright (c) Balajee TM 2017.
 * All rights reserved.
 * License -  @see <a href="http://www.apache.org/licenses/LICENSE-2.0"></a>
 */

/*
 * Created on 12 Mar, 2017 by balajeetm
 * http://www.balajeetm.com
 * http://blog.balajeetm.com/blog/2017/02/21/technical-nuts/
 */
package com.balajeetm.tnut.controller;

import java.util.Stack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.balajeetm.tnut.lever.SinglyLinkedListLever;
import com.balajeetm.tnut.model.SNode;
import com.google.gson.JsonArray;

/**
 * The Class ReverseSinglyLinkedList.
 *
 * @author balajeetm
 */
@RestController
@RequestMapping("/tnut/reverse-in-pockets")
public class ReverseSinglyLinkedList {

	/** The s lever. */
	@Autowired
	private SinglyLinkedListLever sLever;

	/**
	 * Brute.
	 *
	 * @param array the array
	 * @param n the n
	 * @return the json array
	 */
	@PostMapping("/brute")
	public JsonArray brute(@RequestBody JsonArray array, @RequestParam(defaultValue = "1") Integer n) {
		SNode root = sLever.getSinglyLinkedList(array);

		/*variable used to traverse every node*/
		SNode node = root;

		/*variable used to keep track of the node position to identify pockets*/
		Integer nodeCount = 0;

		/* variables used to performing swapping within a pocket of nodes*/
		Integer pocket = null;
		Integer count = 0;

		while (null != node) {
			if (nodeCount % n == 0) {
				pocket = n;
			}
			if (pocket > 0) {
				count = 1;
				SNode newPos = node;
				while (count % pocket != 0 && newPos.getNext() != null) {
					newPos = newPos.getNext();
					count++;
				}
				swap(node, newPos);
				pocket = pocket - 2;
			}
			node = node.getNext();
			nodeCount = nodeCount + 1;
		}

		return sLever.getJsonArray(root);
	}

	/**
	 * Brute stack.
	 *
	 * @param array the array
	 * @param n the n
	 * @return the json array
	 */
	@PostMapping("/brute-stack")
	public JsonArray bruteStack(@RequestBody JsonArray array, @RequestParam(defaultValue = "1") Integer n) {
		SNode root = sLever.getSinglyLinkedList(array);

		/*variable used to traverse every node*/
		SNode currentRoot = root;
		SNode node = root;

		/*variable used to keep track of the node position to identify pockets*/
		Integer nodeCount = 0;

		/* variables used to performing swapping within a pocket of nodes*/
		Stack<Integer> stack = new Stack<>();

		while (null != node) {
			if (nodeCount % n == 0) {
				relocate(stack, currentRoot);
				currentRoot = node;
			}
			stack.push(node.getData());
			node = node.getNext();
			nodeCount = nodeCount + 1;
		}

		relocate(stack, currentRoot);

		return sLever.getJsonArray(root);
	}

	/**
	 * Relocate.
	 *
	 * @param stack the stack
	 * @param currentRoot the current root
	 */
	private void relocate(Stack<Integer> stack, SNode currentRoot) {
		while (!stack.empty()) {
			currentRoot.setData(stack.pop());
			currentRoot = currentRoot.getNext();
		}
	}

	/**
	 * Swap.
	 *
	 * @param node1 the node 1
	 * @param node2 the node 2
	 */
	private void swap(SNode node1, SNode node2) {
		if (node1 != node2) {
			Integer temp = node1.getData();
			node1.setData(node2.getData());
			node2.setData(temp);
		}
	}

}

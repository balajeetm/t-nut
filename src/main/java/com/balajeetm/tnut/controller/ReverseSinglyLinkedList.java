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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * The Class ReverseSinglyLinkedList.
 *
 * @author balajeetm
 */
@RestController
@RequestMapping("/tnut/reverse-in-pockets")
@Api(tags = { "Singly Linked List" }, description = "Reverse list's every n nodes")
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
	@ApiOperation(value = "Brute Force Approach", notes = "Move items one by one, revisiting every item")
	public JsonArray brute(@RequestBody JsonArray array, @RequestParam(defaultValue = "1") Integer n) {
		SNode root = sLever.getSinglyLinkedList(array);

		/* variable used to traverse every node */
		SNode node = root;

		/* variable used to keep track of the node position to identify pockets */
		Integer nodeCount = 0;

		/* variables used to performing swapping within a pocket of nodes */
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

				/* -2 because, 2 nodes are out of the equation
				 * one in front, and one in the end */
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
	@ApiOperation(value = "Brute Force using Stack Approach", notes = "Stack all items in a pocket sequentially, and pop them to respective positions on second visit")
	public JsonArray bruteStack(@RequestBody JsonArray array, @RequestParam(defaultValue = "1") Integer n) {
		SNode root = sLever.getSinglyLinkedList(array);

		/* variable used to identify the current pocket of nodes we are dealing with */
		SNode currentRoot = root;
		SNode node = root;

		/* variable used to keep track of the node position to identify pockets */
		Integer nodeCount = 0;

		/* stack used to place nodes in appropriate positions */
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
	 * Reverse full list.
	 *
	 * @param array the array
	 * @return the json array
	 */
	@PostMapping("/fullreverse")
	@ApiOperation(value = "Recursive Approach", notes = "Reverse the list with a single traversal of nodes")
	public JsonArray reverseFullList(@RequestBody JsonArray array) {
		SNode root = sLever.getSinglyLinkedList(array);
		return sLever.getJsonArray(fullReverse(root));
	}

	/**
	 * Reverse in pockets.
	 *
	 * @param array the array
	 * @param n the n
	 * @return the json array
	 */
	@PostMapping("/pocketreverse")
	@ApiOperation(value = "Recursive Approach in pockets", notes = "Reverse the list with a single traversal of nodes")
	public JsonArray reverseInPockets(@RequestBody JsonArray array, @RequestParam(defaultValue = "1") Integer n) {
		SNode root = sLever.getSinglyLinkedList(array);
		return sLever.getJsonArray(pocketReverse(root, n));
	}

	/**
	 * Pocket reverse.
	 *
	 * @param root the root
	 * @param pocketSize the pocket size
	 * @return the s node
	 */
	private SNode pocketReverse(SNode root, Integer pocketSize) {
		Integer count = 0;
		SNode prev = null;
		SNode curr = null;
		SNode next = null;

		curr = root;
		while (count < pocketSize && null != curr) {
			next = curr.getNext();
			curr.setNext(prev);
			prev = curr;
			curr = next;
			count++;
		}

		root.setNext(null == curr ? curr : pocketReverse(curr, pocketSize));
		return prev;
	}

	/**
	 * Full reverse.
	 *
	 * @param root the root
	 * @return the s node
	 */
	private SNode fullReverse(SNode root) {
		SNode prev = null;
		SNode curr = null;
		SNode next = null;

		curr = root;
		while (null != curr) {
			next = curr.getNext();
			curr.setNext(prev);
			prev = curr;
			curr = next;
		}
		return prev;
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

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
package com.balajeetm.tnut.lever;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.balajeetm.mystique.util.gson.bean.lever.JsonLever;
import com.balajeetm.tnut.model.SNode;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;

/**
 * The Class SinglyLinkedListLever.
 *
 * @author balajeetm
 */
@Component
public class SinglyLinkedListLever {

	/** The json lever. */
	@Autowired
	private JsonLever jsonLever;

	/**
	 * Gets the singly linked list.
	 *
	 * @param integers the integers
	 * @return the singly linked list
	 */
	public SNode getSinglyLinkedList(Integer... integers) {
		SNode root = null;
		SNode prev = null;
		SNode curr = null;
		for (Integer integer : integers) {
			curr = new SNode(integer);
			root = null == root ? curr : root;
			if (null != prev) {
				prev.setNext(curr);
			}
			prev = curr;
		}
		return root;
	}

	/**
	 * Gets the singly linked list.
	 *
	 * @param array the array
	 * @return the singly linked list
	 */
	public SNode getSinglyLinkedList(JsonArray array) {
		SNode root = null;
		SNode prev = null;
		SNode curr = null;
		for (JsonElement element : array) {
			curr = new SNode(jsonLever.getAsInt(element));
			root = null == root ? curr : root;
			if (null != prev) {
				prev.setNext(curr);
			}
			prev = curr;
		}
		return root;
	}

	/**
	 * Gets the json array.
	 *
	 * @param root the root
	 * @return the json array
	 */
	public JsonArray getJsonArray(SNode root) {
		JsonArray result = new JsonArray();
		while (null != root) {
			result.add(new JsonPrimitive(root.getData()));
			root = root.getNext();
		}
		return result;
	}

}

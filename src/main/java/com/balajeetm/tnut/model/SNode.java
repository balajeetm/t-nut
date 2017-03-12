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
package com.balajeetm.tnut.model;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Class representing a Node in a singly linked list.
 *
 * @author balajeetm
 */

/**
 * Instantiates a new s node.
 */

/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Data

/**
 * Instantiates a new s node.
 */
@NoArgsConstructor
public class SNode {

	/** The data. */
	private Integer data;

	/** The next. */
	private SNode next;

	/**
	 * Instantiates a new s-node.
	 *
	 * @param data the data
	 */
	public SNode(Integer data) {
		this.data = data;
	}

}

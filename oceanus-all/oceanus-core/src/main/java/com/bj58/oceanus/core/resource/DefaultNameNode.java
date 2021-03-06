/*
 *  Copyright Beijing 58 Information Technology Co.,Ltd.
 *
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */
package com.bj58.oceanus.core.resource;

import java.util.ArrayList;
import java.util.List;

/**
 * 默认 NameNode 实现
 * 
 * @author Service Platform Architecture Team (spat@58.com)
 */
public class DefaultNameNode implements NameNode {

	List<DataNodeHolder> dataNodeList = new ArrayList<DataNodeHolder>();

	List<DataNodeHolder> writeDataNodes = new ArrayList<DataNodeHolder>();

	List<DataNodeHolder> readDataNodes = new ArrayList<DataNodeHolder>();

	private String id;

	private LoadBanlance loadBanlance;

	public void addDataNode(DataNodeHolder holder) {
		dataNodeList.add(holder);

		if (holder.canRead())
			readDataNodes.add(holder);

		if (holder.canWrite())
			writeDataNodes.add(holder);

	}

	@Override
	public List<DataNodeHolder> getDataNodes() {
		return dataNodeList;
	}

	@Override
	public List<DataNodeHolder> getWriteNodes() {
		return writeDataNodes;
	}

	@Override
	public List<DataNodeHolder> getReadNodes() {
		return readDataNodes;
	}

	@Override
	public DataNodeHolder remove(DataNodeHolder dataNode) {
		readDataNodes.remove(dataNode);
		writeDataNodes.remove(dataNode);
		dataNodeList.remove(dataNode);

		return dataNode;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public LoadBanlance getLoadBanlance() {
		return this.loadBanlance;
	}

	public void setLoadBanlance(LoadBanlance loadBanlance) {
		this.loadBanlance = loadBanlance;
	}

}

package com.softbistro.datakeeper.common.interfaces;

import java.util.List;

import com.softbistro.datakeeper.model.DataItem;

public interface IMongoDbUploading {
	public void insertData(List<List<DataItem>> listData);
}

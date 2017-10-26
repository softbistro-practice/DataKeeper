package com.softbistro.datakeeper.provider;

import java.util.List;

import com.softbistro.datakeeper.model.DataItem;

public interface IDataProvider {

	List<List<DataItem>> getDataRows();
	
}

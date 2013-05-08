package com.qcs.base.pagination;

import java.util.List;

/**
 * 
 * @ClassName: PaginationResult 
 * @Description: 分页查询结果
 * 
 * @param <T>
 */
public class PaginationResult<T> {
	
	//分页信息
	private PaginationInfo paginationInfo;
	//查询结果记录集合
	private List<T> data;

	public PaginationInfo getPaginationInfo() {
		return paginationInfo;
	}

	public void setPaginationInfo(PaginationInfo paginationInfo) {
		this.paginationInfo = paginationInfo;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}
	
}

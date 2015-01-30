package  com.fm.dao.comn.pagi;

import java.util.List;

import com.fm.dao.intf.comn.PageResult;

public class PageResultImpl<T> implements PageResult<T>{
	public List<T> list;
	public PageParameter pageParameter;
	public PageResultImpl(List<T> list,PageParameter pageParameter){
		this.list=list;
		this.pageParameter=pageParameter;
	}
	@Override
	public int getPageSize() {
	
		return pageParameter.getPageSize();
	}

	@Override
	public int getCurrentPage() {
		
		return  pageParameter.getCurrentPage();
	}

	@Override
	public int getTotalPage() {
		return pageParameter.getTotalPage();
	}

	@Override
	public int getTotalCount() {
		return pageParameter.getTotalCount();
	}

	@Override
	public List<T> getList() {
		return list;
	}

}

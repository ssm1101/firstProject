package co.yedam.trip.mapper;

import java.util.*;

import co.yedam.trip.vo.TripVO;

public interface TripMapper {
	public List<TripVO> tripList();

	public int tripAdd(TripVO vo);

	public TripVO tripSearch(int tpId);

	public int tripUpdate(TripVO vo);

	public int tripDel(int tpId);
	
	public List<TripVO> packageList(TripVO vo);

	public TripVO packageView(int tpId);

	public List<TripVO> recommandList();

	public List<TripVO> tripMyList(String mbId);

	public List<TripVO> tripKeywordSearch(TripVO vo);
	
	public List<TripVO> tripProductSearch(int tpId);

	public List<TripVO> tripTheme();

	public List<TripVO> tripArea();
}
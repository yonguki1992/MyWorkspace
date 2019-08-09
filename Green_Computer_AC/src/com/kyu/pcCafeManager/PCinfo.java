package com.kyu.pcCafeManager;

public class PCinfo {
	private int id; // PC serial number
	private String strCpu; // PC cpu 정보
	private int iMem; // PC 메모리 정보
	private long iStart; //  시작시간
	private long iStop;	//   종료시간
	private long iTotal; //  총 사용 시간
	private long iCurrentTime; // 현재까지 사용 시간
	private int iCharge = 600; // 10분당 과금
	
	public PCinfo() {
		
	}
	
	//PC 정보 입력
	public PCinfo setPCinfo(int id, String strCpu, int iMem) {
		this.id = id;
		this.strCpu = strCpu;
		this.iMem = iMem;
		return new PCinfo();
	}
	
	public long getIStart() {
		return this.iStart;
	}
	
	//시작 시간, 시간은 ms 단위로 받을 수 있음
	public void start(long time) {
		this.iStart = time;
		//System.out.println(this.iStart);
	}

	//종료 시간
	public void stop(long time) {
		this.iStop = time;
	}
	
	public long getIStop() {
		return this.iStop;
	}
	
	//총 매출  	10분 -> 600초 -> 600000ms
	public long getTotalTime() {
		this.iTotal =  this.iStop - this.iStart;
		return this.iTotal;
	}
	
	//사용 시작부터 현재시간까지의 총 매출(아직종료 안 한 유저용)	
	public long getTotalTime(long iCurrentTime) {
		//System.out.println(iCurrentTime);
		this.iCurrentTime = iCurrentTime - this.iStart;
		//System.out.println(this.iCurrentTime);
		return this.iCurrentTime;
	}
	
	//총 매출  	10분 -> 600초 -> 600000ms
	public long getTotal() {
		this.iTotal =  this.iStop - this.iStart;
		return (long)((double)this.iTotal / 600000 * iCharge);
	}
	
	//사용 시작부터 현재시간까지의 총 매출(아직종료 안 한 유저용)	
	public long getTotal(long iCurrentTime) {
		//System.out.println(iCurrentTime);
		this.iCurrentTime = iCurrentTime - this.iStart;
		//System.out.println(this.iCurrentTime);
		return (long)((double)this.iCurrentTime / 600000 * iCharge);
	}	
}

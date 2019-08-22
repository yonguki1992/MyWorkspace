package Ch15;

import java.io.Serializable;

/*
 * VO(Value Object) : 단순히 데이터만 저장하기 위한 용도의 클래스
 * DTO(Data Transfer Object) : 단순히 데이터만 저장하여 전달하기 위한 목적의 클래스
 * Vo 를 만들 땐 기본적으로 getter 와 setter만 구현하면 되지만
 * hashCode(), equals(), 또는 Comparable<E>를 구현하면 좋다.
 * 전송, 저장을 하려면, Serializable 인터페이스를 구현해야 함 (구현할 메서드는 없음)
 */

public class HanjaVo implements Comparable<HanjaVo>, Serializable {
	//Vo 만들기
	
	// 1. 변수 선언
	private String idx;
	private String h;
	private String k;
	private String m;
	
	//2. 생성자 굳이 생성 필요 X, 만약 만들거면 기본 생성자도 꼭 같이 만들어 줘야 함.!!
	public HanjaVo() {
		super();
	}

	public HanjaVo(String idx, String h, String k, String m) {
		super();
		this.idx = idx;
		this.h = h;
		this.k = k;
		this.m = m;
	}

	// 3. getter 및 setter 만들기
	public String getIdx() {
		return idx;
	}

	public void setIdx(String idx) {
		this.idx = idx;
	}

	public String getH() {
		return h;
	}

	public void setH(String h) {
		this.h = h;
	}

	public String getK() {
		return k;
	}

	public void setK(String k) {
		this.k = k;
	}

	public String getM() {
		return m;
	}

	public void setM(String m) {
		this.m = m;
	}

	// 4. hashSet 을 사용하려면 아래 hashCode() 및 equals(Object) 를 생성할 것.
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((h == null) ? 0 : h.hashCode());
		result = prime * result + ((idx == null) ? 0 : idx.hashCode());
		result = prime * result + ((k == null) ? 0 : k.hashCode());
		result = prime * result + ((m == null) ? 0 : m.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HanjaVo other = (HanjaVo) obj;
		if (h == null) {
			if (other.h != null)
				return false;
		} else if (!h.equals(other.h))
			return false;
		if (idx == null) {
			if (other.idx != null)
				return false;
		} else if (!idx.equals(other.idx))
			return false;
		if (k == null) {
			if (other.k != null)
				return false;
		} else if (!k.equals(other.k))
			return false;
		if (m == null) {
			if (other.m != null)
				return false;
		} else if (!m.equals(other.m))
			return false;
		return true;
	}

	
	
	@Override
	public String toString() {
		return "HanjaVo [idx=" + idx + ", h=" + h + ", k=" + k + ", m=" + m + "]";
	}

	//5. TreeSet을  사용하려면 Comparable 인터페이스를 구현하면 됨.
	@Override
	public int compareTo(HanjaVo hv) {
		// TODO Auto-generated method stub
		return this.idx.compareTo(hv.getIdx());
	}

}

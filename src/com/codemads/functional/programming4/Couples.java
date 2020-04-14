/**
 * 
 */
package com.codemads.functional.programming4;

/**
 * @author girishgowda
 *
 */
public class Couples {

	private String boy;
	private String girl;
	
	public Couples() {
		super();
	}
	public Couples(String boy, String girl) {
		this.boy = boy;
		this.girl = girl;
	}
	public String getBoy() {
		return boy;
	}
	public void setBoy(String boy) {
		this.boy = boy;
	}
	public String getGirl() {
		return girl;
	}
	public void setGirl(String girl) {
		this.girl = girl;
	}
	@Override
	public String toString() {
		return "Couples [boy=" + boy + ", girl=" + girl + "]";
	}
	
}
